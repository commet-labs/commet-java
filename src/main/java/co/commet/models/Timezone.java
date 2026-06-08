package co.commet.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Timezone {
    UTC("UTC"),
    AMERICA_NEW_YORK("America/New_York"),
    AMERICA_CHICAGO("America/Chicago"),
    AMERICA_DENVER("America/Denver"),
    AMERICA_LOS_ANGELES("America/Los_Angeles"),
    AMERICA_SAO_PAULO("America/Sao_Paulo"),
    AMERICA_MEXICO_CITY("America/Mexico_City"),
    AMERICA_BUENOS_AIRES("America/Buenos_Aires"),
    AMERICA_SANTIAGO("America/Santiago"),
    AMERICA_BOGOTA("America/Bogota"),
    AMERICA_LIMA("America/Lima"),
    AMERICA_ASUNCION("America/Asuncion"),
    EUROPE_LONDON("Europe/London"),
    EUROPE_PARIS("Europe/Paris"),
    EUROPE_BERLIN("Europe/Berlin"),
    EUROPE_MADRID("Europe/Madrid"),
    ASIA_TOKYO("Asia/Tokyo"),
    ASIA_SHANGHAI("Asia/Shanghai"),
    ASIA_SINGAPORE("Asia/Singapore"),
    ASIA_DUBAI("Asia/Dubai"),
    AUSTRALIA_SYDNEY("Australia/Sydney");

    private final String value;

    Timezone(String value) { this.value = value; }

    @JsonValue
    public String getValue() { return value; }

    @JsonCreator
    public static Timezone fromValue(String value) {
        for (Timezone type : values()) {
            if (type.value.equals(value)) return type;
        }
        throw new IllegalArgumentException("Unknown Timezone: " + value);
    }
}
