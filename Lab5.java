/*args[0] is an integor for #of cities
args[1] is the filename for adjecency matrix
*/

inport java.util.*;
import java.io.*;
public class Lab5{
int CITI; //#of cities
int[][] adjecency;
int bestcost = Integer.MAX_VALUE;
ArrayList<Integer> bestpath;

public Lab5(int N){
CITI = N;
adjecency = new int[CITI][CITI];
bestpath = new ArrayList<>();

}

public void output(){
    System.out.println("Best path and cost");
    for(int i = 0; i <bestparth.size(); i++)
        System.out.println(bestparth.get(i) + " ");
    System.out.println("cost = " + best cost);
}

public void populateMatrix(String fname){
    File f = new File(fname);

    try{
        Scanner input = new Scanner(f);
        int i, j;
        for(i=0; i<CITI && input.hasNext();i++){
            for(int j=i; j<CITI&&input.hasNext();j++){
                if(i==j){
                    adjecency[i][j] = 0;
                }
                else {
                    value = input.nextInt();
                    adjecency[i][j] = value;
                    adjecency[j][i] = value;
                }
            }
        }
        input.close();
    }
    catch(IOException e){
        System.out.println("File reading failed");
    }
}

private int cost(ArrayList<Integer> path){
int cost = 0;
    for(int i = 0; i<path.size()-1;i++){
        cost+=adjecency[path.get(i)]{path.get(i+1)];

}
if(path.size() == CITI)
    cost+= adjecency[path.get(path.size()-1)][0];
return cost;
}

public void tspdfs(ArrayList<Integer>partialtour,ArrayList<Integer>remainingCities){
if(remainingCities.isEmpty())
    System.out.println(Lab5.cost(path));
    
//Algorithm in Lab5
}

public static void main(String[] args){


Lab5 tsp = new Lab5(Integer.parseInt(args[0]);
tsp.populateMatrix(args[1]);

ArrayList<Integer> partialT = new ArrayList<>();
partialT.add(0);
ArrayList<Integer> remainingT = new ArrayList<>);

    for(int i=1; i<Integer.parseInt(args[0]);i++){
        remaniningT.add(i);
}

tsp.tspdfs(partialT, remaniningT);
tsp.output();

}
}