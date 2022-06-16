package com.ghy.boot.bean;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/*
* 只有在容器中的组件,才会拥有Spring提供的强大功能
* */
//@Component
@Data   //生成get,set
@ToString   //toString
@NoArgsConstructor  //无参构造器
@AllArgsConstructor //全参构造器
//@EqualsAndHashCode  //equals和hashcode
@ConfigurationProperties(prefix = "mycard")
public class Car {
    private String brand;
    private String price;
}
