package faks.aud4;

public class Coins {

    private static int MAX_SUM = 1000;
    public static int[] minCoins(int n,int coins[]){

        int coinsNum[] = new int[MAX_SUM +1];

        for (int i = 0; i<MAX_SUM; i++)
            coinsNum[i] = 0;

        for (int i=0;i<n;i++){
            coinsNum[i] = 1; //na site po 1parice ex.for sum 5 need 1coin;
        }

        for (int i=0;i<MAX_SUM;i++){
            for (int j=0;j<n;j++){
                if (i+coins[j]<=MAX_SUM){
                    if (coinsNum[i+coins[j]]==0 ||
                    coinsNum[i+coins[j]]>coinsNum[i]+1){
                        coinsNum[i+coins[j]] = coinsNum[i]+1;
                    }
                }
            }
        }
            return coinsNum;
    }

    public static void main(String[] args) {
        int n=5;
        int coins[] = {1,2,5,8,10};

        System.out.println(Coins.minCoins(n,coins)[23]);
    }
}
