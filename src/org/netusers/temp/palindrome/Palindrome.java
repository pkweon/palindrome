package org.netusers.temp.palindrome;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String[] p = new String[] { "11","111","11","211" };
        String[] r = new Palindrome().solution(p);
        System.out.println("result:" + String.join(",", r));
    }

    public String[] solution(String []P) {
        List<String> result = new ArrayList<String>();
        for (int index = 1; index < P.length; index++) {
            System.out.println("testing : " + P[index]);
            if (checker(0, index, P)) {
                System.out.println(P[index] + "is ok");
                result.add(P[index]);
            }
        }
        String[] res = new String[result.size()];
        return result.toArray(res);
    }

    public boolean checker(int i, int j, String[] p) {
        System.out.println(i + ":" + j + ":" + String.join(",", p));
        boolean res = false;
        if (isPalindrome(p[i], p[j])) {
            System.out.println("palindrome:" + p[i] + "..." + p[j]);
            if (p.length > 2) {
                List<String> newp = new ArrayList<String>();
                for (int z = 0; z < p.length; z++) { if (z != i && z != j) newp.add(p[z]); }
                String[] np = new String[newp.size()];
                np = newp.toArray(np);
                for (int x = 0; x < np.length; x++) {
                    for (int y = 0; y < np.length; y++) {
                        if (x == y) continue;
                        res |= checker(x, y, np);
                    }
                }
            }
            else res = true;
        }
        return res;
    }

    public boolean isPalindrome(String a, String b) {
        return (palindrome((a+b).toCharArray()) || palindrome((b+a).toCharArray()));
    }


    public boolean palindrome(char[] word){
        int i1 = 0;
        int i2 = word.length - 1;
        while (i2 > i1) {
            if (word[i1] != word[i2]) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }
}
