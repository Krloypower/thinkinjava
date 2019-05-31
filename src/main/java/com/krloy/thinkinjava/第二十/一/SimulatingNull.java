package com.krloy.thinkinjava.第二十.一;

/**
 * @ClassName SimulatingNull
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-05-30 10:09
 **/
public @interface SimulatingNull {
    int id() default -1;
    String description() default "";
}
