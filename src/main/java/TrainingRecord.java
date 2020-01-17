package trainrec;

import java.util.ArrayList;
import java.util.Collections;

public class TrainingRecord {
    private ArrayList<ExerciseEntry> entries;
    private EntryDate activeDate;
    private StorageInterface storage;

    public TrainingRecord() {
        entries = new ArrayList<ExerciseEntry>();
        activeDate = EntryDate.today();
    }

    public ArrayList<ExerciseEntry> listEntries() {
        sort();
        return entries;
    }

    public void addEntry(String exercise) {
        ExerciseEntry entry = new ExerciseEntry(activeDate.toString(), exercise);
        entries.add(entry);
    }

    public void setActiveDate(EntryDate date) {
        activeDate = date;
    }

    public void setStorage(StorageInterface storage) {
        this.storage = storage;
    }

    public void save() {
        storage.save(this);
    }

    public EntryDate getActiveDate() {
        return activeDate;
    }

    private void sort() {
        Collections.sort(entries, ExerciseEntry.sortByDate);
    }
}
