package no.trainrec.core.data;

public interface StorageInterface {
    void save(TrainingRecord rec);
    TrainingRecord load();
}
