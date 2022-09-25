package lk.ijse.dep.service;

public class HumanPlayer extends Player{

    public HumanPlayer(Board board) {
        super(board);


    }
    @Override
    public void movePiece(int col){
        if (board.isLegalMove(col)){
            board.updateMove(col,Piece.BLUE);
            board.getBoardUI().update(col,true);

            board.findWinner();
            if(Winner.getWinningPiece()==Piece.BLUE){
                board.getBoardUI().notifyWinner(new Winner(Piece.BLUE));
            }
            else if(!(board.existLegalMoves())){
                board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));

                }
        }





    }
}
