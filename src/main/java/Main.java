import model.Graph;
import util.LoadData;
import model.*;

public class Main {
	public static void main(String[] args) {
        double[][] graphMatriz = LoadData.loadAdj("src/main/java/data/data.txt");
//        System.out.println("Matriz:");
//        System.out.println(graphMatriz);

//        Graph lisGraph = LoadData.loadList("src/main/java/data/data.txt");
//        System.out.println("Lista:");
//        System.out.println(lisGraph);


            FloydWarshall arroz = new FloydWarshall();
            arroz.floydWarshall(graphMatriz, 3);


    }
}