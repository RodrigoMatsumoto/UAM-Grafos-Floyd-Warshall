package model;

import model.matriz.GraphMatriz;

import java.io.*;
import java.lang.*;
import java.util.*;

public class FloydWarshall {
    final static double INF = Double.MAX_VALUE;

    public void floydWarshall(double graph[][], int vertexAmount ) {
        double dist[][] = new double[vertexAmount][vertexAmount];
        int i, j, k;

        initializeMatrix(graph);

        for (i = 0; i < vertexAmount; i++)
            for (j = 0; j < vertexAmount; j++)
                dist[i][j] = graph[i][j];

        for (k = 0; k < vertexAmount; k++) {
            for (i = 0; i < vertexAmount; i++) {
                for (j = 0; j < vertexAmount; j++) {
                    if (dist[i][k] + dist[k][j]
                            < dist[i][j])
                        dist[i][j]
                                = dist[i][k] + dist[k][j];
                }
            }
        }

        printSolution(dist);
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

    void printSolution(double dist[][]) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}