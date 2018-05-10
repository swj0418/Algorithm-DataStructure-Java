package chapter_03_arrays_and_linked_lists;

public class GameMain {
    public static void main(String ar[]) {
        GameEntry entry_01 = new GameEntry("James", 1000);
        ScoreBoard board = new ScoreBoard(3);
        board.add(entry_01);
        System.out.println(entry_01.toString());
    }
}
