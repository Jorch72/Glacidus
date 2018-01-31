package com.legacy.glacidus.client.sounds.ambient;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;

import com.legacy.glacidus.ModConfig;

public class LayerAmbientSound extends MovingSound
{

	@SuppressWarnings("unused")
	private int layerId;

	private EntityPlayer player;

	public LayerAmbientSound(EntityPlayer playerIn, SoundEvent soundIn, int layerId)
	{
		super(soundIn, SoundCategory.AMBIENT);

		this.layerId = layerId;
		this.player = playerIn;
        this.repeat = true;
	}

	@Override
    public SoundCategory getCategory()
    {
    	return SoundCategory.AMBIENT;
    }

	@Override
	public void update()
	{
		if (this.player == null)
		{
			this.donePlaying = true;
			return;
		}

		this.xPosF = (float) this.player.posX;
		this.yPosF = (float) this.player.posY;
		this.zPosF = (float) this.player.posZ;

		if (this.player.dimension != ModConfig.dimensionID)
		{
			this.donePlaying = true;
			return;
		}

		if (!Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(this))
		{
			this.donePlaying = true;
			return;
		}

		/*if ((this.layerId == 0 && !this.isInRange(73, 255)) || (this.layerId == 1 && !this.isInRange(51, 72)) || (this.layerId == 2 && !this.isInRange(0, 50)))
		{
			this.volume -= 0.1F;
		}*/

		if (this.volume <= 0.0F)
		{
			this.donePlaying = true;
			return;
		}
	}

	public boolean canPlay()
	{
		return this.player != null && this.player.dimension == ModConfig.dimensionID;/* && ((this.layerId == 0 && this.isInRange(73, 255)) || (this.layerId == 1 && this.isInRange(51, 72)) || (this.layerId == 2 && this.isInRange(0, 50)));*/
	}

	public void setPlayer(EntityPlayer player)
	{
		this.player = player;
	}

	public void resetSong()
	{
		this.xPosF = 0.0F;
		this.yPosF = 0.0F;
		this.zPosF = 0.0F;
		this.volume = 1.0F;
		this.donePlaying = false;
	}

	@SuppressWarnings("unused")
	private boolean isInRange(int min, int max)
	{
		return this.player.posY <= max && this.player.posY >= min;
	}

}