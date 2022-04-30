package package1;

public class Number {
    public static void main(String[] args) {
        Number number = new Number(3.14, (float) 3.14, 222);
        System.out.println(number);
    }

    /**
     * 与Num类在同一个包下的其他类，可以直接实例化Num类
     */
    private double num1 ;
    private float num2;
    private int num;

    public Number() {
    }

    public Number(double num1, float num2, int num) {
        this.num1 = num1;
        this.num2 = num2;
        this.num = num;
    }


    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public float getNum2() {
        return num2;
    }

    public void setNum2(float num2) {
        this.num2 = num2;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Num{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", num=" + num +
                '}';
    }
}
