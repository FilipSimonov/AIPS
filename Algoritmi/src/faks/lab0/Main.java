package faks.lab0;

import java.util.Scanner;

class RabotnaNedela{

    private int [] casovi;
    private int brNedela;

    public RabotnaNedela(int[] casovi, int brNedela) {
        super();
        this.casovi = casovi;
        this.brNedela = brNedela;
    }
    @Override
    public String toString() {
        return String.valueOf(this.getChasovi());
    }
    public int getChasovi(){
        int suma=0;
        for(int i=0;i<5;i++){
            suma+=casovi[i];
        }
        return suma;
    }
}

class Rabotnik{

    private String ime;
    private RabotnaNedela [] nedeli;

    public Rabotnik(String ime, RabotnaNedela[] nedeli) {
        super();
        this.ime = ime;
        this.nedeli = nedeli;
    }

    public int Nedelachasovi(){
        int suma=0;
        for(int i=0;i<4;i++){
            suma+=nedeli[i].getChasovi();
        }
        return suma;
    }


    @Override
    public String toString() {
        String rabotnikpodatoci="";
        rabotnikpodatoci=this.ime;
        for(int i=0;i<4;i++){
            rabotnikpodatoci+="   "+nedeli[i].toString();
        }
        rabotnikpodatoci+="   " + String.valueOf(this.Nedelachasovi());
        return rabotnikpodatoci;
    }

    public String getIme() {
        return ime;
    }
}

public class Main {

    public static Rabotnik najvreden_rabotnik(Rabotnik [] niza)
    {
        Rabotnik rab = niza[0];
        for(int i=0;i<niza.length;i++){
            if(rab.Nedelachasovi()<niza[i].Nedelachasovi()){
                rab=niza[i];
            }
        }
        return rab;
    }
    public static void table(Rabotnik [] niza)
    {
        System.out.println("Rab   1   2   3   4   Vkupno");
        for(int i=0;i< niza.length;i++){
            System.out.println(niza[i]);
        }
    }

    public static void main(String[] args) {

        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        Rabotnik [] niza = new Rabotnik[n];
        for(int i=0;i<n;i++)
        {
            //vasiot kod tuka
            String ime= input.next();
            RabotnaNedela[] nedeli=new RabotnaNedela[4];
            for(int j=0;j<4;j++){
                int[] saati = new int[5];
                for(int k=0;k<5;k++){
                    saati[k]=input.nextInt();
                }
                nedeli[j]=new RabotnaNedela(saati,j);
            }
            niza[i]=new Rabotnik(ime,nedeli);

        }

        table(niza);
        System.out.println();
        System.out.println("NAJVREDEN RABOTNIK: " +najvreden_rabotnik(niza).getIme());

    }
}

