package faks.VezhbanjeKolokviumski2022;

import java.util.Scanner;

public class ListaOdListi {

    public static long findMagicNumber(DLL<DLL<Integer>> list) {
        //Vashiot kod tuka...
        int suma=0;
        long proizvod =1;
        DLLNode<DLL<Integer>> lista1jazol= list.getFirst();
        while(lista1jazol != null){
            DLLNode<Integer> jazol=lista1jazol.element.getFirst();
            suma=0;
            while(jazol!=null){
                suma+=jazol.element;
                jazol=jazol.succ;
            }
            proizvod*=suma;
            lista1jazol=lista1jazol.succ;
        }
        return proizvod;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        DLL<DLL<Integer>> list = new DLL<DLL<Integer>>();
        for (int i = 0; i < n; i++) {
            DLL<Integer> tmp = new DLL<Integer>();
            for (int j = 0; j < m; j++) {
                tmp.insertLast(in.nextInt());
            }
            list.insertLast(tmp);
        }
        in.close();
        System.out.println(findMagicNumber(list));
    }

}