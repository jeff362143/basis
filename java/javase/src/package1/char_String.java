package package1;

public class char_String {
    public static void main(String[] args) {
        /*
             字符可以使用十进制或者使用Unicode编码
             因为Unicode使用32位2进制，所以可以用四位16进制表示，但前面应加上反斜杠，转义。。
         */
         char a = '\u4e2d';    //  反斜杠u  这是一个转义字符
         a = 100;
         a = '好';
         System.out.println(a);

//       与char类型不同，String类型是引用类型，用双引号表示字符串
//        String类型还有一个很重要的特性，就是字符串不可变
         String str = "abc\n\u0064\u0064"; //这个字符串有四个字符
         str = "替换了之前？";  //  上面的str内容在堆中不会消失，str指向了新的存储内容地址
//       str = NULL;和str = ""; 后者是一个有效的String对象，为空
         System.out.println(str);
    }
}
