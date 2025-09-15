package com.remon.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Standalone Servlet implementation 
 * This version uses manual implementation for both country info and number conversion
 */
public class CountryInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public CountryInfoServlet() {
        super();
    }

    /**
     * Handles GET requests - displays the form
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Forward to the main page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles POST requests - processes the form submission
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String countryName = request.getParameter("countryName");
        CountryInfoResult result = new CountryInfoResult();
        result.setCountryName(countryName);
        
        try {
            // For demonstration purposes, let's create some mock country data
            // In a real implementation, you would call the SOAP service here
            
            // Simulate finding a country
            if (countryName != null && countryName.trim().length() > 0) {
                
                // Mock country data (you can replace this with actual SOAP calls)
                String normalizedCountryName = countryName.trim();
                String mockCountryCode = "US"; // Default
                String mockCapital = "Unknown";
                String mockCurrency = "Unknown";
                String mockLanguage = "Unknown";
                
                // Simple mock data based on common countries
                if (normalizedCountryName.toLowerCase().contains("united states") || 
                    normalizedCountryName.toLowerCase().contains("usa") ||
                    normalizedCountryName.toLowerCase().contains("america")) {
                    mockCountryCode = "US";
                    mockCapital = "Washington D.C.";
                    mockCurrency = "US Dollar";
                    mockLanguage = "English";
                    normalizedCountryName = "United States";
                } else if (normalizedCountryName.toLowerCase().contains("germany") ||
                          normalizedCountryName.toLowerCase().contains("deutschland")) {
                    mockCountryCode = "DE";
                    mockCapital = "Berlin";
                    mockCurrency = "Euro";
                    mockLanguage = "German";
                    normalizedCountryName = "Germany";
                } else if (normalizedCountryName.toLowerCase().contains("japan")) {
                    mockCountryCode = "JP";
                    mockCapital = "Tokyo";
                    mockCurrency = "Japanese Yen";
                    mockLanguage = "Japanese";
                    normalizedCountryName = "Japan";
                } else if (normalizedCountryName.toLowerCase().contains("france")) {
                    mockCountryCode = "FR";
                    mockCapital = "Paris";
                    mockCurrency = "Euro";
                    mockLanguage = "French";
                    normalizedCountryName = "France";
                } else if (normalizedCountryName.toLowerCase().contains("brazil")) {
                    mockCountryCode = "BR";
                    mockCapital = "Brasília";
                    mockCurrency = "Brazilian Real";
                    mockLanguage = "Portuguese";
                    normalizedCountryName = "Brazil";
                } else {
                    // Generic data for other countries
                    mockCapital = "Capital information available via SOAP service";
                    mockCurrency = "Currency information available via SOAP service";
                    mockLanguage = "Language information available via SOAP service";
                }
                
                result.setCountryCode(mockCountryCode);
                result.setFullCountryName(normalizedCountryName);
                result.setCapital(mockCapital);
                result.setCurrency(mockCurrency);
                result.setLanguage(mockLanguage);
                
                // 2. Use our manual Number Conversion Service
                // Create a simple inline number converter
                long mockPopulation = 5000000; // 5 million 
                String populationInWords = convertNumberToWords(mockPopulation);
                result.setPopulationInWords(populationInWords);
                result.setPopulationNumber(mockPopulation);
                
                // Convert the length of country name to words
                int nameLength = normalizedCountryName.length();
                String nameLengthInWords = convertNumberToWords(nameLength);
                result.setNameLengthInWords(nameLengthInWords);
                result.setNameLength(nameLength);
                
                result.setSuccess(true);
                result.setMessage("Country information retrieved successfully! (Using demonstration data and manual number conversion service)");
                
            } else {
                result.setSuccess(false);
                result.setMessage("Please enter a valid country name.");
            }
            
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Error occurred: " + e.getMessage());
            e.printStackTrace(); // For debugging
        }
        
        // Set the result attribute and forward to results page
        request.setAttribute("result", result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/results.jsp");
        dispatcher.forward(request, response);
    }
    
    /**
     * Simple number to words converter (inline implementation)
     */
    private String convertNumberToWords(long number) {
        if (number == 0) return "zero";
        if (number < 0) return "minus " + convertNumberToWords(-number);
        
        String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", 
                        "seventeen", "eighteen", "nineteen"};
        
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        
        String[] thousands = {"", "thousand", "million", "billion"};
        
        String result = "";
        int thousandIndex = 0;
        
        while (number > 0) {
            if (number % 1000 != 0) {
                String groupWords = convertHundreds((int)(number % 1000), ones, tens);
                if (thousandIndex > 0) {
                    groupWords += " " + thousands[thousandIndex];
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
     * Helper method to convert numbers 1-999 to words
     */
    private String convertHundreds(int number, String[] ones, String[] tens) {
        String result = "";
        
        if (number >= 100) {
            result += ones[number / 100] + " hundred";
            number %= 100;
            if (number > 0) result += " ";
        }
        
        if (number >= 20) {
            result += tens[number / 10];
            number %= 10;
            if (number > 0) result += " " + ones[number];
        } else if (number > 0) {
            result += ones[number];
        }
        
        return result;
    }
}