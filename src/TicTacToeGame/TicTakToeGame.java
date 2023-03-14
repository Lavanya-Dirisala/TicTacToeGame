package TicTacToeGame;


import java.util.Scanner;

class Piece{
	int XPos;
	int YPos;
	char Value;
	public Piece(int x, int y, char v){
		XPos = x;
		YPos = y;
		Value = v;
	}
}
public class TicTakToeGame {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Board board = new Board();
		for(int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {
				board.addBoardPiece(row, col, '-');
			}
		}
		boolean gameEnded=false;
		char player='1';
		while(!gameEnded) {
			board.printBoard();
				// get input from user 
			   System.out.println("Player "+ player);
				System.out.println("Enter row and col index");
				
				System.out.print("Enter row - 0-1-2");				
				int rowvalue=input.nextInt();
				
				System.out.print("Enter col - 0-1-2");				
				int colvalue=input.nextInt();
				
				
				// Main Logic - checking winner 
				if(board.isvalid(rowvalue,colvalue)) {
					board.addBoardPiece(rowvalue, colvalue,player);
					player=(player=='1')?('2'):('1');
					if(board.checkWinner()=='1') {
						System.out.println("*******Player 1 Won the game*******");
						gameEnded=true;
						
					}
					else if(board.checkWinner()=='2'){
						System.out.println("*******Player 2 Won the game*******");
						gameEnded=true;
						
					}
					else {
						//board filled
						if(board.isBoardFilled()) {
							System.out.print("None of the Players Won");
							gameEnded=true;
							
						}

					}
				
			}
		}
		input.close();
		board.printBoard();
	}
}

