import java.util.Arrays;

/*
   Minesweeper
   11-essential-coding-interview-questions (udemy)
 */
public class Minesweeper {

    public static void main(String[] args) {

        int[][] bombs1 = {{0, 2}, {2, 0}};
        System.out.print("Bombs are in locations: ");
        for (int[] bomb: bombs1) {
            System.out.print(Arrays.toString(bomb) + " ");
        }
        System.out.println();
        int[][] result = mineSweeper(bombs1, 3, 3);
        System.out.println("Printing mine sweeper map : ");
        printMatrix(result);
        // [[0, 1, -1],
        //  [1, 2, 1],
        //  [-1, 1, 0]]

        int[][] bombs2 = {{0, 0}, {0, 1}, {1, 2}};

        System.out.print("Bombs are in locations: ");
        for (int[] bomb: bombs2) {
            System.out.print(Arrays.toString(bomb) + " ");
        }
        System.out.println();
        result = mineSweeper(bombs2, 3, 4);
        System.out.println("Printing mine sweeper map : ");
        printMatrix(result);

        // mineSweeper(bombs2, 3, 4) should return:
        // [[-1, -1, 2, 1],
        //  [2, 3, -1, 1],
        //  [0, 1, 1, 1]]

        int[][] bombs3 = {{1, 1}, {1, 2}, {2, 2}, {4, 3}};
        System.out.print("Bombs are in locations: ");
        for (int[] bomb: bombs3) {
            System.out.print(Arrays.toString(bomb) + " ");
        }
        System.out.println();
        result = mineSweeper(bombs3, 5, 5);
        System.out.println("Printing mine sweeper map : ");
        printMatrix(result);

        // mineSweeper(bombs3, 5, 5) should return:
        // [[1, 2, 2, 1, 0],
        //  [1, -1, -1, 2, 0],
        //  [1, 3, -1, 2, 0],
        //  [0, 1, 2, 2, 1],
        //  [0, 0, 1, -1, 1]]


    }

    public static void printMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            System.out.println(Arrays.toString(matrix[row]));
        }

    }

    public static void placeBomb(int[][] bombs, int[][] matrix) {

        for (int i = 0; i < bombs.length; i++) {
            int[] bomb = bombs[i];
            matrix[bomb[0]][bomb[1]] = -1;
        }

    }

    public static boolean containsBomb(int x, int y, int[][] matrix) {
        return (matrix[y][x] == -1);
    }

    public static int scoreCell(int col, int row, int[][] matrix) {
        int bombCounter = 0;

        //search left
        if (col-1 >= 0) {
            if (containsBomb(col-1, row, matrix)) {
                bombCounter++;
            }
        }

        //search right
        if (col+1 < matrix[0].length) {
            if (containsBomb(col+1, row, matrix)) {
                bombCounter++;
            }
        }

        //search up
        if (row-1 >= 0) {
            if (containsBomb(col,row-1, matrix)) {
                bombCounter++;
            }
        }

        //search down
        if (row+1 < matrix.length) {
            if (containsBomb(col,row+1, matrix)) {
                bombCounter++;
            }
        }

        //search upper diagonals left
        if (col-1 >= 0 && row-1 >= 0) {
            if (containsBomb(col-1, row-1, matrix)) {
                bombCounter++;
            }
        }

        //search upper diagonals right
        if (col+1 < matrix[0].length && row-1 >= 0) {
            if (containsBomb(col+1, row-1, matrix)) {
                bombCounter++;
            }
        }

        //search lower diagonals left
        if (col-1 >= 0 && row+1 < matrix.length) {
            if (containsBomb(col-1, row+1, matrix)) {
                bombCounter++;
            }
        }

        //search lower diagonals right
        if (col+1 < matrix[0].length && row+1 < matrix.length) {
            if (containsBomb(col+1,row+1, matrix)) {
                bombCounter++;
            }
        }

        return bombCounter;
    }

    public static void fillMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            int[] cell = matrix[i];

            for (int j = 0; j < cell.length; j++) {
                //check if it's cell w/ bomb
                if (cell[j] != -1) {
                    //check all 8 directions for bombs and keep adding to the bomb counter if it is found
                    cell[j] = scoreCell(j,i,matrix);
                }
            }
        }
    }

    public static int[][] mineSweeper(int[][] bombs, int numRows, int numCols) {
        int[][] field = new int[numRows][numCols];

        //place the bomb
        placeBomb(bombs, field);

        //go through the matrix and fill in the blanks for cells without bombs
        fillMatrix(field);


        return field;
    }
}
