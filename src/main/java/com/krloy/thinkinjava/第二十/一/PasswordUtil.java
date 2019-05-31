package com.krloy.thinkinjava.第二十.一;

import java.util.List;

/**
 * @ClassName PasswordUtil
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-05-29 18:49
 **/
public class PasswordUtil {
    @UseCase(id = 47, description = "password must contain at least on numbers")
    public boolean validatePassword(String password){
        return (password.matches("\\w\\d\\w*"));
    }

    @UseCase(id=48)
    public String encryptPassword(String password){
        return new  StringBuilder(password).reverse().toString();
    }

//    @UseCase(id = 49, description = "new password can not equal prevPassword used ones")
    public boolean checkForNewPassword(List<String> prevPassword,String password){
        return !prevPassword.contains(password);
    }
}
