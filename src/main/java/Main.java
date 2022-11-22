import model.Graph;
import util.LoadData;
import model.*;

public class Main {
    public static void main(String[] args) {
        Graph graphMatriz = LoadData.loadAdj("src/main/java/data/data.txt");
        System.out.println("Matrix:");
        System.out.println(graphMatriz);

        FloydWarshall floydWarshall = LoadData.loadFloydWarshall("src/main/java/data/data.txt");
        floydWarshall.floydWarshall();
    }
}