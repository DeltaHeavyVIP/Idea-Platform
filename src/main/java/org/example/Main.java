package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.InputObject;
import org.example.dto.Ticket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/resource/tickets.json"));
        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
        List<Ticket> tickets = objectMapper.readValue(br, InputObject.class).getTickets();

        //Минимальное время полета между городами Владивосток и Тель-Авив для каждого авиаперевозчика
        HashMap<String, Duration> carrierDuration = new HashMap<>();
        tickets.stream().filter(ticket -> ticket.getOrigin().equals("VVO") && ticket.getDestination().equals("TLV"))
                .forEach(ticket -> {
                    LocalDateTime arrivalLocalDateTime = LocalDateTime.of(ticket.getArrivalDate(), ticket.getArrivalTime());
                    LocalDateTime departureLocalDateTime = LocalDateTime.of(ticket.getDepartureDate(), ticket.getDepartureTime());
                    Duration difference = Duration.between(departureLocalDateTime, arrivalLocalDateTime);

                    carrierDuration.put(ticket.getCarrier(), carrierDuration.containsKey(ticket.getCarrier()) ?
                            carrierDuration.get(ticket.getCarrier()).getSeconds() > difference.getSeconds() ? difference :
                                    carrierDuration.get(ticket.getCarrier()) : difference);
                });

        System.out.println("Минимальное время полета между городами Владивосток и Тель-Авив для каждого авиаперевозчика:");
        for (Map.Entry<String, Duration> entry : carrierDuration.entrySet()) {
            System.out.printf("Компания: %s; Время полета: %02d:%02d:%02d%n",
                    entry.getKey(), entry.getValue().toHours(), entry.getValue().toMinutesPart(), entry.getValue().toSecondsPart());
        }

        //Разницу между средней ценой и медианой для полета между городами Владивосток и Тель-Авив
        List<Ticket> list =
                tickets.stream().filter(ticket -> ticket.getOrigin().equals("VVO") && ticket.getDestination().equals(
                        "TLV")).sorted((ticket1, ticket2) -> -1 * Integer.compare(ticket2.getPrice(),
                        ticket1.getPrice())).toList();
        double sum = list.stream().mapToInt(Ticket::getPrice).sum();
        double medium = list.size() % 2 == 0 ?
                (list.get((list.size() / 2) - 1).getPrice() + list.get((list.size() / 2)).getPrice()) / 2 :
                list.get((list.size() / 2)).getPrice();
        System.out.println("Разницу между средней ценой и медианой для полета между городами Владивосток и Тель-Авив:");
        System.out.println((sum / list.size()) - medium);
    }
}

