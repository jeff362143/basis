package package2;

import javax.print.DocFlavor;

/**
 * 使用extends关键字用于继承
 * 父类中的private修饰的成员变量不能被子类直接访问
 * 但是protected修饰的成员变量可以被子类直接访问，还能有效防止外部访问
 * Person test = new Student(); 引用类型为Person变量但指向Student类型的实例，运行时是一个Student
 * test对象不能使用Student的独有变量和方法，不过可以覆写父类的方法，然后使用
 * Student转型为Person了，称为向上转型
 * Student->Person->Object
 * 因为Student继承自Person，拥有Person全部功能
 * 向下转型就不可行了，Student test = new Person();
 * Person功能少于Student，无法兼容
 * intstanceof操作符判断类型
 */
public class extends_Person extends Person {
    public static void main(String[] args) {
        Student one = new Student("jeff", 21, 100);
        Person test = new Student();
        System.out.println(test instanceof Student);
        test.test();
    }
}

class Student extends Person{
    int score;
    public void test1(){}
     public void test(){
         System.out.println("i'm child-function");
     }
     Student(){}
//   任何class的构造函数，第一句话都是调用父类的构造函数  super();
     public Student(String name,int age,int score){
          super(name,age);   //显式调用
          this.score = score;
     }
}