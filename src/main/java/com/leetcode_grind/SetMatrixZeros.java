package com.leetcode_grind;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetMatrixZeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                matrix[i][j] = sc.nextInt();

        sc.close();

        setZeros(matrix);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void setZeros(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }

        for (int k : rows)
            makeRowsValueToZero(matrix, k, m);

        for (int k : columns)
            makeColumnsValueToZero(matrix, k, n);
    }

    private static void makeRowsValueToZero(int[][] matrix, int k, int m) {
        for (int i = 0; i < m; i++)
            matrix[k][i] = 0;
    }

    private static void makeColumnsValueToZero(int[][] matrix, int k, int n) {
        for (int i = 0; i < n; i++)
            matrix[i][k] = 0;
    }
}
