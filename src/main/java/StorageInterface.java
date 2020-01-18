package trainrec;

public interface StorageInterface {
    void save(TrainingRecord rec);
    TrainingRecord load();
}
