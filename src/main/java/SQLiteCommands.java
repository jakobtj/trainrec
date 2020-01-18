public class SQLiteCommands {
    // Facilitate cross platform databases by defining
    // common SQLite commands
    public static String createTable() {
        return "CREATE TABLE IF NOT EXISTS TRAININGRECORD (\n"
            + "    DATE text,\n"
            + "    NAME text\n"
            + ");";
    }

    public static String insertEntry() {
        return "INSERT INTO TRAININGRECORD(DATE, NAME) VALUES(?,?);";
    }

    public static String selectAll() {
        return "SELECT * FROM TRAININGRECORD";
    }
}
