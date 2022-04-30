package package2.extends_class;


/**
 * 但是protected修饰的成员变量可以被子类直接访问，还能有效防止外部访问
 * Person test = new Student();Student转型为Person了，称为向上转型；因为Student继承自Person，拥有Person全部功能
 * Person功能少于Student，new Person无法兼容Student类型的变量
 * instanceof操作符判断类型
 */
public class ExtendPerson extends Person {
    public static void main(String[] args) {
        Person person = new Student();
//      引用类型为Person变量但指向Student类型的实例，运行时是一个Student。下方结果都为true
        System.out.println(person instanceof Person);
        System.out.println(person instanceof Student);
        person.test();
    }
}

class Student extends Person{
     public void test(){
         System.out.println("i'm child-function");
     }
     public Student(){
         super();   // 类的构造方法都会隐氏调用它的父类构造函数。这里是显式调用
     }
}