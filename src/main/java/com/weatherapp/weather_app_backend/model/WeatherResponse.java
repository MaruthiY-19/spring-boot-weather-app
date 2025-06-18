package com.weatherapp.weather_app_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    private Coord coord;
    private Weather[] weather;
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;
    private Rain rain;
    private Snow snow;

    // Inner classes for nested JSON objects
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Coord {
        private double lon;
        private double lat;

        // Getters and setters
        public double getLon() { return lon; }
        public void setLon(double lon) { this.lon = lon; }
        public double getLat() { return lat; }
        public void setLat(double lat) { this.lat = lat; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Weather {
        private int id;
        private String main;
        private String description;
        private String icon;

        // Getters and setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getMain() { return main; }
        public void setMain(String main) { this.main = main; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        public String getIcon() { return icon; }
        public void setIcon(String icon) { this.icon = icon; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Main {
        private double temp;
        @JsonProperty("feels_like")
        private double feelsLike;
        @JsonProperty("temp_min")
        private double tempMin;
        @JsonProperty("temp_max")
        private double tempMax;
        private int pressure;
        private int humidity;

        // Getters and setters
        public double getTemp() { return temp; }
        public void setTemp(double temp) { this.temp = temp; }
        public double getFeelsLike() { return feelsLike; }
        public void setFeelsLike(double feelsLike) { this.feelsLike = feelsLike; }
        public double getTempMin() { return tempMin; }
        public void setTempMin(double tempMin) { this.tempMin = tempMin; }
        public double getTempMax() { return tempMax; }
        public void setTempMax(double tempMax) { this.tempMax = tempMax; }
        public int getPressure() { return pressure; }
        public void setPressure(int pressure) { this.pressure = pressure; }
        public int getHumidity() { return humidity; }
        public void setHumidity(int humidity) { this.humidity = humidity; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Wind {
        private double speed;
        private int deg;
        private Double gust;

        // Getters and setters
        public double getSpeed() { return speed; }
        public void setSpeed(double speed) { this.speed = speed; }
        public int getDeg() { return deg; }
        public void setDeg(int deg) { this.deg = deg; }
        public Double getGust() { return gust; }
        public void setGust(Double gust) { this.gust = gust; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Clouds {
        private int all;

        // Getters and setters
        public int getAll() { return all; }
        public void setAll(int all) { this.all = all; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Sys {
        private int type;
        private int id;
        private String country;
        private long sunrise;
        private long sunset;

        // Getters and setters
        public int getType() { return type; }
        public void setType(int type) { this.type = type; }
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getCountry() { return country; }
        public void setCountry(String country) { this.country = country; }
        public long getSunrise() { return sunrise; }
        public void setSunrise(long sunrise) { this.sunrise = sunrise; }
        public long getSunset() { return sunset; }
        public void setSunset(long sunset) { this.sunset = sunset; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Rain {
        @JsonProperty("1h")
        private Double oneHour;
        @JsonProperty("3h")
        private Double threeHours;

        // Getters and setters
        public Double getOneHour() { return oneHour; }
        public void setOneHour(Double oneHour) { this.oneHour = oneHour; }
        public Double getThreeHours() { return threeHours; }
        public void setThreeHours(Double threeHours) { this.threeHours = threeHours; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Snow {
        @JsonProperty("1h")
        private Double oneHour;
        @JsonProperty("3h")
        private Double threeHours;

        // Getters and setters
        public Double getOneHour() { return oneHour; }
        public void setOneHour(Double oneHour) { this.oneHour = oneHour; }
        public Double getThreeHours() { return threeHours; }
        public void setThreeHours(Double threeHours) { this.threeHours = threeHours; }
    }

    // Getters and setters for main class
    public Coord getCoord() { return coord; }
    public void setCoord(Coord coord) { this.coord = coord; }
    public Weather[] getWeather() { return weather; }
    public void setWeather(Weather[] weather) { this.weather = weather; }
    public String getBase() { return base; }
    public void setBase(String base) { this.base = base; }
    public Main getMain() { return main; }
    public void setMain(Main main) { this.main = main; }
    public int getVisibility() { return visibility; }
    public void setVisibility(int visibility) { this.visibility = visibility; }
    public Wind getWind() { return wind; }
    public void setWind(Wind wind) { this.wind = wind; }
    public Clouds getClouds() { return clouds; }
    public void setClouds(Clouds clouds) { this.clouds = clouds; }
    public long getDt() { return dt; }
    public void setDt(long dt) { this.dt = dt; }
    public Sys getSys() { return sys; }
    public void setSys(Sys sys) { this.sys = sys; }
    public int getTimezone() { return timezone; }
    public void setTimezone(int timezone) { this.timezone = timezone; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getCod() { return cod; }
    public void setCod(int cod) { this.cod = cod; }
    public Rain getRain() { return rain; }
    public void setRain(Rain rain) { this.rain = rain; }
    public Snow getSnow() { return snow; }
    public void setSnow(Snow snow) { this.snow = snow; }
}