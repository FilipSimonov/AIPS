package faks.aud4;

public class KnapsackDynamic {

    public static int knapsack(int w[],int p[],int C){
        int n = w.length;
        int D[][] = new int[n+1][C+1];

        for (int i=0;i<=n;i++){
            D[i][0] = 0;
        }
        for (int j=0;j<=C;j++){
            D[0][j] = 0;
        }
        for (int i=0;i<=n;i++){
            for (int j=1;j<=C;j++){
                if (w[i-1] <= j){
                    D[i][j] = Math.max(p[i-1] + D[i-1][j-w[i-1]],D[i-1][j]);
                }
                else
                    D[i][j] = D[i-1][j];
            }
        }
        return D[n][C];
    }
}
