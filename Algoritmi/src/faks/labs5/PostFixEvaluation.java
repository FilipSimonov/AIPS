package faks.labs5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.function.DoubleBinaryOperator;

interface Stack<E> {

    // Elementi na stekot se objekti od proizvolen tip.

    // Metodi za pristap:

    public boolean isEmpty ();
    // Vrakja true ako i samo ako stekot e prazen.

    public E peek ();
    // Go vrakja elementot na vrvot od stekot.

    // Metodi za transformacija:

    public void clear ();
    // Go prazni stekot.

    public void push (E x);
    // Go dodava x na vrvot na stekot.

    public E pop ();
    // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
}

class ArrayStack<E> implements Stack<E> {
    private E[] elems;
    private int depth;

    @SuppressWarnings("unchecked")
    public ArrayStack (int maxDepth) {
        // Konstrukcija na nov, prazen stek.
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }


    public boolean isEmpty () {
        // Vrakja true ako i samo ako stekot e prazen.
        return (depth == 0);
    }


    public E peek () {
        // Go vrakja elementot na vrvot od stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth-1];
    }


    public void clear () {
        // Go prazni stekot.
        for (int i = 0; i < depth; i++)  elems[i] = null;
        depth = 0;
    }


    public void push (E x) {
        // Go dodava x na vrvot na stekot.
        elems[depth++] = x;
    }


    public E pop () {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }

    public int size() {
        return depth;
    }
}

public class PostFixEvaluation {

    static int evaluatePostfix(char [] izraz, int n)
    {
        int counter=0;
        String str=String.valueOf(izraz);
        String [] niza= str.split(" ");
        int reshenie=0;
        ArrayStack<Integer> stack= new ArrayStack<>(str.length());
        for(int i=0;i<niza.length;i++){
            String elem=niza[i];
            if(elem==" ")continue;
            else if(isNumber(elem)){
                Integer broj =Integer.parseInt(elem);
                stack.push(broj);
            }
            else{
                if(stack.size()>=2) {
                    Integer broj1 = stack.pop();
                    Integer broj2 = stack.pop();

                    switch (elem) {
                        case "+":
                            stack.push(broj2 + broj1);
                            break;
                        case "-":
                            stack.push(broj2 - broj1);
                            break;
                        case "*":
                        case "x":
                            stack.push(broj2 * broj1);
                            break;
                        case "/":
                            if(broj1 == 0 || broj2==0){
                                stack.push(0);
                                break;
                            }
                            else {
                                stack.push(broj2 / broj1);
                                break;
                            }
                    }
                }else{
                    return reshenie;
                }
            }
        }
        if (stack.size() != 1) {
            reshenie=0;
        } else {
            reshenie= stack.pop();
        }
        return reshenie;

    }

    private static boolean isNumber(String str) {
        try{
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        int rez = evaluatePostfix(exp, exp.length);
        System.out.println(rez);

        br.close();

    }

}