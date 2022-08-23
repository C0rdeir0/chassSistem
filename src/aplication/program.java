package aplication;

import java.util.Scanner;

import chess.chessMatch;
import chess.chessPiece;
import chess.chessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		chessMatch chessMatch = new chessMatch();
		
		while (true) {
			UI.printBoard(chessMatch.getPieces());
			System.out.println();
			System.out.print("Source: ");
			chessPosition source = UI.readChessPosition(sc);
			System.out.println();
			System.err.print("Target: ");
			chessPosition target = UI.readChessPosition(sc);
			
			chessPiece capuPiece = chessMatch.peformChessMove(source, target); 

		}
		
	}

}
