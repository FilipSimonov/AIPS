import java.io.*;

class SLLNode<E>{
    E element;
    SLLNode <E> succ;
    public SLLNode(E element,SLLNode <E> succ)  {
        this.element=element;
        this.succ=succ;
    }
}
class SLL <E>{
    SLLNode <E> first;
    public SLL() {
        first=null;
    }
    public void insertFirst(E element) {
        SLLNode <E> nov=new SLLNode(element,first);
        first=nov;
    }
    public void insertLast(E element) {
        if(first==null) {
            insertFirst(element);
        }else {
            SLLNode <E> nov=new SLLNode<E>(element,null);
            SLLNode<E>dvizi=first;
            while(dvizi.succ!=null) {
                dvizi=dvizi.succ;
            }
            dvizi.succ=nov;
        }
    }
    public String toString() {
        String string=new String();
        SLLNode<E> dvizi=first;
        while(dvizi!=null) {
            if(dvizi.succ!=null) {
                string=string+dvizi.element+"->";
            }else {
                string=string+dvizi.element;
            }
            dvizi=dvizi.succ;
        }
        return string;

    }
    public void setFirst(SLLNode<E> succ) {
        this.first=succ;
    }

}
public class vezba {

    public static void razdeli(SLL<String> lista,int x) {
        SLL <String> pogolemi=null;
        SLL <String> pomali=null;
        SLLNode<String> pomal=null;
        SLLNode<String> pogolem=null;
        SLLNode<String> dvizi=lista.first;
   /*     if(dvizi.element.length()>=x) {
           pogolemi=lista;
            pogolem=lista.first;
        }
        if(dvizi.element.length()<x) {
            pomali=lista;
            pomal=lista.first;
        }
        dvizi=dvizi.succ;*/
        while(dvizi!=null) {
            if(dvizi.element.length()>=x) {		//AKO E POGOLEM
                if(pogolem==null) {	//ako pogolemi ne e setiran
                    pogolemi=new SLL<String>();
                    pogolemi.first=dvizi;//u listata ga stava prvio zbor;
                    pogolem=dvizi;//prvio zbor u pogolemi t.e jazolo == na zboro sho e u listata

                }else {	//veke imame elementi vo listata pogolemi
                    pogolem.succ=dvizi;//vtorio ,tretio.. zbor u pogolemi == na novio zbor ;
                    pogolem=dvizi;//
                }

            }else {//AKO E POMAL
                if(pomal==null) {
                    pomali=new SLL<String>();
                    pomali.first=dvizi;
                    pomal=dvizi;
                }else {
                    pomal.succ=dvizi;
                    pomal=dvizi;
                }

            }
            dvizi=dvizi.succ;
        }
        if(pomal!=null) {
            pomal.succ=null;
        }
        if (pogolem!=null){
            pogolem.succ=null;
        }


        System.out.println("Pogolemi: "+pogolemi);
        System.out.println("Pomali "+pomali);

    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("vnesete ja recenicata");
        String recenica=input.readLine();
        String [] niza=recenica.split("\\W+");
        SLL <String> lista=new SLL<String>();
        for (int i=0;i<niza.length;i++) {
            lista.insertLast(niza[i]);
        }
        System.out.println(lista);
        System.out.println("Vnesete kolku sakate da e minimalnata dolzina na zborovite");
        String s = input.readLine();
        int x= Integer.parseInt(s);
        razdeli(lista,x);
    }

}