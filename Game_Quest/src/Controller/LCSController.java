/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;



import java.util.Random;
/**
 *
 * @author risin
 */

public class LCSController {
       
        private final Random random = new Random();
        
        
        public LCSController(){
           
        }
    
    public String generateRandomString() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        System.out.println(sb);
        return sb.toString();
    }

    public String calculateLCS(String x, String y) {
        int m = x.length();
        int n = y.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcsLength = dp[m][n];
        char[] lcs = new char[lcsLength];
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                lcs[lcsLength - 1] = x.charAt(i - 1);
                i--;
                j--;
                lcsLength--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return new String(lcs);
        
    }
}
