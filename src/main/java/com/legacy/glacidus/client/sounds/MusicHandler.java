package com.legacy.glacidus.client.sounds;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.legacy.glacidus.ModConfig;
import com.legacy.glacidus.client.sounds.ambient.LayerAmbientSound;

@SideOnly(Side.CLIENT)
public class MusicHandler implements ITickable
{
    private final Random rand = new Random();
    private final Minecraft mc;
    private ISound currentMusic;
    private boolean ambienceMusicPlaying;
    private LayerAmbientSound topLayerAmbience;
    private int timeUntilNextMusic = 100;

    private static MusicHandler INSTANCE;

    public MusicHandler(Minecraft mcIn)
    {
        this.mc = mcIn;
        this.topLayerAmbience = new LayerAmbientSound(null, GlacidusSounds.AMBIENT_WIND_HUM, 0);
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
    	if (!this.mc.getSoundHandler().isSoundPlaying(this.topLayerAmbience) && this.ambienceMusicPlaying)
    	{
    		this.mc.getSoundHandler().stopSound(this.topLayerAmbience);
    		this.topLayerAmbience = new LayerAmbientSound(this.mc.player, GlacidusSounds.AMBIENT_WIND_HUM, 0);
    		this.ambienceMusicPlaying = false;
    		return;
    	}

    	if (this.topLayerAmbience.isDonePlaying() && this.ambienceMusicPlaying)
    	{
    		this.topLayerAmbience.resetSong();
    		this.ambienceMusicPlaying = false;
    	}

    	if (this.mc.player != null)
    	{
    		this.topLayerAmbience.setPlayer(this.mc.player);

    		if (!this.ambienceMusicPlaying && this.topLayerAmbience.canPlay())
    		{
    			if (this.mc.getSoundHandler().isSoundPlaying(this.topLayerAmbience))
    			{
    				this.mc.getSoundHandler().stopSound(this.topLayerAmbience);
    	    		this.topLayerAmbience = new LayerAmbientSound(this.mc.player, GlacidusSounds.AMBIENT_WIND_HUM, 0);
    				this.ambienceMusicPlaying = false;
    				return;
    			}

    			if (!this.mc.getSoundHandler().isSoundPlaying(this.topLayerAmbience))
    			{
            		this.mc.getSoundHandler().playSound(this.topLayerAmbience);
    			}

        		this.ambienceMusicPlaying = true;
    		}
    	}

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
    	boolean flag = false;

    	for (MusicType value : MusicType.values())
    	{
    		flag = this.playingMusic(value);
    	}

    	return flag;
    }

    /**
     * Plays a music track for the maximum allowable period of time
     */
    public void playMusic(MusicHandler.MusicType requestedMusicType)
    {
        this.currentMusic = requestedMusicType.getSound();
        this.mc.getSoundHandler().playSound(this.currentMusic);
        this.timeUntilNextMusic = Integer.MAX_VALUE;
    }

    private boolean playingMusic(MusicType musicType)
    {
    	return this.mc.getSoundHandler().isSoundPlaying(musicType.getSound());
    }

    private MusicHandler.MusicType getRandomMusicType()
    {
    	return MusicHandler.MusicType.values()[this.rand.nextInt(6)];
    }

    @SideOnly(Side.CLIENT)
    public static enum MusicType
    {
        GoodbyePlanet(PositionedSoundRecord.getMusicRecord(GlacidusSounds.MUSIC_TRACK_ONE), 1500, 4400),
        Indigo(PositionedSoundRecord.getMusicRecord(GlacidusSounds.MUSIC_TRACK_TWO), 1500, 4400),
        Underground(PositionedSoundRecord.getMusicRecord(GlacidusSounds.MUSIC_TRACK_THREE), 1500, 4400),
        SicutTerrae(PositionedSoundRecord.getMusicRecord(GlacidusSounds.MUSIC_TRACK_FOUR), 1500, 4400),
        Mitescere(PositionedSoundRecord.getMusicRecord(GlacidusSounds.MUSIC_TRACK_FIVE), 1500, 4400),
        Lumicia(PositionedSoundRecord.getMusicRecord(GlacidusSounds.MUSIC_TRACK_SIX), 1500, 4400);


        private final ISound sound;
        private final int minDelay;
        private final int maxDelay;

        private MusicType(ISound soundIn, int minDelayIn, int maxDelayIn)
        {
            this.sound = soundIn;
            this.minDelay = minDelayIn;
            this.maxDelay = maxDelayIn;
        }

        /**
         * Gets the {@link ISound} containing the current music track
         */
        public ISound getSound()
        {
            return this.sound;
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