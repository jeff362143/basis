package package2;

public class method2 {
    public static void main(String[] args) {
        Person one = new Person();
        //用数组来表示函数多个参数，还可以使用可变参数
//        one.setFriend(new String[]{"aa","bb"});
//        System.out.println(one.getFriend());

        //可变参数表示多个参数
         one.setFriend("aa","bb","cc");
         System.out.println(one.getFriend());
    }
}

