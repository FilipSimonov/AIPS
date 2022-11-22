package faks.lab0;
import java.util.Locale;
import java.util.Scanner;

public class Initials {

    static void printInitials(String name)
    {
        String[] pom=name.split(" ");
        String initials="";
        for(int i=0; i< pom.length;i++){
            initials+= pom[i].substring(0,1);
        }
        System.out.printf(initials.toUpperCase());
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        String name;
        input.nextLine();

        for(int i=0; i<n; i++){
            name = input.nextLine();
            printInitials(name);
            System.out.println();
        }
    }
}

