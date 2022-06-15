package com.ghy.boot;
import ch.qos.logback.core.db.DBHelper;
import com.ghy.boot.bean.Pet;
import com.ghy.boot.bean.User;
import com.ghy.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/*主程序类
 *@SpringBootApplication:这是一个SpringBoot应用
 */
//@SpringBootApplication(scanBasePackages = "com.ghy")
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.ghy")
public class MainApplication {
    public static void main(String[] args) {
        //1 返回我们IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2 查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String s:names) {
            System.out.println(s);
        }

        //3 从容器中获取组件
        Pet tom01 = run.getBean("tom", Pet.class);
        Pet tom02 = run.getBean("tom", Pet.class);
        System.out.println("组件："+(tom01 == tom02));

        //4 配置类也是容器中的一个组件
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println("配置类:"+bean);

        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法，
        //SpringBoot总会检查这个组件是否在容器中有
        //保持组件单实例
        User user01 = bean.user01();
        User user02 = bean.user01();
        System.out.println("user01和user02是否相等："+ (user01 == user02));

        //组件依赖
        User u1 = run.getBean("user01", User.class);
        Pet p1 = run.getBean("tom", Pet.class);
        System.out.println("用户的宠物是不是容器中的宠物："+(u1.getPet() == p1));

        // 获取组件
        // 验证@Import注解：容器中会不会有这两个组件
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        System.out.println("=====");
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        DBHelper dBHelper = run.getBean(DBHelper.class);
        System.out.println(dBHelper);

    }
}
