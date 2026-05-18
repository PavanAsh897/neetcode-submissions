class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROW= matrix.length, COL =matrix[0].length;
        int top=0,bot=ROW-1;
        while(top<=bot){
            int row =(top+bot)/2;
            if(matrix[row][COL-1]<target)top=row+1;
            else if(matrix[row][0]>target)bot=row-1;
            else break;
        }
        if(!(top<=bot)) return false;

        int row= (top+bot)/2;
        int l=0,r=COL-1;
        while(l<=r){
            int col= (l+r)/2;
            if(matrix[row][col]<target) l=col+1;
            else if(matrix[row][col]>target) r=col-1;
            else return true;
        }
        return false;
        
    }
}
