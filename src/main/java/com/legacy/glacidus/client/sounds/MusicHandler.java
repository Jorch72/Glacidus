package com.legacy.glacidus.client.sounds;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.legacy.glacidus.ModConfig;

@SideOnly(Side.CLIENT)
public class MusicHandler implements ITickable
{
    private final Random rand = new Random();
    private final Minecraft mc;
    private ISound currentMusic;
    private int timeUntilNextMusic = 100;

    private static MusicHandler INSTANCE;

    public MusicHandler(Minecraft mcIn)
    {
        this.mc = mcIn;
    }

    public static MusicHandler getInstance()
    {
    	if (INSTANCE == null)
    	{
    		INSTANCE = new MusicHandler(Minecraft.getMinecraft());
    	}

    	return INSTANCE;
    }

    /**
     * Like the old updateEntity(), except more generic.
     */
    public void update()
    {
        MusicHandler.MusicType musicticker$musictype = this.getRandomMusicType();

        if (this.currentMusic != null)
        {
            if (this.mc.player != null && this.mc.player.dimension != ModConfig.dimensionID)
            {
                this.mc.getSoundHandler().stopSound(this.currentMusic);
                this.timeUntilNextMusic = MathHelper.getInt(this.rand, 0, musicticker$musictype.getMinDelay() / 2);
            }

            if (!this.mc.getSoundHandler().isSoundPlaying(this.currentMusic))
            {
                this.currentMusic = null;
                this.timeUntilNextMusic = Math.min(MathHelper.getInt(this.rand, musicticker$musictype.getMinDelay(), musicticker$musictype.getMaxDelay()), this.timeUntilNextMusic);
            }
        }

        this.timeUntilNextMusic = Math.min(this.timeUntilNextMusic, musicticker$musictype.getMaxDelay());

        if (this.currentMusic == null && this.mc.player != null && this.mc.player.dimension == ModConfig.dimensionID && this.timeUntilNextMusic-- <= 0)
        {
            this.playMusic(musicticker$musictype);
        }
    }

    public boolean isMusicPlaying()
    {
    	return this.currentMusic != null;
    }

    /**
     * Plays a music track for the maximum allowable period of time
     */
    public void playMusic(MusicHandler.MusicType requestedMusicType)
    {
        this.currentMusic = PositionedSoundRecord.getMusicRecord(requestedMusicType.getMusicLocation());
        this.mc.getSoundHandler().playSound(this.currentMusic);
        this.timeUntilNextMusic = Integer.MAX_VALUE;
    }

    private MusicHandler.MusicType getRandomMusicType()
    {
    	return MusicHandler.MusicType.values()[this.rand.nextInt(3)];
    }

    @SideOnly(Side.CLIENT)
    public static enum MusicType
    {
        GoodbyePlanet(GlacidusSounds.MUSIC_TRACK_ONE, 1500, 4400),
        SicutTerrae(GlacidusSounds.MUSIC_TRACK_TWO, 1500, 4400),
        Underground(GlacidusSounds.MUSIC_TRACK_THREE, 1500, 4400);

        private final SoundEvent musicLocation;
        private final int minDelay;
        private final int maxDelay;

        private MusicType(SoundEvent musicLocationIn, int minDelayIn, int maxDelayIn)
        {
            this.musicLocation = musicLocationIn;
            this.minDelay = minDelayIn;
            this.maxDelay = maxDelayIn;
        }

        /**
         * Gets the {@link SoundEvent} containing the current music track's location
         */
        public SoundEvent getMusicLocation()
        {
            return this.musicLocation;
        }

        /**
         * Returns the minimum delay between playing music of this type.
         */
        public int getMinDelay()
        {
            return this.minDelay;
        }

        /**
         * Returns the maximum delay between playing music of this type.
         */
        public int getMaxDelay()
        {
            return this.maxDelay;
        }
    }

}