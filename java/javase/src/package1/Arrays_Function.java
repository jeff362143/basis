package package1;

import java.util.Arrays;

public class Arrays_Function {
    public static void main(String[] args) {
//        一维数组
        int [] array1 = new int[]{1,2,5,8,0};
//       Arrays的静态sort方法用于快速排序
        Arrays.sort(array1);
//       toString方法用于将数组以"[x,x,x,x]"形式输出
        System.out.println(Arrays.toString(array1));

    }
}
