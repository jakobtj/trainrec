package no.trainrec.core.data;

import no.trainrec.core.domain.ExerciseEntry;

import java.util.List;

public interface StorageInterface {
    void save(List<ExerciseEntry> entries);
    List<ExerciseEntry> load();
}
