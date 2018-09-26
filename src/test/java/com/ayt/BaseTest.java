package com.ayt;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Auther: ayt
 * @Date: 2018/9/9 14:31
 * @Description: Don't worry ,just try
 * 用于配置spring 和Junit整合，junit启动时加载springIoc容器
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class BaseTest {
}
