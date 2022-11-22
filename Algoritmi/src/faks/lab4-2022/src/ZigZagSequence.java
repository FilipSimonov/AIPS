import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZigZagSequence {

    static int najdiNajdolgaCikCak(int a[]) {
        int counter=1;
        int max=0;
        // Vasiot kod tuka

       for(int i=0;i<a.length;i++){

           int broj=a[i];
           if(a[i]<0){
               for(int j=i+1;j<a.length;j++){
                   if((a[j]>0 && broj<0)||(a[j]<0 &&broj >0)){
                       counter++;
                       broj=a[j];
                   }else break;
               }

           }else if(a[i]>=0){
                for(int j=i+1;j<a.length;j++){
                    if((a[j]<0 && broj>0) || (broj<0 && a[j]>0)){
                        counter++;
                        broj=a[j];
                    }
                    else break;
                }
           }
           if(max<counter){
               max=counter;
           }
           counter=1;
       }

        return max;
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int a[] = new int[N];
        for (i=0;i<N;i++)
            a[i] = Integer.parseInt(br.readLine());

        int rez = najdiNajdolgaCikCak(a);
        System.out.println(rez);

        br.close();

    }

}
