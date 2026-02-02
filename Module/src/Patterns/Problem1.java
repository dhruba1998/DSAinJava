package src.Patterns;

import java.util.Scanner;

public class Problem1 {

    /* Print the following pattern
      *
    * * *
  * * * * *
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;
        for(int i=0;i<n;i++){
            for(int j=1;j<=n-i-1;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=count;j++){
                System.out.print("*");
            }
            count+=2;
            for(int j=1;j<=n-i-1;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
