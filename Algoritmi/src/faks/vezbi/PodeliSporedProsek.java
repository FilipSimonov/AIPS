package faks.vezbi;

/**Подели според просек
 Дадена е еднострано поврзана листа чии што јазли содржат по еден природен број. Листата треба да се подели на две резултантни листи,  т.ш. во првата листа треба да се сместат сите јазли кои содржат броеви помали или еднакви на просекот на листата (просек на листа претставува математички просек од сите природни броеви кои се јавуваат во листата),
 а во втората сите јазли кои содржат броеви поголеми од просекот на листата. Јазлите во резултантните листи се додаваат според редоследот по кој се појавуваат
 во дадената листа.

 Во првиот ред од влезот е даден бројот на јазли во листата, а во вториот ред се дадени броевите од кои се составени јазлите по редослед во листата.
 Во првиот ред од излезот треба да се испечатат јазлите по редослед од првата резултантна листа (броеви помали или еднакви на просекот на листата), во вториот ред од втората (броеви поголеми од просекот на листата) .

 Име на класа (за Java): PodeliSporedProsek

 Забелешка: При реализација на задачите МОРА да се користат дадените структури, а не да користат помошни структури како низи или сл.
 Sample input
 5
 4 2 1 5 3

 2 1 3
 4 5

 Sample input
 6
 6 7 9 8 10 10
 Sample output
 6 7 8
 9 10 10
 */


//CODE



import java.util.Scanner;

public class PodeliSporedProsek {

   public static void PodeliSporedProsekG1(SLL<Integer> list, int n){
       SLLNode<Integer> node = list.getFirst();
       double prosek = 0.0;
       int sum = 0;
       while (node!=null){
           sum+=node.element;
           node = node.succ;
       }
       prosek = sum/n;
       SLL<Integer> pogolemi = new SLL<>();
       node = list.getFirst();
       while (node!=null){
           if (node.element>prosek){
               pogolemi.insertLast(node.element);
               list.delete(node);
           }
           node = node.succ;
       }
       System.out.println(list);
       System.out.println(pogolemi);
   }




    public static void main(String[] args) {
        SLL<Integer> list = new SLL<Integer>();

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        for (int i = 0; i < n; i++)
            list.insertLast(input.nextInt());

        PodeliSporedProsekG1(list, n);
        input.close();
    }
}