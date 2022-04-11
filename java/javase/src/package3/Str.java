package package3;
/*
String也是一个class，编译器特殊处理后可以使用" "表示，在内部其实是用数组表示String的
因此String str = new String(new char[]{'h','e','l','l','o'})
 */
public class Str {

    public static void main(String[] args) {
        String str = new String(new char[]{'h','e','l','l','o'});
        System.out.println(str);

//      java有char数据类型
        char alphabet = 'z';
        System.out.println(alphabet);
    }
}
