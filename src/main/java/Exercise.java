package trainrec;

public class Exercise {
    private String name;

    public Exercise(String name) {
        this.name = name;
    }

    public boolean equals(Object object) {
        Exercise other = (Exercise) object;
        return name == other.name;
    }
}
