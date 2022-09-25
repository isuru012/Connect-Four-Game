package lk.ijse.dep.service;

public class AiPlayer extends Player{
    private int minimax(int depth, boolean maximizingPlayer) {
        if (depth == CERTAIN_NUMBER) {
            return the static evaluation of the board
        }
        if (maximizingPlayer) {
            maxEval = -Infinity;
            for each column in the board {
                heuristicVal = minimax(depth + 1, false);
                maxEval = max(heuristicVal, maxEval);

            }
            return maxEval;
        }else{
                minEval = +Infinity;
                for each column in the board {
                    heuristicVal = minimax(depth + 1, true);
                    mineval - min(heuristicVal, minEval)
                }
                return minEval
            }
        }



    public AiPlayer(Board board) {
        super(board);
    }

    @Override
    public void movePiece(int col) {
        boolean bool=true;

        do {
            col= (int) ((Math.random() * (6 - 0)) + 0);
            if (board.isLegalMove(col)) {
                bool=false;
            }
        }while(bool);
        board.updateMove(col,Piece.GREEN);
        board.getBoardUI().update(col,false);
        board.findWinner();
        if(Winner.getWinningPiece()==Piece.GREEN){
            board.getBoardUI().notifyWinner(new Winner(Piece.GREEN));
        }
        else if(!(board.existLegalMoves())){
            board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
        }




    }
}
