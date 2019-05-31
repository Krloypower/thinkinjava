package com.krloy.thinkinjava.第二十.三;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TableCreator
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-05-30 14:32
 **/
public class TableCreator {
    public static void main(String[] args) throws Exception {
        if (args.length < 1){
            System.out.println("arguments: annotated classes");
            System.exit(0);
        }
        for (String className : args){
            Class<?> cl = Class.forName(className);
            DbTable dbTable = cl.getAnnotation(DbTable.class);
            if (dbTable== null){
                System.out.println("no DBTable annotations in class " + className);
                continue;
            }
            String tableName = dbTable.name();
            if (tableName.length() < 1){
                tableName = cl.getName().toUpperCase();
            }
            List<String> columnDefs = new ArrayList<>();
            for(Field field : cl.getDeclaredFields()){
                String columnName = null;
                Annotation[] anns = field.getDeclaredAnnotations();
                if (anns.length < 1) continue;
                if (anns[0] instanceof SQLInteger){
                    SQLInteger sInt = (SQLInteger) anns[0];
                    if (sInt.name().length()  < 1){
                        columnName = field.getName().toUpperCase();
                    }else {
                        columnName = sInt.name();
                    }
                    columnDefs.add(columnName + " INT" + getConstraints(sInt.constrains()) );
                }
                if (anns[0] instanceof  SQLString){
                    SQLString sString = (SQLString) anns[0];
                    if (sString.name().length() < 1){
                        columnName = field.getName().toUpperCase();
                    }else {
                        columnName = sString.name();
                    }
                    columnDefs.add(columnName + " VARCHAR("+sString.value() + ")" + getConstraints(sString.constrains()));

                }

                StringBuilder createCommand = new StringBuilder("CREATE TABLE " +tableName
                +"(");
                for (String columnDef : columnDefs){
                    createCommand.append(" \n  "+columnDef+ ",");
                }
                String tableCreate = createCommand.substring(0,createCommand.length()-1) + ");";
                System.out.println("table crete sql for " + className + " is : \n " + tableCreate);
            }
        }
    }

    private static String getConstraints(Constrains con){
        String constraints = "";
        if (!con.allowNull()){
            constraints +=" NOT NULl";
        }
        if (con.primaryKey()){
            constraints +=" PRIMARY KEY";
        }
        if (con.unqiue()){
            constraints +=" UNIQUE";
        }
        return constraints;
    }
}
