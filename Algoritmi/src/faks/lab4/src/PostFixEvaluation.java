import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class PostFixEvaluation {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        System.out.println(result(exp));

        br.close();

    }

    public static int result(char [] ch) {

        Stack<Integer> intStack = new Stack<>();


        StringBuilder sb = new StringBuilder();
        for (int i=0; i<ch.length; ++i) {

            if (Character.isDigit(ch[i])) {

                if (Character.isDigit(ch[i+1])) {
                    sb.append(ch[i]);
                    continue;
                }
                else {
                    sb.append(ch[i]);
                    intStack.push(Integer.parseInt(sb.toString()));
                    sb = new StringBuilder();
                }

            }

            else if (ch[i] == '+') {
                int num1 = intStack.pop();
                int num2 = intStack.pop();
                intStack.push(num1 + num2);
            }
            else if (ch[i] == '-') {
                int num1 = intStack.pop();
                int num2 = intStack.pop();
                intStack.push(num2 - num1);
            }
            else if (ch[i] == '*') {
                int num1 = intStack.pop();
                int num2 = intStack.pop();
                intStack.push(num1 * num2);
            }
            else if (ch[i] == '/') {
                int num1 = intStack.pop();
                int num2 = intStack.pop();
                intStack.push(num2 / num1);
            }

        }

        return intStack.pop();

    }

}
