package faks.vezbi;

/** Во првиот ред од влезот е даден бројот на јазли на влезната листа, потоа во вториот ред се дадени цифрите од кои се составени јазлите по редослед разделени со празно место.
 На излез треба да се испечатат јазлите на резултантната илста.

 Пример влез: 											Пример излез:
 5														 4 56 67
 4 5 6 6 7

 Пример влез:
 6														Пример излез:
 5 6 6 1 1 5												 56 61 1 5

 */


//CODE

import java.util.Scanner;

public class DvocifreniBroevi {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        SLL<Integer> list = new SLL<Integer>();

        for (int i = 0; i < n; ++i)
            list.insertLast(input.nextInt());

        doubleDigitNumbers(list);
        input.close();
    }

    private static void doubleDigitNumbers(SLL<Integer> list) {
        SLLNode<Integer> curr = list.getFirst();

        while (curr!=null){
            if (curr.element==5 || curr.element>5){
                if (curr.succ==null){
                    break;
                }
                list.insertBefore(curr.element*10 + curr.succ.element,curr);
                list.delete(curr);
                curr = curr.succ;
                list.delete(curr);
            }
            curr = curr.succ;
        }
        System.out.println(list);
    }
}