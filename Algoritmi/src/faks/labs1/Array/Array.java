package faks.labs1.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array<E> {
    E data[];//najverojatno koj tip na data da chuva nizata a nizata da se vika data
    int size;//golemina
    public Array(int  size){
        data=(E[])new Object[size];
        this.size=size;
    }

    public int getSize() {
        return size;
    }
    public E get(int position) {
        if (position >= 0 && position < size)
            return data[position];
        return null;
    }
    public void set(int position , E o) {
        data[position]=o;
    }
    private static int brojDoProsek(Array<Integer> niz) {
        double prosek;
        int suma=0;
        int i;
        for(i=0;i<niz.getSize();i++){
            suma+=niz.get(i);
        }
        prosek=(double)suma/i;
        double min=Math.abs(prosek-niz.get(0));
        int index=0;
        for(int j=0;j<niz.getSize();j++){
            if(min > Math.abs(prosek-niz.get(j))){
                min=Math.abs(prosek-niz.get(j));
                index=j;
            }
            else if(min == Math.abs(prosek-niz.get(j))){
                if(niz.get(j)<niz.get(index)){
                    min=Math.abs(prosek-niz.get(j));
                    index=j;
                }
            }
        }
        return niz.get(index);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader stdin= new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N= Integer.parseInt(s);
        Array<Integer> niz= new Array<Integer>(N);
        for(int i=0;i<N;i++){
            s=stdin.readLine();
            niz.set(i,Integer.parseInt(s));
        }
        System.out.println(brojDoProsek(niz));
    }

}

