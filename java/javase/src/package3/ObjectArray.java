package package3;

import java.util.Arrays;

public class ObjectArray {
    public ObjectArray(){}
    public ObjectArray(int n){}
    public static void main(String[] args) {
        ObjectArray[] objectArray = new ObjectArray[]{
                new ObjectArray(),
                new ObjectArray()
        };
        System.out.println(Arrays.toString(objectArray));
        // test.toString()和Arrays.toString(test)的区别
    }
}
