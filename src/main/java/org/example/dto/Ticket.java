package org.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.config.LocalTimeDeserializer;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Ticket {

    @JsonSetter("origin")
    private String origin;

    @JsonSetter("origin_name")
    private String originName;

    @JsonSetter("destination")
    private String destination;

    @JsonSetter("destination_name")
    private String destinationName;

    @JsonSetter("departure_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yy")
    private LocalDate departureDate;

    @JsonSetter("departure_time")
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime departureTime;

    @JsonSetter("arrival_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yy")
    private LocalDate arrivalDate;

    @JsonSetter("arrival_time")
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime arrivalTime;

    @JsonSetter("carrier")
    private String carrier;

    @JsonSetter("stops")
    private int stops;

    @JsonSetter("price")
    private int price;
}
