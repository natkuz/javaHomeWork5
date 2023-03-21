// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И вывести Доску. 
// Пример вывода доски 8x8:
// 0x000000
// 0000x000
// 00x00000

public class task5_3_chess {
    public static void main(String[] args) {
        int[] board[] = new int[8][8];
        fillColumns(0, fillCell(board[0].length - 1, board.length - 1, board), board);
    
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 0) System.out.print('x');
                else System.out.print('0');
            }
            System.out.print("\n"); 
        }
     
    } 

    public static int fillCell(int col, int row, int[][] board) { 
        for(int i = 0; i < col; i++) { 
            if (board[i][row] != 0) return 0;
            if (row - col + i >= 0) {
                if (board[i][row - col + i] != 0) return 0;
            }
            if (row + col - i < 8) {
                if (board[i][row + col - i] != 0) return 0;
            }
        }
        return 1;
    }  
        

    public static int fillColumns(int i, int cell, int[][] board) { 
        if (i == 8) return 1;
        for(int j = 0; j < board[0].length; j++)
            if (fillCell(i, j, board) !=0 ) {
                board[i][j] = 1;
                if (fillColumns(i + 1, cell, board) != 0) return 1;
                    board[i][j] = 0;
            }
        return 0;
    }

}