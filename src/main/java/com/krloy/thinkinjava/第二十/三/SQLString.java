package com.krloy.thinkinjava.第二十.三;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName SQLString
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-05-30 10:20
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString {
    int value() default 0;
    String name() default "";
    Constrains constrains() default @Constrains;
}
