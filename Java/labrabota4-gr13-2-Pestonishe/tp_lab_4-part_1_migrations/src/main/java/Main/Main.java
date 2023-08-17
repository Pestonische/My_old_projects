package Main;

import org.flywaydb.core.Flyway;

public class Main {
    final static String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    final static String DB_USER_LOGIN = "postgres";
    final static String DB_USER_PASSWORD = "password";

    public static void main(String[] args) {
        Flyway flyway = Flyway.configure().dataSource(DB_URL, DB_USER_LOGIN, DB_USER_PASSWORD)
                .load();
        flyway.clean();

        var result1 = flyway.migrate();

        System.out.println(result1.migrationsExecuted);
    }
}
