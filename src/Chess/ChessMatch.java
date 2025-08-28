package Chess;

import Chess.pieces.King;
import Chess.pieces.Rook;
import boardgame.Board;
import boardgame.Position;

public class ChessMatch {
    private Board board;

    public ChessMatch() {
        this.board = new Board(8, 8);
        inicialsetup();
    }

    // reconhece somente a camada ChessPiece não PIECE.
    // retorna uma matriz de peça de xadrez em uma partida.
    public ChessPiece[][] getPieces() {
        ChessPiece[][] pieces = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                pieces[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return pieces;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.PlacePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void inicialsetup() {
        placeNewPiece('b', 6, new Rook(board, Color.WHITE));
        placeNewPiece('e', 8,new King(board, Color.BLACK));
        placeNewPiece('e', 1 ,new King(board, Color.WHITE));

    }
}
