package faks.vezbi;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String phrase = scanner.nextLine();
        postFixExecute(phrase);
    }

    private static int execute(int a, int b, char c) {
        if (c == '+')
            return b + a;
        else if (c == '-')
            return b - a;
        else if (c == '*')
            return b * a;
        else if (c == '/')
            return b / a;
        return 0;

    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static void postFixExecute(String phrase) {
        Stack<Integer> stack = new Stack<Integer>();
        String[] parts = phrase.split("\\s+");
        for (String part : parts) {
            if (Character.isDigit(part.charAt(0)))
                stack.push(Integer.parseInt(part));
            else if (isOperator(part.charAt(0)))
                stack.push(execute(stack.pop(), stack.pop(), part.charAt(0)));
        }

        if (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}
