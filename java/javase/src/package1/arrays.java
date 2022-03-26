package package1;

import java.util.Arrays;

public class arrays {
    public static void main(String[] args) {
        int [][] arrays = new int [][]{{1,1,1},{2,2,2},{3,3,3}};   //定义二维数组
             for(int i = 0; i < 3; i++){
                 for(int j = 0; j < 3; j++){
                System.out.println(arrays[i][j]);
            }
        }
//           Arrays.deepToString静态方法可以用于以[]形式输出二维数组
             System.out.println(Arrays.deepToString(arrays));
    }
}
