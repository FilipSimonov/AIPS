package faks.aud2;

public class Koeficient implements Comparable<Koeficient>{
    int koef;
    int exp;

    public Koeficient(int koef, int exp) {
        this.koef = koef;
        this.exp = exp;
    }

    @Override
    public String toString() {
        String ret = koef + "*x^"+exp+" ";
        return ret;
    }

    public int getKoef() {
        return koef;
    }

    public void setKoef(int koef) {
        this.koef = koef;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
    public Koeficient soberi(Koeficient in){
        if(this.exp!=in.exp){
            System.out.println("Koeficientite ne mozat da se soberat bidejki imaat razlicni exponenti");
            return null;
        }
        Koeficient ret = new Koeficient(this.koef+in.koef,exp);
        return ret;
    }

    @Override
    public int compareTo(Koeficient o) {
        if(this.exp>o.exp) return 1;
        if(this.exp<o.exp) return -1;
        return 0;
    }
}
