package package1;

public class DimesionArray {
    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2}, {3, 4}};
        String[][] str = new String[2][2];
        System.out.println(array[0][0] + " " + str[0][0]);  // 1 null
    }
}
