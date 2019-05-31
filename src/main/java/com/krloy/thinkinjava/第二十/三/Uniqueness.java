package com.krloy.thinkinjava.第二十.三;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Uniqueness {
    String name() default "";
    Constrains constrains() default @Constrains(unqiue = true);
}
