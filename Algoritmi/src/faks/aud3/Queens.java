package faks.aud3;

public class Queens {

    private int i1,i2,j1,j2;

    public Queens(int i1, int i2, int j1, int j2) {
        this.i1 = i1;
        this.i2 = i2;
        this.j1 = j1;
        this.j2 = j2;
    }

    public boolean areAttacking(int i1, int i2, int j1, int j2){
        if (i1==i2) return true;
        if (j1==j2) return true;
        if(Math.abs(i1-i2) == Math.abs(j1-j2))
            return true;
        return false;
    }

    public int numWays(){
        int num=0;
        for (i1=0;i1<8;i1++){
            for (i2=0;i2<8;i2++){
                for (j1=0;j1<8;j1++){
                    for (j2=0;j2<8;j2++){
                        if (!(areAttacking(i1,i2,j1,j2)))
                            num++;
                    }
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Queens queen1 = new Queens(1,1,3,4);
        Queens queen2 = new Queens(4,4,4,4);
        Queens queen3 = new Queens(1,1,3,4);
        Queens queen4 = new Queens(1,1,3,4);

        System.out.println(queen2.numWays());
    }

}
