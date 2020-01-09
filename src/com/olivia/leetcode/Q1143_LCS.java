package com.olivia.leetcode;

public class Q1143_LCS {
    public static void main(String[] args) {
        String text1 = "mhunuzqrkzsnidwbun";
        String text2 = "szulspmhwpazoxijwbq";
        int res = longestCommonSubsequence(text1, text2);
        System.out.println(res
        );
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        char[] X = text1.toCharArray();
        char[] Y = text2.toCharArray();
        int X_len = X.length;
        int Y_len = Y.length;
        Integer[][] dp = new Integer[X_len][Y_len];
        int lcs_len = LCS_Recursive_Memo(X,Y,X_len-1, Y_len-1,dp);
        return lcs_len;
    }

    private static int LCS_Reursive(char[] X, char[] Y, int i, int j) {
        if (i <0 || j <0) return 0;
        if (X[i] == Y[j]) return 1 + LCS_Reursive(X, Y, i - 1, j - 1);
        else return Math.max(LCS_Reursive(X, Y, i - 1, j), LCS_Reursive(X, Y, i, j - 1));

    }

    private static int LCS_Recursive_Memo(char[] X, char[] Y, int i, int j,Integer[][] dp) {
        if(i<0||j<0) return 0;
        if(dp[i][j]==null) {
            if(X[i]==Y[j]) return 1+LCS_Recursive_Memo(X,Y,i-1,j-1,dp);
            else return Math.max(LCS_Recursive_Memo(X,Y,i-1,j,dp),LCS_Recursive_Memo(X,Y,i,j-1,dp));
        }
        return dp[i][j];
    }
}
