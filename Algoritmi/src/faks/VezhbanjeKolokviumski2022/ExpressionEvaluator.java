package faks.VezhbanjeKolokviumski2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ExpressionEvaluator {

    public static int evaluateExpression(String expression){
        // Vasiot kod tuka
        int rezultat=0;
        //   System.out.println(expression);
        Stack<Integer> stack = new Stack<>();
        String [] niza= expression.split("\\+");
        String[] pom;
        for(int i=0;i<niza.length;i++){
            if(!(niza[i].contains("*"))){
                stack.push(Integer.valueOf(niza[i]));
            }
            else{
                pom = niza[i].split("\\*");
                int proizvod=1;
                for(int j=0;j < pom.length;j++){
                    proizvod *= Integer.valueOf(pom[j]);
                }
                stack.push(proizvod);
            }
        }
        while(!(stack.isEmpty())){
            rezultat+=stack.pop();
        }

        return rezultat;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

}