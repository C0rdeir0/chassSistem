package chess.pieces;

import boardGame.Board;
import chess.Color;
import chess.chessPiece;

public class King  extends chessPiece{

	public King(Board board, Color color) {
		super(board, color);

	}

	@Override
	public String toString() {
		return "k";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		return mat;
	}
	

}
