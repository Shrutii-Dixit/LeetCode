class Solution {

    public void solve(int row, int n, char[][] board, boolean[]col, boolean[]left_di, boolean[] right_di, List<List<String>> ans){
        
        //All Placed
        if( row == n){
            List<String> current = new ArrayList<>();

            for(int i=0; i<n; i++) current.add(new String(board[i]));

            ans.add(current);
            return;
        }

        //Check Column 
        for(int c=0; c<n; c++){
            int left = row - c + n - 1;
            int right = row + c;

            //Unsafe
            if (col[c] || left_di[left] || right_di[right]) {
                continue;
            }

            // Place queen
            board[row][c] = 'Q';

            col[c] = true;
            left_di[left] = true;
            right_di[right] = true;

            solve(row + 1, n, board, col, left_di, right_di, ans);

            // Backtrack
            board[row][c] = '.';

            col[c] = false;
            left_di[left] = false;
            right_di[right] = false;
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(board[i], '.');
        }

        boolean[] col = new boolean[n];
        boolean[] left_di = new boolean[2 * n-1];
        boolean[] right_di = new boolean[2* n-1];

        solve(0, n, board, col, left_di, right_di, ans);

        return ans;
    }
}