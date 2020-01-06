package domain;

import java.util.Date;

public class Exercise {
    private String name;
    private Date date;

    public Exercise(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }
}
