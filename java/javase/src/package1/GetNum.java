package package1;

class GetNum {

    public static void main(String[] args) {
        // Num类与GetNum类在同一个包下,直接调用构造函数创建对象
         Num num = new Num();
         System.out.println(num.getNum());
    }
}
