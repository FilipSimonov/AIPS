package faks.labs3;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZigZagSequence {

    private static int MAX_VALUE = 0;

    static int najdiNajdolgaCikCak(int a[]) {
        int count = 1;
        int MAX = MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i + 1] == 0) {
                MAX = Math.max(MAX, count);
                count = 1;
                i++;
            }
            else if (a[i + 1] > 0) {
                if (a[i] < 0)
                    count++;
                else {
                    MAX = Math.max(MAX, count);
                    count = 1;

                }
            }
            else if (a[i + 1] < 0) {
                if (a[i] > 0)
                    count++;
                else {
                    MAX = Math.max(MAX, count);
                    count = 1;

                }
            }
        }
        MAX = Math.max(MAX,count);
        return MAX;
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
