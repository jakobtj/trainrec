package trainrec;

class Exercise {
    private String name;

    public Exercise(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        Exercise other = (Exercise) object;
        return name.equals(other.name);
    }
}
