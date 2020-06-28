package no.trainrec.core;

import java.util.Iterator;
import java.util.List;

public class EntryIterator implements Iterator<ExerciseEntry> {
    private Iterator<ExerciseEntry> entries;

    public EntryIterator(TrainingRecord rec) {
        entries = rec.listEntries().iterator();
    }

    public boolean hasNext() {
        return entries.hasNext();
    }

    public ExerciseEntry next() {
        return entries.next();
    }
}
