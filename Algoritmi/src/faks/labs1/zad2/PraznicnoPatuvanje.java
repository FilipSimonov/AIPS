package faks.labs1.zad2;

public class PraznicnoPatuvanje extends Patuvanje {
    private int pocD;
    private int pocM;
    private int krajD;
    private int krajM;

    public PraznicnoPatuvanje(){};

    public PraznicnoPatuvanje(String ime, int cena, int pocD, int pocM, int krajD, int krajM) {
        super(ime, cena);
        try {
            if (pocM > krajM)
                throw new Exception();
            else if (pocM == krajM && pocD > krajD)
                throw new Exception();
            this.pocD = pocD;
            this.pocM = pocM;
            this.krajD = krajD;
            this.krajM = krajM;
        }
        catch (Exception e){
            this.pocD=krajD;
            this.pocM=krajM;
            this.krajD=krajM;
            this.krajM=pocM;
            System.out.println("Iskluchok");
        }

    }
    public int getPocD() {
        return pocD;
    }

    public int getPocM() {
        return pocM;
    }

    public int getKrajD() {
        return krajD;
    }

    public int getKrajM() {
        return krajM;
    }
    public int vratiVremeVoDenovi(){
        if(pocM==krajM){
            return krajD-pocD;
        }
        else{
            return ((krajM-pocM)*30)+krajD-pocD;
        }
    }
}
