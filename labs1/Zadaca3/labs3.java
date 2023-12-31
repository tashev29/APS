//For the purpose of a software for keeping track of the revenue generated by employees in the sales department, define a QuarterlySales class that stores the number of sales, 
//the revenue generated by each sale and the number of the quarter.
//Then define another SalesPerson class for which a name(string) and an array of quarterly sales (exactly 4) are stored. 
//For the classes implement the appropriate constructors and methods for the correct execution of the program.
//Implement the following requirements:
//• Method `int sumSales(SalesPerson sp)' which will return sum of all the revenues in all quarters generated by the given worker.
//• Method `SalesPerson salesChampion(SalesPerson [] arr)' which for the given array of sales employees will return the worker with the most generated revenue (of all quarters)
//• Add the `main' method, which will initialize an array of sales persons and quarters according to the input test cases. 
//The number of sales employees is read from input in the first line, and then for each employee the name is read in the first line,
//and then for each of the quarters for that employee in the first line we have the number of sales, and then in the next line the revenue generated by each of those sales.
//• On standard output, print the array of sales employees using the method `void table(SalesPerson [] arr)', 
//which will print a display for the array of sales persons in the following format (three spaces are used for printing space):

import java.util.Scanner;

class QuarterlySales {

    private int numOfSales;
    private int [] revenues;
    private int quarterNo;

    public QuarterlySales(int numOfSales, int[] revenues, int quarterNo) {
        this.numOfSales = numOfSales;
        this.revenues = revenues;
        this.quarterNo = quarterNo;
    }

    public int sales(){
        int sum=0;
        for (int rev : revenues) {
            sum+=rev;
        }
        return sum;
    }
    @Override
    public String toString() {
        return String.valueOf(sales());
    }

}

class SalesPerson {

    private String name;
    private QuarterlySales [] quarters;

    public SalesPerson(String name, QuarterlySales[] quarters) {
        this.name = name;
        this.quarters = quarters;
    }

    public QuarterlySales getQuarters(int id) {
        return quarters[id];
    }



    @Override
    public String toString() {
       StringBuilder res = new StringBuilder();
       res.append(name);
       int total=0;
        for (int i = 0; i < 4; i++) {
            res.append("   ").append(quarters[i].sales());
            total+=quarters[i].sales();
        }
        res.append("   ");
        res.append(total);
       return res.toString();

    }

    public String getName() {
        return name;
    }
}



public class Main {
    public static int sumSales(SalesPerson sp){
        int sum=0;
        for (int i=0;i<4;i++) {
            sum+=sp.getQuarters(i).sales();
        }
        return sum;

    }
    public static SalesPerson salesChampion(SalesPerson [] arr)
    {
     int id=0;
        for (int i = 0; i <arr.length ; i++) {
            if(sumSales(arr[i])>sumSales(arr[id])){
                id=i;
            }
        }
        return arr[id];
    }
    public static void table(SalesPerson [] arr)
    {
        System.out.println("SP   1   2   3   4   Total");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }
        System.out.println();

    }

    public static void main(String[] args) {

        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        SalesPerson [] arr = new SalesPerson[n];
        for(int i=0;i<n;i++) {
            String name = input.next();
            input.nextLine();
            QuarterlySales [] quartes = new QuarterlySales[4];
            for (int k = 0; k < 4; k++) {
                int numRev = input.nextInt();
                int[] rev = new int[numRev];
                for (int j = 0; j < numRev; j++) {
                    rev[j] = input.nextInt();
                }
                quartes[k]=new QuarterlySales(numRev,rev,k);

            }
            arr[i]=new SalesPerson(name,quartes);


        }

        table(arr);
        System.out.println("SALES CHAMPION: " + salesChampion(arr).getName());

    }
}
