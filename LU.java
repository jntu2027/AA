import java.util.Scanner;

public class LU {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n:- ");
        int n = sc.nextInt();

        double[][] u = new double[n][n];
        double[][] l = new double[n][n];
        System.out.println("Enter matrix");

        for (int i = 0; i < u.length; i++) {
            for (int j = 0; j < u.length; j++) {
                l[i][j] = 0;
                u[i][j] = sc.nextDouble();
            }
            l[i][i] = 1;
        }

        

        for (int k = 0; k < n; k++){
            //k to represent the diagonal  elements

            for (int r = k+1; r < n;r++){
                //r to represent elements below the diagonal
                double ratio = u[r][k]/u[k][k];
                l[r][k] = ratio;

                for (int c = 0; c < n; c++){
                    //c to represent column to do row operations like r1 -> r1 - r2
                    u[r][c] -= ratio*u[k][c];
                }
            }
        }



        //print lower matrix
        System.out.println("\nMatrix L\n");
        for (int i = 0; i < n;i++){
            for (int j = 0;j < n;j++){
                System.out.print(l[i][j] + " ");
            }
            System.out.println();
        }

        //print upper matrix
        System.out.println("\nMatrix U\n");
        for (int i = 0; i < n;i++){
            for (int j = 0;j < n;j++){
                System.out.print(u[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
