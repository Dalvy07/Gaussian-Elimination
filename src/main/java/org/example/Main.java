package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File inFile = new File("InputGaussElimination.txt");
        double[][] inputGauss = getInputFromFile(inFile);
        for (double[] number :
                inputGauss) {
            System.out.println(Arrays.toString(number));
        }
    }

    static double[][] getInputFromFile(File inputFile) {
        List<double[]> matrix = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] numbersString = line.split("\\s+");
                double[] row = new double[numbersString.length];

                for (int i = 0; i < numbersString.length; i++) {
                    try {
                        row[i] = Double.parseDouble(numbersString[i]);
                    } catch (NumberFormatException e) {
                        System.err.println("Type converting error" + e.getMessage());
                    }
                }
                matrix.add(row);
            }
        } catch (IOException e) {
            System.err.println("Error with opening file: " + e.getMessage());
        }
        return matrix.toArray(new double[matrix.size()][]);
    }
}