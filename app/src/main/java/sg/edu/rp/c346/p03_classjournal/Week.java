package sg.edu.rp.c346.p03_classjournal;

import java.io.Serializable;

public class Week implements Serializable {
    private int week;
    private String grade;

    public Week(int week, String grade) {
        this.week = week;
        this.grade = grade;
    }

    public int getWeek() {
        return week;
    }

    public String getGrade() {
        return grade;
    }
}