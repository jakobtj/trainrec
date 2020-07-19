package no.trainrec.core.data;

import no.trainrec.core.domain.ExerciseEntry;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TrainingRecord {
    private List<ExerciseEntry> entries;
    private StorageInterface storage;

    public TrainingRecord(StorageInterface inputStorage) {
        storage = inputStorage;
        entries = storage.load();
    }

    public List<ExerciseEntry> listEntries() {
        sort();
        return entries;
    }

    public void addEntry(ExerciseEntry entry) {
        entries.add(entry);
    }

    public void save() {
        storage.save(entries);
    }

    private void sort() {
        Collections.sort(entries, ExerciseEntry.sortByDate);
    }
}
