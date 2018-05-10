package chapter_03_arrays_and_linked_lists;

/** Class for storing high scores in an array in nondecreasing order */
public class ScoreBoard {
    private int numEntries = 0;     // Number of actual entries
    private GameEntry[] board;      // Array of game entries (names & scores)
    /** Constructs an empty scoreboard with the given capacity for storing entries */
    public ScoreBoard(int capacity) {
        board = new GameEntry[capacity];
    }

    /** Attempt to add a new score to the collection (if it is high enough) */
    public void add(GameEntry e)  {
        int newScore = e.getScore();

        if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
            if(numEntries < board.length){
                numEntries++;
            }

            int j = numEntries - 1;
            while(j > 0 && board[j - 1].getScore() < newScore) {
                board[j] = board[j - 1];
                j--;
            }
            board[j] = e;
        }
    }

    /** Remove and return the high score at index i */
    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if(i < 0 || i >= numEntries) {
            throw new IndexOutOfBoundsException("Invalid index : " + i);
        }
        GameEntry temp = board[i];
        for(int j = i; j < numEntries - 1; j++) {
            board[j] = board[j + 1];
        }
        board[numEntries - 1] = null;
        numEntries--;
        return temp;
    }
}
