package com.soap.number;

/**
 * Manual implementation of Number Conversion Service
 * This replaces the SOAP service that converts numbers to words
 */
public class NumberConversionService {
    
    // Arrays for number to word conversion
    private static final String[] ONES = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", 
        "seventeen", "eighteen", "nineteen"
    };
    
    private static final String[] TENS = {
        "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };
    
    private static final String[] THOUSANDS = {
        "", "thousand", "million", "billion", "trillion"
    };
    
    /**
     * Converts a number to its word representation
     * @param number The number to convert
     * @return The number in words
     */
    public String numberToWords(long number) {
        if (number == 0) {
            return "zero";
        }
        
        if (number < 0) {
            return "minus " + numberToWords(-number);
        }
        
        String result = "";
        int thousandIndex = 0;
        
        while (number > 0) {
            if (number % 1000 != 0) {
                String groupWords = convertHundreds((int)(number % 1000));
                if (thousandIndex > 0) {
                    groupWords += " " + THOUSANDS[thousandIndex];
                }
                
                if (!result.isEmpty()) {
                    result = groupWords + " " + result;
                } else {
                    result = groupWords;
                }
            }
            
            number /= 1000;
            thousandIndex++;
        }
        
        return result.trim();
    }
    
    /**
     * Converts numbers from 1 to 999 to words
     */
    private String convertHundreds(int number) {
        String result = "";
        
        // Handle hundreds
        if (number >= 100) {
            result += ONES[number / 100] + " hundred";
            number %= 100;
            if (number > 0) {
                result += " ";
            }
        }
        
        // Handle tens and ones
        if (number >= 20) {
            result += TENS[number / 10];
            number %= 10;
            if (number > 0) {
                result += " " + ONES[number];
            }
        } else if (number > 0) {
            result += ONES[number];
        }
        
        return result;
    }
    
    /**
     * Converts number to dollars format (mimicking the SOAP service)
     * @param number The number to convert
     * @return The number in dollar format words
     */
    public String numberToDollars(long number) {
        if (number == 0) {
            return "zero dollars";
        }
        
        String words = numberToWords(number);
        
        if (number == 1) {
            return words + " dollar";
        } else {
            return words + " dollars";
        }
    }
}