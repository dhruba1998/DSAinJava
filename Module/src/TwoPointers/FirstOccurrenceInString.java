package src.TwoPointers;

public class FirstOccurrenceInString {

    public static int firstOccurrenceInString(String haystack, String needle){
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i)==needle.charAt(0) && haystack.length()-1 >= i+needle.length()-1){
                int idx = i+1;
                boolean isFound = true;
                for(int j=1;j<needle.length();j++){
                    if(haystack.charAt(idx++)!=needle.charAt(j)){
                        isFound = false;
                        break;
                    }
                }
                if(isFound){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstOccurrenceInString("sadbutsad","sad"));
        System.out.println(firstOccurrenceInString("leetcode","leeto"));
    }
}
