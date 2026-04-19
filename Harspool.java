import java.util.Scanner;
import java.util.HashMap;

public class Harspool {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String : \t");
        String s = sc.next();
        
        System.out.print("Enter pattern to search : \t");
        String p = sc.next();

        int n = s.length(), m = p.length();

        HashMap<Character,Integer> shiftTable = new HashMap<>();

        for (int i = 0;i < m-1;i++){
            shiftTable.put(p.charAt(i), m-1-i);
        }

        int i = m-1,j = m-1;

        for (char key : shiftTable.keySet()){
            System.out.println(key + " -> " + shiftTable.get(key));
        }

        boolean notFound = true;

        while(i < n){
            if (s.charAt(i) == p.charAt(j)){
                i--;
                j--;
                if (j == -1){
                    System.out.println("pattern Found at "+(i+2) + " (1 - based Indexing)");
                    notFound = false;
                    break;
                }
            } else{
                i +=  shiftTable.getOrDefault(s.charAt(i), m);
                j = m-1;
            }
        }

        
        if (notFound) System.out.println("pattern not found");


        sc.close();
    }
}
