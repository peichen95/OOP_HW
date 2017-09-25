
/* 
 * I learned the algorithm from this website:
 * http://www.geeksforgeeks.org/backtracking-set-3-n-queen-problem/
*/

import java.util.*;

public class NQueens{
	static int solutions = 0;
	static int n;
	
	static void printSolution(int[][] board){
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static boolean isSafe(int[][] board, int row, int col){
		int i, j;
		
		for(i=0; i<col; i++){
			if(board[row][i] == 1) return false;
		}
		
		for(i=row, j=col; i>=0 && j>=0; i--,j--){
			if(board[i][j] == 1) return false;
		}
		
		for(i=row, j=col; j>=0 && i<n; i++, j--){
			if(board[i][j] == 1) return false;
		}
		
		return true;
	}
	
	static int findNQSolutions(int[][] board, int col){
		if(col >= n){
			solutions++;
			printSolution(board);
			return 1;
		}
		
		for(int row=0; row<n; row++){
			if(isSafe(board, row, col)){
				board[row][col] = 1;
			
				if(findNQSolutions(board, col+1)==1){
					board[row][col] = 0;
					continue;
				}
				
				board[row][col] = 0;
			}
		}
		
		return solutions;
	}
	
	static void solveNQueens(int[][] board){
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				board[i][j] = 0;
			}
		}
		
		findNQSolutions(board, 0);
	}

	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		System.out.print("Set N to: ");

		n = stdin.nextInt();
		int[][] board = new int[n][n];
		solveNQueens(board);

		System.out.printf("total %d solutions are found", solutions);
	}
}