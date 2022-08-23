package chess;

import boardGame.Board;
import boardGame.Piece;
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
	public chessPiece peformChessMove(chessPosition soucePosition,chessPosition targetPosition) {
		Position source = soucePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		Piece capturedPiece = makeMove (source , target);
		return (chessPiece) capturedPiece;
	}
	private Piece makeMove(Position source , Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	private void validateSourcePosition(Position position) {
		if(!board.thereIsaPiece(position)) {
			throw new ChessException("there is no piece o source position");
			
		}
		
	}
		
	private void pleceNewPiece(char column ,int row, chessPiece piece) {
		board.placePiece(piece, new chessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		pleceNewPiece('c', 1, new Rook(board, Color.WHITE));
        pleceNewPiece('c', 2, new Rook(board, Color.WHITE));
        pleceNewPiece('d', 2, new Rook(board, Color.WHITE));
        pleceNewPiece('e', 2, new Rook(board, Color.WHITE));
        pleceNewPiece('e', 1, new Rook(board, Color.WHITE));
        pleceNewPiece('d', 1, new King(board, Color.WHITE));

        pleceNewPiece('c', 7, new Rook(board, Color.BLACK));
        pleceNewPiece('c', 8, new Rook(board, Color.BLACK));
        pleceNewPiece('d', 7, new Rook(board, Color.BLACK));
        pleceNewPiece('e', 7, new Rook(board, Color.BLACK));
        pleceNewPiece('e', 8, new Rook(board, Color.BLACK));
        pleceNewPiece('d', 8, new King(board, Color.BLACK));
	}

}
