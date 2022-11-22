package faks.vezbi;

import java.util.Scanner;
import java.util.Stack;
public class Zagradi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String phrase = scanner.nextLine();
        System.out.println(daliKorektni(phrase));

    }
    private static boolean daliOdgovaraat(char a,char b){
        if (a=='(')
            return b==')';
        else if (a=='[')
            return b==']';
        else if (a=='{')
            return b=='}';
        return false;
    }

    private static int daliKorektni(String phrase) {
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<phrase.length();i++){
            if (phrase.charAt(i)=='(' || phrase.charAt(i)=='[' || phrase.charAt(i)=='{'){
                stack.push(phrase.charAt(i));
            }
            else if (phrase.charAt(i)==')' || phrase.charAt(i)==']' || phrase.charAt(i)=='}'){
                if (!daliOdgovaraat(stack.pop(),phrase.charAt(i))){
                    return -1;
                }
            }
        }
        if (stack.isEmpty()){
             return 1;
        }
        return -1;
    }

}
