package ru.testing.utils.elegant.dates.enums

enum DateTimeFormatEnum {
    // Global и SQL-standard
    SQL_DATE("yyyy-MM-dd"),                         // DATE: 2024-04-27
    SQL_DATETIME("yyyy-MM-dd HH:mm:ss"),            // DATETIME/TIMESTAMP: 2024-04-27 15:30:00
    SQL_TIMESTAMP("yyyy-MM-dd HH:mm:ss"),           // TIMESTAMP: 2024-04-27 15:30:00
    SQL_TIMESTAMP_TZ("yyyy-MM-dd HH:mm:ssXXX"),     // TIMESTAMP WITH TIME ZONE: 2024-04-27 15:30:00+03:00
    SQL_TIME("HH:mm:ss"),                           // TIME: 15:30:00

    // ISO and RFC
    ISO_DATE("yyyy-MM-dd"),                         // ISO 8601 date
    ISO_DATETIME("yyyy-MM-dd'T'HH:mm:ss"),          // ISO 8601 datetime: 2024-04-27T15:30:00
    ISO_DATETIME_TZ("yyyy-MM-dd'T'HH:mm:ssX"),      // ISO 8601 with zone: 2024-04-27T15:30:00Z

    // Russian local format
    RUSSIAN_DATE("dd.MM.yyyy"),                     // 27.04.2024
    RUSSIAN_DATETIME("dd.MM.yyyy HH:mm:ss"),        // 27.04.2024 15:30:00

    // American/Global
    US_DATE("MM/dd/yyyy"),                          // 04/27/2024
    US_DATETIME("MM/dd/yyyy HH:mm:ss"),             // 04/27/2024 15:30:00

    // UNIX Timestamp (special, for reference)
    UNIX_TIMESTAMP("UNIX_TIMESTAMP")                // seconds since epoch

    private final String pattern

    DateTimeFormatEnum(String pattern) {
        this.pattern = pattern
    }

    String getPattern() {
        return pattern
    }
}
