package application;

import chess.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        try (BufferedWriter log = new BufferedWriter(new FileWriter(fileName()))) {
            log.write("White Source, White Target, Black Source, Black Target");
            log.newLine();
            while (!chessMatch.isCheckMate()) {
                try {
                    UI.clearScreen();
                    System.out.println("Chess match: \n");
                    UI.printMatch(chessMatch, captured);
                    System.out.println();
                    System.out.print("Source: ");
                    ChessPosition source = UI.readChessPosition(sc);
                    boolean[][] possibleMoves = chessMatch.possibleMoves(source);

                    UI.clearScreen();
                    System.out.println("Chess match: \n");
                    UI.printBoard(chessMatch.getPieces(), possibleMoves);

                    System.out.println();
                    System.out.print("Target: ");
                    ChessPosition target = UI.readChessPosition(sc);

                    ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                    log.write(source + ", ");
                    if (chessMatch.getCurrentPlayer() == Color.BLACK || chessMatch.isCheckMate()) {
                        log.write(target.toString());
                        log.newLine();
                    } else {
                        log.write(target + ", ");
                    }

                    if (capturedPiece != null) {
                        captured.add(capturedPiece);
                    }

                    if (chessMatch.getPromoted() != null) {
                        System.out.println("qual peca?");
                        String type = sc.nextLine();
                        chessMatch.replacePromotedPiece(type);
                    }

                } catch (ChessException | InputMismatchException e) {
                    System.out.println(e.getMessage());
                    sc.nextLine();
                }

            }

            UI.clearScreen();
            UI.printMatch(chessMatch, captured);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String fileName() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        return "log" + formatter.format(LocalDateTime.now()) + ".csv";
    }
}
