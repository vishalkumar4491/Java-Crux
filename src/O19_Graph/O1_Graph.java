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

    public boolean hasPath(String vname1, String vname2, HashMap<String, Boolean> isVisited ){
        //direct edge
        if(containsEdge(vname1, vname2)){
            return true;
        }

        isVisited.put(vname1, true);

        Vertex vtx = vrtcs.get(vname1);
        ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

        for(String key: keys){
            if(!isVisited.containsKey(key) && hasPath(key, vname2, isVisited)){
                return true;
            }
        }

        return false;
    }

    public void BFS(String vname, HashMap<String, Boolean> isVisited){
        Deque<String> dq = new ArrayDeque<>();
        dq.add(vname);
        isVisited.put(vname, true);
        while(dq.size() > 0){
            String x = dq.removeFirst();
            Vertex vtx = vrtcs.get(x);
            System.out.print(x + " ");
            ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
            for(String key: keys){
                if(!isVisited.containsKey(key)){
                    isVisited.put(key, true);
                    dq.add(key);
                }
            }
        }
    }

    //same code as bfs just by adding first instead of add last we make bfs to dfs
    public void DFS(String vname, HashMap<String, Boolean> isVisited){
        Deque<String> dq = new ArrayDeque<>();
        dq.add(vname);
        isVisited.put(vname, true);
        while(dq.size() > 0){
            String x = dq.removeFirst();
            Vertex vtx = vrtcs.get(x);
            System.out.print(x + " ");
            ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
            for(String key: keys){
                if(!isVisited.containsKey(key)){
                    isVisited.put(key, true);
                    dq.addFirst(key);
                }
            }
        }
    }

    public boolean isCyclic(String vname, HashMap<String, Boolean> isVisited, HashMap<String, Boolean> isAlreadyPresent){
        Deque<String> dq = new ArrayDeque<>();
        dq.add(vname);
        while(dq.size() > 0){
            String x = dq.remove();
            isVisited.put(x, true);
            Vertex vtx = vrtcs.get(x);
            ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
            for(String key: keys){
                if(!isVisited.containsKey(key)){
                    if(isAlreadyPresent.containsKey(key)) return true;
                    isAlreadyPresent.put(key, true);
                    dq.add(key);
                }
            }
        }
        return false;
    }

    public boolean isConnected(String vname, HashMap<String, Boolean> isVisited){
        ArrayList<String> keys = new ArrayList<>(vrtcs.keySet());
        Deque<String> dq = new ArrayDeque<>();
        int count = 0;
        for(String key: keys){
            if(isVisited.containsKey(key)){
                continue;
            }
            count += 1;
            dq.add(key);
            while(dq.size() > 0){
                String x = dq.removeFirst();
                isVisited.put(x, true);
                Vertex vtx = vrtcs.get(x);
                ArrayList<String> nbr = new ArrayList<>(vtx.nbrs.keySet());
                for(String nb: nbr){
                    if(!isVisited.containsKey(nb)){
                        dq.add(nb);
                    }
                }
            }
        }
        if(count >=2) return false;
        return true;
    }

    public boolean isTree(String vname){
        if(isConnected(vname, new HashMap<>()) && !isCyclic(vname, new HashMap<>(), new HashMap<>())){
            return true;
        }
        return false;
    }

    public ArrayList<ArrayList<String>> getComponents(String vname, HashMap<String, Boolean> isVisited){
        ArrayList<String> keys = new ArrayList<>(vrtcs.keySet());
        Deque<String> dq = new ArrayDeque<>();
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for(String key: keys){
            if(isVisited.containsKey(key)){
                continue;
            }
            ArrayList<String> all = new ArrayList<>();
            
            dq.add(key);
            all.add(key);
            while(dq.size() > 0){
                String x = dq.removeFirst();
                
                isVisited.put(x, true);
                Vertex vtx = vrtcs.get(x);
                ArrayList<String> nbr = new ArrayList<>(vtx.nbrs.keySet());
                for(String nb: nbr){
                    if(!isVisited.containsKey(nb)){
                        dq.addFirst(nb);
                        all.add(nb);
                        isVisited.put(nb, true);

                    }
                }
            }
            ans.add(all);
        }
        return ans;
        
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
        
        // graph.display();

        // System.out.println(graph.numVertex());
        // System.err.println(graph.numEdges());

        // System.out.println("--------------");

        // System.out.println(graph.containsEdge("A", "C"));
        // System.out.println(graph.containsEdge("E", "F"));

        // System.out.println("--------------");

        //graph.removeEdge("D", "E");
        // graph.display();

        // graph.removeVertex("F");
        // graph.display();

        // graph.addVertex("F");
        // graph.display();

        // graph.addEdge("A", "F", 10);
        // graph.display();

        //System.out.println(graph.hasPath("A", "F", new HashMap<>()));

        // graph.BFS("A", new HashMap<>());

        // System.out.println("----------------");
        // graph.DFS("A", new HashMap<>());

        // graph.removeEdge("B", "C");
          graph.removeEdge("D", "E");

        // System.out.println(graph.isCyclic("A", new HashMap<>(), new HashMap<>()));

        //System.out.println(graph.isConnected("A", new HashMap<>()));

        // System.out.println(graph.isTree("A"));

        System.out.println(graph.getComponents("A", new HashMap<>()));

    }
}



