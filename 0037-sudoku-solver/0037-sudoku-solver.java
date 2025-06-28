class Solution {
    
    public static boolean sudokuSol(char [][] board,int row,int col){
        //basecase
        if(row==9){
            return true;
        }
        //recursion
        int nextRow=row,nextCol=col+1;
        if(col+1==9){
            nextRow=row+1;
            nextCol=0;
          
        }
        //check if cell is empty
        if(board[row][col] !='.'){
            return sudokuSol(board,nextRow,nextCol);
        }
        for(char ch='1';ch<='9';ch++){
            if(isSafe( board, row, col, ch)){
                //place the digit
                board[row][col]=ch;
                if(sudokuSol(board,nextRow,nextCol)){
                    return true;
                }
                 board[row][col]='.';
            }
        }
        return false;
    }
    public static boolean isSafe(char [][] board,int row,int col,char ch){
        //column
        for(int i=0;i<=8;i++){
            if(board[i][col]==ch){
                return false;
            }
        }
        //row
        for(int j=0;j<=8;j++){
            if(board[row][j]==ch){
                return false;
            }
        }
        //grid
        int sr=(row/3)*3;
        int sc=(col/3)*3;

        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(board[i][j]==ch){
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        int row=0;
        int col=0;
        sudokuSol(board,row,col);
        
    }
}