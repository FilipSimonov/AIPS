import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BNode<E> {

    public E info;
    public BNode<E> left;
    public BNode<E> right;

    static int LEFT = 1;
    static int RIGHT = 2;

    public BNode(E info) {
        this.info = info;
        left = null;
        right = null;
    }

    public BNode() {
        this.info = null;
        left = null;
        right = null;
    }

    public BNode(E info, BNode<E> left, BNode<E> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

}

class BTree<E extends Comparable<E>> {

    public BNode<E> root;

    public BTree() {
        root = null;
    }

    public BTree(E info) {
        root = new BNode<E>(info);
    }

    public void makeRoot(E elem) {
        root = new BNode(elem);
    }

    public void makeRootNode(BNode<E> node) {
        root = node;
    }

    public BNode<E> addChild(BNode<E> node, int where, E elem) {

        BNode<E> tmp = new BNode<E>(elem);

        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }

        return tmp;
    }

    public BNode<E> addChildNode(BNode<E> node, int where, BNode<E> tmp) {

        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }

        return tmp;
    }

    public BNode<Integer> baraj(BNode<Integer> jazol, int elem) {
        BNode<Integer> rez = null;
        if (jazol == null)
            return null;
        if (jazol.info == elem)
            return jazol;
        if (jazol.left != null)
            rez = baraj(jazol.left, elem);
        if (rez == null)
            rez = baraj(jazol.right, elem);

        return rez;
    }

    int levo(BNode<Integer> jazol, int elem)
    {
        int sum = 0;
        if (jazol == null)
            return 0;
        if (jazol.info < elem)
            sum += jazol.info;
        if (jazol.left != null)
            sum += levo(jazol.left, elem);
        if (jazol.right != null)
            sum += levo(jazol.right, elem);
        return sum;
    }

    int desno(BNode<Integer> jazol, int elem)
    {
        int suma = 0;

        if (jazol == null)
            return 0;
        if (jazol.info > elem)
            suma += jazol.info;
        if (jazol.left != null)
            suma+= desno(jazol.left, elem);
        if (jazol.right != null)
            suma += desno(jazol.right, elem);
        return suma;
    }
}


public class BinaryTreeSum {


    public static void main(String[] args) throws Exception {
        int i, j, k;
        int index;
        String action;

        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        BNode<Integer> nodes[] = new BNode[N];
        BTree<Integer> tree = new BTree<Integer>();

        for (i=0;i<N;i++)
            nodes[i] = new BNode<Integer>();

        for (i = 0; i < N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            index = Integer.parseInt(st.nextToken());
            nodes[index].info = Integer.parseInt(st.nextToken());
            action = st.nextToken();
            if (action.equals("LEFT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.LEFT, nodes[index]);
            } else if (action.equals("RIGHT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.RIGHT, nodes[index]);
            } else {
                // this node is the root
                tree.makeRootNode(nodes[index]);
            }
        }
        int baranaVrednost=Integer.parseInt(br.readLine());
        br.close();
        BNode<Integer> gljazol = tree.baraj(tree.root, baranaVrednost);
        System.out.println(tree.levo(gljazol.left, gljazol.info) + " " + tree.desno(gljazol.right, gljazol.info));

    }
}
