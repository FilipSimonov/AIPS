package faks.aud3;

public class CoinsBruteForce {
   private int m50,m10,m5,m2,m1;
   private final int INF = 1000000;

    public CoinsBruteForce() {
    }

    public int numCoins(int sum){
        Coins coins = new Coins();
       int tmp = 0;
       int num=0;
       int MIN = INF;
       for (m50=0;m50<=(sum/50);m50++){
           for (m10=0;m10<=(sum/10);m10++){
               for (m5=0;m5<=(sum/5);m5++){
                   for (m2=0;m2<=(sum/2);m2++){
                       for (m1=0;m1<=(sum/1);m1++){
                           tmp = m50*50 + m10*10 + m5*5 + m2*2 + m1*1;
                           if (tmp == sum){
                               num = m50+m10+m5+m2+m1;
                               if (MIN>num){
                                   MIN=num;

                               }
                           }

                       }
                   }
               }
           }
       }
       return MIN;
   }

    public static void main(String[] args) {
        CoinsBruteForce coinsBruteForce = new CoinsBruteForce();
        System.out.println(coinsBruteForce.numCoins(79));

    }
}
