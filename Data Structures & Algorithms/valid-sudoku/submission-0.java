class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> line;
        //column
        for(int c = 0; c < 9; c++){
            line = new HashSet<Character>();
            for(int r = 0; r < 9; r++){
                if(line.contains(board[c][r])){
                    return false;
                }
                if(board[c][r] != '.')
                    line.add(board[c][r]);
            }
        }
        //row
        for(int r = 0; r < 9; r++){
            line = new HashSet<Character>();
            for(int c = 0; c < 9; c++){
                if(line.contains(board[c][r])){
                    return false;
                }
                if(board[c][r] != '.')
                    line.add(board[c][r]);
            }
        }
        //sub-boxes
        for(int c = 0; c <9; c += 3){
            for(int r = 0; r < 9; r += 3){
                if(!boxHelper(c,c+3,r,r+3,board)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean boxHelper(int minc, int maxc, int minr, int maxr, char[][] board){
        HashSet box = new HashSet<Character>();
        for(int c = minc; c < maxc; c++){
            for(int r = minr; r < maxr; r++){
                    if(box.contains(board[c][r])){
                        return false;
                    }
                    if(board[c][r] != '.')
                        box.add(board[c][r]);
            }
        }
        return true;
    }
}
