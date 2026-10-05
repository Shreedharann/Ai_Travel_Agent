package com.substring.agent.backend.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class WeatherTools {

    // getForecast

    // apis to get forecast

    @Tool(name = "getForecast", description = "Get the weather forecast for a specific city and date. Returns the temperature, weather conditions, and humidity.")
    public String getForecast(String city, String date) {
        // Placeholder implementation for getting weather forecast
        return city + " on " + date + ": 31°C, light rain, humidity 78%";
    }
}
