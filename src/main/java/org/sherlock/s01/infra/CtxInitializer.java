package org.sherlock.s01.infra;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author Evgeny Borisov
 */
public class CtxInitializer implements ApplicationContextInitializer<GenericApplicationContext>
{
    @Override
    public void initialize(GenericApplicationContext context) {
        context.getDefaultListableBeanFactory().setAllowBeanDefinitionOverriding(false);
    }
}
