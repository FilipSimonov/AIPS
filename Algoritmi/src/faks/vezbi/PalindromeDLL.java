package faks.vezbi;

import java.util.Scanner;

public class PalindromeDLL {

    public static int isItPalindrome(DLL<Integer> list){
        DLLNode<Integer> node1 = list.getFirst();
        DLLNode<Integer> node2 = list.getLast();
        while (node1!=null && node2!=null){
            if (!(node1.element.equals(node2.element)))
                return -1;
            node1 = node1.succ;
            node2 = node2.pred;
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(in.nextInt());
        }
        in.close();
        System.out.println(isItPalindrome(list));
    }

}
