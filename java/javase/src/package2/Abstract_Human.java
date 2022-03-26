package package2;

public class Abstract_Human extends Human{
    public void test(){
        System.out.println("it's a member-function of child class");
    }
    public static void main(String[] args) {
        /*
          抽象类和抽象方法使用abstract修饰时,前面修饰符默认为public
          抽象方法只能在抽象类中定义，抽象类只能被继承，不能实例化，抽象类中可以有非抽象方法
          抽象方法实际上是一种规范，子类继承抽象类就必须实现它的抽象方法，否则报错
        */
         Human test = new Abstract_Human();
         test.test();

    }
}


