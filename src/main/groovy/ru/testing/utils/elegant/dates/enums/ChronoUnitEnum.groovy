package ru.testing.utils.elegant.dates.enums

import java.time.temporal.ChronoUnit

enum ChronoUnitEnum {

    SECONDS(ChronoUnit.SECONDS),
    MINUTES(ChronoUnit.MINUTES),
    HOURS(ChronoUnit.HOURS),
    DAYS(ChronoUnit.DAYS),
    MONTHS(ChronoUnit.MONTHS),
    YEARS(ChronoUnit.YEARS)

    private final ChronoUnit unit

    private ChronoUnitEnum(ChronoUnit unit) {
        this.unit = unit
    }

    ChronoUnit getUnit() {
       return unit
    }

}