package faks.vezbi;

/**Парни разменливи елементи на дадена поврзана листа
 Со оглед на листата со поединечно поврзана вредност, напишете функција за да ги замените елементите.
 На пример, ако поврзаната листа е 1-> 2-> 3-> 4-> 5 тогаш функцијата треба да ја смени на 2-> 1-> 4-> 3-> 5,
 и ако поврзаната листа е  1-> 2-> 3-> 4-> 5-> 6 тогаш функцијата треба да ја промени на 2-> 1-> 4-> 3-> 6-> 5.
 */


//CODE



import java.util.Scanner;

public class Kolokvium2018 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SLL<Integer> list = new SLL<Integer>();
        int n = input.nextInt();

        for (int i = 0; i < n; i++)
            list.insertLast(input.nextInt());

        swap(list, n);
        input.close();
    }

    private static void swap(SLL<Integer> list, int n) {
        SLLNode<Integer> curr = list.getFirst();
        SLLNode<Integer> next = curr.succ;
        if (n%2==0){
            while (n>1){
                list.insertLast(next.element);
                list.delete(next);
                list.insertLast(curr.element);
                list.delete(curr);
                curr = next.succ;
                next = next.succ.succ;
                n-=2;
            }
        }else {
            while (n>1){
              list.insertLast(next.element);
              list.delete(next);
              list.insertLast(curr.element);
              list.delete(curr);
              curr = next.succ;
              --n;
              if (n<1)
                  break;
              next = next.succ.succ;
              --n;
            }
            list.insertLast(curr.element);
            list.delete(curr);
        }
        System.out.println(list);
    }


}