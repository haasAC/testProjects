
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * CSCI-202 Traveling Salesperson Problem with a Stack - Shortest Path Tree.
 * Purpose: Prints the best path for given cities.
 *
 * @author Haseeb Chaudhry
 * @version 1.0 12/02/16
 */
public class PA6 {
	int city; // #of cities
	static int[][] adjecency;
	int bestcost = Integer.MAX_VALUE;
	ArrayList<Integer> bestpath;
	 private static long startTime = System.currentTimeMillis();

	/**
	 * Constuctor
	 */
	public PA6(int N) {
		city = N;
		adjecency = new int[city][city];
		bestpath = new ArrayList<>();
	}

	/**
	 * Displays the output
	 */
	public void output() {
		System.out.println("-tsp12 Best path");
		for (int i = 0; i < bestpath.size(); i++) {
			System.out.println(bestpath.get(i) + " ");
		}

	}

	/**
	 * Creates a scanner for the input file
	 *
	 * Populates the matrix with the given input file.
	 */
	public void populateMatrix(String fname) {
		File f = new File(fname);

		try {
			Scanner input = new Scanner(f);
			int i, j;
			for (i = 0; i < city && input.hasNext(); i++) {
				for (j = i; j < city && input.hasNext(); j++) {
					if (i == j) {
						adjecency[i][j] = 0;
					} else {
						int value = input.nextInt();
						adjecency[i][j] = value;
						adjecency[j][i] = value;
					}
				}
			}
			input.close();
		} catch (IOException e) {
			System.out.println("File reading failed");
		}
	}

	/*
	 * Algorithm to figure out the shortest path.
	 */
	public void tsp(){
	}
	public void tsp(int adjacencyMatrix[][]) {
		Stack<Integer> pathStack = new Stack<Integer>();

		int[] visitedCities = new int[city];
		visitedCities[0] = 0;
		pathStack.push(0);
		int closestCity = 0;
		int currentCity = 0;
	
		int min = 0;
		boolean minFlag = false;
		System.out.print(0 + "\t");

		while (!pathStack.isEmpty()) {
	
			currentCity = pathStack.peek();
	
			min = Integer.MAX_VALUE;
			
			for (int i = 0; i < city; i++) {
				if ((adjacencyMatrix[currentCity][i] - currentCity != 0) && visitedCities[i] != i) {
					if (adjacencyMatrix[currentCity][i] < min) {
						min = adjacencyMatrix[currentCity][i];
						closestCity = i;
						minFlag = true;
					}
				}
			}

			if (minFlag) {
				visitedCities[closestCity] = closestCity;
				pathStack.push(closestCity);
				
				System.out.print(closestCity + "\t");
				minFlag = false;
				continue;
			}
			pathStack.pop();
		}
	}

	/**
	 * Main method to test all the methods.
	 */
	public static void main(String[] args) {


		PA6 tsp = new PA6(Integer.parseInt(args[0]));
		tsp.populateMatrix(args[1]);
	
	
		tsp.tsp(adjecency);
		tsp.output();

		long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) + " milliseconds");
	}
	}

