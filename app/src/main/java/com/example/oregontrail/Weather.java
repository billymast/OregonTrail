// Weather Class
// Tracks and updates temperature, weather, rain amount, snow amount, and whether there is a drought
// Author: Billy Mast

package com.example.oregontrail;

public class Weather {

    // Class Variables
    private int temp;

    private String tempType;

    private int zone;

    /*
    0 = No Precipitation
    1 = Rain
    2 = Heavy Rain
    3 = Snow
    4 = Heavy Snow
     */
    private int weatherType;
    private final int noPrecipitation = 0;
    private final int lightRain = 1;
    private final int heavyRain = 2;
    private final int lightSnow = 3;
    private final int heavySnow = 4;

    private double rainAmount;

    private double snowAmount;

    private boolean isDrought;
    private boolean isSevereDrought;

    // Zone Variables

    private final int[][] temperatures =
            {
                    // Zone 1
                    {60,60,60,60,60,60,60,60,60,60,60,60},
                    // Zone 2
                    {60,60,60,60,60,60,60,60,60,60,60,60},
                    // Zone 3
                    {60,60,60,60,60,60,60,60,60,60,60,60},
                    // Zone 4
                    {60,60,60,60,60,60,60,60,60,60,60,60},
                    // Zone 5
                    {60,60,60,60,60,60,60,60,60,60,60,60},
                    // Zone 6
                    {60,60,60,60,60,60,60,60,60,60,60,60}
            };

    private final double[][] precipitationChances =
            {
                    // Zone 1
                    {0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2},
                    // Zone 2
                    {0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2},
                    // Zone 3
                    {0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2},
                    // Zone 4
                    {0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2},
                    // Zone 5
                    {0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2},
                    // Zone 6
                    {0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2,0.2}
            };


    // Constructor

    public Weather(){
        temp = 60;
        tempType = "warm";
        zone = 1;
        weatherType = 0;
        rainAmount = 0.0001;
        snowAmount = 0.0001;
        isDrought = false;
        isSevereDrought = false;
    }


    // Getters and Setters

    // getTemp - returns the current temperature
    // @return temp - current temperature
    public int getTemp() {
        return temp;
    }

    // setTemp - sets the temperature to entered temperature
    // @param temp - temperature to change to
    public void setTemp(int temp) {
        this.temp = temp;
    }

    // getTempType - returns the current temperature type
    // @return tempType - current temperature type
    public String getTempType() {
        return tempType;
    }

    // setTempType - sets the temperature type to entered temperature type
    // @param temp - temperature type to change to
    public void setTempType(String tempType) {
        this.tempType = tempType;
    }

    // getZone - returns the current zone
    // @return zone - current zone
    public int getZone() {
        return zone;
    }

    // setZone - sets the zone to entered zone
    // @param zone - zone to change to
    public void setZone(int zone) {
        this.zone = zone;
    }

    // getRainAmount - returns the current rain amount
    // @return rainAmount - current rain amount
    public double getRainAmount() {
        return rainAmount;
    }

    // setRainAmount - sets the rain amount to entered rain amount
    // @param rainAmount - rain amount to change to
    public void setRainAmount(double rainAmount) {
        this.rainAmount = rainAmount;
    }

    // getSnowAmount - returns the current snow amount
    // @return snowAmount - current snow amount
    public double getSnowAmount() {
        return snowAmount;
    }

    // setSnowAmount - sets the snow amount to entered snow amount
    // @param snowAmount - snow amount to change to
    public void setSnowAmount(double snowAmount) {
        this.snowAmount = snowAmount;
    }

    // getWeatherType - returns weather type
    // 0 = no precipitation, 1 = light rain, 2 = heavy rain, 3 = light snow, 4 = heavy snow
    // @return weatherType - current weather type
    public int getWeatherType() {
        return weatherType;
    }

    // setWeatherType - sets the weather type to entered weather type
    // 0 = no precipitation, 1 = light rain, 2 = heavy rain, 3 = light snow, 4 = heavy snow
    // @param weatherType - weather type to change to
    public void setWeatherType(int weatherType) {
        this.weatherType = weatherType;
    }

    // isDrought - returns true if there is a drought / false otherwise
    // @return isDrought - true or false
    public boolean isDrought() {
        return isDrought;
    }

    // setDrought - sets whether there is a drought currently
    // @param drought - true if there is a drought / false otherwise
    public void setDrought(boolean drought) {
        isDrought = drought;
    }

    // isSevereDrought - returns true if there is a severe drought / false otherwise
    // @return isSevereDrought - true or false
    public boolean isSevereDrought() {
        return isSevereDrought;
    }


