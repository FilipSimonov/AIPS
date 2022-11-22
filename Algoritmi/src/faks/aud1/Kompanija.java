package faks.aud1;

import java.util.Scanner;

public class Kompanija {
    public Vraboten []vraboteni;

    public Kompanija(Vraboten [] vraboteni) {
        this.vraboteni = vraboteni;
    }

    public Vraboten najangaziran(){
        int max=0;
        int k=0;
        for (int i=0;i<vraboteni.length;i++){
            if(vraboteni[i].vkupnoCasovi()>max){
                max=vraboteni[i].vkupnoCasovi();
                k=i;
            }
        }
        return vraboteni[k];
    }
    public void pecatiPoUspesnost(){
        boolean flag = true;
        while (flag){
            flag = false;
            for (int j=0;j<vraboteni.length-1;j++){
                if(vraboteni[j].procentZavrseni() >
                        vraboteni[j+1].procentZavrseni()){
                    Vraboten tmp = vraboteni[j];
                    vraboteni[j]= vraboteni[j+1];
                    vraboteni[j+1]= tmp;
                    flag = true;
                }
            }
        }
        for (int i=0;i<vraboteni.length;i++){
            System.out.println("Vraboten: " + vraboteni[i].getIme() + " " + vraboteni[i].getPrezime() +
                    "Uspesnost: " + vraboteni[i].procentZavrseni()*100);
        }
    }
    public void pecati(){
        for (Vraboten v : vraboteni)
            System.out.println(v.toString());
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Vraboten []pom = new Vraboten[n];
        for(int i=0;i<n;i++){
            Vraboten v = new Vraboten();
            v.setIme(input.next());
            v.setPrezime(input.next());
            v.setStaz(input.nextInt());
            v.setBrBodovi(input.nextInt());
            pom[i]=v;
            int p = input.nextInt();
            for(int j=0;j<p;j++){
                Zadaca z = new Zadaca();
                z.setBrCasovi(input.nextInt());
                z.setOpis(input.next());
                z.setStatus(input.nextBoolean());
                v.dodadiZadaca(z);
            }
        }
        Kompanija k = new Kompanija(pom);
        k.pecati();
        k.pecatiPoUspesnost();
        System.out.println("Najangaziran vraboten e: " + k.najangaziran());
    }

}
