package faks.aud1;

public class Vraboten {
    private static double BOD = 50;
    private String ime;
    private String prezime;
    private double plata;
    private int staz;
    private int brBodovi;
    private Zadaca[] zadaci;
    private int brZadaci;

    public Vraboten() {
        zadaci = new Zadaca[10];
        brZadaci = 0;
    }

    public Vraboten(String ime, String prezime, double plata, int staz, int brBodovi) {
        this.ime = ime;
        this.prezime = prezime;
        this.staz = staz;
        this.brBodovi = brBodovi;
        this.plata = BOD*brBodovi;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public int getStaz() {
        return staz;
    }

    public void setStaz(int staz) {
        this.staz = staz;
    }

    public int getBrBodovi() {
        return brBodovi;
    }

    public void setBrBodovi(int brBodovi) {
        this.brBodovi = brBodovi;
    }

    public int getBrZadaci() {
        return brZadaci;
    }

    public void setBrZadaci(int brZadaci) {
        this.brZadaci = brZadaci;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    public void dodadiZadaca(Zadaca nova){
        if(brZadaci==10)
            System.out.println("Ne moze da se dodade nova zadaca");
        else
            zadaci[brZadaci++] = nova;
    }

    public int vkupnoCasovi(){
        int sum=0;
        for (int i=0;i<brZadaci;i++){
            sum+=zadaci[i].getBrCasovi();
        }
        return sum;
    }
    public double procentZavrseni(){
        int br=0;
        for(int i=0;i<brZadaci;i++){
            if(zadaci[i].isStatus()){
                br++;
            }
        }
        return (double)br/brZadaci;
    }
}
