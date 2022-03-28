package package2;
/*
静态字段是一段共享空间，即多个对象拥有的静态成员b在同一片共享空间
静态方法在main中可以使用类名.方法访问，还可以直接使用方法名访问
 */

public class Static {
    public static int num;
    public static void test(){
        System.out.println("it's a static function");
    }
    public static void main(String[] args) {
        Static staticObj = new Static();
        Static.num = 10 ;
        System.out.println(staticObj.num);
        staticObj.num = 20 ;
        System.out.println(Static.num);

        // 这两种方法可以访问静态方法
        test();
        Static.test();
    }
}
