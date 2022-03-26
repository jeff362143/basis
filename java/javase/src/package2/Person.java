package package2;


/**
 *    Person中的成员变量是private的，不能被外部直接访问，
 *    因此设置了几个public成员函数用来充当外界接口，可以
 *    用来修改和访问成员变量
 *    private只允许内部函数访问
 */
 class Person{
    private int age;
    private String name;
    private String [] friend ;
    protected long money;
    /*
    * 方法重载概念：返回值一般一样，但参数个数或者类型不一样
    * */
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public Person(){}

    /*
    用数组来表示函数中的多个参数
    public void setFriend(String[] friend) {
        this.friend = friend;
    }
    调用时，需要new一个数组对象
    */

//    可变参数表示多个参数，且调用直接使用字符串格式，不必new数组对象
    public  void setFriend(String... friend){
        this.friend = friend;
    }
    public String getFriend(){
        return friend[0]+" "+friend[1];
   }

   public  void test(){
        System.out.println("a member-function of Person");
   }

    public int getAge(){
        return  this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

}