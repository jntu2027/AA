import java.util.Scanner;

public class RabinKarp {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String : \t");
        String s = sc.next();
        
        System.out.print("Enter pattern to search : \t");
        String p = sc.next();

        int n = s.length(), m = p.length();

        int curHashValue = 0,patternHashValue = 0;

        for (int i = 0;i < m;i++){
            curHashValue = curHashValue*10 + (s.charAt(i) - 'a');
            patternHashValue = patternHashValue*10 + (p.charAt(i) -'a');
        }
        if (curHashValue == patternHashValue){
            System.out.println("Patten Found at 1");
        }
        else{

            int power =(int) Math.pow(10, m-1);

            for (int i = m;i < n;i++){
                curHashValue = (curHashValue - (s.charAt(i-m) - 'a')*power)*10 + (s.charAt(i) - 'a');

                if (curHashValue == patternHashValue){
                    if (s.substring(i-m+1, i+1).equals(p)){ 
                        System.out.println("Patten Found at " + (i-m+2));
                        break;
                    }
                }
            }
        }
        sc.close();
    }
}
