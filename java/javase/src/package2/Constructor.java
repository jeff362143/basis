package package2;

public class Constructor {
    int test_age ;
    public static void main(String[] args) {
        /*
        * 构造方法--每个类都会有构造方法
        * 无人工定义构造方法时，系统为类自动生成一个无参数的Constructor构造函数
        * 若是已经定义了一个有参构造方法，系统便不会自动生成无参构造方法了
        * 构造方法与类的普通方法比较最大区别在于：构造方法没有返回值
        */
        Constructor test = new Constructor();
        System.out.println(test.test_age);

        Person two = new Person("jeff",21);
        Person two1 = new Person();
        System.out.println(two.getName()+two.getAge());
    }
}
