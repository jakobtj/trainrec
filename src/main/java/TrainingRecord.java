package trainrec;

import java.util.ArrayList;

class TrainingRecord {
    private ArrayList<ExerciseEntry> entries;

    public TrainingRecord() {
        entries = new ArrayList();
    }

    void add(ExerciseEntry entry) {
        entries.add(entry);
    }

    boolean contains(ExerciseEntry entry) {
        return entries.contains(entry);
    }

    int getExerciseCount() {
        return entries.size();
    }

}
