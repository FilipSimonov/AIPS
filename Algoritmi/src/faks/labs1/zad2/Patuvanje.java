package faks.labs1.zad2;

abstract public class Patuvanje {
    private String ime;
    private int cena;

    public Patuvanje() {
    }

    public Patuvanje(String ime, int cena) {
        this.ime = ime;
        this.cena = cena;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
    abstract int vratiVremeVoDenovi();
    public static int vratiMinCena(Patuvanje [] niza, int n, Patuvanje zaSporedba){
        int min=0;
        int k=0;
        for (int i=0;i<n;i++){
            if(niza[i].vratiVremeVoDenovi()>zaSporedba.vratiVremeVoDenovi()){
                if(niza[i].getCena()<min){
                    min=niza[i].getCena();
                    k=i;
                }
            }
        }
        return min;
    }
}
