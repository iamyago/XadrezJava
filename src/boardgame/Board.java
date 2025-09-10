package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Rows and columns must be greater than 1 ");
        }
        this.rows = rows;
        this.columns = columns;
        this.pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column) {
        if (!positionExistis(row, column)) {
            throw new BoardException("Position does not exist");
        }
        return pieces[row][column];
    }
    public Piece pieces(Position pos) {
        if (!positionExists(pos)) {
            throw new BoardException("Position does not exist");
        }
        return piece(pos.getRow(), pos.getColumn());
    }
    public void PlacePiece(Piece piece, Position pos) {
        if (thereIsAPiece(pos)){
            throw new BoardException("There is already a piece on this position");
        }
        pieces[pos.getRow()][pos.getColumn()] = piece;
        piece.position = pos;
    }

    public Piece RemovePiece (Position position){
        if (!positionExists(position)) {
            throw new BoardException("Position does not exist");
        }
        if (pieces(position) == null){
            return null;
        }
        Piece aux = pieces(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }

    private boolean positionExistis (int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists (Position pos) {
        return positionExistis (pos.getRow(), pos.getColumn());
    }

    public boolean thereIsAPiece (Position pos){
        if (!positionExists(pos)) {
            throw new BoardException("Position does not exist");
        }
        return pieces(pos) != null;
    }
}
