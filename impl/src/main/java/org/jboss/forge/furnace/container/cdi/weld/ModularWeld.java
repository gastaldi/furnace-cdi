/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.forge.furnace.container.cdi.weld;

import org.jboss.weld.bootstrap.api.CDI11Bootstrap;
import org.jboss.weld.bootstrap.spi.Deployment;
import org.jboss.weld.configuration.spi.ExternalConfiguration;
import org.jboss.weld.configuration.spi.helpers.ExternalConfigurationBuilder;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.resources.spi.ResourceLoader;

/**
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 */
public class ModularWeld extends Weld
{
   private final ResourceLoader resourceLoader;
   private final ExternalConfiguration config;

   public ModularWeld(String containerId, ResourceLoader resourceLoader)
   {
      super(containerId);
      this.resourceLoader = resourceLoader;
      this.config = new ExternalConfigurationBuilder()
               .add("org.jboss.weld.bootstrap.preloaderThreadPoolSize", 0)
               .add("org.jboss.weld.bootstrap.concurrentDeployment", false).build();
   }

   @Override
   protected Deployment createDeployment(ResourceLoader loader, CDI11Bootstrap bootstrap)
   {
      Deployment deployment = super.createDeployment(resourceLoader, bootstrap);
      deployment.getServices().add(ExternalConfiguration.class, config);
      return deployment;
   }
}
