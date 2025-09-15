package com.soap.number;

/**
 * SOAP Type class that implements the actual number conversion methods
 */
public class NumberConversionSoapType {
    
    private NumberConversionService conversionService;
    
    public NumberConversionSoapType() {
        this.conversionService = new NumberConversionService();
    }
    
    /**
     * Converts a number to words (main method used in the servlet)
     * @param number The number to convert
     * @return The number in words
     */
    public String numberToWords(long number) {
        return conversionService.numberToWords(number);
    }
    
    /**
     * Converts a number to dollar format
     * @param number The number to convert
     * @return The number in dollar format
     */
    public String numberToDollars(long number) {
        return conversionService.numberToDollars(number);
    }
}