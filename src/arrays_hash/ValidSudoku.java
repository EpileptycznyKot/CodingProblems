package arrays_hash;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        Set<Character> characterSet = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char currentChar = board[i][j];
                if (characterSet.contains(currentChar) && currentChar != '.') {
                    return false;
                }
                characterSet.add(board[i][j]);
            }
            characterSet.clear();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char currentChar = board[j][i];
                if (characterSet.contains(currentChar) && currentChar != '.') {
                    return false;
                }
                characterSet.add(currentChar);
            }
            characterSet.clear();
        }

        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                for (int row = boxRow * 3; row < boxRow * 3 + 3; row++) {
                    for (int col = boxCol * 3; col < boxCol * 3 + 3; col++) {
                        char currentChar = board[row][col];
                        if (characterSet.contains(currentChar) && currentChar != '.') {
                            return false;
                        }
                        characterSet.add(currentChar);

                    }
                }
                characterSet.clear();
            }
        }

        return true;
    }


    public static void runTests() {
        ValidSudoku validSudoku = new ValidSudoku();

        char[][] board = {
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] boardInvalid = {
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '1', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(validSudoku.isValidSudoku(board));
        System.out.println(validSudoku.isValidSudoku(boardInvalid));
    }
}
