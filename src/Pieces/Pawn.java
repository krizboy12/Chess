package Pieces;

public class Pawn extends Piece{
	
	//private boolean isFirstMove = true;
	int[] CANDIDATE_MOVES = {7, 8, 9, 16}; //can move up one (+8), up two (+16), or diagonal to capture (+7, +9)

	public Pawn(int pos) {
		super(pos);
		ID = 'P';
	}

	@Override
	public char getID() {
		return ID;
	}

	@Override
	public boolean isMoveValid() {
		
		return false;
	}
	
	public int getPos() {
		return pos;
	}
	
	public void setPos(int pos){
		this.pos = pos;
	}

}
