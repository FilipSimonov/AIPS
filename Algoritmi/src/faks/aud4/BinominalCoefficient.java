package faks.aud4;

public class BinominalCoefficient {

    public static int binominal_coeficient(int n,int k){

        int matrix[][]  =new int[n-1][n-1];

        for (int i=0;i<=n;i++){
            matrix[i][0] = 1;
        }
        for (int j=0;j<=n;j++){
            matrix[j][j] = 1;
        }

        for (int i=1;i<=n;i++){
            for (int j=1;j<i;j++){
                matrix[i][j] = matrix[i-1][j-1] + matrix[i-1][j];
            }
        }

        return matrix[n][k];
    }

    public static void main(String[] args) {

        System.out.println(BinominalCoefficient.binominal_coeficient(5,2));
    }
}
