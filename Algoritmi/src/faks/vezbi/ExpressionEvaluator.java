package faks.vezbi;

import com.sun.source.tree.BreakTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


public class ExpressionEvaluator {

    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

    private static int evaluateExpression(String expression) {
        Stack<Integer> stack = new Stack<Integer>();
        String[] broevi = expression.split("\\+");
        int rez = 0;
        for (int i=0;i<broevi.length;i++){
            int proizvod = 1;
            String []mnozenje = broevi[i].split("\\*");
            for (int j=0;j<mnozenje.length;j++){
                proizvod *= Integer.parseInt(mnozenje[j]);
            }
            stack.push(proizvod);
        }
        while (!stack.isEmpty())
            rez+=stack.pop();

        return rez;

    }


}