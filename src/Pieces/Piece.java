package Pieces;

public abstract class Piece {
	
	protected char ID;

	protected int pos;
	protected char color;

	public Piece(int pos, char color) {
		this.pos = pos;
		this.color = color;
		ID = 0;
	}
	
	public abstract char getID();
	
	//checks if the movement submitted is valid
	public abstract boolean isMoveValid();

	//simple movement of the piece
	public int getPos() {
		return pos;
	}
	
	public void setPos(int pos){
		this.pos = pos;
	}
	
	public char getColor(){
		return color;
	}
}
