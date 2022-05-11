//package lesson7_Graphs;
//
//public class Main {
//
//    public static void main(String[] args) {
////        testGraph();
////        testDfs();
////        testBfs();
////        System.out.println();
//
//
//        Graph graph = new GraphImpl(10);
//        graph.addVertex("Москва");
//
//        graph.addVertex("Тула");
//        graph.addVertex("Рязань");
//        graph.addVertex("Калуга");
//
//        graph.addVertex("Липецк");
//        graph.addVertex("Тамбов");
//        graph.addVertex("Орел");
//
//        graph.addVertex("Саратов");
//        graph.addVertex("Курск");
//
//        graph.addVertex("Воронеж");
//
//
//        Integer MoscowTula = 182;
//        Integer MoscowRyazan = 199;
//        Integer MoscowKaluga = 197;
//
//        Integer TulaLipeck = 294;
//        Integer RyazanTambov = 290;
//        Integer KalygaOrel = 210;
//
//        Integer LipeckVoronesh = 123;
//        Integer TambovSaratov = 384;
//        Integer OrelKursk = 161;
//
//        Integer SaratovVoronesh = 515;
//        Integer KurskVoronesh = 222;
//
//
//
//        graph.addEdge("Москва", "Тула", MoscowTula);
//        graph.addEdge("Москва", "Рязань",MoscowRyazan);
//        graph.addEdge("Москва", "Калуга",MoscowKaluga);
//
//
//        graph.addEdge("Тула", "Липецк", TulaLipeck);
//        graph.addEdge("Рязань", "Тамбов", RyazanTambov);
//        graph.addEdge("Калуга", "Орел", KalygaOrel);
//
//        graph.addEdge("Липецк", "Воронеж", LipeckVoronesh);
//        graph.addEdge("Тамбов", "Саратов", TambovSaratov);
//        graph.addEdge("Орел", "Курск", OrelKursk);
//
//        graph.addEdge("Саратов", "Воронеж", SaratovVoronesh);
//        graph.addEdge("Курск", "Воронеж", KurskVoronesh);
//
//        graph.addWeightConnection("Москва", "Тула",MoscowTula);
//        graph.addWeightConnection("Москва", "Рязань",MoscowRyazan);
//        graph.addWeightConnection("Москва", "Калуга",MoscowKaluga);
//
//        graph.addWeightConnection("Тула", "Липецк",TulaLipeck);
//        graph.addWeightConnection("Рязань", "Тамбов",RyazanTambov);
//        graph.addWeightConnection("Калуга", "Орел",KalygaOrel);
//
//        graph.addWeightConnection("Липецк", "Воронеж", LipeckVoronesh);
//        graph.addWeightConnection("Тамбов", "Саратов", TambovSaratov);
//        graph.addWeightConnection("Орел", "Курск", OrelKursk);
//
//        graph.addWeightConnection("Саратов", "Воронеж", SaratovVoronesh);
//        graph.addWeightConnection("Курск", "Воронеж", KurskVoronesh);
//
//
//
//        graph.bfs("Москва");
//
//        graph.dijkstra();
//
//
//    }
//
////    private static void testGraph() {
////        Graph graph = new GraphImpl(7);
////
////        graph.addVertex("A");
////        graph.addVertex("B");
////        graph.addVertex("C");
////        graph.addVertex("D");
////
////        graph.addEdge("A", "B", "C");
////        graph.addEdge("B", "C", "D");
////        graph.addEdge("C", "A", "B","D");
////        graph.addEdge("D", "B", "C");
////
////        System.out.println("Size of graph is " + graph.getSize());
////        graph.display();
////    }
////
////    private static void testDfs() {
////        Graph graph = new GraphImpl(7);
////
////        graph.addVertex("A");
////        graph.addVertex("B");
////        graph.addVertex("C");
////        graph.addVertex("D");
////        graph.addVertex("E");
////        graph.addVertex("F");
////        graph.addVertex( "G");
////
////        graph.addEdge("A", "B", "C", "D");
////        graph.addEdge("B", "E");
////        graph.addEdge("D", "F");
////        graph.addEdge("F", "G");
////
////        graph.dfs("A");
////    }
////
////    private static void testBfs() {
////        Graph graph = new GraphImpl(8);
////        graph.addVertex("A");
////        graph.addVertex("B");
////        graph.addVertex("C");
////        graph.addVertex("D");
////        graph.addVertex("E");
////        graph.addVertex("F");
////        graph.addVertex("G");
////        graph.addVertex("H");
////
////        graph.addEdge("A", "B", "C", "D");
////        graph.addEdge("B", "E");
////        graph.addEdge("E", "H");
////        graph.addEdge("C", "F");
////        graph.addEdge("D", "G");
////
////        graph.bfs("A");
////    }
//
//
//}
