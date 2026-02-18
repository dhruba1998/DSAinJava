package src.CodeChef;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Problem3 {

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            int len = sc.nextInt();
            String str = sc.next();
            for(int i=0;i<len;i++){
                Character ch = str.charAt(i);
                if(ch>=48 && ch<=57){
                    deque.push(ch-48);
                }
                else{
                    int count = 1;
                    int secondEle=0;
                    int firstEle=0;
                    while(count<=2){
                        if(count==1)
                            secondEle = deque.pop();
                        else
                            firstEle = deque.pop();
                        count++;
                    }
                    if(ch=='+'){
                        deque.push(firstEle+secondEle);
                    }
                    else if(ch=='-'){
                        deque.push(firstEle-secondEle);
                    }
                    else{
                        deque.push(firstEle*secondEle);
                    }
                }
            }
            System.out.println(deque.pop());
        }
    }
}
