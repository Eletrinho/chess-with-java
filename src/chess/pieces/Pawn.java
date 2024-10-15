package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
    private boolean firstMove;
    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        if (getColor() == Color.WHITE) {
            p.setValues(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() - 2, position.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) &&
                    getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() < 1) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpppentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            // en passant
            if (position.getRow() == 3) {
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positionExists(left) && isThereOpppentPiece(left)
                    && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                    mat[p.getRow() - 1][left.getColumn()] = true;
                }

                Position right = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positionExists(right) && isThereOpppentPiece(right)
                    && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
                    mat[p.getRow() - 1][right.getColumn()] = true;
                }
            }
        } else {
            p.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) &&
                    getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() < 1) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpppentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }


            // en passant
            if (position.getRow() == 4) {
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positionExists(left) && isThereOpppentPiece(left)
                        && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                    mat[p.getRow() + 1][left.getColumn()] = true;
                }

                Position right = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positionExists(right) && isThereOpppentPiece(right)
                        && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
                    mat[p.getRow() + 1][right.getColumn()] = true;
                }
            }
        }

        if (getBoard().positionExists(p) && isThereOpppentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }
}
