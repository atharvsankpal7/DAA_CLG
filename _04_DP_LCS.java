import java.util.Scanner;
class Solution {
  public static Scanner io = new Scanner(System.in);
  public static int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length() + 1;
    int n = text2.length() + 1;

    int[][] solution = new int[m][n];
    solution[0][0] = 0;

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          solution[i][j] = solution[i - 1][j - 1] + 1;
        } else {
          solution[i][j] = Math.max(solution[i][j - 1], solution[i - 1][j]);
        }
      }
    }
    return solution[m - 1][n - 1];
  }

  public static void main(String[] a){
    System.out.println("Enter the First string --> ");
    String s1 = io.next();
    System.out.println("Enter the second string --> ");
    String s2 = io.next();
    System.out.println("The length of Longest common Subsequence is --> " + longestCommonSubsequence(s1,s2));
  }
}
