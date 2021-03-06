package Pieces;

public class Exceptions { // there are many exceptions to the rules when on the edges of the board, this class fixes that

	public static final int BOARD_SIZE = 8 * 8;

	public static boolean posExists(int destination) {
		return destination >= 0 && destination < BOARD_SIZE;
	}

	public static final boolean[] FIRST_COLUMN = defineColumn(0);
	public static final boolean[] SECOND_COLUMN = defineColumn(1);
	public static final boolean[] SEVENTH_COLUMN = defineColumn(6);
	public static final boolean[] EIGTH_COLUMN = defineColumn(7);

	private static boolean[] defineColumn(int colNum) {
		final boolean[] column = new boolean[BOARD_SIZE];
		do {
			column[colNum] = true;
			colNum += 8;
		} while (colNum < BOARD_SIZE);
		return column;
	}
	
	public static final boolean[] FIRST_ROW = defineRow(0);
	public static final boolean[] SECOND_ROW = defineRow(8);
	public static final boolean[] SEVENTH_ROW = defineRow(48);
	public static final boolean[] EIGTH_ROW = defineRow(56);
	
	private static boolean[] defineRow(int rowNum){
		final boolean[] row = new boolean[BOARD_SIZE];
		for (int i = 0; i < 8; i++)
			row[rowNum + i] = true;
		return row;
	}

	public static boolean isWrapping(Piece piece, int candidate, int destination) { // prevents wrapping around the board
		// bishop exceptions
		if (piece.getID() == 'b' || piece.getID() == 'B')
			if (FIRST_COLUMN[destination]) {
				return (candidate == -9 || candidate == 7);
			} else if (EIGTH_COLUMN[destination])
				return (candidate == -7 || candidate == 9);

		// king exceptions
		if (piece.getID() == 'k' || piece.getID() == 'K')
			if (FIRST_COLUMN[destination]) {
				return (candidate == -9 || candidate == -1 || candidate == 7);
			} else if (EIGTH_COLUMN[destination])
				return (candidate == -7 || candidate == 1 || candidate == 9);

		// knight exceptions
		if (piece.getID() == 'n' || piece.getID() == 'N')
			if (FIRST_COLUMN[destination]) {
				return (candidate == -17 || candidate == -10 || candidate == 6 || candidate == 15);
			} else if (SECOND_COLUMN[destination]) {
				return (candidate == -10 || candidate == 6);
			} else if (SEVENTH_COLUMN[destination]) {
				return (candidate == -6 || candidate == 10);
			} else if (EIGTH_COLUMN[destination])
				return (candidate == -15 || candidate == -6 || candidate == 10 || candidate == 17);

		// pawn exceptions
		if (piece.getID() == 'p' || piece.getID() == 'P')
			if (FIRST_COLUMN[destination] && piece.getColor() == 'b') {
				return (candidate == 7);
			} else if (EIGTH_COLUMN[destination] && piece.getColor() == 'w') {
				return (candidate == 7);
			} else if (FIRST_COLUMN[destination] && piece.getColor() == 'w') {
				return (candidate == 9);
			} else if (EIGTH_COLUMN[destination] && piece.getColor() == 'b')
				return (candidate == 9);
		
		// queen exceptions
		if (piece.getID() == 'q' || piece.getID() == 'Q')
			if (FIRST_COLUMN[destination]) {
				return (candidate == -9 || candidate == -1 || candidate == 7);
			} else if (EIGTH_COLUMN[destination])
				return (candidate == -7 || candidate == 1 || candidate == 9);

		// rook exceptions
		if (piece.getID() == 'r' || piece.getID() == 'R')
			if (FIRST_COLUMN[destination]) {
				return (candidate == -1);
			} else if (EIGTH_COLUMN[destination])
				return (candidate == 1);

		return false;
	}

}
