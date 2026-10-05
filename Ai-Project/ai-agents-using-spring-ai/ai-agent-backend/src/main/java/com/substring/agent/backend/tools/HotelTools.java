package com.substring.agent.backend.tools;

import java.util.List;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import com.substring.agent.backend.model.Hotel;

@Component
public class HotelTools {

    private final List<Hotel> hotels = List.of(
            new Hotel("Sea Breeze Resort", "Goa", 2200, 4.3),
            new Hotel("Budget Stay Inn", "Goa", 1100, 3.8),
            new Hotel("Palm Grove Villas", "Goa", 3500, 4.7),
            new Hotel("City Center Hotel", "Mumbai", 3000, 4.1),
            new Hotel("Luxury Suites", "Mumbai", 5000, 4.9),
            new Hotel("Heritage Inn", "Mumbai", 2500, 4.0));

    // search hotel
    // apis to search hotel

    @Tool(name = "searchHotel", description = "Search for hotels based on city and maximum price per night. Returns a list of available hotels with their prices and ratings.")
    public String searchHotel(String city, int maxPrice) {
        StringBuilder result = new StringBuilder();
        for (Hotel hotel : hotels) {
            if (hotel.city().equalsIgnoreCase(city) && hotel.pricePerNightINR() <= maxPrice) {
                result.append("Hotel Name: ").append(hotel.name())
                        .append(", Price per Night: ").append(hotel.pricePerNightINR())
                        .append(", Rating: ").append(hotel.rating()).append(", ");
            }
        }
        return result.length() > 0 ? result.toString() : "No hotels found for the given criteria.";
    }

    // hotel status

    // hotel booking

}
