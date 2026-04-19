import java.util.Scanner;

public class Multiplication {

    private static long multi(long X, long Y){
        
        if (X < 10 || Y < 10) return X*Y;

        int n = Math.max(String.valueOf(X).length(), String.valueOf(Y).length());

        int m = n/2;

        long power = (long) Math.pow(10, m);

        long a = X/power;
        long b = X%power;
        long c = Y/power;
        long d = Y%power;

        long ac = multi(a, c);
        long bd = multi(b, d);
        long adplusbc = multi(a+b, c+d) - ac - bd;

        long result = ac * power * power + adplusbc * power + bd;

        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a:\t");
        long a = sc.nextLong();        
        System.out.print("Enter b:\t");
        long b = sc.nextLong();

        System.out.println(multi(a, b));


        sc.close();
    }
}
