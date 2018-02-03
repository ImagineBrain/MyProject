package com.xzx.test;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    Class<Student> studentClass = Student.class;

    /**
     * 通过类直接获取
     */
    @Test
    public void test1() {
        Class<Student> studentClass = Student.class;
        System.out.println("通过类直接获取" + studentClass);
    }

    /**
     * 通过路径获取
     */
    @Test
    public void test2() {
        try {
            Class<?> studentClass2 = Class.forName("com.xzx.reflection.test.Student");
            System.out.println("通过路径获取" + studentClass2);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 通过对象获取
     */
    @Test
    public void test3() {
        Student student = new Student("Kael", 18);
        @SuppressWarnings("unchecked")
        Class<Student> studentClass3 = (Class<Student>) student.getClass();
        System.out.println("通过对象获取" + studentClass3);
    }

    /**
     * 获取构造器
     */
    @Test
    public void test4() {
        try {
            System.out.println("获取构造器实例化类");
            Constructor<Student> constructor = studentClass.getConstructor(String.class, int.class);
            constructor.setAccessible(true); // 取消访问控制
            Student newStudent = constructor.newInstance("Bill", 20);
            newStudent.speak();
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    /**
     * 获取类的公有方法（包括从父类继承）
     */
    @Test
    public void test5() {
        Student student = new Student("Bill", 18);
        System.out.print("获取类的公有方法（包括从父类继承）:");
        Method[] methods = student.getClass().getMethods();
        for (Method method : methods) {
            System.out.println("\t" + method.getName() + "\t");
            if ("speak".equals(method.getName())) {
                try {
                    method.invoke(student);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println();
    }

    /**
     * 获取类的方法（不包括从父类继承）
     */
    @Test
    public void test6() {
        System.out.println("获取类的方法（不包括从父类继承）");
        try {
            Student student = new Student("Bill", 18);
            Method methodSpeak = student.getClass().getDeclaredMethod("learn", String.class);
            methodSpeak.setAccessible(true); // 设置可见性
            System.out.println(methodSpeak.getName());
            try {
                methodSpeak.invoke(student, "Math");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 获取类的公有属性（包括从父类继承）
     */
    @Test
    public void test7() {
        System.out.println("获取类的公有属性（包括从父类继承）");
        Field[] fields = studentClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    /**
     * 获取类的属性（不包活从父类继承）
     */
    @Test
    public void test8() {
        try {
            Field field = studentClass.getDeclaredField("grade");
            System.out.println("获取类的属性（不包活从父类继承）:" + field.getName());
        } catch (NoSuchFieldException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 获取父类
     */
    @Test
    public void test9() {
        @SuppressWarnings("unchecked")
        Class<People> peopleClass = (Class<People>) studentClass.getSuperclass();
        System.out.println("获取父类：" + peopleClass.getName());
    }

    /**
     * 获取接口
     */
    @Test
    public void test10() {
        Class<?>[] interfaceClasses = studentClass.getInterfaces();
        System.out.print("获取接口:");
        for (Class<?> interfaceClass : interfaceClasses) {
            System.out.print("\t" + interfaceClass.getName() + "\t");
        }
        System.out.println();
    }
}
