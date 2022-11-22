package faks.aud5;

import java.util.Scanner;
import java.util.Stack;

public class Zagradi {
    public static boolean daliOdgovaraat(char left,char right){
        if (left=='(' && right==')')
            return true;
        else if (left=='[' && right==']')
            return true;
        else if (left=='{' && right=='}')
            return true;
        else return false;
        }
        public static boolean daliKorektni(String phrase){
            Stack<Character> stack = new Stack<>();
            for (int i=0;i<phrase.length();i++){
                if (phrase.charAt(i)=='(' || phrase.charAt(i)=='['|| phrase.charAt(i)=='{')
                    stack.push(phrase.charAt(i));
                else if (phrase.charAt(i)==')' || phrase.charAt(i)==']'|| phrase.charAt(i)=='}'){
                    if(!daliOdgovaraat(stack.pop(),phrase.charAt(i))){
                        return false;
                    }
                }
            }
            if (stack.isEmpty())
                return true;
            return false;
        }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String phrase = scanner.nextLine();
        System.out.println(daliKorektni(phrase));

    }
}
