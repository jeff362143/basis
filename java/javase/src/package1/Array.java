package package1;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {

     //创建数组: 1、{}   2、int[] array = new int[]{}
     int[] array = new int[5];
     int[] array1 = new int[]{1,2,5,8,0};
     int[] array2 = {1,2,3};

//     遍历数组
     for(int n : array1){
         System.out.println(n);
     }
        System.out.println("***");
    /*
        假设赋值array1[0]=100;这个时候array1[0]指向的值为100，
        之前array1[0]指向的1，并不会消失，只是无法访问，同字符串一样。。。
    */

     //int数组默认每个数组项值为0，但boolean数组项没有初始值
     for(int i = 0; i < 5; i++){
         System.out.println(array[i]);
     }
     System.out.println(Arrays.toString(array1));//以[]形式打印数组

    }
}
