package chapter_03_arrays_and_linked_lists;

public class GameEntry {
    private String name;
    private int score;
    /** Constructs a game entry with given parameters */
    public GameEntry(String n, int s) {
        this.name = n;
        this.score = s;
    }
    /** Returns the name field */
    public String getName() { return name; }
    /** Returns the score field */
    public int getScore() { return score; }
    /** Returns a string representation of this entry */
    public String toString() {
        return "(" + name + ", " + score + ")";
    }
}
