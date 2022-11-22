package faks.vezbi;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

interface Stack<E> {
    public boolean isEmpty();

    public E peek();

    public void clear();

    public void push(E x);

    public E pop();

    public int len();
}
class ArrayStack<E> implements Stack<E> {

    private E[] elems;
    private int depth;

    @SuppressWarnings("unchecked")
    public ArrayStack(int maxDepth) {
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }

    public boolean isEmpty() {
        return (depth == 0);
    }

    public E peek() {
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth - 1];
    }

    public void clear() {
        for (int i = 0; i < depth; i++)
            elems[i] = null;
        depth = 0;
    }

    public void push(E x) {
        elems[depth++] = x;
    }

    public E pop() {
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }

    public int len() {
        return elems.length;
    }
}

public class StackBukvi {


    public static void main(String[] args) throws IOException {
        char [] niza = new char[100];

        Scanner f=new Scanner(System.in);
        String st=f.next();
        niza=st.toCharArray();

        int rez= proveri_t_posle_s(niza);
        System.out.println(rez);
    }

    private static int proveri_t_posle_s(char[] niza) {
        ArrayStack<Character> stack = new ArrayStack<>(100);

        for (int i=0;i<niza.length;i++){
            if (niza[i]=='T'){
                stack.push(niza[i]);
            }
            else if (niza[i]=='S'){
                stack.push(niza[i]);
            }
        }
        if (!isTrue(stack))
            return 0;
        return 1;

    }
    private static boolean isTrue(ArrayStack<Character> stack){
        int sum = 0;
        int totalSum = 0;
        boolean flag = true;
        while (!stack.isEmpty()){
            if (stack.pop()=='T')
                sum++;
            else if (stack.pop()=='S'){
                if (flag){
                    totalSum +=sum;
                    sum = 0;
                    flag = false;
                }else if (totalSum!=sum){
                    return false;
                }
                sum = 0;
            }
        }
        return true;
    }



}