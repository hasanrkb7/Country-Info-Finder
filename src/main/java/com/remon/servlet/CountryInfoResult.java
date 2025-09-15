package com.remon.servlet;

/**
 * Data object to hold the combined results from both services
 */
public class CountryInfoResult {
    private String countryName;
    private String countryCode;
    private String fullCountryName;
    private String capital;
    private String currency;
    private String language;
    private long populationNumber;
    private String populationInWords;
    private int nameLength;
    private String nameLengthInWords;
    private boolean success;
    private String message;
    
    // Default constructor
    public CountryInfoResult() {}
    
    // Getters and Setters
    public String getCountryName() {
        return countryName;
    }
    
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    
    public String getCountryCode() {
        return countryCode;
    }
    
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    
    public String getFullCountryName() {
        return fullCountryName;
    }
    
    public void setFullCountryName(String fullCountryName) {
        this.fullCountryName = fullCountryName;
    }
    
    public String getCapital() {
        return capital;
    }
    
    public void setCapital(String capital) {
        this.capital = capital;
    }
    
    public String getCurrency() {
        return currency;
    }
    
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    public String getLanguage() {
        return language;
    }
    
    public void setLanguage(String language) {
        this.language = language;
    }
    
    public long getPopulationNumber() {
        return populationNumber;
    }
    
    public void setPopulationNumber(long populationNumber) {
        this.populationNumber = populationNumber;
    }
    
    public String getPopulationInWords() {
        return populationInWords;
    }
    
    public void setPopulationInWords(String populationInWords) {
        this.populationInWords = populationInWords;
    }
    
    public int getNameLength() {
        return nameLength;
    }
    
    public void setNameLength(int nameLength) {
        this.nameLength = nameLength;
    }
    
    public String getNameLengthInWords() {
        return nameLengthInWords;
    }
    
    public void setNameLengthInWords(String nameLengthInWords) {
        this.nameLengthInWords = nameLengthInWords;
    }
    
    public boolean isSuccess() {
        return success;
    }
    
    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}