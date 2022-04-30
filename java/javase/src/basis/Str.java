package package1;

public class Str {
    public static void main(String[] args) {
        /*
            String是引用类型
            String变量重新赋值后之前的值并不会丢失，而是暂时扔在字符池中
        */
        String str = "string and char";
        str = "hello world";
        System.out.println(str);
    }
}
