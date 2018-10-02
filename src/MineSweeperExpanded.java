import java.util.Arrays;

public class MineSweeperExpanded {

    public static void main(String[] args) {

        int[][] field1 = {{0, 0, 0, 0, 0},
                          {0, 1, 1, 1, 0},
                          {0, 1, -1, 1, 0}};


        printExample(field1, 3, 5, 2, 2);
        // [[0, 0, 0, 0, 0],
        //  [0, 1, 1, 1, 0],
        //  [0, 1, -1, 1, 0]]

        printExample(field1, 3, 5, 1, 4);
        // [[-2, -2, -2, -2, -2],
        //  [-2, 1, 1, 1, -2],
        //  [-2, 1, -1, 1, -2]]

        int[][] field2 = {{-1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, -1}};

        printExample(field2, 4, 4, 0, 1);
        // [[-1, 1, 0, 0],
        //  [1, 1, 0, 0],
        //  [0, 0, 1, 1],
        //  [0, 0, 1, -1]]

        printExample(field2, 4, 4, 1, 3);
        // [[-1, 1, -2, -2],
        //  [1, 1, -2, -2],
        //  [-2, -2, 1, 1],
        //  [-2, -2, 1, -1]]


    }

    public static void printExample(int[][] field, int numRows, int numCols, int givenI, int givenJ) {
        System.out.println("Input : ");
        printMatrix(field);
        System.out.println("Output : " );
        click(field, numRows, numCols, givenI, givenJ);
        printMatrix(field);

    }

    public static void printMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            System.out.println(Arrays.toString(matrix[row]));
        }

    }

    public static void markAllSurroundingCells(int[][] field, int numRows, int numCols, int givenI, int givenJ) {

        for (int row = givenI-1; row <= givenI+1; row++) {
            if (row < 0 || row > numRows -1) {
                continue;
            }
            for(int col = givenJ-1; col <= givenJ+1; col++) {
                if (col < 0 || col > numCols - 1) {
                    continue;
                }
                if (field[row][col] == 0) {
                    //sets the field to -2
                    field[row][col] = -2;
                    //continue to set all the surrounding cells with value 0 to -2
                    markAllSurroundingCells(field,numRows,numCols,row,col);
                }
            }
        }

    }


    public static int[][] click(int[][] field, int numRows, int numCols, int givenI, int givenJ) {

        //if the clicked cell is a bomb or it's not equals 0
        //return the field matrix unmodified

        if (field[givenI][givenJ] != 0) {
            return field;
        }

        markAllSurroundingCells(field,numRows,numCols,givenI,givenJ);

        return field;
    }
}
