package faks.aud3;

public class CoinsGreedy {

    void sort(int coins[],int n){
        int tmp;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if (coins[i]<coins[j]){
                    tmp = coins[i];
                    coins[i]=coins[j];
                    coins[j]=tmp;
                }
            }
        }
    }

    int greedyCoins(int coins[],int n,int sum,int coinsNum[]){
        sort(coins,n);
        int i=0;
        int br=0;
        while (sum>0){
            coinsNum[i]= sum/coins[i];
            sum-=coins[i]*coinsNum[i];
            br+=coinsNum[i];
            i++;
        }
        while (i<n){
            coinsNum[i]=0;
            i++;
        }
        return br;

    }

    public static void main(String[] args) {
        CoinsGreedy coinsGreedy = new CoinsGreedy();
        int coins[] = {1,2,5,10,50};
        int n = 5;
        int sum = 79;
        int numCoins[] = {0, 0 , 0 , 0 ,0};

        System.out.println("Greedy coins: " + coinsGreedy.greedyCoins(coins,n,sum,numCoins));

        for (int i=0;i<n;i++){
            System.out.println(coins[i] + " : " + numCoins[i]);
        }
    }
}
