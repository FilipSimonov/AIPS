package faks.labs1.zad2;
import java.util.Scanner;
public class Test {


    public static void main(String[] args) {


        int n;
        Scanner in=new Scanner(System.in);
        n=in.nextInt();

        Patuvanje nizaPatuvanje[]=new Patuvanje[n];

        for (int i=0;i<n;i++){
            int tip=in.nextInt();
            if (tip==0){
                String ime=in.next();
                int cena =in.nextInt();
                int vreme=in.nextInt();
                nizaPatuvanje[i]=new GodishenOdmor(ime,cena,vreme);
            }
            else {
                String ime=in.next();
                int cena =in.nextInt();
                int pocD=in.nextInt();
                int pocM=in.nextInt();
                int krajD=in.nextInt();
                int krajM=in.nextInt();
                nizaPatuvanje[i]=new PraznicnoPatuvanje(ime,cena,pocD,pocM, krajD,krajM);

            }
        }

        //решение на барање 1
        String print = new String();
        for (int i=0;i< nizaPatuvanje.length;i++){
            PraznicnoPatuvanje p = new PraznicnoPatuvanje();
            if(nizaPatuvanje[i] instanceof PraznicnoPatuvanje){
                p=(PraznicnoPatuvanje)nizaPatuvanje[i];
                if(p.getPocM()==6)
                    print+=p.getIme() + " ";
            }
        }
        System.out.println(print);

        //решение на барање 2
            double sum=0.0;
            for (int i=0;i<nizaPatuvanje.length;i++){
                sum+=nizaPatuvanje[i].vratiVremeVoDenovi();
            }
        System.out.println(sum/nizaPatuvanje.length);

        //решение на барање 3
        String ime = in.next();
        int cena = in.nextInt();
        int vreme = in.nextInt();
        GodishenOdmor odmor = new GodishenOdmor(ime,cena,vreme);

        //решение на барање 4
        System.out.println(Patuvanje.vratiMinCena(nizaPatuvanje,nizaPatuvanje.length,odmor));

    }
}
