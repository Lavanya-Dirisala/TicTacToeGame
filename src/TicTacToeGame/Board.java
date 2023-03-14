package TicTacToeGame;


class Board{
	public Piece[][] TicTacToeBoard;
	int n=3;
	public Board(){
		TicTacToeBoard = new Piece[n][n];
	}
	public void addBoardPiece(int xPos, int yPos, char player){
		TicTacToeBoard[xPos][yPos] = new Piece(xPos, yPos, player);
	}

	public char GetBoardPiece(int xPos, int yPos){
		return TicTacToeBoard[xPos][yPos].Value;
	}

	public boolean isBoardFilled() {
		for(int row=0;row<n;row++) {
			for(int col=0;col<n;col++) {
				if(TicTacToeBoard[row][col].Value=='-')
				{
					return false;
				}
			}
		}
		return true;
	}
	public void printBoard() {
		for(int row=0;row<n;row++) {
			for(int col=0;col<n;col++) {
				System.out.print(TicTacToeBoard[row][col].Value+" ");
			}
			System.out.println();
		}
	}
	public boolean isvalid(int row,int col) {
		if(row<0|| col<0 || row> 2 ||col>2) {
			System.out.println("Enter valid row or column indexes");
		}
		else if(TicTacToeBoard[row][col].Value!='-') {
			System.out.println("Filled by someone already");
		}
		else {
			//Valid scenario
			return true;
		}
		return false;
	}
	public  char checkWinner() {
		//row check
		for(int iteraterow=0;iteraterow<n;iteraterow++) {
			if(TicTacToeBoard[iteraterow][0].Value == TicTacToeBoard[iteraterow][1].Value &&
					TicTacToeBoard[iteraterow][1].Value == TicTacToeBoard[iteraterow][2].Value && 
					TicTacToeBoard[iteraterow][0].Value!='-')
			{
				return TicTacToeBoard[iteraterow][0].Value; 
			}

		}
		//col check
		for(int iteratecol=0;iteratecol<n;iteratecol++) {
			if(TicTacToeBoard[0][iteratecol].Value == TicTacToeBoard[1][iteratecol].Value &&
					TicTacToeBoard[1][iteratecol].Value== TicTacToeBoard[2][iteratecol].Value && 
					TicTacToeBoard[0][iteratecol].Value!='-')
			{
				return TicTacToeBoard[0][iteratecol].Value; 
			}

		}
		//diagonal check \
		if(TicTacToeBoard[0][0].Value==TicTacToeBoard[1][1].Value && TicTacToeBoard[1][1].Value==TicTacToeBoard[2][2].Value && TicTacToeBoard[0][0].Value!='-') {
			return TicTacToeBoard[0][0].Value;
		}
		// diagonal check /
		if(TicTacToeBoard[2][0].Value==TicTacToeBoard[1][1].Value && TicTacToeBoard[1][1].Value==TicTacToeBoard[2][0].Value && TicTacToeBoard[2][0].Value!='-') {
			return TicTacToeBoard[2][0].Value;
		}
		//Nobody wins
		return '-';
	}
}

