package package1;

public class Char {
    public static void main(String[] args) {
        /*
             字符可以使用十进制或者使用Unicode编码
             因为Unicode使用16位2进制表示，因此也可以用四位16进制表示，但前面应加上斜杠u进行转义(斜杠写在注释中也会报错)
         */
         char c = '\u4f60';
         System.out.println(c);
    }
}
