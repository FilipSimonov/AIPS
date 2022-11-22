package faks.Graf;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

class Graph<E> {

    int num_nodes;
    GraphNode<E> adjList[];

    @SuppressWarnings("unchecked")
    public Graph(int num_nodes, E[] list) {
        this.num_nodes = num_nodes;
        adjList = (GraphNode<E>[]) new GraphNode[num_nodes];
        for (int i = 0; i < num_nodes; i++)
            adjList[i] = new GraphNode<E>(i, list[i]);
    }

    @SuppressWarnings("unchecked")
    public Graph(int num_nodes) {
        this.num_nodes = num_nodes;
        adjList = (GraphNode<E>[]) new GraphNode[num_nodes];
    }

    int adjacent(int x, int y) {
        // proveruva dali ima vrska od jazelot so
        // indeks x do jazelot so indeks y
        return (adjList[x].containsNeighbor(adjList[y])) ? 1 : 0;
    }

    void addEdge(int x, int y) {
        // dodava vrska od jazelot so indeks x do jazelot so indeks y
        if (!adjList[x].containsNeighbor(adjList[y])) {
            adjList[x].addNeighbor(adjList[y]);
        }
    }
    void deleteEdge(int x, int y) {
        adjList[x].removeNeighbor(adjList[y]);
    }
    @Override
    public String toString() {
        String ret = new String();
        for (int i = 0; i < this.num_nodes; i++)
            ret += i + ": " + adjList[i] + "\n";
        return ret;
    }
}
class GraphNode<E> {
    private int index;//index (reden broj) na temeto vo grafot
    private E info;
    private LinkedList<GraphNode<E>> neighbors;

    public GraphNode(int index, E info) {
        this.index = index;
        this.info = info;
        neighbors = new LinkedList<GraphNode<E>>();
    }

    boolean containsNeighbor(GraphNode<E> o){
        return neighbors.contains(o);
    }

    void addNeighbor(GraphNode<E> o){
        neighbors.add(o);
    }

    void removeNeighbor(GraphNode<E> o){
        if(neighbors.contains(o))
            neighbors.remove(o);
    }

    @Override
    public String toString() {
        String ret= "INFO:"+info+" SOSEDI:";
        for(int i=0;i<neighbors.size();i++)
            ret+=neighbors.get(i).info+" ";
        return ret;
    }
    @Override
    public boolean equals(Object obj) {
        @SuppressWarnings("unchecked")
        GraphNode<E> pom = (GraphNode<E>)obj;
        return (pom.info.equals(this.info));
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public LinkedList<GraphNode<E>> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(LinkedList<GraphNode<E>> neighbors) {
        this.neighbors = neighbors;
    }
}

public class Lavirint{
    Graph g;
    int start_node;
    int end_node;
    Hashtable<String,Integer> hash1;

    public Lavirint() {
        hash1 = new Hashtable<String,Integer>();
    }

    void generateGraph(int rows,int columns,String[] in){
        int num_nodes = 0;
        String key;

        for (int i=1;i<rows;i++){
            for (int j=1;j<columns;j++){
                if (in[i].charAt(j)!='#'){
                    key = i + "," + j;
                    hash1.put(key,num_nodes);
                    if (in[i].charAt(j)=='S')
                        start_node = num_nodes;
                    if (in[i].charAt(j)=='E')
                        end_node = num_nodes;
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
                        x = hash1.get(i+","+j);
                        y = hash1.get(i+","+(j-1));
                        g.addEdge(x,y);
                    }
                    if (in[i].charAt(j+1)!='#'){
                        x = hash1.get(i+","+j);
                        y = hash1.get(i+","+(j+1));
                        g.addEdge(x,y);
                    }
                    if (in[i-1].charAt(j)!='#'){
                        x = hash1.get(i+","+j);
                        y = hash1.get((i-1)+","+j);
                        g.addEdge(x,y);
                    }
                    if (in[i+1].charAt(j)!='#'){
                        x = hash1.get(i+","+j);
                        y = hash1.get((i+1)+","+j);
                        g.addEdge(x,y);
                    }
                }
            }
        }
    }
    void findPath() {
        boolean visited[] = new boolean[g.num_nodes];
        for (int i = 0; i < g.num_nodes; i++)
            visited[i] = false;
        visited[start_node] = true;
        Stack<Integer> s = new Stack<Integer>();
        s.push(start_node);

        int pom;

        while (!s.isEmpty() && s.peek()!=end_node) {
            pom = s.peek();
            int pom1 = pom;
            for (int i = 0; i < g.num_nodes; i++) {
                if(g.adjacent(pom,i)==1){
                    pom1 = i;
                    if(!visited[i])
                        break;
                }
            }
            if(!visited[pom1]){
                visited[pom1] = true;
                //System.out.println(pom1 + ": " + nodes[pom1]);
                s.push(pom1);
            }
            else
                s.pop();
        }
        if(s.isEmpty())
            System.out.println("Nema reshenie");
        else{
            Stack<Integer> os = new Stack<Integer>();
            while(!s.isEmpty())
                os.push(s.pop());
            while(!os.isEmpty())
                System.out.println(hash1.get(os.pop()));
        }
    }

    @Override
    public String toString() {
        return g.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lavirint lavirint = new Lavirint();
        String line = scanner.nextLine();
        String parts[] = line.split(",");

        int rows = Integer.parseInt(parts[0]);
        int columns = Integer.parseInt(parts[1]);

        String input[] = new String[rows];
        for (int i=0;i<rows;i++){
            input[i] = scanner.nextLine();
        }
        lavirint.generateGraph(rows,columns,input);
        lavirint.findPath();
    }
}
