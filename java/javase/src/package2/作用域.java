package package2;
import package1.*;
/*
public protected private 还有package(不写时默认)这些修饰符用于限定访问作用域
但是记得导入包，不然可以访问也无法找到其地址
public定义的class 和 interface 可以被其他任何类访问
private一般不能修饰外部类，只能修饰内部类,暂且不管
private修饰的方法和field访问权限限定在类内部
protected可以被子类及子孙类
package修饰的类和方法可以被同一个包的访问
 */
class 作用域 {

    public static void main(String[] args) {
//        demo_1
          test1 test = new test1();   //test1修饰符为public，但是在其他包中，需导入
          System.out.println(test.getTest_num());
//        demo_2
          test obj = new test();
          obj.hi();
          obj.hi1();
    }


}
