package faks.lab0;

import java.io.*;
import java.util.Scanner;

public class PushZero
{
    static void pushZerosToEnd(int arr[], int n)
    {
        System.out.println("Transformiranata niza e:");
        int counter=0;
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                counter++;
                System.out.printf(arr[i] + " ");
            }
        }
        for(int i=0;i<n-counter;i++){
            System.out.printf("0 ");
        }
    }

    public static void main (String[] args) throws IOException {
        int arr[] = new int[100];
        int n;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        n=Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(pomniza[i]);
        }

        pushZerosToEnd(arr, n);

    }
}