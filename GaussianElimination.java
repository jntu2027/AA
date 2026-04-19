import java.util.Scanner;

public class GaussianElimination {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of equations: ");
        int n = sc.nextInt();

        double[][] matrix = new double[n][n+1];

        System.out.println("Enter the values of equations");
        for (int i = 0;i < n;i++){
            for (int j = 0;j < n+1;j++){
                matrix[i][j] = sc.nextDouble();
            }
        }

        //forward
        for (int c = 0;c < n-1;c++){
            for (int r = c+1 ; r < n;r++){
                double ratio = matrix[r][c]/matrix[c][c];
                for (int  k = 0; k < n+1 ;k++){
                    matrix[r][k] -= ratio*matrix[c][k];
                }
            }
        }

        
        //forward print
        for (int c = 0;c < n;c++){
            for (int r = 0 ; r < n+1;r++){
                System.out.print(matrix[c][r] + " ");
            }
            System.out.println();
        }


        //backward
        double[] values = new double[n];

        for (int r = n-1;r > -1 ; r--){
            double sum = 0;
            for (int c = r+1;c < n;c++){
                sum += matrix[r][c]*values[c];
            }
            values[r] = (matrix[r][n] - sum)/matrix[r][r];
        }

        System.out.println("Solutions");
        for (double d : values) {
            System.out.print(d+" ");
        }


        sc.close();
    }
    
}
// 3
// 2 1 -1 8
// -3 -1 2 -11
// -2 1 2 -3
//output :- 2 , 3 , -1