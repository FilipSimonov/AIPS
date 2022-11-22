package faks.aud3;

public class Greedy {

    void sortiraj_paricki(int coins[],int n){
        int i,j,tmp;

        for (i=0;i<n;i++){
            for (j=i+1;j<n;j++){
                if (coins[i]<coins[j]){
                    tmp = coins[i];
                    coins[i]=coins[j];
                    coins[j] = tmp;
                }
            }
        }
    }

    int greedyCoins(int coins[], int n, int sum , int coinsNum[]){
        sortiraj_paricki(coins,n);

        int i=0;
        int br=0;

        while (sum>0){
            coinsNum[i]=sum/coins[i];
            sum-=coinsNum[i] * coins[i];
            br+=coinsNum[i];
            i++;
        }
        while (i<n){
            coinsNum[i]=0;
            i++;
        }
        return br;
    }

}
