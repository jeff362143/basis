package package2.extends_class;

import package1.Array;

import java.util.Arrays;

//  Person中的成员变量是private的，不能被外部直接访问，
public class Person{
    private String[] friend ;

//  方法的重载
    public Person(String[] friend) {
        this.friend = friend;
    }
    public Person(){}

//  可变参数
    public  void setFriend(String... friend){
        this.friend = friend;
    }
    public String getFriend(){
        return Arrays.toString(this.friend) ;
   }
    public  void test(){
        System.out.println("a member-function of Person");
   }

}