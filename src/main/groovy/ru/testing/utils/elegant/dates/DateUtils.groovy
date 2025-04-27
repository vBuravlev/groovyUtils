package ru.testing.utils.elegant.dates


import groovy.transform.Memoized
import ru.testing.utils.elegant.dates.enums.ChronoUnitEnum
import ru.testing.utils.elegant.dates.enums.DateTimeFormatEnum
import ru.testing.utils.elegant.dates.enums.ZoneProfileEnum

import java.time.ZonedDateTime
import java.time.ZoneId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DateUtils {
    private final String pattern
    private final ZoneId zoneId

    DateUtils(final DateTimeFormatEnum format, final ZoneProfileEnum zone) {
        this.pattern = format.getPattern()
        this.zoneId = zone.getZoneId()
    }

    ZonedDateTime now() {
        return ZonedDateTime.now(zoneId)
    }

    String nowToString() {
        return formatDate(now())
    }

    String shiftedDays(long stepAmount, ZonedDateTime base = now()) {
        return formatDate(shift(base, ChronoUnitEnum.DAYS, stepAmount))
    }

    String shiftedYears(long stepAmount, ZonedDateTime base = now()) {
        return formatDate(shift(base, ChronoUnitEnum.YEARS, stepAmount))
    }

    String shiftedMonth(long stepAmount, ZonedDateTime base = now()) {
        return formatDate(shift(base, ChronoUnitEnum.MONTHS, stepAmount))
    }

    String shiftedHours(long stepAmount, ZonedDateTime base = now()) {
        return formatDate(shift(base, ChronoUnitEnum.HOURS, stepAmount))
    }

    String shiftedMinutes(long stepAmount, ZonedDateTime base = now()) {
        return formatDate(shift(base, ChronoUnitEnum.MINUTES, stepAmount))
    }

    String shiftedSeconds(long stepAmount, ZonedDateTime base = now()) {
        return formatDate(shift(base, ChronoUnitEnum.SECONDS, stepAmount))
    }

    List<String> getDateTimeList(ZonedDateTime from, ZonedDateTime to, ChronoUnitEnum chronoUnit, long stepAmount = 1) {
        checkInvariant(from, to)
        List<String> results = buildDateList(from, to, chronoUnit, stepAmount)
        return results
    }

    static ZonedDateTime randomDateBetween(ZonedDateTime from, ZonedDateTime to, ChronoUnitEnum chronoUnit) {
        long duration = chronoUnit.getUnit().between(from, to)
        long random = new Random().nextLong(duration + 1)
        return from.plus(random, chronoUnit.getUnit())
    }

    ZonedDateTime parseDateString(String dateString, String patternDate = pattern) {
        return LocalDateTime.parse(dateString, formatterByPattern(patternDate)).atZone(zoneId)
    }

    ZonedDateTime convertLocalDateTime(LocalDateTime ldt) {
        return ldt.atZone(zoneId)
    }

    //------------------------------------Private-------------------------------------//

    private List<String> buildDateList(ZonedDateTime from, ZonedDateTime to, ChronoUnitEnum chronoUnit, long stepAmount) {
        List<String> results = []
        ZonedDateTime current = from
        while (!current.isAfter(to)) {
            results << formatDate(current)
            current = current.plus(stepAmount, chronoUnit.getUnit())
        }
        return results
    }

    @Memoized(maxCacheSize = 5)
    private DateTimeFormatter formatterByPattern(String patternString = pattern) {
        return DateTimeFormatter.ofPattern(patternString).withZone(zoneId)
    }

    private static ZonedDateTime shift(ZonedDateTime base, ChronoUnitEnum chronoUnit, long stepAmount) {
        return ZonedDateTime.from(base).plus(stepAmount, chronoUnit.getUnit())
    }

    private String formatDate(ZonedDateTime date, String patternString = pattern) {
        return date.withZoneSameInstant(zoneId).format(formatterByPattern(patternString))
    }

    private static checkInvariant(ZonedDateTime from, ZonedDateTime to) {
        if (from.isAfter(to)) {
            throw new IllegalArgumentException("Invalid range: from $from must be before to $to")
        }
    }

}