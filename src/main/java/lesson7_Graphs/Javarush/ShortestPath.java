package lesson7_Graphs.Javarush;

import java.util.*;

public class ShortestPath {


    // Смежные вершины
    private Map<String, String[]> getGraph() {
        Map<String, String[]> map = new HashMap<>();
        map.put("you", new String[]{"alice", "bob", "clarie"});
        map.put("bob", new String[]{"anuj", "peggy"});
        map.put("alice", new String[]{"peggy"});
        map.put("claire", new String[]{"thom", "jonny"});
        map.put("annuj", null);
        map.put("peggy", null);
        map.put("thom", null);
        map.put("johny", null);
        return map;
    }

    // поиск

    private String search() {
        Map<String, String[]> graph = getGraph();
        Set<String> searched = new HashSet<>();
        Deque<String> searchQue = new ArrayDeque<>();
        searchQue.add("you");

        while (!searchQue.isEmpty()) {
            String person = searchQue.pollFirst();
            System.out.println(person);

            if (personIsSeller(person)) {
                return person;
            } else {
                String[] friends = graph.get(person);
                if (friends == null) continue;
                for (String friend : friends) {
                    if (friend != null && !searched.contains(friend)) {
                        searchQue.addLast(friend);
                    }
                }
            }
        }
        return null;
    }

    private boolean personIsSeller(String person) {
        return false;
    }

    public Integer[][] getGraphMatrix(int size) {
        Integer[][] matrix = new Integer[size][size];

        return matrix;
    }

    public void dexterAlgorithm() {
        Integer[][] graph = getGraphMatrix(5); // данные графа
        Integer[] costs = new Integer[graph.length];// стоимость перехода
        Integer[] parents = new Integer[graph.length];// родительский узел
        BitSet visited = new BitSet(graph.length);

        Integer w = 0;

        do {
            System.out.println("-> Рассматриваем вершину: " + w);
            Integer min = null;
            for (int i = 0; i < graph.length; i++) {//обрабатываем каждую дугу
                if (graph[w][i] == null) continue;// дуги нет
                if (min == null || (!visited.get(i) && graph[w][min] > graph[w][i])) {
                    min = i;
                }
                if (costs[i] == null || costs[i] > costs[w] + graph[w][i]) {
                    System.out.println("Меняем вес с " + costs[i]);
                     costs[i] = (costs[w] != null ? costs[w] : 0) + graph[w][i];
                    System.out.println(" на " + costs[i] + " для вершины " + i);
                    parents[i] = w;
                }
            }
            System.out.println("Вершина с минимальным весом: " + min);
            visited.set(w);
            w = min;
        } while (w != null);

        System.out.println(Arrays.toString(costs));
        printPath(parents, 3);
    }

    private void printPath(Integer[] parents, int target) {
        Integer parent = target;
        do {
            System.out.println(parent + "<-");
            parent = parents[parent];
        } while (parent != null);
    }

}
