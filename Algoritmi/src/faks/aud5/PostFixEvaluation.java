package faks.aud5;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class PostFixEvaluation {
    private static class SLLNode<E> {
        protected E element;
        protected SLLNode<E> succ;

        public SLLNode(E elem, SLLNode<E> succ) {
            this.element = elem;
            this.succ = succ;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    private static class LinkedStack<E> {
        private int count = 0;
        private SLLNode<E> top;

        public LinkedStack() {
            top = null;
        }

        public boolean isEmpty() {
            return (top == null);
        }

        public E peek() {
            if (top == null)
                throw new NoSuchElementException();
            return top.element;
        }

        public void clear() {
            top = null;
        }

        public void push(E x) {
            count++;
            top = new SLLNode<E>(x, top);

        }

        public E pop() {
            if (top == null)
                throw new NoSuchElementException();
            E topElem = top.element;
            top = top.succ;
            count--;
            return topElem;

        }
        public int getSize() {
            return count;
        }
    }
    public static int execute(int a,int b,char c){
        if (c=='+')
            return b+a;
        else if (c=='-')
            return b-a;
        else if (c=='*')
            return b*a;
        else if (c=='/')
            return b/a;
        else return 0;
    }
    public static boolean isOperator(char c){
        if (c=='+' || c=='-' || c=='*' || c=='/')
            return true;
        else return false;
    }
    public static void postFixExecute(String phrase){
        LinkedStack<Integer> stack = new LinkedStack<>();

        for (int i=0;i<phrase.length();i++){
            if (Character.isDigit(phrase.charAt(i))){
                stack.push(Integer.parseInt(String.valueOf(phrase.charAt(i))));
            }
            if (isOperator(phrase.charAt(i))){
                stack.push(execute(stack.pop(),stack.pop(),phrase.charAt(i)));
            }
        }
        if (!(stack.isEmpty()))
            System.out.println(stack.pop());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String phrase = scanner.nextLine();
        postFixExecute(phrase);
    }

}
