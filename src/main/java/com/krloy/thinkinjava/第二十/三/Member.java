package com.krloy.thinkinjava.第二十.三;

/**
 * @ClassName Member
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-05-30 10:27
 **/
@DbTable(name = "MEMBER")
public class Member {
    @SQLString(30)
    String firstName;

    @SQLString(50)
    String lastName;

    @SQLInteger
    Integer age;

    @SQLString(value = 30 ,constrains = @Constrains(primaryKey = true))
    String handle;

    static int memberCount;

    public String getHandle(){
        return handle;
    }
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String toString(){
        return handle;
    }

    public Integer getAge(){
        return age;
    }
}
