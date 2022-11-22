package faks.vezbi;

/**
 За дадена листа од А0 до Аn да се испечати како резултат А0->Аn-1->А1->Аn-2->А2->...

 Влез:
 5
 1 2 3 4 5
 Излез:
 1->5->2->4->3
 Забелешка:
 Не смеат да се креираат нови листи
 Работа со јазлите
 */


//CODE


import java.util.Scanner;

public class ChangeList {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SLL<Integer> list = new SLL<Integer>();

        int n = input.nextInt();

        for (int i = 0; i < n; i++)
            list.insertLast(input.nextInt());

        changeList(list);
        input.close();
    }
    public static void changeList(SLL<Integer> list){
        SLLNode<Integer> node = list.getFirst();
        SLLNode<Integer> next;

        while (node.succ!=null){
            next = node.succ;
            while (next.succ!=null) {
                next = next.succ;
            }

            node = node.succ;
            list.insertBefore(next.element,node);
            list.delete(next);

        }
        System.out.println(list);
    }


}