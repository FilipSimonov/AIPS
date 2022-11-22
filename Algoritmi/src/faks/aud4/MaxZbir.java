package faks.aud4;

public class MaxZbir {

    private static void max(int m,int n,int [][]initcial){

        int [][]max = new int[100][100];
        max[0][0] = initcial[0][0];

        for (int i=1;i<n;i++){
            max[0][i] = max[0][i-1] + initcial[0][i]; //first row
        }
        for (int i=1;i<m;i++){
            max[i][0] = max[i-1][0] + initcial[i][0]; //first column
        }

        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                max[i][j] = Math.max(max[i-1][j],max[i][j-1]) + initcial[i][j];
            }
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                System.out.println(max[i][j] + " ");
            }

        }

    }

    public static void main(String[] args) {
        int m=5;
        int n=3;
        int initcial[][] = {{1,2,4},{5,5,5},{2,6,8},{9,9,4},{2,4,6}};

        max(m,n,initcial);
    }
}
