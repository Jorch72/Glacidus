package com.legacy.glacidus.client.models.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelDropSpider extends ModelBase
{
    /** The spider's head box */
    public ModelRenderer spiderHead;
    /** The spider's neck box */
    public ModelRenderer spiderNeck;
    /** The spider's body box */
    public ModelRenderer spiderBody;
    /** Spider's first leg */
    public ModelRenderer spiderLeg1;
    public ModelRenderer spiderHang1;
    /** Spider's second leg */
    public ModelRenderer spiderLeg2;
    public ModelRenderer spiderHang2;
    /** Spider's third leg */
    public ModelRenderer spiderLeg3;
    public ModelRenderer spiderHang3;
    /** Spider's fourth leg */
    public ModelRenderer spiderLeg4;
    public ModelRenderer spiderHang4;
    /** Spider's fifth leg */
    public ModelRenderer spiderLeg5;
    public ModelRenderer spiderHang5;
    /** Spider's sixth leg */
    public ModelRenderer spiderLeg6;
    public ModelRenderer spiderHang6;

    public ModelDropSpider()
    {
        this.spiderHead = new ModelRenderer(this, 32, 4);
        this.spiderHead.addBox(-4.0F, -4.0F, -8.0F, 8, 8, 8, 0.0F);
        this.spiderHead.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.spiderNeck = new ModelRenderer(this, 0, 0);
        this.spiderNeck.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
        this.spiderNeck.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.spiderBody = new ModelRenderer(this, 0, 12);
        this.spiderBody.addBox(-5.0F, -4.0F, -6.0F, 10, 8, 12, 0.0F);
        this.spiderBody.setRotationPoint(0.0F, 15.0F, 9.0F);
        this.spiderLeg1 = new ModelRenderer(this, 18, 0);
        this.spiderLeg1.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.spiderLeg1.setRotationPoint(-4.0F, 15.0F, 2.0F);
        this.spiderLeg2 = new ModelRenderer(this, 18, 0);
        this.spiderLeg2.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.spiderLeg2.setRotationPoint(4.0F, 15.0F, 2.0F);
        this.spiderLeg3 = new ModelRenderer(this, 18, 0);
        this.spiderLeg3.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.spiderLeg3.setRotationPoint(-4.0F, 15.0F, 1.0F);
        this.spiderLeg4 = new ModelRenderer(this, 18, 0);
        this.spiderLeg4.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.spiderLeg4.setRotationPoint(4.0F, 15.0F, 1.0F);
        this.spiderLeg5 = new ModelRenderer(this, 18, 0);
        this.spiderLeg5.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.spiderLeg5.setRotationPoint(-4.0F, 15.0F, 0.0F);
        this.spiderLeg6 = new ModelRenderer(this, 18, 0);
        this.spiderLeg6.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.spiderLeg6.setRotationPoint(4.0F, 15.0F, 0.0F);

        this.spiderHang1 = new ModelRenderer(this, 18, 0);
        this.spiderHang1.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.spiderHang1.setRotationPoint(-4.0F, 15.0F, 2.0F);
        this.spiderHang2 = new ModelRenderer(this, 18, 0);
        this.spiderHang2.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.spiderHang2.setRotationPoint(4.0F, 15.0F, 2.0F);
        this.spiderHang3 = new ModelRenderer(this, 18, 0);
        this.spiderHang3.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.spiderHang3.setRotationPoint(-4.0F, 15.0F, 1.0F);
        this.spiderHang4 = new ModelRenderer(this, 18, 0);
        this.spiderHang4.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.spiderHang4.setRotationPoint(4.0F, 15.0F, 1.0F);
        this.spiderHang5 = new ModelRenderer(this, 18, 0);
        this.spiderHang5.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.spiderHang5.setRotationPoint(-4.0F, 15.0F, 0.0F);
        this.spiderHang6 = new ModelRenderer(this, 18, 0);
        this.spiderHang6.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.spiderHang6.setRotationPoint(4.0F, 15.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);

        this.spiderHead.offsetY = 0.25F;
        this.spiderHead.render(scale);

        this.spiderNeck.offsetY = 0.25F;
        this.spiderNeck.render(scale);

        this.spiderBody.offsetY = 0.25F;
        this.spiderBody.render(scale);

        this.spiderLeg1.offsetY = -0.354F;
        this.spiderLeg1.offsetX = -0.44F;
        this.spiderLeg1.offsetZ = -0.11F;

        this.spiderLeg1.render(scale);

        this.spiderLeg2.offsetY = -0.358F;
        this.spiderLeg2.offsetX = 0.44F;
        this.spiderLeg2.offsetZ = -0.12F;

        this.spiderLeg2.render(scale);

        this.spiderLeg3.offsetY = -0.323F;
        this.spiderLeg3.offsetX = -0.415F;
        this.spiderLeg3.offsetZ = 0.41F;

        this.spiderLeg3.render(scale);

        this.spiderLeg4.offsetY = -0.323F;
        this.spiderLeg4.offsetX = 0.415F;
        this.spiderLeg4.offsetZ = 0.41F;

        this.spiderLeg4.render(scale);

        this.spiderLeg5.offsetY = -0.324F;
        this.spiderLeg5.offsetX = -0.415F;
        this.spiderLeg5.offsetZ = -0.428F;

        this.spiderLeg5.render(scale);

        this.spiderLeg6.offsetY = -0.324F;
        this.spiderLeg6.offsetX = 0.415F;
        this.spiderLeg6.offsetZ = -0.428F;

        this.spiderLeg6.render(scale);

        this.spiderHang1.offsetY = 0.25F;
        this.spiderHang1.offsetX = 0.2F;
        this.spiderHang1.offsetZ = -0.11F;

        this.spiderHang1.render(scale);

        this.spiderHang2.offsetY = 0.25F;
        this.spiderHang2.offsetX = -0.2F;
        this.spiderHang2.offsetZ = -0.12F;

        this.spiderHang2.render(scale);

        this.spiderHang3.offsetY = 0.20F;
        this.spiderHang3.offsetX = 0.16F;
        this.spiderHang3.offsetZ = -0.01F;

        this.spiderHang3.render(scale);

        this.spiderHang4.offsetY = 0.202F;
        this.spiderHang4.offsetX = -0.16F;
        this.spiderHang4.offsetZ = -0.01F;;

        this.spiderHang4.render(scale);

        this.spiderHang5.offsetY = 0.20F;
        this.spiderHang5.offsetX = 0.16F;
        this.spiderHang5.offsetZ = -0.01F;

        this.spiderHang5.render(scale);

        this.spiderHang6.offsetY = 0.20F;
        this.spiderHang6.offsetX = -0.16F;
        this.spiderHang6.offsetZ = -0.01F;

        this.spiderHang6.render(scale);
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
    	this.spiderLeg1.rotateAngleY = 0.0F;
    	this.spiderLeg1.rotateAngleZ = -0.7F;

    	this.spiderLeg2.rotateAngleY = 0.0F;
    	this.spiderLeg2.rotateAngleZ = 0.7F;

    	this.spiderLeg3.rotateAngleY = 0.0F;
    	this.spiderLeg3.rotateAngleX = -0.5F;
    	this.spiderLeg3.rotateAngleZ = -0.7F;

    	this.spiderLeg4.rotateAngleY = 0.0F;
    	this.spiderLeg4.rotateAngleX = -0.5F;
    	this.spiderLeg4.rotateAngleZ = 0.7F;

    	this.spiderLeg5.rotateAngleY = 0.02F;
    	this.spiderLeg5.rotateAngleX = 0.48F;
    	this.spiderLeg5.rotateAngleZ = -0.67F;

    	this.spiderLeg6.rotateAngleY = 0.02F;
    	this.spiderLeg6.rotateAngleX = 0.48F;
    	this.spiderLeg6.rotateAngleZ = 0.67F;

    	this.spiderHang1.rotateAngleY = 0.0F;
    	this.spiderHang1.rotateAngleZ = 0.9F;

    	this.spiderHang2.rotateAngleY = 0.0F;
    	this.spiderHang2.rotateAngleZ = -0.9F;

    	this.spiderHang3.rotateAngleY = 0.5F;
    	this.spiderHang3.rotateAngleZ = 0.9F;

    	this.spiderHang4.rotateAngleY = -0.5F;
    	this.spiderHang4.rotateAngleZ = -0.9F;

    	this.spiderHang5.rotateAngleY = -0.5F;
    	this.spiderHang5.rotateAngleZ = 0.9F;

    	this.spiderHang6.rotateAngleY = 0.5F;
    	this.spiderHang6.rotateAngleZ = -0.9F;
    }

}