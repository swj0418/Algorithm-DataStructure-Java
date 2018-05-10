package chapter_04_analysis_tools;

public class Empirical_Analysis {
    public static void main(String[] ar) {
        new Empirical_Analysis('*', 128);
    }

    Empirical_Analysis(char c, int steps) {
        long timeTotalStart = System.currentTimeMillis();
        long timeStart = System.currentTimeMillis();

        System.out.println(run_01(c, steps));
        System.out.println("Job 1 run time : " + (System.currentTimeMillis() - timeStart));
        timeStart = System.currentTimeMillis();

        System.out.println(run_02(c, steps));
        System.out.println("Job 2 run time : " + (System.currentTimeMillis() - timeStart));

        System.out.println("Total time run : " + (System.currentTimeMillis() - timeTotalStart) );
    }

    public String run_01(char c, int n) {
        String answer = "";
        for(int i = 0; i < n; i++) {
            answer += c;
        }
        return answer;
    }

    public String run_02(char c, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

}
