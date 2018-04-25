package com.legacy.glacidus.player;

import com.legacy.glacidus.ModConfig;
import com.legacy.glacidus.world.TeleporterGlacidus;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class PlayerCapability
{

	private EntityPlayer player;

	private boolean activatedMoonJump;
	
	private boolean isJumping;

	private int timeSinceEcholocate;

	public PlayerCapability(EntityPlayer player)
	{
		this.player = player;
	}

	public static PlayerCapability get(EntityPlayer player)
	{
		return player.getCapability(PlayerRegistry.PLAYER_CAPABILITY, null);
	}

	public int getTimeSinceEcholocate()
	{
		return this.timeSinceEcholocate;
	}

	public void setTimeSinceEcholocate(int timeSinceEcholocate)
	{
		this.timeSinceEcholocate = timeSinceEcholocate;
	}

	public void onUpdate()
	{
		this.timeSinceEcholocate++;

		boolean hasJumped = ReflectionHelper.getPrivateValue(EntityLivingBase.class, this.player, "isJumping", "field_70703_bu");

		this.setJumping(hasJumped);
		
		if (this.player.dimension == ModConfig.dimensionID)
		{
			if (this.player.posY > 300.0D)
			{
				this.teleportPlayerToGlacidus();
			}

			if (this.player.onGround && this.activatedMoonJump)
			{
				this.activatedMoonJump = false;
			}

			if (this.player.posY < 110 && this.player.posY > 60)
			{
				if (!this.activatedMoonJump && this.player.motionY >= 0.0F)
				{
					this.player.motionY += 0.24F;
					this.activatedMoonJump = true;
				}
			}
			else if (this.player.posY >= 110)
			{
				if (!this.activatedMoonJump && this.player.motionY >= 0.0F)
				{
					this.player.motionY += 0.6F;
					this.activatedMoonJump = true;
				}
			}

			if (!this.player.onGround && this.player.posY > 0)
			{
				float math = MathHelper.clamp(0.1F + ((0.3F / (float) this.player.posY) * -100.0F), -0.35F, -0.10F);

				if (this.player.motionY < math)
				{
					this.player.motionY = math;
				}
			}

			this.player.fallDistance = 0.0F;
		}
	}

	public void teleportPlayerToGlacidus()
	{
		if (this.player instanceof EntityPlayerMP)
		{
			int dimensionToTravel = this.player.dimension == ModConfig.dimensionID ? 0 : ModConfig.dimensionID;
			MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();

			if (server != null)
			{
				if (ForgeHooks.onTravelToDimension(this.player, dimensionToTravel))
				{
					server.getPlayerList().transferPlayerToDimension((EntityPlayerMP) this.player, dimensionToTravel, new TeleporterGlacidus(server.getWorld(dimensionToTravel)));
				}
			}
		}
	}

	public void writeCapabilityToNBT(NBTTagCompound compound)
	{
		
	}

	public void readCapabilityFromNBT(NBTTagCompound compound)
	{
		
	}
	
	public boolean isJumping()
	{
		return this.isJumping;
	}

	public void setJumping(boolean isJumping)
	{
		this.isJumping = isJumping;
	}

	public EntityPlayer getPlayer()
	{
		return this.player;
	}

}