package com.ghy.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.ghy.boot.bean.Pet;
import com.ghy.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
/*
* 配置类里面使用@Bean标注在方法上给容器注册组件，默认为单实例true
* 配置类也是容器中的一个组件
* proxyBeanMethods：代理bean的方法
*   Full(proxyBeanMethods = true)
*   Lite(proxyBeanMethods = false)
*   组件依赖
*
* 4 @Import({User.class, DBHelper.class})
*   给容器中自动创建出这两个类型的组件,默认组件的名字就是全类名
* */
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)  //告诉SpringBoot这是一个配置类 == 配置文件
public class MyConfig {
    /*
    * 给容器中添加组件。默认以方法名作为组件的id。
    * 返回类型就是组件类型。
    * 返回的值，就是组件在容器中实例
    *
    * proxyBeanMethods = true
    * 外部无论对配置类中的这个组件注册方法调用多少次
    * 获取的都是之前注册容器中的单实例对象
    * */
    @Bean
    public User user01(){
        User zhangsan = new User("张三", "18");
        //user组件依赖了Pet组件
        zhangsan.setPet(tomcat());
        return zhangsan;
    }

    @Bean("tom")
    public Pet tomcat(){
        return new Pet("tomcat");
    }
}







