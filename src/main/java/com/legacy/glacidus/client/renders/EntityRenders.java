package com.legacy.glacidus.client.renders;

<<<<<<< HEAD
import com.legacy.glacidus.client.renders.entities.RenderDropSpider;
import com.legacy.glacidus.entities.hostile.EntityDropSpider;
=======
import com.legacy.glacidus.client.renders.entity.GlimmerRenderer;
import com.legacy.glacidus.client.renders.entity.PorcaliRenderer;
import com.legacy.glacidus.entities.passive.EntityPorcali;
import com.legacy.glacidus.entities.util.EntityGlimmer;
>>>>>>> origin/master

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class EntityRenders 
{

	public static void initialization()
	{
<<<<<<< HEAD
		register(EntityDropSpider.class, RenderDropSpider.class);
=======
		register(EntityPorcali.class, PorcaliRenderer.class);
		register(EntityGlimmer.class, GlimmerRenderer.class);
>>>>>>> origin/master
	}

	private static<T extends Entity> void register(Class<T> clazz, Class<? extends Render<T>> render)
	{
		RenderingRegistry.registerEntityRenderingHandler(clazz, new IRenderFactory<T>() 
		{
			@Override
			public Render<T> createRenderFor(RenderManager manager) 
			{
				try 
				{
					return render.getConstructor(RenderManager.class).newInstance(manager);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}

				return null;
			}
		});
	}

}