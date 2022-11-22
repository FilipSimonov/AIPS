package faks.labs3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfAbsoluteDifferences {

    static int execute(int a,int b){
        return Math.abs(a-b);
    }

    static int solve(int numbers[],int N,int K){
        int [][]tmp = new int[numbers.length][K];
        int MAX=0;
        int sum =0;

        for (int i=1;i<N;i++){
            for (int j=1;j<K;j++){
                for (int k1=0;k1<i;k1++){
                    sum = execute(numbers[i],numbers[k1]);
                    if (tmp[i][j]<tmp[k1][j-1]+sum)
                        tmp[i][j] = tmp[k1][j-1]+sum;
                }
                if (tmp[i][j]>sum)
                    sum = tmp[i][j];
            }
        }
return sum;


    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int numbers[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (i=0;i<N;i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int res = solve(numbers, N, K);
        System.out.println(res);

        br.close();

    }

}