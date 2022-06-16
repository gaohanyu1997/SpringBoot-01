package com.ghy.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.ghy.boot.bean.Car;
import com.ghy.boot.bean.Pet;
import com.ghy.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.filter.CharacterEncodingFilter;

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
//@ConditionalOnBean(name = "tom")
@ConditionalOnMissingBean(name = "tom")
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)  //告诉SpringBoot这是一个配置类 == 配置文件
@ImportResource("classpath:beans.xml")  //导入Spring资源文件,相当于把这个资源文件内容解析放到容器里面
@EnableConfigurationProperties(Car.class)  //开启属性配置功能
// 1 开启Car配置绑定功能
// 2 把这个Car组件自动注入到容器中
public class MyConfig {
    /*
    * proxyBeanMethods = true
    * 外部无论对配置类中的这个组件注册方法调用多少次
    * 获取的都是之前注册容器中的单实例对象
    * @ConditionalOnBean：在容器中有某个组件时
    * */
    @Bean
    public User user01(){
        User zhangsan = new User("张三", "18");
        //user组件依赖了Pet组件
        zhangsan.setPet(tomcat());
        return zhangsan;
    }

    @Bean("tom2")
    public Pet tomcat(){
        return new Pet("tomcat");
    }

    /*@Bean
    public CharacterEncodingFilter filter(){
        return null;
    }*/
}







