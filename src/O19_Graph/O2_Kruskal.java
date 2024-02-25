package O19_Graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;


public class O2_Kruskal {

    private class Vertex{
        HashMap<String, Integer> nbrs = new HashMap<>();
    }

    HashMap<String, Vertex> vrtcs = new HashMap<>();

    public void addVertex(String vname){
        Vertex vtx = new Vertex();
        vrtcs.put(vname, vtx);
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

    // Disjoint set means 2 sets never have same value common
    public class DisjointSet{
        // for storing the address to corresponding value
        HashMap<String, Node> map = new HashMap<>();

        private class Node{
            String data;
            Node parent;
            int rank;
        }

        // creating set or node 
        public void create(String value){
            // nn= new Node
            Node nn = new Node();
            nn.data = value;
            nn.parent = nn;
            nn.rank = 0;

            // for finding address corresponding string
            // so that we can use it in find method i.e.
            // we given any string we need to find its parent for that we need address
            // so that we move till parent become parent of itself.
            map.put(value, nn);
        }

        // return the representative elemnt of given value
        // i.e. return those value when parent become parent of itself
        public String find(String value){
            // map.get(value) will give Node i.e. address
            return findHelper(map.get(value)).data;
        }

        // this is used to find the parent of any element
        // i.e. return those value when parent become parent of itself
        private Node findHelper(Node node){
            if(node == node.parent){
                return node;
            }
            // recursion result
            Node rr = findHelper(node.parent);
            node.parent = rr; // path compression
            return rr;
        }

        // it will return the union set of both values 
        public void union(String value1, String value2){
            Node n1 = map.get(value1);
            Node n2 = map.get(value2);

            // representative elements for both nodes
            Node re1 = findHelper(n1);
            Node re2 = findHelper(n2);

            // if both have same parent (same representative element) then that means
            // there is cycle we simply return from there.
            if(re1.data.equals(re2.data)){
                return;
            }else{
                // if both have same rank then make parent of second to first
                // and also icrease the rank for first because its rank will increase
                if(re1.rank == re2.rank){
                    re2.parent = re1;
                    re1.rank += 1;
                }else if(re1.rank > re2.rank){
                    re2.parent = re1;
                }else{
                    re1.parent = re2;
                }
            }
        }
    }

    private class EdgePair implements Comparable<EdgePair>{
        String v1;
        String v2;
        int cost;

        @Override
        public int compareTo(EdgePair o){
            return this.cost - o.cost;
        }

        public String toString(){
            return v1 + "-" + v2 +" : " + cost; 
        }
    }

    public ArrayList<EdgePair> getAllEdges(){
        ArrayList<EdgePair> edges = new ArrayList<>();
        for(String vname: vrtcs.keySet()){
            Vertex vtx = vrtcs.get(vname);
            for(String nbr: vtx.nbrs.keySet()){
                EdgePair ep = new EdgePair();
                ep.v1 = vname;
                ep.v2 = nbr;
                ep.cost = vtx.nbrs.get(nbr);

                edges.add(ep);
            }
        }
        return edges;
    }

    public void kruskal(){
        // sort the edges in increasing order of weight
        ArrayList<EdgePair> edges = getAllEdges();
        Collections.sort(edges);

        DisjointSet set = new DisjointSet();

        // create vrtcs number of sets
        for(String vname: vrtcs.keySet()){
            set.create(vname);
        }

        // traverse over the edges
        for(EdgePair edge: edges){
            String re1 = set.find(edge.v1);
            String re2 = set.find(edge.v2);

            if(re1.equals(re2)){
                continue;
            }else{
                System.out.println(edge);
                set.union(edge.v1, edge.v2);
            }
        }
    }

    public static void main(String[] args){
        O2_Kruskal graph = new O2_Kruskal();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");

        graph.addEdge("A", "B", 2);
        graph.addEdge("A", "D", 3);
        graph.addEdge("B", "C", 1);
        graph.addEdge("C", "D", 8);
        graph.addEdge("D", "E", 10);
        graph.addEdge("E", "F", 45);
        graph.addEdge("E", "G", 7);
        graph.addEdge("F", "G", 8);
        // graph.addEdge("H", "I", 8);
        // graph.addEdge("G", "I", 8);

        graph.kruskal();

    }
}
