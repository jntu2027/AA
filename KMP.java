import java.util.Scanner;

public class KMP {
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String : \t");
        String s = sc.next();
        
        System.out.print("Enter pattern to search : \t");
        String p = sc.next();

        int n = s.length(), m = p.length();

        

        int[] LPS = new int[m];
        LPS[0] = 0;
        int i= 1,j = 0;
        while (i < m){
            if (p.charAt(i) == p.charAt(j)){
                LPS[i++] = ++j;
            }
            else{
                if (j == 0){
                    LPS[i++] = 0;
                }
                else{
                    j = LPS[j];
                }
            }
        }


        for (int a = 0;a < m;a++) System.out.println(a + " -> "+(LPS[a]));

        i=0;
        j = 0;
        boolean notFound = true;

        while (i < n) {
            if (s.charAt(i) == p.charAt(j)){
                i++;
                j++;
                    
                if (j == m){
                    System.out.println("Found at " +  (i-j));
                    notFound = false;
                    break;
                }
            }
            else{
                if (j == 0 ){
                    i++;
                }else{
                    j = LPS[j-1];
                }
            }
        }

        if (notFound){
            System.out.println("Pattern Not Found");
        }



        sc.close();
    }

}
