package package2;

public class 多态 extends Person {
    public String name = "jeff";


    /*
    a.方法的覆写：继承关系中，子类定义了一个与父类签名完全相同(包括修饰符)的方法，被称为覆写(override)
    使用 super 可以访问父类的已被覆写的方法
    final修饰符有多种作用：
    1、修饰的方法可以阻止覆写
    2、修饰的class可以阻止继承
    3、修饰的变量会在共享内存中
    b.多态：Java的实例方法调用是基于运行时的实际类型的动态调用，而非变量的声明类型。
    这个非常重要的特性在面向对象编程中称之为多态。它的英文拼写非常复杂：Polymorphic。
    */


    //demo_覆写
    //父类存在一个静态的menber-function test，覆写要求签名一致(全部一致)
    public void test(){
         System.out.println("a menber-function of child-class");
    }

    //  test_demo     覆写一下继承自Object的toString方法,super可以用来调用父类的已被覆写的方法，如toString
    public String toString(){
        return super.toString()+this.name;
    }


    public static void main(String[] args) {
        //demo_多态
        Person test = new 多态();
        test.test();
        System.out.println(test.toString());//测试覆写的toString方法


    }
}
