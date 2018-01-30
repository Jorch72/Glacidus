package com.legacy.glacidus.client.models.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelMoose extends ModelBase 
{
    public ModelRenderer body;
    public ModelRenderer leg3;
    public ModelRenderer leg1;
    public ModelRenderer leg4;
    public ModelRenderer leg2;
    public ModelRenderer snoot;
    public ModelRenderer head;
    public ModelRenderer rightantlerspike6;
    public ModelRenderer rightantlerspike4;
    public ModelRenderer rightantlerspike1;
    public ModelRenderer rightantlerspike2;
    public ModelRenderer rightantlerspike3;
    public ModelRenderer rightantlerbase;
    public ModelRenderer rightantlerspike5;
    public ModelRenderer rightantlerbeginning;
    public ModelRenderer leftantlerbase;
    public ModelRenderer leftantlerspike2;
    public ModelRenderer leftantlerspike1;
    public ModelRenderer leftantlerspike3;
    public ModelRenderer leftantlerspike6;
    public ModelRenderer leftantlerspike5;
    public ModelRenderer leftantlerspike4;
    public ModelRenderer leftantlerspike5_1;
    public ModelRenderer leftantlerspike5_2;
    public ModelRenderer leftantlerbeginning;

    public ModelMoose(float size) 
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.rightantlerbase = new ModelRenderer(this, 46, 59);
        this.rightantlerbase.mirror = true;
        this.rightantlerbase.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.rightantlerbase.addBox(-9.0F, -5.0F, -5.0F, 5, 1, 4, size);
        this.rightantlerspike4 = new ModelRenderer(this, 60, 0);
        this.rightantlerspike4.mirror = true;
        this.rightantlerspike4.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.rightantlerspike4.addBox(-9.0F, -7.0F, -2.0F, 1, 2, 1, size);
        this.rightantlerspike5 = new ModelRenderer(this, 60, 0);
        this.rightantlerspike5.mirror = true;
        this.rightantlerspike5.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.rightantlerspike5.addBox(-7.0F, -7.0F, -2.0F, 1, 2, 1, size);
        this.leftantlerspike1 = new ModelRenderer(this, 60, 0);
        this.leftantlerspike1.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.leftantlerspike1.addBox(4.2F, -7.0F, -5.0F, 1, 2, 1, size);
        this.leg4 = new ModelRenderer(this, 0, 16);
        this.leg4.mirror = true;
        this.leg4.setRotationPoint(-4.0F, 12.0F, 7.0F);
        this.leg4.addBox(-1.0F, 0.0F, -2.0F, 3, 12, 3, size);
        this.leftantlerspike3 = new ModelRenderer(this, 60, 0);
        this.leftantlerspike3.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.leftantlerspike3.addBox(6.2F, -7.0F, -5.0F, 1, 2, 1, size);
        this.leftantlerspike5 = new ModelRenderer(this, 60, 0);
        this.leftantlerspike5.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.leftantlerspike5.addBox(8.2F, -7.0F, -5.0F, 1, 2, 1, size);
        this.leftantlerspike5_1 = new ModelRenderer(this, 60, 0);
        this.leftantlerspike5_1.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.leftantlerspike5_1.addBox(8.2F, -7.0F, -5.0F, 1, 2, 1, size);
        this.leg2 = new ModelRenderer(this, 0, 16);
        this.leg2.mirror = true;
        this.leg2.setRotationPoint(-3.0F, 12.0F, -6.0F);
        this.leg2.addBox(-2.0F, 0.0F, -2.0F, 3, 12, 3, size);
        //this.leftantlerspike5_2 = new ModelRenderer(this, 60, 0);
        //this.leftantlerspike5_2.setRotationPoint(0.0F, 4.0F, -8.0F);
        //this.leftantlerspike5_2.addBox(8.2F, -7.0F, -5.0F, 1, 2, 1, 0.0F);
        this.rightantlerspike2 = new ModelRenderer(this, 60, 0);
        this.rightantlerspike2.mirror = true;
        this.rightantlerspike2.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.rightantlerspike2.addBox(-7.0F, -7.0F, -5.0F, 1, 2, 1, size);
        this.rightantlerbeginning = new ModelRenderer(this, 48, 0);
        this.rightantlerbeginning.mirror = true;
        this.rightantlerbeginning.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.rightantlerbeginning.addBox(-6.0F, -4.0F, -4.0F, 3, 1, 1, size);
        this.leftantlerspike2 = new ModelRenderer(this, 60, 0);
        this.leftantlerspike2.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.leftantlerspike2.addBox(4.2F, -7.0F, -2.0F, 1, 2, 1, size);
        this.rightantlerspike6 = new ModelRenderer(this, 60, 0);
        this.rightantlerspike6.mirror = true;
        this.rightantlerspike6.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.rightantlerspike6.addBox(-5.0F, -7.0F, -2.0F, 1, 2, 1, size);
        this.leftantlerspike6 = new ModelRenderer(this, 60, 0);
        this.leftantlerspike6.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.leftantlerspike6.addBox(6.2F, -7.0F, -2.0F, 1, 2, 1, size);
        this.leftantlerbeginning = new ModelRenderer(this, 48, 0);
        this.leftantlerbeginning.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.leftantlerbeginning.addBox(3.0F, -4.0F, -4.0F, 3, 1, 1, size);
        this.leftantlerspike4 = new ModelRenderer(this, 60, 0);
        this.leftantlerspike4.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.leftantlerspike4.addBox(8.2F, -7.0F, -2.0F, 1, 2, 1, size);
        this.leg1 = new ModelRenderer(this, 0, 16);
        this.leg1.setRotationPoint(4.0F, 12.0F, -6.0F);
        this.leg1.addBox(-2.0F, 0.0F, -2.0F, 3, 12, 3, size);
        this.rightantlerspike1 = new ModelRenderer(this, 60, 0);
        this.rightantlerspike1.mirror = true;
        this.rightantlerspike1.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.rightantlerspike1.addBox(-5.0F, -7.0F, -5.0F, 1, 2, 1, size);
        this.rightantlerspike3 = new ModelRenderer(this, 60, 0);
        this.rightantlerspike3.mirror = true;
        this.rightantlerspike3.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.rightantlerspike3.addBox(-9.0F, -7.0F, -5.0F, 1, 2, 1, size);
        this.leftantlerbase = new ModelRenderer(this, 46, 59);
        this.leftantlerbase.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.leftantlerbase.addBox(4.2F, -5.0F, -5.0F, 5, 1, 4, size);
        this.leg3 = new ModelRenderer(this, 0, 16);
        this.leg3.setRotationPoint(4.0F, 12.0F, 7.0F);
        this.leg3.addBox(-2.0F, 0.0F, -2.0F, 3, 12, 3, size);
        this.snoot = new ModelRenderer(this, 0, 33);
        this.snoot.setRotationPoint(0.0F, 4.0F, -9.1F);
        this.snoot.addBox(-2.0F, 0.0F, -8.0F, 4, 3, 3, size);
        this.body = new ModelRenderer(this, 18, 7);
        this.body.setRotationPoint(0.0F, 5.0F, 2.0F);
        this.body.addBox(-5.0F, -10.0F, -7.0F, 10, 17, 10, size);
        this.setRotateAngle(body, 1.5707963267948966F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.head.addBox(-3.0F, -4.0F, -6.0F, 6, 8, 7, size);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
    { 
    	if (this.isChild)
        {
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, 0.55F, 0F);
             GlStateManager.scale(0.6F, 0.6F, 0.6F);
             this.rightantlerbase.render(f5);
             this.rightantlerspike4.render(f5);
             this.rightantlerspike5.render(f5);
             this.leftantlerspike1.render(f5);
             this.leg4.render(f5);
             this.leftantlerspike3.render(f5);
             this.leftantlerspike5.render(f5);
             //this.leftantlerspike5_1.render(f5);
             this.leg2.render(f5);
             //this.leftantlerspike5_2.render(f5);
             this.rightantlerspike2.render(f5);
             this.rightantlerbeginning.render(f5);
             this.leftantlerspike2.render(f5);
             this.rightantlerspike6.render(f5);
             this.leftantlerspike6.render(f5);
             this.leftantlerbeginning.render(f5);
             this.leftantlerspike4.render(f5);
             this.leg1.render(f5);
             this.rightantlerspike1.render(f5);
             this.rightantlerspike3.render(f5);
             this.leftantlerbase.render(f5);
             this.leg3.render(f5);
             this.snoot.render(f5);
             this.body.render(f5);
             this.head.render(f5);
            GlStateManager.popMatrix();
        }
    	else
    	{
        this.rightantlerbase.render(f5);
        this.rightantlerspike4.render(f5);
        this.rightantlerspike5.render(f5);
        this.leftantlerspike1.render(f5);
        this.leg4.render(f5);
        this.leftantlerspike3.render(f5);
        this.leftantlerspike5.render(f5);
        //this.leftantlerspike5_1.render(f5);
        this.leg2.render(f5);
        //this.leftantlerspike5_2.render(f5);
        this.rightantlerspike2.render(f5);
        this.rightantlerbeginning.render(f5);
        this.leftantlerspike2.render(f5);
        this.rightantlerspike6.render(f5);
        this.leftantlerspike6.render(f5);
        this.leftantlerbeginning.render(f5);
        this.leftantlerspike4.render(f5);
        this.leg1.render(f5);
        this.rightantlerspike1.render(f5);
        this.rightantlerspike3.render(f5);
        this.leftantlerbase.render(f5);
        this.leg3.render(f5);
        this.snoot.render(f5);
        this.body.render(f5);
        this.head.render(f5);
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
    	
    	//Antlers
    	this.leftantlerbase.rotateAngleX = head.rotateAngleX;
    	this.leftantlerbase.rotateAngleY = head.rotateAngleY;
    	this.rightantlerbase.rotateAngleX = head.rotateAngleX;
    	this.rightantlerbase.rotateAngleY = head.rotateAngleY;
    	this.leftantlerbeginning.rotateAngleX = head.rotateAngleX;
    	this.leftantlerbeginning.rotateAngleY = head.rotateAngleY;
    	this.rightantlerbeginning.rotateAngleX = head.rotateAngleX;
    	this.rightantlerbeginning.rotateAngleY = head.rotateAngleY;
    	
    	this.rightantlerspike1.rotateAngleX = head.rotateAngleX;
    	this.rightantlerspike1.rotateAngleY = head.rotateAngleY;
    	this.rightantlerspike2.rotateAngleX = head.rotateAngleX;
    	this.rightantlerspike2.rotateAngleY = head.rotateAngleY;
    	this.rightantlerspike3.rotateAngleX = head.rotateAngleX;
    	this.rightantlerspike3.rotateAngleY = head.rotateAngleY;
    	this.rightantlerspike4.rotateAngleX = head.rotateAngleX;
    	this.rightantlerspike4.rotateAngleY = head.rotateAngleY;
    	this.rightantlerspike5.rotateAngleX = head.rotateAngleX;
    	this.rightantlerspike5.rotateAngleY = head.rotateAngleY;
    	this.rightantlerspike6.rotateAngleX = head.rotateAngleX;
    	this.rightantlerspike6.rotateAngleY = head.rotateAngleY;
    	
    	this.leftantlerspike1.rotateAngleX = head.rotateAngleX;
    	this.leftantlerspike1.rotateAngleY = head.rotateAngleY;
    	this.leftantlerspike2.rotateAngleX = head.rotateAngleX;
    	this.leftantlerspike2.rotateAngleY = head.rotateAngleY;
    	this.leftantlerspike3.rotateAngleX = head.rotateAngleX;
    	this.leftantlerspike3.rotateAngleY = head.rotateAngleY;
    	this.leftantlerspike4.rotateAngleX = head.rotateAngleX;
    	this.leftantlerspike4.rotateAngleY = head.rotateAngleY;
    	this.leftantlerspike5.rotateAngleX = head.rotateAngleX;
    	this.leftantlerspike5.rotateAngleY = head.rotateAngleY;
    	this.leftantlerspike6.rotateAngleX = head.rotateAngleX;
    	this.leftantlerspike6.rotateAngleY = head.rotateAngleY;
    	
    	
    	
    }
}
