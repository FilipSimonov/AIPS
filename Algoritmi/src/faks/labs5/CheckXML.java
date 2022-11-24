package faks.labs5;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CheckXML {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String [] redovi = new String[n];

        for(int i=0;i<n;i++)
            redovi[i] = br.readLine();

        int valid=0;

        // Vasiot kod tuka
        // Moze da koristite dopolnitelni funkcii ako vi se potrebni

        ArrayStack<String> stek =new ArrayStack<>(redovi.length);

        for(int i=0;i< redovi.length;i++){
            String tag= redovi[i];
            String tag2="";
            if(tag.charAt(0)=='[' && tag.charAt(tag.length()-1)==']'){
                if(tag.charAt(1)!= '/'){
                    stek.push(tag);
                }
                else {
                    if(stek.isEmpty()){
                        valid=0;
                        break;
                    }
                    tag2= stek.pop();
                    if(tag2.substring(1).compareTo(tag.substring(2))==0){
                        valid=1;
                    }else{
                        valid=0;
                        break;
                    }
                }

            }
        }

        System.out.println(valid);

        br.close();
    }
}