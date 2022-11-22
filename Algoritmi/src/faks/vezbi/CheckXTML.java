package faks.vezbi;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Stack;

public class CheckXTML {

    private static int isValid(String []rows) {
        Stack<String> stack = new Stack<String>();

        for (String row:rows){
            if (row.charAt(0)=='[' && row.charAt(row.length()-1)==']'){
                if (row.charAt(1) !='/')
                    stack.push(row);
                else {
                    if (!(row.substring(2).equals(stack.pop().substring(1))))
                        return 0;

                }
            }
        }

    return 1;


    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String []redovi = new String[n];
        for (int i=0;i<n;i++){
            redovi[i] = br.readLine();
        }
        int valid;

        System.out.println(isValid(redovi));
        br.close();
    }
}