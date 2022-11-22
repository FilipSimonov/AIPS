package faks.labs3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArithmeticExpression {
    static int execute(int a,int b,char c){
        if (c=='+')
           return a+b;
        else if (c=='-')
            return a-b;
        return 0;
    }

    static int presmetaj(char c[],int l,int r){
        int i = l+1; //ripamo gu 1zagrada;
        int count=0;
        if (r-l==4)
            return execute(c[l+1]-'0',c[l+3]-'0',c[l+2]);
        if (l==r)
            return c[l]-'0';

        while (i<r){
            if (c[i]=='(')
                count++;
            else if (c[i]==')')
                count--;
            if (count==0)
                return execute(presmetaj(c,l+1,i),presmetaj(c,i+2,r-1),c[i+1]);
            else
                i++;
        }
    return 0;

    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        int rez = presmetaj(exp, 0, exp.length-1);
        System.out.println(rez);

        br.close();

    }

}
