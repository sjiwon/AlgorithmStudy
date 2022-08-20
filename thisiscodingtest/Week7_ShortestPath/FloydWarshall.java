package thisiscodingtest.Week7_ShortestPath;

public class FloydWarshall {

    static final int MAX_DISTANCE = 987654321;
    static int[][] basicFloydWarshallMatrix;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 3; i++) {
            basicFloydWarshallMatrix = ShortestPathBasicGraph.getBasicFloydWarshallMatrix(i);
            matrixInitialization();
            simulateFloydWarshallAlgorithm(basicFloydWarshallMatrix);
        }
    }

    static void simulateFloydWarshallAlgorithm(int[][] basicFloydWarshallMatrix) {
        for (int k = 0; k < basicFloydWarshallMatrix.length; k++) {
            for (int i = 0; i < basicFloydWarshallMatrix.length; i++) {
                for (int j = 0; j < basicFloydWarshallMatrix.length; j++) {
                    if (basicFloydWarshallMatrix[i][j] > basicFloydWarshallMatrix[i][k] + basicFloydWarshallMatrix[k][j] && i != j) {
                        basicFloydWarshallMatrix[i][j] = basicFloydWarshallMatrix[i][k] + basicFloydWarshallMatrix[k][j];
                    }
                }
            }
        }

        printMatrix("FloydWarshall Algorithm 적용 후");
        printResult();
    }

    static void matrixInitialization() {
        // Matrix Initialization
        for (int i = 0; i < basicFloydWarshallMatrix.length; i++) {
            for (int j = 0; j < basicFloydWarshallMatrix[i].length; j++) {
                if (basicFloydWarshallMatrix[i][j] == 0) {
                    basicFloydWarshallMatrix[i][j] = MAX_DISTANCE;
                }
            }
        }
    }

    static void printMatrix(String title) {
        System.out.println("[" + title + "]");

        for (int i = 0; i < basicFloydWarshallMatrix.length; i++) {
            for (int j = 0; j < basicFloydWarshallMatrix[i].length; j++) {
                if (basicFloydWarshallMatrix[i][j] == MAX_DISTANCE) {
                    System.out.print("0\t");
                } else {
                    System.out.print(basicFloydWarshallMatrix[i][j] + "\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static void printResult() {
        for (int i = 0; i < basicFloydWarshallMatrix.length; i++) {
            System.out.println(">>>> " + i + " ~> [other] <<<<");
            for (int j = 0; j < basicFloydWarshallMatrix.length; j++) {
                if (i != j) {
                    if (basicFloydWarshallMatrix[i][j] == MAX_DISTANCE) {
                        System.out.println(i + " -> " + j + " = INFINITY..");
                    } else {
                        System.out.println(i + " -> " + j + " = " + basicFloydWarshallMatrix[i][j]);
                    }
                }
            }
            System.out.println();
        }
    }
}
