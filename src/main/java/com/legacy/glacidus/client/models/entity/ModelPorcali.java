package com.legacy.glacidus.client.models.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelPorcali extends ModelBase 
{	
    public ModelRenderer body;
    public ModelRenderer leg4;
    public ModelRenderer leg3;
    public ModelRenderer leg2;
    public ModelRenderer head;
    public ModelRenderer snoot;
    public ModelRenderer leg1;
    public ModelRenderer hornbottom1;
    public ModelRenderer hornbottom2;
    public ModelRenderer horntop2;
    public ModelRenderer horntop1;
    protected float childYOffset = 8.0F;
    protected float childZOffset = 4.0F;


    public ModelPorcali(float scale) 
    {
    	this.textureWidth = 64;
        this.textureHeight = 32;
        this.leg2 = new ModelRenderer(this, 0, 16);
        this.leg2.setRotationPoint(-3.0F, 18.0F, 7.0F);
        this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.hornbottom1 = new ModelRenderer(this, 24, 0);
        this.hornbottom1.setRotationPoint(0.0F, 12.0F, -6.0F);
        this.hornbottom1.addBox(1.1F, 1.2F, -8.6F, 3, 1, 1, 0.0F);
        this.horntop2 = new ModelRenderer(this, 37, 0);
        this.horntop2.mirror = true;
        this.horntop2.setRotationPoint(0.0F, 12.0F, -6.0F);
        this.horntop2.addBox(-4.25F, 3.3F, -8.6F, 3, 1, 1, 0.0F);
        this.hornbottom2 = new ModelRenderer(this, 24, 0);
        this.hornbottom2.mirror = true;
        this.hornbottom2.setRotationPoint(0.0F, 12.0F, -6.0F);
        this.hornbottom2.addBox(-3.9F, 1.2F, -8.6F, 3, 1, 1, 0.0F);
        this.leg1 = new ModelRenderer(this, 0, 16);
        this.leg1.setRotationPoint(-3.0F, 18.0F, -5.0F);
        this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 12.0F, -6.0F);
        this.head.addBox(-4.0F, -4.0F, -8.0F, 8, 8, 8, 0.0F);
        this.leg3 = new ModelRenderer(this, 0, 16);
        this.leg3.mirror = true;
        this.leg3.setRotationPoint(3.0F, 18.0F, -5.0F);
        this.leg3.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.snoot = new ModelRenderer(this, 16, 16);
        this.snoot.setRotationPoint(0.0F, 12.0F, -6.0F);
        this.snoot.addBox(-2.0F, 0.0F, -9.0F, 4, 3, 1, 0.0F);
        this.leg4 = new ModelRenderer(this, 0, 16);
        this.leg4.mirror = true;
        this.leg4.setRotationPoint(3.0F, 18.0F, 7.0F);
        this.leg4.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.horntop1 = new ModelRenderer(this, 37, 0);
        this.horntop1.setRotationPoint(0.0F, 12.0F, -6.0F);
        this.horntop1.addBox(1.0F, 3.55F, -8.6F, 3, 1, 1, 0.0F);
        this.body = new ModelRenderer(this, 28, 8);
        this.body.setRotationPoint(0.0F, 11.0F, 2.0F);
        this.body.addBox(-5.0F, -10.0F, -7.0F, 10, 16, 8, 0.0F);
        this.setRotateAngle(body, 1.5707963267948966F, 0.0F, 0.0F);
    }

	@Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) 
    {         
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);

        if (this.isChild)
        {
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, this.childYOffset * scale, this.childZOffset * scale);
            this.head.render(scale);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5F, 0.5F, 0.5F);
            GlStateManager.translate(0.0F, 24.0F * scale, 0.0F);
            this.body.render(scale);
            this.leg1.render(scale);
            this.leg2.render(scale);
            this.leg3.render(scale);
            this.leg4.render(scale);
            this.snoot.render(scale);
            this.horntop1.render(scale);
            this.horntop2.render(scale);
            this.hornbottom1.render(scale);
            this.hornbottom2.render(scale);
            GlStateManager.popMatrix();
        }
        else
        {
            this.head.render(scale);
            this.body.render(scale);
            this.leg1.render(scale);
            this.leg2.render(scale);
            this.leg3.render(scale);
            this.leg4.render(scale);
            this.snoot.render(scale);
            this.horntop1.render(scale);
            this.horntop2.render(scale);
            this.hornbottom1.render(scale);
            this.hornbottom2.render(scale);
        }
        
    }
    
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        this.head.rotateAngleX = headPitch * 0.017453292F;
        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.body.rotateAngleX = ((float)Math.PI / 2F);
        this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.snoot.rotateAngleX = head.rotateAngleX;
    	this.snoot.rotateAngleY = head.rotateAngleY;
    	
    	this.hornbottom1.rotateAngleZ = -0.31869712141416456F;
    	this.hornbottom2.rotateAngleZ = 0.27314402793711257F;
    	this.horntop1.rotateAngleZ = -1.1838568316277536F;
     	this.horntop2.rotateAngleZ = 1.0471975511965976F;
    	
        this.horntop1.rotateAngleX = head.rotateAngleX;
    	this.horntop1.rotateAngleY = head.rotateAngleY;
    	this.hornbottom1.rotateAngleX = head.rotateAngleX;
    	this.hornbottom1.rotateAngleY = head.rotateAngleY;
    	
    	this.horntop2.rotateAngleX = head.rotateAngleX;
    	this.horntop2.rotateAngleY = head.rotateAngleY;
    	this.hornbottom2.rotateAngleX = head.rotateAngleX;
    	this.hornbottom2.rotateAngleY = head.rotateAngleY;

    }
}
