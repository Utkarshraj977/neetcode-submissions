class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> s = new HashSet<>();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if(ch=='.') continue;
                String rowkey = ch + "in row" + r;
                String colkey = ch + "in col" + c;
                String squarekey = ch + "in square" + (r / 3) + "-" + (c / 3);
                
                if (s.contains(rowkey) || s.contains(colkey) || s.contains(squarekey)) {
                    return false;
                }else{
                    s.add(rowkey);s.add(colkey);s.add(squarekey);
                }
            }
        }
        return true;
    }
}
