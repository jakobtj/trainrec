package trainrec;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class CSVConverter {
    private static DateTimeFormatter formatter = 
        DateTimeFormatter.ofPattern("yyyy.MM.dd");

    public static ExerciseEntry fromString(String inString) {
        String[] splitString = inString.split(";");
        LocalDate date = LocalDate.parse(splitString[0], formatter);
        Exercise exercise = new Exercise(splitString[1]);
        return new ExerciseEntry(date, exercise);
    }

    public static String toString(ExerciseEntry entry) {
        String date = entry.getDate().format(formatter);
        return date + ";" + entry.getExercise().getName();
    }
}
