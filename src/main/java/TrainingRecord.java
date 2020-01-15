package trainrec;

import java.util.ArrayList;
import java.util.Collections;

public class TrainingRecord {
    private ArrayList<ExerciseEntry> entries;
    private Date activeDate;

    public TrainingRecord() {
        entries = new ArrayList();
        activeDate = Date.today();
    }

    public ArrayList<ExerciseEntry> listEntries() {
        sort();
        return entries;
    }

    public void addEntry(String exercise) {
        ExerciseEntry entry = new ExerciseEntry(activeDate.toString(), exercise);
        entries.add(entry);
    }

    public void setActiveDate(Date date) {
        activeDate = date;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    private void sort() {
        Collections.sort(entries, ExerciseEntry.sortByDate);
    }
}
