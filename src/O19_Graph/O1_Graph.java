package O19_Graph;

import java.util.*;

public class O1_Graph {
    private class Vertex{
        HashMap<String, Integer> nbrs = new HashMap<>();
    }

    HashMap<String, Vertex> vrtcs = new HashMap<>();

    public int numVertex(){
        return vrtcs.size();
    }

    public boolean containsVertex(String vname){
        return vrtcs.containsKey(vname);
    }

    public void addVertex(String vname){
        Vertex vtx = new Vertex();
        vrtcs.put(vname, vtx);
    }

    public void removeVertex(String vname){
        //invalid key provided which is not in graph
        if(!vrtcs.containsKey(vname)){
            return;
        }

        Vertex vtx = vrtcs.get(vname);
        ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
        for(String key: keys){
            Vertex nbrVtx = vrtcs.get(key);
            nbrVtx.nbrs.remove(vname);
        }
        vrtcs.remove(vname);
    }

    public int numEdges(){
        ArrayList<String> keys = new ArrayList<>(vrtcs.keySet());
        int num = 0;
        for(String key: keys){
            num += vrtcs.get(key).nbrs.size();
        }
        return num / 2;
    }

    public boolean containsEdge(String vname1, String vname2){
        Vertex vtx1 = vrtcs.get(vname1);
        Vertex vtx2 = vrtcs.get(vname2);

        if(vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) return false;
        return (vrtcs.get(vname1).nbrs.containsKey(vname2) && vrtcs.get(vname2).nbrs.containsKey(vname1));
    }

    public void addEdge(String vname1, String vname2, int val){
        Vertex vtx1 = vrtcs.get(vname1);
        Vertex vtx2 = vrtcs.get(vname2);
        //either vertex not exist or edge between vertices already exist
        if(vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)){
            return;
        }
        vtx1.nbrs.put(vname2, val);
        vtx2.nbrs.put(vname1, val);
    }

    public void removeEdge(String vname1, String vname2){
        Vertex vtx1 = vrtcs.get(vname1);
        Vertex vtx2 = vrtcs.get(vname2);
        //either vertex not exist or edge between vertices not exist
        if(vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)){
            return;
        }
        vtx1.nbrs.remove(vname2);
        vtx2.nbrs.remove(vname1);
    }

    public void display(){
        ArrayList<String> keys = new ArrayList<>(vrtcs.keySet());
        for(String key: keys){
            Vertex vtx = vrtcs.get(key);
            System.out.println(key + " : " +vtx.nbrs);
        }
        System.out.println("------------");
    }
    public static void main(String[] args){
        O1_Graph graph = new O1_Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A", "B", 2);
        graph.addEdge("A", "D", 3);
        graph.addEdge("B", "C", 1);
        graph.addEdge("C", "D", 8);
        graph.addEdge("D", "E", 10);
        graph.addEdge("E", "F", 45);
        graph.addEdge("E", "G", 7);
        graph.addEdge("F", "G", 8);
        
        graph.display();

        System.out.println(graph.numVertex());
        System.err.println(graph.numEdges());

        System.out.println("--------------");

        System.out.println(graph.containsEdge("A", "C"));
        System.out.println(graph.containsEdge("E", "F"));

        System.out.println("--------------");

        graph.removeEdge("A", "B");
        graph.display();

        graph.removeVertex("F");
        graph.display();

        graph.addVertex("F");
        graph.display();

        graph.addEdge("A", "F", 10);
        graph.display();

    }
}



