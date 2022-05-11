//package lesson7_Graphs;
//
//import java.util.*;
//
//public class GraphImpl implements Graph {
//
//    // список для хранения вершин
//    private final List<Vertex> vertexList;
//
//    // матрица смежности (связей)
//    private final boolean[][] adjMatrix;
//
//    // матрица смежности(связей)
//    private final Integer[][] weightAdjMatrix;
//
//    public GraphImpl(int maxVertexCount) {
//        this.vertexList = new ArrayList<>(maxVertexCount);
//        adjMatrix = new boolean[maxVertexCount][maxVertexCount];
//        weightAdjMatrix = new Integer[maxVertexCount][maxVertexCount];
//
//    }
//
//    // метод добавления вершины
//    @Override
//    public void addVertex(String label) {
//        vertexList.add(new Vertex(label));
//    }
//
//    // метод добавления ребра
////    @Override
////    public boolean addEdge(String startLabel, String secondLabel, String... others) {
////        boolean result = addEdge(startLabel, secondLabel);
////
////        // проходимя по все вершинам и поочереднно делаем ребра
////        for (String other : others) {
////            result &= addEdge(startLabel, other);
////        }
////        return result;
////    }
//
//    // метод добавления ребра
//    @Override
//    public boolean addEdge(String startLabel, String secondLabel, Integer weight) {
//        // найти индекс вершин в листе и по этим индексам проставить в матрицу либо true(если есть ребро), либо false (если нет ребра). Если же будут веса, то нужно указывать веса.
//        int startIndex = indexOf(startLabel);// первая точка вершины
//        int endIndex = indexOf(secondLabel);// вторая точка вершины
//
//        // проверка на существование таких узлов
//        if (startIndex == -1 || endIndex == -1) {
//            return false;
//        }
//
//        // проставляем связи
//        adjMatrix[startIndex][endIndex] = true;// здесь должен быть вес ребра
////        adjMatrix[endIndex][startIndex] = true; // связь во вторую сторону
//
//        return true;
//    }
//
//    // метод поиска индекса вершины в массиве
//    private int indexOf(String label) {
//        for (int i = 0; i < vertexList.size(); i++) {
//            if (vertexList.get(i).getLabel().equals(label)) { // пробегаемся по каждой вершине и сравниваем ее с искомой.
//                return i;
//            }
//        }
//        return -1;// если такой вершины не нашли
//    }
//
//    @Override
//    public int getSize() {
//        return vertexList.size();
//    }
//
//    @Override
//    public void display() {
//        System.out.println(this);// вызывается метод toString()
//    }
//
//    @Override
//    public String toString() {
//        // пробегаемя по каждому из узлов и просто вывести с кем узел будет связываться
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < getSize(); i++) {
//            sb.append(vertexList.get(i));
//            for (int j = 0; j < getSize(); j++) {
//                if (adjMatrix[i][j]) {
//                    sb.append(" -> ").append(vertexList.get(j));
//                }
//            }
//            sb.append("\n");// перенос строки
//        }
//        return sb.toString();
//    }
//
//    // обход в глубину
//    @Override
//    public void dfs(String startLabel) {
//        int startIndex = indexOf(startLabel);
//
//        if (startIndex == -1) {
//            throw new IllegalArgumentException("Неверная вершина " + startLabel);
//        }
//
//        Stack<Vertex> stack = new Stack<>();
//        Vertex vertex = vertexList.get(startIndex);
//
//        //метод посещения каждого из узлов
//        visitVertex(stack, vertex);
//
//        while (!stack.isEmpty()) {
//            vertex = getNearUnvisitedVertex(stack.peek());
//            if (vertex == null) {
//                stack.pop();
//            } else {
//                visitVertex(stack, vertex);
//            }
//        }
//    }
//
//    private Vertex getNearUnvisitedVertex(Vertex vertex) {
//        int currentIndex = vertexList.indexOf(vertex);
//
//        for (int i = 0; i < getSize(); i++) {
//            if (adjMatrix[currentIndex][i] && !vertexList.get(i).isVisited()) {
//                return vertexList.get(i);
//            }
//        }
//
//        return null;
//    }
//
//    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
//        System.out.print(vertex.getLabel() + " ");
//        stack.push(vertex);
//        vertex.setVisited(true);
//    }
//
//    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
//        System.out.print(vertex.getLabel() + " ");
//        queue.add(vertex);
//        vertex.setVisited(true);
//    }
//
//    // Обход в ширину
//    @Override
//    public void bfs(String startLabel) {
//        int startIndex = indexOf(startLabel);
//
//        if (startIndex == -1) {
//            throw new IllegalArgumentException("Неверная вершина " + startLabel);
//        }
//
//        Queue<Vertex> queue = new LinkedList<>();
//        Vertex vertex = vertexList.get(startIndex);
//
//        visitVertex(queue, vertex);
//        while (!queue.isEmpty()) {
//            vertex = getNearUnvisitedVertex(queue.peek());
//            if (vertex == null) {
//                queue.remove();
//            } else {
//                visitVertex(queue, vertex);
//            }
//        }
//
//    }
//
//    @Override
//    public boolean addWeightConnection(String label1, String label2, int kilometers) {
//        weightAdjMatrix[indexOf(label1)][indexOf(label2)] = kilometers;
//        return true;
//    }
//
//    public Integer[][] getWeightAdjMatrix() {
//        return weightAdjMatrix;
//    }
//
//    @Override
//    public void dijkstra() {
//        Integer[][] graph = getWeightAdjMatrix();           // Данные графа
//        Integer[] costs = new Integer[graph.length];    // Стоимость перехода
//        Integer[] parents = new Integer[graph.length];  // Родительский узел
//        BitSet visited = new BitSet(graph.length);      // "Ферма" маркеров посещённости
//
//        Integer w = 0;
//        do {
//            System.out.println("-> Рассматриваем вершину: " + w);
//            Integer min = null;
//            for (int i = 0; i < graph.length; i++) {    // Обрабатываем каждую дугу
//                if (graph[w][i] == null) continue;      // Дуги нет - идём дальше
//                if (min == null || (!visited.get(i) && graph[w][min] > graph[w][i])) {
//                    min = i;
//                }
//                if (costs[i] == null || costs[i] > costs[w] + graph[w][i]) {
//                    System.out.print("Меням вес с " + costs[i]);
//                    costs[i] = (costs[w] != null ? costs[w] : 0) + graph[w][i];
//                    System.out.println(" на " + costs[i] + " для вершины " + i);
//                    parents[i] = w;
//                }
//            }
//            System.out.println("Вершина с минимальным весом: " + min);
//            visited.set(w);
//            w = min;
//        } while (w != null);
//
//        System.out.println(Arrays.toString(costs));
//        printPath(parents, 3);
//    }
//
//    public void printPath(Integer[] parents, int target) {
//        Integer parent = target;
//        do {
//            System.out.print(parent + " <- ");
//            parent = parents[parent];
//        } while (parent != null);
//    }
//
//
//}
