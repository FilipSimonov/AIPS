package faks.aud1;

public class Zadaca {
   private String opis;
   private int brCasovi;
   private boolean status;

    public Zadaca() {
    }

    public Zadaca(String opis, int brCasovi, boolean status) {
        this.opis = opis;
        this.brCasovi = brCasovi;
        this.status = status;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getBrCasovi() {
        return brCasovi;
    }

    public void setBrCasovi(int brCasovi) {
        this.brCasovi = brCasovi;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Opis: " + opis + ",broj na casovi: " + brCasovi + " status: "
                + (status ? "aktivna" : "zavrsena");
    }
}
