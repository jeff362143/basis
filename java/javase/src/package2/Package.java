package package2;
import package1.*;

public class Package {
    /*
    完整类名为  包名.类名
    在Java虚拟机执行的时候，JVM只看完整类名，因此，只要包名不同，类就不同
    在一个class中，引用其他class方法：
    1、直接写出完整类名
    2、使用import语句，导入其他类
    使用*可以把这个包下面所有class引进来...但是我在这里测试没成功。。。。。。
    注意：
    JDK的核心类使用java.lang包，编译器会自动导入；
     */
    public static void main(String[] args) {
        //    demo_1
        Num test1 = new Num();
        System.out.println(test1.getNum());
//      demo_2
        Num test12 = new Num();
        System.out.println(test12.getNum());
    }
}
