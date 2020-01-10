package trainrec;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class CSVConverter {
    private static DateTimeFormatter formatter = 
        DateTimeFormatter.ofPattern("yyyy.MM.dd");

    public static ExerciseEntry fromString(String inString) {
        String[] splitString = inString.split(";");
        LocalDate date = LocalDate.parse(splitString[0], formatter);
        return new ExerciseEntry(date, new Exercise(splitString[1]));
    }
}
