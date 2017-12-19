package MultiplicacaoMatriz;

import jomp.runtime.OMP;

public class MultiplicacaoMatriz {

    public static void main(String[] args) {
        int matriz[][] = new int[4][4];
        int matrizResult[][] = new int[4][4];
        matriz[0][0] = 55;
        matriz[0][1] = 15;
        matriz[0][2] = 546;
        matriz[0][3] = 56;
        matriz[1][0] = 54;
        matriz[1][1] = 13;
        matriz[1][2] = 23;
        matriz[1][3] = 10;
        matriz[2][0] = 49;
        matriz[2][1] = 57;
        matriz[2][2] = 102;
        matriz[2][3] = 25;
        matriz[3][0] = 23;
        matriz[3][1] = 45;
        matriz[3][2] = 24;
        matriz[3][3] = 15;

        System.out.println("Matriz original: ");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("[");
            for (int y = 0; y < matriz.length; y++) {
                System.out.printf("%3d  ", matriz[i][y]);
            }
            System.out.println("]");
        }
        System.out.println();

        int myid;
        OMP.setNumThreads(4);

        //omp parallel private(myid)
        {
            for (int i = 0; i < matriz.length; i++) {
                myid = OMP.getThreadNum();
                matrizResult[myid][i] = matriz[myid][i] * 4;
                System.out.println("Elemento da linha: " + myid + " coluna: " + i);
            }
        }

        System.out.println();
        System.out.println("Matriz multiplicada por 4: ");
        for (int i = 0; i < matrizResult.length; i++) {
            System.out.print("[");
            for (int y = 0; y < matrizResult.length; y++) {
                System.out.printf("%4d  ", matrizResult[i][y]);
            }
            System.out.println("]");
        }
    }
}
