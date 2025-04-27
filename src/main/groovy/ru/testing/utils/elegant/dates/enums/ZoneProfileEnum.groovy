package ru.testing.utils.elegant.dates.enums

import java.time.ZoneId

enum ZoneProfileEnum {
    UTC('UTC'), // +00:00
    GMT('GMT'), // +00:00

    //Russian countries
    KALININGRAD('Europe/Kaliningrad'), // +02:00
    MOSCOW('Europe/Moscow'), // +03:00
    SAMARA('Europe/Samara'), // +04:00
    EKATERINBURG('Asia/Yekaterinburg'), // +05:00
    OMSK(' Asia/Omsk'), // +06:00
    NOVOSIBIRSK('Asia/Novosibirsk'), // +07:00
    KRASNOYARSK('Asia/Krasnoyarsk'), // +08:00
    YAKUTSK('Asia/Yakutsk'), // +09:00
    VLADIVOSTOK('Asia/Vladivostok'), // +10:00
    MAGADAN('Asia/Magadan'), // +11:00
    KAMCHATKA('Asia/Kamchatka'), // +12:00

    //By Hours
    PLUS_2("+02:00"),
    PLUS_3("+03:00"),
    PLUS_4("+04:00"),
    PLUS_5("+05:00"),
    PLUS_6("+06:00"),
    PLUS_7("+07:00"),
    PLUS_8("+08:00"),
    PLUS_9("+09:00"),
    PLUS_10("+10:00"),
    PLUS_11("+11:00"),
    PLUS_12("+12:00"),

    //Global
    NEW_YORK('America/New_York'),
    LONDON('Europe/London'),
    TOKYO('Asia/Tokyo'),
    PARIS('Europe/Paris'),
    BERLIN('Europe/Berlin'),
    BEIJING('Asia/Shanghai'),
    SYDNEY('Australia/Sydney')

    final String zoneId

    ZoneProfileEnum(String zoneId) {
        this.zoneId = zoneId
    }

    ZoneId getZoneId() {
        return ZoneId.of(zoneId)
    }

    String getZone() {
        return zoneId
    }
}
