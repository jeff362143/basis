package package2;
/*
接口就是纯抽象的类,不能有正常的实例的函数，抽象函数前面默认修饰符为 public abstract，
所以这两个修饰符可以省略，但在使用implement关键字实现的子类中，实现方法必须有public修饰符
接口需要注意：
1、可以implement多个interface，但只能继承一个父类
2、interface可以继承interface，使用extends关键字
interface Student extends Human
3、接口中可以定义一个default方法，继承的子类可以不必实现该方法，只在需要时再重写











4、接口可以定义字段，只是有两个限制：
a.字段修饰必须是 public static final类型,可以省略    b.初始化后必须赋值
 */
public class Inter implements skill{
    public void sing(){}
    public void jump(){}
    public void rap(){}
    public static void main(String[] args) {
          skill test = new Inter();
          test.basketball();
    }
}

interface skill{
    int abc = 10;
    void sing();
    void jump();
    void rap();
    default void basketball(){
        System.out.println("play basketball");
    }
}
