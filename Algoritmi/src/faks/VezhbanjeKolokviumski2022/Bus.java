package faks.VezhbanjeKolokviumski2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bus {

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());//broj vozrasni
        int M = Integer.parseInt(br.readLine());//broj deca

        br.close();

        // Vasiot kod tuka
        int mincena=0;
        int maxcena=(N+(M-1))*100;

        if(M==0){
            maxcena=N*100;
        }
        if(N>=M){
            mincena=N*100;
        }
        else if(M>N){
            mincena=(N+(M-N))*100;
        }
        System.out.println(mincena);
        System.out.println(maxcena);


    }

}
