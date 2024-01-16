package programming;

import java.util.* ;
import java.io.*;
public class Solution1 {

    public static boolean checkPalindrome(String str) {

        // WRITE YOUR CODE HERE
        str = str.toLowerCase();
        String rev = "";
        boolean ans = false;

        for (int i =str.length()-1; i>=0; i--) {
            rev = rev + str.charAt(i);
        }

        if (str.equals(rev)) {
            ans= true;
        }
        return ans;
    }

    public static void main(String[] args) {
        boolean ans = checkPalindrome("c1 O$d@eeD o1c");
        System.out.println(ans);
    }
}