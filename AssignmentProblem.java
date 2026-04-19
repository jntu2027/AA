import java.util.Scanner;

public class AssignmentProblem {

    private static int[][] matrix;
    private static int min  = Integer.MAX_VALUE;
    private static int n;
    private static boolean[] Task;
    private static int assigned[];
    private static int minassigned[];

    private static void backtrack(int person, int cur ){
        if (person == n){
            if (min >= cur){
                min = cur;
                minassigned = assigned.clone();
            }
            return;
        }
        if (cur > min) return;
        for (int i = 0;i < n;i++){
            if (Task[i] == false){
                Task[i] = true;
                cur += matrix[person][i];
                assigned[person] = i;

                backtrack(person+1, cur);

                assigned[person] = -1;
                cur -= matrix[person][i];
                Task[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of Tasks/Person:\t");
        n = sc.nextInt();

        matrix = new int[n][n];
        Task = new boolean[n];
        assigned = new int[n];

        System.out.println("Enter the values of Tasks for the Person");
        for (int i = 0; i < n ; i++) System.out.print("   Task "+(i+1));

        for (int i = 0; i < n;i++){
            System.out.print("Perosn " + (i+1) + " :- ");
            Task[i] = false;
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        backtrack(0, 0);

        System.out.println("Minimum Value : "+min);
        System.out.println("Minimum assignment");
        for (int i = 0; i < n; i++) {
            System.out.println("Person "+(i+1)+" : "+(minassigned[i]+1));
        }
        sc.close();
    }
}