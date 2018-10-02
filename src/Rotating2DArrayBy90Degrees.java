import java.util.Arrays;

/*
   Rotating 2D Array by 90 degrees
   11-essential-coding-interview-questions (udemy) and CtCi 1.7
 */
public class Rotating2DArrayBy90Degrees {

    public static void main(String[] args) {

        int a1[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println("original matrix : ");
        printMatrix(a1);

//        int[][] rotated = rotate(a1, 3);
        rotateInPlace(a1,3);
        System.out.println("rotated matrix : ");
        printMatrix(a1);
        // [[7, 4, 1],
        //  [8, 5, 2],
        //  [9, 6, 3]]

        int a2[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        System.out.println("original matrix : ");
        printMatrix(a2);
        rotateInPlace(a2, 4);
        System.out.println("rotated matrix : ");
        printMatrix(a2);


        // [[13, 9, 5, 1],
        //  [14, 10, 6, 2],
        //  [15, 11, 7, 3],
        //  [16, 12, 8, 4]]


    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static int[] getNewPosition(int[][] matrix, int n, int x, int y) {

        int newX = n-1-y;
        int newY = x;

        return new int[]{newY,newX};
    }

    public static int[][] rotate(int[][] a, int n) {
        // NOTE: To solve it in place, write this function so that you
        // won't have to create rotated.
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i ++) {

            for (int j = 0; j < n; j++) {

                int[] newPosition = getNewPosition(a,n,j,i);
                rotated[newPosition[0]][newPosition[1]] = a[i][j];
            }
        }

        return rotated;
    }

    public static void rotateInPlace(int[][] a, int n) {

        //do it layer by layer
        for (int layer = 1; layer <= n/2; layer++) {
            int first = layer - 1;
            int last = n - first - 1;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                int left = last - offset;
                int right = first - offset;

                //save top
                int top = a[first][i];

                //left -> top
                a[first][i] = a[last-offset][first];

                //bottom -> left
                a[last-offset][first] = a[last][last-offset];

                //right -> bottom
                a[last][last-offset] = a[first+offset][last];

                //top -> right
                a[first+offset][last] = top;

            }


        }

    }
}
