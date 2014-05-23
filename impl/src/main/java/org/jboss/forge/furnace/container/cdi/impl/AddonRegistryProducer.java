package org.jboss.forge.furnace.container.cdi.impl;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Typed;
import javax.inject.Singleton;

import org.jboss.forge.furnace.addons.AddonRegistry;

/**
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 */
@Singleton
public class AddonRegistryProducer
{
   private AddonRegistry registry;

   @Produces
   @Typed(AddonRegistry.class)
   @Singleton
   public AddonRegistry produceGlobalAddonRegistry()
   {
      return registry;
   }

   public void setRegistry(AddonRegistry registry)
   {
      this.registry = registry;
   }
}
