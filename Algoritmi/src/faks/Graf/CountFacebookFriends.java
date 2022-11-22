package faks.Graf;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

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

    boolean adjacent(int x, int y) {
        // proveruva dali ima vrska od jazelot so
        // indeks x do jazelot so indeks y
        return adjList[x].containsNeighbor(adjList[y]);
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



    void bfs(int from,int to){
        boolean visited[] = new boolean[num_nodes];
        for (int i = 0; i < num_nodes; i++)
            visited[i] = false;
        visited[from] = true;
//        System.out.println(node+": " + adjList[node].getInfo());
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(from);

        GraphNode<E> pom;
        int distance = 0;
        int parent = from;

        while(!q.isEmpty()){
            pom = adjList[q.poll()];
            if (pom.getIndex() == to)
                break;
            if (q.peek()==null || !this.adjacent(q.peek(),parent)){
                distance++;
                parent = pom.getIndex();
            }

            GraphNode<E> tmp = null;
            for (int i = 0; i < pom.getNeighbors().size(); i++) {
                tmp = pom.getNeighbors().get(i);
                if (!visited[tmp.getIndex()]){
                    visited[tmp.getIndex()] = true;
//                    System.out.println(tmp.getIndex()+": " + tmp.getInfo());
                    q.add(tmp.getIndex());
                }
            }


        }

        System.out.println(distance);
    }


    @Override
    public String toString() {
        String ret = new String();
        for (int i = 0; i < this.num_nodes; i++)
            ret += i + ": " + adjList[i] + "\n";
        return ret;
    }

}

public class CountFacebookFriends {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int NoUsers = Integer.parseInt(br.readLine());
        Integer []info = new Integer[NoUsers];

        for (int i=0;i<NoUsers;i++){
            info[i] = i;
        }
        Graph<Integer> users = new Graph<>(NoUsers,info);

        for (int i=0;i<NoUsers;i++){
            int NoFriends = Integer.parseInt(br.readLine());
            for (int j=0;i<NoFriends;j++){
                int y = Integer.parseInt(br.readLine().split(" ")[0]);
                users.addEdge(i,y);
            }
        }
        int from = Integer.parseInt(br.readLine());
        int to = Integer.parseInt(br.readLine());

        users.bfs(from,to);
    }
}
