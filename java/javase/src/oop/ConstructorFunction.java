package package2;

public class ConstructorFunction {
    int age ;
    public static void main(String[] args) {
        /*
        * 构造方法--每个类都会有构造方法
        * 无人工定义构造方法时，系统为类自动生成一个无参数的Constructor构造函数
        * 若是已经定义了一个有参构造方法，系统便不会自动生成无参构造方法了
        */
        ConstructorFunction test = new ConstructorFunction();
        System.out.println(test.age);
    }
}
