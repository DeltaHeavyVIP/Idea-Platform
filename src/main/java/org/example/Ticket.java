package org.example;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private String departureDate;

    @JsonSetter("departure_time")
    private String departureTime;

    @JsonSetter("arrival_date")
    private String arrivalDate;

    @JsonSetter("arrival_time")
    private String arrivalTime;

    @JsonSetter("carrier")
    private String carrier;

    @JsonSetter("stops")
    private int stops;

    @JsonSetter("price")
    private int price;
}
