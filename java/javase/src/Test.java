public class Test {
    public Test(){}
    public Test(int n){}
    public static void main(String[] args) {
        Test []test = new Test[]{
                new Test(),
                new Test()
        };
        System.out.println(test[0].toString());
    }
}
