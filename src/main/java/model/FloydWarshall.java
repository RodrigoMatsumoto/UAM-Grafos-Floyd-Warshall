package model;

import java.lang.*;

public class FloydWarshall {
    final static double INF = Double.MAX_VALUE;
    private double[][] graph;
    private int vertexAmount;


    public FloydWarshall(double graph[][], int vertexAmount) {
        this.graph = graph;
        this.vertexAmount = vertexAmount;
    }

    public void floydWarshall() {
        double dist[][] = new double[this.vertexAmount][this.vertexAmount];
        int i, j, k;

        initializeMatrix(graph);

        for (i = 0; i < this.vertexAmount; i++)
            for (j = 0; j < this.vertexAmount; j++)
                dist[i][j] = graph[i][j];

        for (k = 0; k < this.vertexAmount; k++) {
            for (i = 0; i < this.vertexAmount; i++) {
                for (j = 0; j < this.vertexAmount; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        printResolution(dist);
    }

    void initializeMatrix(double matrix[][]) {
        for(int i = 0; i < matrix.length; i++) {
           for(int j = 0; j < matrix[i].length; j++) {
               if (i == j) {
                   matrix[i][j] = 0;
               } else if (matrix[i][j] == 0 ) {
                   matrix[i][j] = INF;
               }
           }
        }
    }

    void printResolution(double dist[][]) {
        System.out.println("Matrix by Floyd Warshall");
        for (int i = 0; i < dist.length; ++i) {
            for (int j = 0; j < dist[i].length; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}