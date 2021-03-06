import java.util.Scanner;
import java.util.*;
import java.util.stream.IntStream; 

public class Sieve{

    public static void multiples(int n, int N, ArrayList<Boolean> visited, int m){
        if(n*m>N){
            return;
        }
        else{
            visited.set(n*m, true);
            multiples(n, N, visited, m+1);
        }
    }

    public static void main(String[] args){
        Scanner inp = new Scanner(System.in);
        if(inp.hasNextInt()){
            int N= inp.nextInt();
            ArrayList<Boolean> visited = new ArrayList<Boolean>(Collections.nCopies(N+1,false));
            IntStream stream = IntStream.range(2,N+1);
            stream.filter( x -> {
                if(!visited.get(x)){
                    multiples(x, N, visited, 2);
                }
                return !visited.get(x);
            }).map(x->(char)x).forEach( (x) -> System.out.print(x + " ")); 
        }
	System.out.println("");
    }
    



}