package lk.ijse.dep.service;

public class BoardImpl implements Board {
    private Piece[][] pieces;
    private BoardUI boardUI;
    public BoardImpl(BoardUI boardUI){
        pieces=new Piece[NUM_OF_COLS][NUM_OF_ROWS];
        this.boardUI=boardUI;
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j <pieces[i].length; j++) {
                pieces[i][j]=Piece.EMPTY;
            }
        }


    }
    @Override
    public BoardUI getBoardUI() {
        return boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {
        int count=5;
        for(int i=0; i<pieces[i].length;i++){
            if(pieces[col][i]==Piece.EMPTY){
                count--;
            }
        }
        if(count==5){
            count=-1;
        }
        return count;
    }

    @Override
    public boolean isLegalMove(int col) {
        boolean bool1=true;
        if (findNextAvailableSpot(col)==-1){
            bool1=false;
        }
        return bool1;
    }

    @Override
    public boolean existLegalMoves() {

        boolean bool2=false;
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j <pieces[i].length; j++) {
               if(pieces[i][j]==Piece.EMPTY){
                   bool2=true;
               }
            }
        }

        return bool2;
    }

    @Override
    public void updateMove(int col, Piece move) {

        pieces[col][findNextAvailableSpot(col)]=move;

    }

    @Override
    public void updateMove(int col, int row, Piece move) {
        pieces[col][row]=move;

    }

    @Override
    public Winner findWinner() {
        int count=0;
        Piece win=Piece.EMPTY;
        int col1=0;
        int col2=0;
        int row1=0;
        int row2=0;

        for (int i = 0; i < pieces.length; i++) {
            count=findNextAvailableSpot(i);
            if(count==4 || count==-1){
                if (pieces[i][0]==pieces[i][1] &&
                        pieces[i][1]==pieces[i][2] &&
                            pieces[i][2]==pieces[i][3]){
                    win=pieces[i][0];
                    col1=i;
                    col2=i;
                    row1=0;
                    row2=3;

                }
                else if (pieces[i][1]==pieces[i][2] &&
                            pieces[i][2]==pieces[i][3] &&
                                pieces[i][3]==pieces[i][4]){
                    win=pieces[i][1];
                    col1=i;
                    col2=i;
                    row1=1;
                    row2=4;
                }
            }
        }
        for (int i = 0; i < pieces[i].length; i++) {
            count = findColumnSpot(i);
            if (count == 5 || count == 4 || count==-1) {
                if (pieces[0][i] == pieces[1][i]  &&
                        pieces[1][i]  == pieces[2][i]  &&
                        pieces[2][i]  == pieces[3][i] ) {
                    win = pieces[0][i];
                    col1 = 0;
                    col2 = 3;
                    row1 = i;
                    row2 = i;

                }
                else if (pieces[1][i] == pieces[2][i]  &&
                        pieces[2][i]  == pieces[3][i]  &&
                        pieces[3][i]  == pieces[4][i] ) {
                    win = pieces[1][i];
                    col1 = 1;
                    col2 = 4;
                    row1 = i;
                    row2 = i;

                }
                else if (pieces[2][i] == pieces[3][i]  &&
                        pieces[3][i]  == pieces[4][i]  &&
                        pieces[4][i]  == pieces[5][i] ) {
                    win = pieces[2][i];
                    col1 = 2;
                    col2 = 5;
                    row1 = i;
                    row2 = i;

                }
            }
        }

        Winner winner;
        if(win==Piece.EMPTY){
            winner=new Winner(win);
        }
        else {
            winner=new Winner(win,col1,row1,col2,row2);
        }
        return winner;
    }
    private int findColumnSpot(int row){
        int count=6;
        for(int i=0; i<pieces.length;i++){
            if(pieces[i][row]==Piece.EMPTY){
                count--;
            }
        }
        if(count==6){
            count=-1;
        }
        return count;
            }


    }



