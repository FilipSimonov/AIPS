import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BNode<E> {

    public E info;
    public BNode<E> levo;
    public BNode<E> desno;
    char ltag;
    char dtag;

    static int LEFT = 1;
    static int RIGHT = 2;

    public BNode(E info) {
        this.info = info;
        levo = null;
        desno = null;
        ltag = '-';
        dtag = '-';
    }

}

class BTree<E> {

    public BNode<E> head;

    public BTree() {
        head = new BNode<E>(null);
        head.levo = head;
        head.ltag = '-';
        head.desno = head;
        head.dtag = '+';
    }

    public BNode<E> makeRoot(E elem) {
        BNode<E> tmp = new BNode<E>(elem);
        head.levo = tmp;
        head.ltag = '+';

        tmp.levo = head;
        tmp.ltag = '-';
        tmp.desno = head;
        tmp.dtag = '-';

        return tmp;
    }

    public BNode<E> makeRootNode(BNode<E> tmp) {
        head.levo = tmp;
        head.ltag = '+';

        tmp.levo = head;
        tmp.ltag = '-';
        tmp.desno = head;
        tmp.dtag = '-';

        return tmp;
    }

    public BNode<E> addChild(BNode<E> node, int where, E elem) {
        BNode<E> tmp = new BNode<E>(elem);

        if (where == BNode.LEFT) {

            if (node.ltag == '+')
                return null;

            tmp.levo = node.levo;
            tmp.ltag = '-';
            tmp.desno = node;
            tmp.dtag = '-';
            node.levo = tmp;
            node.ltag = '+';
        } else {

            if (node.dtag == '+')
                return null;

            tmp.desno = node.desno;
            tmp.dtag = '-';
            tmp.levo = node;
            tmp.ltag = '-';
            node.desno = tmp;
            node.dtag = '+';
        }

        return tmp;
    }

    public BNode<E> addChildNode(BNode<E> node, int where, BNode<E> tmp) {

        if (where == BNode.LEFT) {

            if (node.ltag == '+')
                return null;

            tmp.levo = node.levo;
            tmp.ltag = '-';
            tmp.desno = node;
            tmp.dtag = '-';
            node.levo = tmp;
            node.ltag = '+';
        } else {

            if (node.dtag == '+')
                return null;

            tmp.desno = node.desno;
            tmp.dtag = '-';
            tmp.levo = node;
            tmp.ltag = '-';
            node.desno = tmp;
            node.dtag = '+';
        }

        return tmp;
    }

    public BNode<E> insertRight(BNode<E> parent, E info) {

        BNode<E> child = new BNode<E>(info);

        child.ltag = '-';
        child.levo = parent;
        child.dtag = parent.dtag;
        child.desno = parent.desno;

        parent.desno = child;
        parent.dtag = '+';

        if (child.dtag == '+') {
            BNode<E> temp = child.desno;
            while (temp.ltag == '+')
                temp = temp.levo;
            temp.levo = child;
        }

        return child;
    }

    public BNode<E> predecessorInorder(BNode<E> node) {

        if (node.ltag == '-')
            return node.levo;

        BNode<E> p = node.levo;
        while (p.dtag == '+')
            p = p.desno;

        return p;
    }

    public BNode<E> successorInorder(BNode<E> node) {

        if (node.dtag == '-')
            return node.desno;

        BNode<E> p = node.desno;
        while (p.ltag == '+')
            p = p.levo;

        return p;
    }

}

public class ConsecutiveNumbers {

    public static boolean PosledovatelniBroevi(BTree<Integer> t)
    {
        if(t.head.ltag=='-')
            return false;
        BNode<Integer> p=t.head.levo;
        while(p.ltag=='+')
            p=p.levo;
        BNode<Integer> q;
        while(p!=t.head)
        {
            q=t.successorInorder(p);
            if(q!=t.head)
            {
                if(p.info+1 != q.info)
                    return false;
            }
            p=q;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp;
        int N = Integer.parseInt(br.readLine());
        BNode<Integer> nodes[] = new BNode[N];
        BTree<Integer> tree = new BTree<Integer>();

        for (i=0;i<N;i++)
            nodes[i] = null;

        for (i = 0; i < N; i++) {
            String niza = br.readLine();
            temp = new StringTokenizer(niza);
            int index = Integer.parseInt(temp.nextToken());
            nodes[index] = new BNode<Integer>(Integer.parseInt(temp.nextToken()));
            String action = temp.nextToken();
            if (action.equals("LEFT")) {
                tree.addChildNode(nodes[Integer.parseInt(temp.nextToken())], BNode.LEFT, nodes[index]);
            } else if (action.equals("RIGHT")) {
                tree.addChildNode(nodes[Integer.parseInt(temp.nextToken())], BNode.RIGHT, nodes[index]);
            } else {
                tree.makeRootNode(nodes[index]);
            }
        }
        br.close();
        boolean rezultat= PosledovatelniBroevi(tree);
        System.out.print(rezultat);
    }
}