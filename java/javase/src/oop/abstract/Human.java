package package2.abstract_class;

public class Human extends AbstractHunman {
    public void test() {
        System.out.println("继承抽象类需要实现其抽象方法");
    }
    public static void main(String[] args) {
        Human person = new Human();
        person.test();
    }
}