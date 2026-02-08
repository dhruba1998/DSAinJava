package src.CodeChef;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem1 {

    /* AabBcCDd (https://www.codechef.com/problems/AABBCCDD) */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            int n = sc.nextInt();
            String s = sc.next();
            String newString = s.toLowerCase();
            HashMap<Character,Integer> map = new HashMap<>();
            for(int i=0;i<n;i++){
                if(map.containsKey(newString.charAt(i))){
                    map.put(newString.charAt(i),map.get(newString.charAt(i))+1);
                }
                else {
                    map.put(newString.charAt(i),1);
                }
            }
            int max1 = 0;
            int max2 = 0;
            for(Map.Entry<Character,Integer> entry : map.entrySet()){
                if(entry.getValue()>max1){
                    max2 = max1;
                    max1 = entry.getValue();
                } else if (entry.getValue()>max2) {
                    max2 = entry.getValue();
                }
            }
            System.out.println(max1+max2);
        }
    }

}
