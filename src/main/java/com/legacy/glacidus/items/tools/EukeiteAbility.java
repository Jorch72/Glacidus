package com.legacy.glacidus.items.tools;

import com.legacy.glacidus.Glacidus;
import com.legacy.glacidus.blocks.natural.IOre;
import com.legacy.glacidus.client.sounds.GlacidusSounds;
import com.legacy.glacidus.player.PlayerCapability;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Timer;
import java.util.TimerTask;

public class EukeiteAbility
{
    public static ActionResult<ItemStack> echolocate(World world, EntityPlayer player, EnumHand hand, int radius)
    {
        PlayerCapability cap = PlayerCapability.get(player);

        if (cap.getTimeSinceEcholocate() < 100)
        {
            return new ActionResult<>(EnumActionResult.PASS, player.getHeldItem(hand));
        }

        if (world.isRemote)
        {
            Glacidus.proxy.getClientEventHandler().dimMusic(5.0F);
        }

        BlockPos pos = player.getPosition();

        final BlockPos min = pos.add(-radius, -radius, -radius);
        final BlockPos max = pos.add(radius, radius, radius);

        if (player instanceof EntityPlayerMP)
        {
            EntityPlayerMP playerMP = (EntityPlayerMP)player;
            playerMP.connection.sendPacket(new SPacketSoundEffect(GlacidusSounds.ECHOLOCATION_SEARCHING, SoundCategory.PLAYERS, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, 1.0F, player.getRNG().nextFloat() * 0.4F + 0.8F));
        }

        BlockPos closest = null;

        for (BlockPos.MutableBlockPos p : BlockPos.getAllInBoxMutable(min, max))
        {
            IBlockState state = world.getBlockState(p);

            if (state.getBlock() instanceof IOre)
            {
                if (closest == null)
                {
                    closest = p.toImmutable();
                }
                else
                {
                    double newDist = p.getDistance(pos.getX(), pos.getY(), pos.getZ());
                    double oldDist = closest.getDistance(pos.getX(), pos.getY(), pos.getZ());

                    if (newDist < oldDist)
                    {
                        closest = p.toImmutable();
                    }
                }
            }
        }

        BlockPos finalClosest = closest;

        if (player.getServer() != null)
        {
            player.getServer().addScheduledTask(() ->
            {
                double dist = finalClosest.getDistance(pos.getX(), pos.getY(), pos.getZ());
                double mod = dist / radius;

                long delay = (long) (5000L * mod);

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (player instanceof EntityPlayerMP)
                        {
                            EntityPlayerMP playerMP = (EntityPlayerMP)player;

                            playerMP.connection.sendPacket(new SPacketSoundEffect(GlacidusSounds.ECHOLOCATION_DISCOVERY, SoundCategory.BLOCKS, (double) finalClosest.getX() + 0.5D, (double) finalClosest.getY() + 0.5D, (double) finalClosest.getZ() + 0.5D, (float)dist / 8.0F, player.getRNG().nextFloat() * 0.4F + 0.8F));
                        }
                    }
                }, delay);
            });
        }

        cap.setTimeSinceEcholocate(0);

        return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }
}
