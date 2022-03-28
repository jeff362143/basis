package package2;

import package2.extends_class.Person;

// 多态
public class Polymorphic extends Person {
    public String name = "jeff";


    /*
    方法的覆写：继承关系中，子类定义了一个与父类签名完全相同(包括修饰符)的方法，被称为覆写(override);复写后使用super可以访问父类的已被覆写的方法
    final修饰符有多种作用：
    1、修饰的方法可以阻止覆写
    2、修饰的class可以阻止继承
    3、修饰的变量会在共享内存中

    多态：Java的实例方法调用是基于运行时的实际类型的动态调用，而非变量的声明类型。
    这个非常重要的特性在面向对象编程中称之为多态。它的英文拼写复杂：Polymorphic。
    */


    //demo_覆写
    //父类存在一个静态的成员函数 test，覆写要求全部一致
    public void test(){
         System.out.println("a member-function of child-class");
    }

    //  test_demo     覆写一下继承自Object的toString方法,super可以用来调用父类的已被覆写的方法，如toString
    public String toString(){
        return this.name;
    }

    public static void main(String[] args) {
        Person person = new Polymorphic();
        person.test();
        System.out.println(person.toString());//测试覆写的toString方法
    }
}
