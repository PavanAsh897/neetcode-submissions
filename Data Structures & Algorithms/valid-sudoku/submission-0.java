class Solution {
    public boolean isValidSudoku(char[][] board) {
        int [] row =new int [9];
        int [] col =new int[9];
        int [] boxes = new int [9];
        for(int r =0; r<9; r++){
            for(int c=0; c<9;c++){
                if(board[r][c]=='.') continue;
                int val = board[r][c]-'1';
                int mask = 1<<val;
                int box =(r/3)*3+(c/3);

                if((row[r]& mask)!=0 || (col[c]& mask)!=0|| (boxes[box]&mask)!=0){
                    return false;
                }
                row[r]|=mask;
                col[c]|=mask;
                boxes[box]|=mask;

                
            }
        }
        return true;
        
    }
}
