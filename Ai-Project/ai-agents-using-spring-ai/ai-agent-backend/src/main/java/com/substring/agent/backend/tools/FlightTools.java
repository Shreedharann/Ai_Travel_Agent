package com.substring.agent.backend.tools;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import com.substring.agent.backend.model.Flight;

@Component
public class FlightTools {

    private final List<Flight> flights = List.of(
            new Flight("IndiGo", "Delhi", "Goa", "2026-08-21", 4200),
            new Flight("Air India", "Delhi", "Goa", "2026-08-21", 5600),
            new Flight("SpiceJet", "Delhi", "Goa", "2026-08-21", 3900),
            new Flight("IndiGo", "Delhi", "Mumbai", "2026-08-21", 3500),
            new Flight("Air India", "Delhi", "Mumbai", "2026-08-21", 4800),
            new Flight("SpiceJet", "Delhi", "Mumbai", "2026-08-21", 3200));

    // search flight
    // apis to search flight

    @Tool(name = "searchFlight", description = "Search for flights based on source, destination, and date. Returns a list of available flights with their prices.")
    public String searchFlight(String source, String destination, String date) {

        List<Flight> filteredFlights = flights.stream()
                .filter(f -> f.getSource().equalsIgnoreCase(source) && f.getDestination().equalsIgnoreCase(destination)
                        && f.getDate().equals(date))
                .toList();

        if (filteredFlights.isEmpty()) {
            return "No flights found for the given criteria.";
        }

        return filteredFlights.stream()
                .map(f -> f.getAirline() + " : $ " + f.getPrice())
                .collect(Collectors.joining(", "));

        // StringBuilder result = new StringBuilder();
        // for (Flight flight : flights) {
        // if (flight.getSource().equalsIgnoreCase(source) &&
        // flight.getDestination().equalsIgnoreCase(destination) &&
        // flight.getDate().equals(date)) {
        // result.append("Airline: ").append(flight.getAirline())
        // .append(", Price: ").append(flight.getPrice()).append("\n");
        // }
        // }
        // return result.length() > 0 ? result.toString() : "No flights found for the
        // given criteria.";
    }

    // flight status

    // flight booking

}
