package com.chariotsolutions.springthreeone;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@ActiveProfiles(profiles = "dev")
public class DevBeansTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void testDevBeans() {
        SimpleBean simpleBean = applicationContext.getBean("constructorBean", SimpleBean.class);
        assertNotNull(simpleBean);
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void testProdBean() {
        SimpleBean prodBean = applicationContext.getBean("prodBean", SimpleBean.class);
        assertNull(prodBean);
    }
}
