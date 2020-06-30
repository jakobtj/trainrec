package no.trainrec.core;

public interface StorageInterface {
    void save(TrainingRecord rec);
    TrainingRecord load();
}
