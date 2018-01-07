import java.util.Stack;

/**
 By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom of the triangle below:

 * @author zachc
 *
 */
public class Problem18 {
	public static void main(String[] args) {
		String triangleString = 
			"75\n" + 
			"95 64\n" + 
			"17 47 82\n" + 
			"18 35 87 10\n" + 
			"20 04 82 47 65\n" + 
			"19 01 23 75 03 34\n" + 
			"88 02 77 73 07 63 67\n" + 
			"99 65 04 28 06 16 70 92\n" + 
			"41 41 26 56 83 40 80 70 33\n" + 
			"41 48 72 33 47 32 37 16 94 29\n" + 
			"53 71 44 65 25 43 91 52 97 51 14\n" + 
			"70 11 33 28 77 73 17 78 39 68 17 57\n" + 
			"91 71 52 38 17 14 91 43 58 50 27 29 48\n" + 
			"63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" + 
			"04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";
		String[] triangleRows = triangleString.split("\n");
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
