<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Country Information Finder</title>
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
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #555;
        }
        input[type="text"] {
            width: 100%;
            padding: 12px;
            border: 2px solid #ddd;
            border-radius: 5px;
            font-size: 16px;
            box-sizing: border-box;
        }
        input[type="text"]:focus {
            border-color: #4CAF50;
            outline: none;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 12px 24px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }
        button:hover {
            background-color: #45a049;
        }
        .info {
            background-color: #e7f3ff;
            padding: 15px;
            border-radius: 5px;
            margin-bottom: 20px;
            border-left: 4px solid #2196F3;
        }
        .examples {
            background-color: #fff3cd;
            padding: 15px;
            border-radius: 5px;
            margin-top: 20px;
            border-left: 4px solid #ffc107;
        }
        .examples h3 {
            margin-top: 0;
            color: #856404;
        }
        .example-list {
            list-style-type: none;
            padding: 0;
        }
        .example-list li {
            padding: 5px 0;
            color: #856404;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>🌍 Country Information Finder</h1>
        
        <div class="info">
            <strong>What this app does:</strong><br>
            This application combines two services to provide comprehensive country information:
            <ul>
                <li><strong>Country Info SOAP Service:</strong> Provides detailed country data (capital, currency, language)</li>
                <li><strong>Manual Number Conversion Service:</strong> Converts numbers to words for interesting statistics</li>
            </ul>
        </div>
        
        <form action="countryinfo" method="post">
            <div class="form-group">
                <label for="countryName">Enter Country Name:</label>
                <input type="text" id="countryName" name="countryName" 
                       placeholder="e.g., United States, Germany, Japan..." 
                       required>
            </div>
            
            <button type="submit">🔍 Get Country Information</button>
        </form>
        
        <div class="examples">
            <h3>💡 Try these examples:</h3>
            <ul class="example-list">
                <li>• <strong>United States</strong> - Get info about the USA</li>
                <li>• <strong>Germany</strong> - Learn about Deutschland</li>
                <li>• <strong>Japan</strong> - Discover facts about Japan</li>
                <li>• <strong>France</strong> - Information about France</li>
                <li>• <strong>Brazil</strong> - Details about Brazil</li>
            </ul>
            <p><em>Note: Try partial names too - the search is flexible!</em></p>
        </div>
    </div>
</body>
</html>