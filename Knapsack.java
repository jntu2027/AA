import java.util.Arrays;
import java.util.Scanner;

class Item{
    int id;
    int weight;
    int value;
    Item(int i,int w,int v){
        id = i;
        weight = w;
        value = v;
    }
}
public class Knapsack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of Items:\t");
        int n = sc.nextInt();

        Item[] bag = new Item[n];

        for(int i = 0;i < n;i++){
            System.out.print("Enter the value of the Weight & Value of Item "+(i+1)+" : ");
            bag[i] = new Item(i+1,sc.nextInt(), sc.nextInt());
        }

        System.out.print("Enter the Capacity of bag:\t");
        int capacity = sc.nextInt();

        Arrays.sort(bag, (a,b) -> 
            Double.compare((double) b.value/b.weight, (double) a.value/a.weight)
        );
        double curValue = 0;
        for (Item i : bag){
            if (capacity >= i.weight){
                capacity -= i.weight;
                curValue += i.value;

                System.out.println("Item "+(i.id) +" Taken Full :-\tWeight : "+(i.weight) + " value : "+(i.value));

            }
            else{
                double v = ((double) i.value/i.weight) * capacity;
                System.out.println("Item "+(i.id) +" Taken Partially :-\tWeight : "+(capacity)+"/"+(i.weight) + " value : "+(i.value));
                curValue += v;
            }
        }

        System.out.println("Maximum value :- " + curValue);

        sc.close();
    }
}
