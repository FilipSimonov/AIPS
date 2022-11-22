package faks.aud3;

public class Coins {
    private int m50;
    private int m10;
    private int m5;
    private int m2;
    private int m1;
    private int sum;

    public Coins(int m50, int m10, int m5, int m2, int m1,int sum) {
        this.m50 = m50;
        this.m10 = m10;
        this.m5 = m5;
        this.m2 = m2;
        this.m1 = m1;
        this.sum = 0;
    }

    @Override
    public String toString() {
        return "Coins{" +
                "m50=" + m50 +
                ", m10=" + m10 +
                ", m5=" + m5 +
                ", m2=" + m2 +
                ", m1=" + m1 +
                ", MINParicki=" + sum +
                '}';
    }

    public Coins() {

    }

    public int getM50() {
        return m50;
    }

    public int getM10() {
        return m10;
    }

    public int getM5() {
        return m5;
    }

    public int getM2() {
        return m2;
    }

    public int getM1() {
        return m1;
    }

    public int getSum() {
        return sum;
    }
}
