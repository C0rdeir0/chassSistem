package chess;

import boardGame.Board;
import boardGame.Position;
import chess.pieces.King;
import chess.pieces.Rook;



public class chessMatch {
	
	private Board board;
	
	public chessMatch() {
		board = new Board(8,8); 
		initialSetup();
	}
	public chessPiece [][] getPieces(){
		chessPiece[][] mat= new chessPiece [board.getRows()][board.getColumns()];
		for(int i = 0; i < board.getRows(); i++){
			for(int j = 0; j< board.getColumns();j++) {
				mat[i][j] = (chessPiece) board.piece(i,j);
			}
		}
		return mat;
	}
	private void pleceNewPiece(char column ,int row, chessPiece piece) {
		board.placePiece(piece, new chessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		pleceNewPiece('b' ,6 ,new Rook(board, Color.WHITE));
		pleceNewPiece('e' ,8 ,new King(board, Color.BLACK));
		pleceNewPiece('e' ,1 ,new King(board, Color.WHITE));
	}

}
