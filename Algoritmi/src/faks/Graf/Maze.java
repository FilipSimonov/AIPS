package faks.Graf;

import java.util.Hashtable;
import java.util.Stack;
class Graph<E> {

    int num_nodes; // broj na jazli
    E nodes[];    // informacija vo jazlite - moze i ne mora?
    int adjMat[][];  // matrica na sosednost

    @SuppressWarnings("unchecked")
    public Graph(int num_nodes) {
        this.num_nodes = num_nodes;
        nodes = (E[]) new Object[num_nodes];
        adjMat = new int[num_nodes][num_nodes];

        for(int i=0;i<this.num_nodes;i++)
            for(int j=0;j<this.num_nodes;j++)
                adjMat[i][j]=0;
    }



    public Graph(int num_nodes, E[] nodes) {
        this.num_nodes = num_nodes;
        this.nodes = nodes;
        adjMat = new int[num_nodes][num_nodes];

        for(int i=0;i<this.num_nodes;i++)
            for(int j=0;j<this.num_nodes;j++)
                adjMat[i][j]=0;
    }



    int adjacent(int x,int y)
    {  // proveruva dali ima vrska od jazelot so indeks x do jazelot so indeks y
        return (adjMat[x][y]!=0)?1:0;
    }

    void addEdge(int x,int y)
    {  // dodava vrska megu jazlite so indeksi x i y
        adjMat[x][y]=1;
        adjMat[y][x]=1;
    }

    void deleteEdge(int x,int y)
    {
        // ja brise vrskata megu jazlite so indeksi x i y
        adjMat[x][y]=0;
        adjMat[y][x]=0;
    }

    // Moze i ne mora?
    E get_node_value(int x)
    {  // ja vraka informacijata vo jazelot so indeks x
        return nodes[x];
    }

    // Moze i ne mora?
    void set_node_value(int x, E a)
    {  // ja postavuva informacijata vo jazelot so indeks na a
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
            if(adjacent(node, i)==1){
                if (!visited[i])
                    dfsRecursive(i, visited);
            }
        }
    }
    @Override
    public String toString() {
        String ret="  ";
        for(int i=0;i<num_nodes;i++)
            ret+=nodes[i]+" ";
        ret+="\n";
        for(int i=0;i<num_nodes;i++){
            ret+=nodes[i]+" ";
            for(int j=0;j<num_nodes;j++)
                ret+=adjMat[i][j]+" ";
            ret+="\n";
        }
        return ret;
    }
}

public class Maze {
    Graph g;
    int start_node;
    int end_node;
    Hashtable<String ,Integer> h;

    public Maze(){
        h = new Hashtable<String ,Integer>();
    }
    void generateGraph(int rows,int columns,String[] in){
        int num_nodes=0;
        String key;

        for (int i=1;i<rows;i++){
            for(int j=1;j<columns;j++){
                if (in[i].charAt(j)!='#'){
                    key = i + "," + j;
                    h.put(key,num_nodes);
                    if (in[i].charAt(j)=='S')
                        start_node=num_nodes;
                    if (in[i].charAt(j)=='E')
                        end_node=num_nodes;
                    num_nodes++;
                }
            }
        }

        g = new Graph(num_nodes);

        int x;
        int y;
        for (int i=1;i<rows;i++){
            for (int j=1;j<columns;j++){
                if (in[i].charAt(j)!='#'){
                    if (in[i].charAt(j-1)!='#'){
                        x=h.get(i+","+j);
                        y=h.get(i+","+(j-1));
                        g.addEdge(x,y);
                    }
                    if (in[i].charAt(j+1)!='#'){
                        x=h.get(i+","+j);
                        y=h.get(i+","+(j+1));
                        g.addEdge(x,y);
                    }
                    if (in[i-1].charAt(j)!='#'){
                        x=h.get(i+","+j);
                        y=h.get((i-1)+","+j);
                        g.addEdge(x,y);
                    }
                    if (in[i+1].charAt(j)!='#'){
                        x=h.get(i+","+j);
                        y=h.get((i+1)+","+j);
                        g.addEdge(x,y);
                    }
                }
            }
        }
    }
    void findPath() {
        boolean visited[] = new boolean[g.getNum_nodes()];
        for (int i = 0; i < g.getNum_nodes(); i++)
            visited[i] = false;
        visited[start_node] = true;
        Stack<Integer> s = new Stack<Integer>();
        s.push(start_node);

        int pom;

        while (!s.isEmpty() && s.peek() != end_node) {
            pom = s.peek();
            int pom1 = pom;
            for (int i = 0; i < g.getNum_nodes(); i++) {
                if (g.adjacent(pom, i) == 1) {
                    pom1 = i;
                    if (!visited[i])
                        break;
                }
            }
            if (!visited[pom1]) {
                visited[pom1] = true;
                //System.out.println(pom1 + ": " + nodes[pom1]);
                s.push(pom1);
            } else
                s.pop();
        }
        if (s.isEmpty())
            System.out.println("Nema reshenie");
        else {
            Stack<Integer> os = new Stack<Integer>();
            while (!s.isEmpty())
                os.push(s.pop());
            while (!os.isEmpty())
                System.out.println(os.pop());
        }
    }


       public static void main(String[] args) {
        Maze m = new Maze();
        int rows = 6;
        int columns = 6;
        String[] in = new String[rows];

        in[0] = "######";
        in[1] = "# # ##";
        in[2] = "# # S#";
        in[3] = "# # ##";
        in[4] = "# E  #";
        in[5] = "######";

        m.generateGraph(rows, columns, in);
        System.out.println("Pateka: ");
        m.findPath();
    }
}