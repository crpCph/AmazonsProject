/*
Class that makes it possible to transition between states
*/
public class Action {
    //location of picked queen given by (x,y)
    int[] queen;
    //position to put queen in given by (x,y)
    int[] pos;
    //position where to shoot an arrow
    int[] arrow;

    public Action(){
        queen = new int[2];
        pos = new int[2];
        arrow = new int[2];
    }

    public Action(int queenX, int queenY, int posX, int posY, int arrowX, int arrowY){
        queen = new int[2];
        pos = new int[2];
        arrow = new int[2];

        if( !( isOutOfBounds(queenX, queenY)
                || isOutOfBounds(posX, posY)
                || isOutOfBounds(arrowX, arrowY))) {

            queen[0] = queenX; queen[1] = queenY;
            pos[0] = posX;     pos[1] = posY;
            arrow[0] = arrowX; arrow[1] = arrowY;

        }
    }

    public void perform(Board current){
        int qColor = current.get(queen);
        current.setTo(queen, 0);
        current.setTo(pos, qColor);
        current.setTo(arrow, 3);
    }

    //quick coordinate boundaries check
    public boolean isOutOfBounds(int x, int y){
        if(x<0 || x>=Board.N || y<0 || y>=Board.N) {
            System.out.println("Coordinates out of bounds");
            return true;
        }
        return false;
    }
    // quick value check
    public boolean isUnknownValue(int val){
        if(!(val == 0 || val == 1 || val == 2 || val == 3)) {
            System.out.println("Value out of bounds");
            return true;
        }
        return false;
    }

}
