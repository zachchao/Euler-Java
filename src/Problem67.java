import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Problem67 {
	public final static String FILE_NAME = "src/Problem67Text";
	public static void main(String[] args) throws IOException{
		//Read the values in from the file
		File directory = new File(FILE_NAME);
		FileReader in = new FileReader(directory);
		BufferedReader br = new BufferedReader(in);

		String line;
		ArrayList<String> triangleList = new ArrayList<String>();
		while((line = br.readLine()) != null)
		{
			//System.out.println(line);
			triangleList.add(line);
		}
		String[] triangleRows = triangleList.toArray(new String[triangleList.size()]);
		//Reverse it, take it bottom up for dynamic programming
		Stack<String> stack = new Stack<String>();
		for(String row : triangleRows) {
			stack.push(row);
		}
		triangleRows = new String[triangleRows.length];
		int index = 0;
		while(!stack.isEmpty()) {
			triangleRows[index++] = stack.pop();
		}
		//Dynamic programming, take the max of the two 
		//As the maximal path will always choose that one
		for(int i = 0; i < triangleRows.length-1; i++) {
			String dynamicRow = "";
			String[] rowRay = triangleRows[i].split(" ");
			for(int j = 0; j < rowRay.length - 1; j++) {
				dynamicRow += String.valueOf(Math.max(Integer.valueOf(rowRay[j]), Integer.valueOf(rowRay[j+1]))) + " ";
			}
			
			//Make the next row the weights of the path that must have been taken to 
			//keep maximality
			String maximalPath = "";
			for(int j = 0; j < dynamicRow.split(" ").length; j++) {
				maximalPath += String.valueOf(Integer.valueOf(triangleRows[i+1].split(" ")[j]) + Integer.valueOf(dynamicRow.split(" ")[j]) + " ");
			}
			//Replace with new dynamic row
			triangleRows[i+1] = maximalPath;
			
			
		}
		System.out.println(triangleRows[triangleRows.length - 1]);
		
	}
}
