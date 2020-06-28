package no.trainrec.core;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TrainingRecord {
    private List<ExerciseEntry> entries;
    private StorageInterface storage;

    public TrainingRecord() {
        entries = new ArrayList<ExerciseEntry>();
    }

    public List<ExerciseEntry> listEntries() {
        sort();
        return entries;
    }

    public void addEntry(ExerciseEntry entry) {
        entries.add(entry);
    }

    public void setStorage(StorageInterface newStorage) {
        storage = newStorage;
    }

    public void save() {
        storage.save(this);
    }

    public static TrainingRecord load(StorageInterface storage) {
        return storage.load();
    }

    private void sort() {
        Collections.sort(entries, ExerciseEntry.sortByDate);
    }
}
