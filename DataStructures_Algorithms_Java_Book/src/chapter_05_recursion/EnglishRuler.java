package chapter_05_recursion;

public class EnglishRuler {
    EnglishRuler(int centimeters_to_draw) {
        drawRuler(centimeters_to_draw);
    }

    private void drawRuler(float track) {
        if(track < 0.0) {
            System.out.println("Ruler Printing Done.");
        } else if(track % 1 == 0) {
            drawMajor((int) track);
            drawRuler(track -= 0.25);
        } else if(track % 0.5 == 0) {
            drawMiddle(track);
            drawRuler(track -= 0.25);
        } else if(track % 0.25 == 0) {
            drawMinor(track);
            drawRuler(track -= 0.25);
        }
    }


    private void drawMajor(int centimeter) {
        System.out.println("----- " + centimeter);
    }
    private void drawMiddle(float centimeter) {
        System.out.println("--- " + centimeter);
    }
    private void drawMinor(float centimeter) {
        System.out.println("-");
    }
}