    // setSevereDrought - sets whether there is a severe drought currently
    // @param severeDrought - true if there is a severe drought / false otherwise
    public void setSevereDrought(boolean severeDrought) {
        isSevereDrought = severeDrought;
    }


    // Helper Methods

    public String weatherTypeString() {
        if (this.weatherType == 0) { return "No Precipitation"; }
        else if (this.weatherType == 1) { return "Light Rain"; }
        else if (this.weatherType == 2) { return "Heavy Rain"; }
        else if (this.weatherType == 3) { return "Light Snow"; }
        else { return "Heavy Snow"; }
    }

    // updateTempType - Takes number temp and updates category for temp
    public void updateTempType() {
        if (getTemp() < 10) { setTempType("very cold"); }
        else if (getTemp() <= 30) { setTempType("cold"); }
        else if (getTemp() <= 50) { setTempType("cool"); }
        else if (getTemp() <= 70) { setTempType("warm"); }
        else if (getTemp() <= 90) { setTempType("hot"); }
        else { setTempType("very hot"); }
    }

    // adjustTemp - Randomly adds or subtracts up to 20 to or from the temperature
    public void adjustTemp(Time time) {
        int startTemp = temperatures[this.zone][time.getMonth()];
        int adjustment = ((int)(Math.random() * 41)) - 20;
        this.temp = startTemp + adjustment;
    }

    // dailyPrecipitation - Determines whether no precipitation, light rain, heavy rain, light snow, or heavy snow
    public void dailyPrecipitation(Time time) {
        // 50% chance for no change in weather
        if (Math.random() < 0.5) {
            this.weatherType = 0;
            // Chance for Precipitation
            if (Math.random() < precipitationChances[zone][time.getMonth()]) {
                this.weatherType += 1;
                // Chance of Heavy Precipitation
                if (Math.random() < 0.3) { this.weatherType += 1; }
                // Does it Snow?
                if (this.temp <= 30) { this.weatherType += 2; }
            }
        }
    }

    // updateRainfall - Updates the amount of rainfall and snowfall on the ground
    public void updateRainfall() {
        final double dailyRainfallDiminish = 0.1;
        final double dailyFastSnowDiminish = 5.0;
        final double dailySlowSnowDiminish = 0.03;
        final double lightRainAccumulation = 0.2;
        final double heavyRainAccumulation = 0.8;
        final double lightSnowAccumulation = 2.0;
        final double heavySnowAccumulation = 8.0;
        final double snowMelt = 0.5;
        final double minSnowAmount = 0.0001;

        // Updates Rainfall Amount
        this.rainAmount = this.rainAmount * (1 - dailyRainfallDiminish);
        if (this.weatherType == lightRain) { this.rainAmount = this.rainAmount + lightRainAccumulation; }
        if (this.weatherType == heavyRain) { this.rainAmount = this.rainAmount + heavyRainAccumulation; }

        // Updates Snowfall Amount

        // Fast snow melt conditions
        if (this.tempType.equals("warm") || this.tempType.equals("hot") || this.tempType.equals("very hot") || this.weatherType == heavyRain) {
            // If snow amount is less than 5 inches
            if (this.snowAmount <= 5.0) {
                this.snowAmount = minSnowAmount;
            }
            // If snow amount is greater than 5 inches
            else {
                this.snowAmount -= dailyFastSnowDiminish;
            }
            this.rainAmount += snowMelt;
        }
        // Slow snow melt conditions
        else {
            this.snowAmount = this.snowAmount * (1 - dailySlowSnowDiminish);
        }
        // If snowing accumulation
        if (this.weatherType == lightSnow) { this.snowAmount += lightSnowAccumulation; }
        if (this.weatherType == heavySnow) { this.snowAmount += heavySnowAccumulation; }
    }

    // checkDought - Updates variables to determine if there is currently a drought
    public void checkDrought(){
        if (this.rainAmount < 0.1) { this.isSevereDrought = true; }
        if (this.rainAmount < 0.2) { this.isDrought = true; }
        else {
            this.isDrought = false;
            this.isSevereDrought = false;
        }
    }


    // Daily Function

    // dailyWeather - simulates a daily cycle for weather in the game
    public void dailyWeather(Time time){
        // Randomly adjust Temperature
        adjustTemp(time);

        // Updates Temp Classification
        updateTempType();

        // Random Precipitation for Day
        dailyPrecipitation(time);

        // Update rainfall and snowfall amounts
        updateRainfall();

        // Determines whether there is a drought
        checkDrought();
    }





}
