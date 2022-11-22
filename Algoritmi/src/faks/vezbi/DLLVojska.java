package faks.vezbi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DLLVojska {


    public static void main(String[] args) throws IOException {
        DLL<Integer> lista = new DLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] ids = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(ids[i]));
        }

        s = stdin.readLine();
        String interval[] = s.split(" ");
        int a = Integer.parseInt(interval[0]);
        int b = Integer.parseInt(interval[1]);

        s = stdin.readLine();
        interval = s.split(" ");
        int c = Integer.parseInt(interval[0]);
        int d = Integer.parseInt(interval[1]);


        DLL<Integer> result = vojska(lista, a, b, c, d);


        DLLNode<Integer> node = result.getFirst();
        System.out.print(node.element);
        node = node.succ;
        while(node != null){
            System.out.print(" "+node.element);
            node = node.succ;
        }

    }

    private static DLL<Integer> vojska(DLL<Integer> lista, int a, int b, int c, int d) {
        DLLNode<Integer> node = lista.getFirst();
        DLLNode<Integer> start1 = null, start2=null, end1=null , end2= null, tmp;

        while (node!=null){
            if (node.element.equals(a)) start1=node;
            if (node.element.equals(b)) end1 = node;
            if (node.element.equals(c)) start2 = node;
            if (node.element.equals(d)) end2 = node;
            node = node.succ;
        }
        start2.pred.succ = start1;
        if (start1==lista.getFirst()){
            start1.pred = start2.pred;
            start2.pred = null;
            //lista.setFirst(start2);
        }else {
            start1.pred.succ = start2;
            tmp = start1.pred;
            start1.pred = start2.pred;
            start2.pred = tmp;
        }
        end1.succ.pred = end2;
        if (end2== lista.getLast()){
            end2.succ = end1.succ;
//            end1.succ = null;
           // lista.setLast(end1);
        }else {
            end2.succ.pred = end1;
            tmp = end1.succ;
            end1.succ = end2.succ;
            end2.succ = tmp;
        }

        return lista;
    }
}