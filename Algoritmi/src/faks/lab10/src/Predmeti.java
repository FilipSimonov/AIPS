import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Predmeti{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String[] predmeti=new String[n];
        for(int i=0;i<n;i++){
            predmeti[i]=input.nextLine();
        }
        Graph<String>graf=new Graph<>(n,predmeti);
        int m = Integer.parseInt(input.nextLine());
        for(int i=0;i<m;i++){
            String linija = input.nextLine();
            String del[] = linija.split(" ");
            for(int j=1;j<del.length;j++){
                graf.addEdge(graf.getNodeIndex(del[j]),graf.getNodeIndex(del[0]));
            }
        }
        String s = input.nextLine();
        System.out.print(graf.getNodeInfo(graf.topological_sort_dfs(s)));
    }
}
class Graph<E> {
    int num_nodes;
    GraphNode<E> adjList[];
    int getNodeIndex(E info){
        for(GraphNode node: adjList){
            if(node.getInfo().equals(info)) return node.getIndex();
        }
        return -1;
    }
    String getNodeInfo(int i){
        for(GraphNode node: adjList){
            if(node.getIndex()==i) return (String) node.getInfo();
        }
        return null;
    }
    @SuppressWarnings("unchecked")
    public Graph(int num_nodes, E[] list) {
        this.num_nodes = num_nodes;
        adjList = (GraphNode<E>[]) new GraphNode[num_nodes];
        for (int i=0;i<num_nodes;i++)
            adjList[i] = new GraphNode<E>(i, list[i]);
    }
    @SuppressWarnings("unchecked")
    public Graph(int num_nodes) {
        this.num_nodes = num_nodes;
        adjList = (GraphNode<E>[]) new GraphNode[num_nodes];
        for (int i=0;i<num_nodes;i++)
            adjList[i] = new GraphNode<E>(i,null);
    }
    int adjacent(int x, int y) {
        return (adjList[x].containsNeighbor(adjList[y])) ? 1 : 0;
    }
    void addEdge(int x, int y) {
        if (!adjList[x].containsNeighbor(adjList[y])) {
            adjList[x].addNeighbor(adjList[y]);
        }
    }
    void deleteEdge(int x, int y) {
        adjList[x].removeNeighbor(adjList[y]);
    }
    void dfsVisit(Stack<Integer> s, int i, boolean[] visited){
        if(!visited[i]){
            visited[i]=true;
            Iterator<GraphNode<E>>it=adjList[i].getNeighbors().iterator();
            while(it.hasNext()){
                dfsVisit(s, it.next().getIndex(), visited);
            }
            s.push(i);
        }
    }
    int topological_sort_dfs(E res){
        boolean visited[] = new boolean[num_nodes];
        for(int i=0;i<num_nodes;i++){
            visited[i] = false;
        }
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0;i<num_nodes;i++){
            dfsVisit(s,i,visited);
        }
        while(!s.pop().equals(getNodeIndex(res))){
        }
        return s.peek();
    }
    @Override
    public String toString() {
        String ret = new String();
        for (int i=0;i<this.num_nodes;i++)
            ret += i + ": " + adjList[i] + "\n";
        return ret;
    }
}
class GraphNode<E> {
    private int index;
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
        this.index=index;
    }
    public E getInfo() {
        return info;
    }
    public void setInfo(E info) {
        this.info=info;
    }
    public LinkedList<GraphNode<E>> getNeighbors() {
        return neighbors;
    }
    public void setNeighbors(LinkedList<GraphNode<E>> neighbors) {
        this.neighbors=neighbors;
    }
}