public class WordSearch {


    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}};
        String[] input = {"ABCCED", "SEE", "ABCB"};

        for (String word: input) {
            System.out.println("input : " + word + " exists in board " + exist(board,word));
        }


    }


    public static boolean exist(char[][] board, String word) {

        for (int i =0; i < board.length;i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
//                    System.out.println("this is i " + i + " and j " + j);
                    if (exist(board,i,j,0,word)) {
                        return true;
                    }
                }
            }
        }

        return false;

    }

    public static boolean exist(char[][] board, int i, int j, int index, String word) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';
        boolean result = exist(board,i+1,j,index+1,word) ||
            exist(board,i-1,j,index+1,word) ||
            exist(board, i, j+1,index+1,word) ||
            exist(board, i, j-1,index+1,word);

        board[i][j] = temp;

        return result;

    }
}
