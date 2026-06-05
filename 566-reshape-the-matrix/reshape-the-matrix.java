class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length*mat[0].length != r*c) return mat;
        int[][] re_mat = new int[r][c];
        int n = r * c;
        int t_c = mat[0].length;
        for(int idx=0; idx<n; idx++){
            int r_o = idx / t_c;
            int c_o = idx % t_c;
            int r_n = idx / c;
            int c_n = idx % c;
            re_mat[r_n][c_n] = mat[r_o][c_o];
        }
        return re_mat;
    }
}