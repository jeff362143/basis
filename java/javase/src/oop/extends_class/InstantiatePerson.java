package package2.extends_class;

import package2.extends_class.Person;

public class InstantiatePerson {
    public static void main(String[] args) {
        Person one = new Person();

        //可变参数表示多个参数
         one.setFriend("h","z","f");
         System.out.println(one.getFriend());
    }
}

