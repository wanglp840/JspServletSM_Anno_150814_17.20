package com.wanglp.web.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * Created by Administrator on 2015/5/16.
 */
public class ResourceTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    Resource rs = ac.getResource("classpath:applicationContext.xml");

}
