package package2;
/*
静态字段是一段共享空间，即多个对象拥有的静态成员b在同一片共享空间
静态字段和静态方法可以通过类名.成员(方法)直接使用
静态方法在main中可以使用类名.方法访问，还可以直接使用方法名访问
 */

public class 静态字段和静态方法 {
    public int a;
    public static int b;
    public static void test(){
        System.out.println("it's a static function");
    }

    public static void main(String[] args) {
        // b是一片共享内存
        静态字段和静态方法 test = new 静态字段和静态方法();
        静态字段和静态方法.b = 10 ;
        System.out.println(test.b);
        test.b = 20 ;
        System.out.println(静态字段和静态方法.b);

        // 这两种方法可以访问静态方法
        test();
        静态字段和静态方法.test();
    }
}
