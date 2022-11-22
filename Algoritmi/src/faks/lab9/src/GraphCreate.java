import java.util.*;

public class GraphCreate {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n;
        n=input.nextInt();
        input.nextLine();
        Hashtable<Integer,Character> table=new Hashtable();
        Graph<Character> graph=new Graph(500);
        for (int i=0; i<n; i++) {
            String line=input.nextLine();
            String commands[]=line.split(" ");

            if(commands[0].equals("CREATE")) {
                graph.setNum_nodes(Integer.parseInt(commands[1]));
                for(int j=0; j<Integer.parseInt(commands[1]); j++) {
                    table.put(j, (char)((int)'A'+j));
                    graph.set_node_value(j, (char)((int)'A'+j));
                }
            }
            if(commands[0].equals("ADDEDGE")) {
                graph.addEdge(Integer.parseInt(commands[1]),Integer.parseInt(commands[2]));
            }
            if(commands[0].equals("PRINTMATRIX")) {
                System.out.print(graph);
            }
            if(commands[0].equals("ADJACENT")) {
                if(graph.adjacent(Integer.parseInt(commands[1]),Integer.parseInt(commands[2]))==1)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
            if(commands[0].equals("PRINTNODE")) {
                System.out.println(table.get(Integer.parseInt(commands[1])));
            }
            if(commands[0].equals("DELETEEDGE")) {
                graph.deleteEdge(Integer.parseInt(commands[1]),Integer.parseInt(commands[2]));
            }
        }
    }
}
interface Queue<E> {
    public boolean isEmpty ();
    public int size ();
    public E peek ();
    public void clear ();
    public void enqueue (E x);
    public E dequeue ();
}
class SLLNode<E> {
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
class LinkedQueue<E> implements Queue<E> {
    SLLNode<E> front, rear;
    int length;
    public LinkedQueue () {
        clear();
    }

    public boolean isEmpty () {
        return (length == 0);
    }

    public int size () {
        return length;
    }

    public E peek () {
        if (front == null)
            throw new NoSuchElementException();
        return front.element;
    }

    public void clear () {
        front = rear = null;
        length = 0;
    }

    public void enqueue (E x) {
        SLLNode<E> latest = new SLLNode<E>(x, null);
        if (rear != null) {
            rear.succ = latest;
            rear = latest;
        } else
            front = rear = latest;
        length++;
    }

    public E dequeue () {
        if (front != null) {
            E frontmost = front.element;
            front = front.succ;
            if (front == null)  rear = null;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }

}
class Graph<E> {

    int num_nodes;
    E nodes[];
    int adjMat[][];

    @SuppressWarnings("unchecked")
    public Graph(int num_nodes) {
        this.num_nodes = num_nodes;
        nodes = (E[]) new Object[num_nodes];
        adjMat = new int[num_nodes][num_nodes];

        for(int i=0; i<this.num_nodes; i++)
            for(int j=0; j<this.num_nodes; j++)
                adjMat[i][j]=0;
    }



    public Graph(int num_nodes, E[] nodes) {
        this.num_nodes = num_nodes;
        this.nodes = nodes;
        adjMat = new int[num_nodes][num_nodes];
        for(int i=0; i<this.num_nodes; i++)
            for(int j=0; j<this.num_nodes; j++)
                adjMat[i][j]=0;
    }



    int adjacent(int x,int y) {
        return (adjMat[x][y]!=0)?1:0;
    }

    void addEdge(int x,int y) {
        adjMat[x][y]=1;
        adjMat[y][x]=1;
    }

    void deleteEdge(int x,int y) {
        adjMat[x][y]=0;
        adjMat[y][x]=0;
    }

    E get_node_value(int x) {
        return nodes[x];
    }

    void set_node_value(int x, E a) {
        nodes[x]=a;
    }

    public int getNum_nodes() {
        return num_nodes;
    }

    public void setNum_nodes(int num_nodes) {
        this.num_nodes = num_nodes;
    }

    void dfsSearch(int node) {
        boolean visited[] = new boolean[num_nodes];
        for (int i = 0; i < num_nodes; i++)
            visited[i] = false;
        dfsRecursive(node, visited);
    }

    void dfsRecursive(int node, boolean visited[]) {
        visited[node] = true;
        System.out.println(node + ": " + nodes[node]);

        for (int i = 0; i < this.num_nodes; i++) {
            if(adjacent(node, i)==1) {
                if (!visited[i])
                    dfsRecursive(i, visited);
            }
        }
    }

    void dfsNonrecursive(int node) {
        boolean visited[] = new boolean[num_nodes];
        for (int i = 0; i < num_nodes; i++)
            visited[i] = false;
        visited[node] = true;
        System.out.println(node + ": " + nodes[node]);
        Stack<Integer> s = new Stack<Integer>();
        s.push(node);
        int temp;
        while (!s.isEmpty()) {
            temp = s.peek();
            int temp1 = temp;
            for (int i = 0; i < num_nodes; i++) {
                if(adjacent(temp,i)==1) {
                    temp1 = i;
                    if(!visited[i])
                        break;
                }
            }
            if(!visited[temp1]) {
                visited[temp1] = true;
                System.out.println(temp1 + ": " + nodes[temp1]);
                s.push(temp1);
            } else
                s.pop();
        }
    }
    void bfs(int node) {
        boolean visited[] = new boolean[num_nodes];
        for (int i = 0; i < num_nodes; i++)
            visited[i] = false;
        visited[node] = true;
        System.out.println(node+": " + nodes[node]);
        Queue<Integer> q = new LinkedQueue<Integer>();
        q.enqueue(node);
        int pom;
        while(!q.isEmpty()) {
            pom = q.dequeue();
            for (int i = 0; i < num_nodes; i++) {
                if(adjacent(pom, i)==1) {
                    if (!visited[i]) {
                        visited[i] = true;
                        System.out.println(i+": " + nodes[i]);
                        q.enqueue(i);
                    }
                }
            }
        }
    }
    @Override
    public String toString() {
        String rez="";
        for(int i=0; i<num_nodes; i++) {
            for(int j=0; j<num_nodes; j++)
                rez+=adjMat[i][j]+" ";
            rez+="\n";
        }
        return rez;
    }
}