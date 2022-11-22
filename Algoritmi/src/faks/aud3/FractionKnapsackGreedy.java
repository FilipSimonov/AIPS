package faks.aud3;

public class FractionKnapsackGreedy {

    public void sort(float p[],float w[],int n){
        float tmpP,tmpW;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if ( (p[i]/w[i]) < (p[j]/w[j])){
                    tmpP = p[i];
                    tmpW = w[i];
                    p[i] = p[j];
                    w[i] = w[j];
                    p[j] = tmpP;
                    w[j] = tmpW;
                }
            }
        }
    }


    public float fractionalKnapsack(float p[],float w[],int C,int n, float result[]){
        sort(p,w,n);

        float profit = 0;
        for (int i=0;i<n;i++){
            result[i] = 0;
        }

        for (int i=0;i<n;i++){
            if (C>w[i]){
                C-=w[i];
                profit+=p[i];
            }
            else {
                profit += (C/w[i]*p[i]);
            }
        }
        return profit;
    }

    public static void main(String[] args) {

        int C = 20;
        int n=3;
        float p[] = {25,24,15};
        float w[] = {18,15,19};
        float result[] = new float[3];
        FractionKnapsackGreedy fractionKnapsackGreedy = new FractionKnapsackGreedy();
        System.out.println("Greedy: " + fractionKnapsackGreedy.fractionalKnapsack(p,w,C,n,result));
    }
}
