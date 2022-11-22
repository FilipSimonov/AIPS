package faks.labSort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddEvenSort {

    static void oddEvenSort(int a[], int n)
    {
        int brParni=0;
        int brNeparni = 0;
        int parni[] = new int[n];
        int neparni[] = new int[n];

        for (int i=0;i<a.length;i++){
            if (a[i]%2 == 0){
                parni[brParni++] = a[i];
            }
            else {
                neparni[brNeparni++] = a[i];
            }
        }
        bubbleSort(parni,brParni,'<');
        bubbleSort(neparni,brNeparni,'>');

        for (int i=0;i<brNeparni;i++)
            a[i] = neparni[i];
        for (int i=0;i<brParni;i++){
            a[brNeparni+i] = parni[i];
        }



    }
    static void bubbleSort(int a[],int n,char c){
        for (int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                if (c=='>'){
                    if (a[i]>a[j]){
                        int tmp = a[i];
                        a[i]=a[j];
                        a[j] = tmp;
                    }
                }
                else if (c=='<'){
                    if (a[i]<a[j]){
                        int tmp = a[i];
                        a[i] = a[j];
                        a[j] = tmp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        int i;
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String [] pom = s.split(" ");
        int [] a = new int[n];
        for(i=0;i<n;i++)
            a[i]=Integer.parseInt(pom[i]);
        oddEvenSort(a,n);
        for(i=0;i<n-1;i++)
            System.out.print(a[i]+" ");
        System.out.print(a[i]);
    }
}