package aplication;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.chessMatch;
import chess.chessPiece;
import chess.chessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		chessMatch chessMatch = new chessMatch();
		
		while (true) {
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces());
				System.out.println();
				System.out.print("Source: ");
				chessPosition source = UI.readChessPosition(sc);
				System.out.println();
				System.err.print("Target: ");
				chessPosition target = UI.readChessPosition(sc);
				
				chessPiece capuPiece = chessMatch.peformChessMove(source, target); 
			}
			catch(ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();			
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();			
			}
		}
		
	}

}
