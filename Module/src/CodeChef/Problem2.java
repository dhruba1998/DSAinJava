package src.CodeChef;

import java.util.Scanner;

public class Problem2 {

    /* Accommodation (https://www.codechef.com/problems/ACMDT)
There are B boys and G girls who would like to take accommodation in a hotel.
The hotel has infinitely many rooms, and each room with a positive number of occupants must satisfy the following conditions:

It must contain at least X boys.
It must contain at least Y girls.
It can contain at most N people in total.
Determine the minimum number of rooms required to accommodate all B+G people while satisfying these constraints.

If it is impossible to accommodate everyone while following the constraints, output −1.*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0) {
            t--;
            long b = sc.nextLong();
            long g = sc.nextLong();
            long x = sc.nextLong();
            long y = sc.nextLong();
            long n = sc.nextLong();
            if(b<x || g<y || (x+y)>n){
                System.out.println(-1);
            }
            else {
                long totalBoysAndGirls = b+g;
                long minRooms = (totalBoysAndGirls + n -1)/n;

                if(minRooms*x>b || minRooms*y>g){
                    System.out.println(-1);
                }
                else {
                    System.out.println(minRooms);
                }

            }




        }
    }

}
