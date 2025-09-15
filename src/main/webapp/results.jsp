<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.remon.servlet.CountryInfoResult" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Country Information Results</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 30px;
        }
        .success {
            background-color: #d4edda;
            padding: 15px;
            border-radius: 5px;
            border-left: 4px solid #28a745;
            margin-bottom: 20px;
        }
        .error {
            background-color: #f8d7da;
            padding: 15px;
            border-radius: 5px;
            border-left: 4px solid #dc3545;
            margin-bottom: 20px;
        }
        .result-section {
            background-color: #f8f9fa;
            padding: 20px;
            margin-bottom: 20px;
            border-radius: 5px;
            border-left: 4px solid #007bff;
        }
        .result-section h3 {
            margin-top: 0;
            color: #007bff;
        }
        .info-grid {
            display: grid;
            grid-template-columns: 1fr 2fr;
            gap: 10px;
            margin-bottom: 15px;
        }
        .info-label {
            font-weight: bold;
            color: #555;
        }
        .info-value {
            color: #333;
        }
        .number-conversion {
            background-color: #e7f3ff;
            padding: 15px;
            border-radius: 5px;
            margin-top: 10px;
        }
        .back-button {
            background-color: #6c757d;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            display: inline-block;
            margin-top: 20px;
        }
        .back-button:hover {
            background-color: #5a6268;
            text-decoration: none;
            color: white;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>🌍 Country Information Results</h1>
        
        <%
            CountryInfoResult result = (CountryInfoResult) request.getAttribute("result");
            if (result != null) {
                if (result.isSuccess()) {
        %>
        
        <div class="success">
            <strong>✅ <%= result.getMessage() %></strong>
        </div>
        
        <div class="result-section">
            <h3>🏛️ Basic Country Information (SOAP Service)</h3>
            <div class="info-grid">
                <div class="info-label">Search Term:</div>
                <div class="info-value"><%= result.getCountryName() %></div>
                
                <div class="info-label">Official Country Name:</div>
                <div class="info-value"><strong><%= result.getFullCountryName() %></strong></div>
                
                <div class="info-label">Country Code:</div>
                <div class="info-value"><%= result.getCountryCode() %></div>
                
                <div class="info-label">Capital City:</div>
                <div class="info-value">🏙️ <%= result.getCapital() %></div>
                
                <div class="info-label">Currency:</div>
                <div class="info-value">💰 <%= result.getCurrency() %></div>
                
                <div class="info-label">Primary Language:</div>
                <div class="info-value">🗣️ <%= result.getLanguage() %></div>
            </div>
        </div>
        
        <div class="result-section">
            <h3>🔢 Number Conversions (Manual Service Integration)</h3>
            <p>This section demonstrates the integration with our manual Number Conversion service:</p>
            
            <div class="number-conversion">
                <strong>Sample Population (Demo):</strong><br>
                <div class="info-grid">
                    <div class="info-label">Number:</div>
                    <div class="info-value"><%= String.format("%,d", result.getPopulationNumber()) %></div>
                    
                    <div class="info-label">In Words:</div>
                    <div class="info-value"><em>"<%= result.getPopulationInWords() %>"</em></div>
                </div>
            </div>
            
            <div class="number-conversion">
                <strong>Country Name Length:</strong><br>
                <div class="info-grid">
                    <div class="info-label">Length:</div>
                    <div class="info-value"><%= result.getNameLength() %> characters</div>
                    
                    <div class="info-label">In Words:</div>
                    <div class="info-value"><em>"<%= result.getNameLengthInWords() %>"</em></div>
                </div>
            </div>
        </div>
        
        <div class="result-section">
            <h3>🔧 Technical Information</h3>
            <p><strong>Services Used:</strong></p>
            <ul>
                <li><strong>Country Info SOAP Service:</strong> http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso</li>
                <li><strong>Number Conversion Service:</strong> Manual implementation (replaces SOAP service)</li>
            </ul>
            <p><em>This application demonstrates the integration of SOAP web services with manual service implementations.</em></p>
        </div>
        
        <% } else { %>
        
        <div class="error">
            <strong>❌ <%= result.getMessage() %></strong>
        </div>
        
        <% } 
           } else { %>
        
        <div class="error">
            <strong>❌ No results available. Please try again.</strong>
        </div>
        
        <% } %>
        
        <a href="index.jsp" class="back-button">⬅️ Search Another Country</a>
    </div>
</body>
</html>