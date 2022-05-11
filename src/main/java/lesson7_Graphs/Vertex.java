//package lesson7_Graphs;
//
//import java.util.Objects;
//
//// класс отвечающий за вершины
//public class Vertex {
//
//    // поле которые показывает: проходили ли в поиске мы по этой вершине
//    private boolean isVisited;
//
//    public boolean isVisited() {
//        return isVisited;
//    }
//
//    public void setVisited(boolean visited) {
//        isVisited = visited;
//    }
//
//    private final String label;// название вершины
//
//    public Vertex(String label) {
//        this.label = label;
//    }
//
//    // метод для сравнения двух вершин
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        Vertex vertex = (Vertex) o;
//        return Objects.equals(label, vertex.label);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(label);
//    }
//
//    @Override
//    public String toString() {
//        return "Vertex{" +
//                "label='" + label + '\'' +
//                '}';
//    }
//
//    public String getLabel() {
//        return label;
//    }
//}
