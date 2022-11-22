package faks.labs1.zad2;

public class GodishenOdmor extends Patuvanje {
    private int vremetraenje;

    public GodishenOdmor(){}
    public GodishenOdmor(String ime, int cena, int vremetraenje) {
        super(ime, cena-1000);
        this.vremetraenje = vremetraenje;
    }

    public int getVremetraenje() {
        return vremetraenje;
    }
    public int vratiVremeVoDenovi(){
        return vremetraenje;
    }
}
