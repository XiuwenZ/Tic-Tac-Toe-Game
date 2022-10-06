import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class TicTacToe{
	/*
	 * Creates two arraylists for recording the positions 
	 */
	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> comPositions = new ArrayList<Integer>();
	
	 public static void main(String[] args){
		 Scanner input = new Scanner(System.in);
		
		
		
		//Two Dimension Array to create the structure of the game 
		
		char [][] board =  { {' ', '|', ' ', '|', ' '},
								{'-', '+', '-', '+', '-'},
								{' ', '|', ' ', '|', ' '},
								{'-', '+', '-', '+', '-'},
								{' ', '|', ' ', '|', ' '},
		};
		
		printBoard(board);
		
		//player input and computer random generation

		while(true) {
			
			System.out.println("Enter your position: ");
			
			
			int playerPosition = input.nextInt();
			while(playerPositions.contains(playerPosition) || comPositions.contains(playerPosition)) {
				System.out.println("Position taken! Try Again:");
				playerPosition = input.nextInt();
			}
			positionPlacement(board, playerPosition, "player");
			
			
			Random randNum = new Random();
			int comPosition = randNum.nextInt(9) + 1;
//			while(playerPositions.contains(comPositions) || comPositions.contains(playerPositions)) {
//				comPosition = randNum.nextInt(9) + 1;
//			
//			}
			positionPlacement(board, comPosition, "computer");
			printBoard(board);
			
			List<List> winCondition = winnerCheck();
			
			for(List pos: winCondition) {
				if(playerPositions.containsAll(pos)) {
					System.out.println( "You won the game!");
					System.out.println();
					break;
					
				}
				else if(comPositions.containsAll(pos)) {
					System.out.println( "Computer won the game! Good luck next time!");
					System.out.println();
					break;
				}
				else if(comPositions.size() + playerPositions.size() == 9 ) {
					System.out.println( "TIE");
					System.out.println();
					break;
				}
			}
		}
	}
	
	
	//creates the game board
	public static void printBoard(char[][]board) {
		for(char[] row: board) {
			for (char col: row) {
				System.out.print(col);
				
			}
			System.out.println();
		}
	
				
	}
	
	public static void positionPlacement(char[][]board, int pos, String user) {
		//player vs computer 
		char symbol = ' ';
		if (user.equals("player")) {
			symbol = 'X';
			playerPositions.add(pos);
			
		}
		else if (user.equals("computer")) {
			symbol = 'O';
			comPositions.add(pos);
			
		}
			
		//place the positions of the player or the computer
		switch(pos) {
			case 1: 
				board[0][0] = symbol;
				break;
			case 2: 
				board[0][2] = symbol; 
				break;
			case 3:  
				board[0][4] = symbol;
				break;
			case 4: 
				board[2][0] = symbol;
				break;
			case 5: 
				board[2][2] = symbol;
				break;
			case 6: 
				board[2][4] = symbol;
				break;
			case 7: 
				board[4][0] = symbol;
				break;
			case 8: 
				board[4][2] = symbol;
				break;
			case 9: 
				board[4][4] = symbol;
				break;
			default:
				break;
				
		}
	}
	
	public static List winnerCheck() {
		//winning conditions as lists
		List topRow = Arrays.asList(1,2,3);
		List secondRow = Arrays.asList(4,5,6);
		List lastRow = Arrays.asList(7,8,9);
		
		List topCol = Arrays.asList(1,4,7);
		List secondCol = Arrays.asList(2,5,8);
		List lastCol = Arrays.asList(3,6,9);

		List forwardSlash = Arrays.asList(1,5,9);
		List backSlash = Arrays.asList(7,5,3);

		
		List<List> winCondition = new ArrayList<List>();
		
		winCondition.add(topRow);
		winCondition.add(secondRow);
		winCondition.add(lastRow);
		winCondition.add(topCol);
		winCondition.add(secondCol);
		winCondition.add(lastCol);
		winCondition.add(forwardSlash);
		winCondition.add(backSlash);
		
		return winCondition;
		
		
	}

}
