package com.krloy.thinkinjava.第二十.三;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName DbTable
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-05-30 10:15
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DbTable {
    String name() default "";
}
