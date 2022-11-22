package faks.labs1.zad1;

public class Maraton implements IMaraton {
    private String mesto;
    private int godina;
    Atleticar[]atleticari;

    public Maraton() {
    }

    public Maraton(String mesto, int godina, Atleticar[] atleticari) {
        this.mesto = mesto;
        this.godina = godina;
        this.atleticari = atleticari;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public Atleticar[] getAtleticari() {
        return atleticari;
    }

    public void setAtleticari(Atleticar[] atleticari) {
        this.atleticari = atleticari;
    }
    public String toString(){
        String s = mesto + "\n" + godina + "\n";
        for (int i=0;i<atleticari.length;i++){
            s = s+atleticari[i].toString();
        }
        return s;
    }
    public Atleticar najdobroVreme(){
        double min = atleticari[0].getVreme();
        int k = 0;
        for (int i=0;i<atleticari.length;i++){
            if(atleticari[i].getVreme()<min){
                min=atleticari[i].getVreme();
                k=i;
            }
        }
        return atleticari[k];
    }
    public int atleticariOd(String s){
        int br=0;
        for (int i=0;i<atleticari.length;i++){
            if(atleticari[i].getZemja().compareTo(s)==0)
                br++;
        }
        return br;
    }

}
