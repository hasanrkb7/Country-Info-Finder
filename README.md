# Country Info Finder

This is a Java web app I made for the SOA and Cloud Computing course (TIES4560) at the University of Jyväskylä, from September to October 2025. You type a country name in a JSP form and the servlet gets it. Then the results page shows the country code, capital, currency and language. It also shows some numbers written out in words.

## What is inside

- A Java servlet and JSP pages, built with Maven and run on Tomcat 9. After that I deployed it to Heroku with `webapp-runner`, a `Procfile` and `system.properties`.
- JAX-WS client classes in `src/main/java/com/soap/country`. I generated them with `wsimport` from the public CountryInfoService WSDL (oorsprong.org).

Currently, the servlet does not call that SOAP service. It returns sample data for 5 countries (USA, Germany, Japan, France and Brazil), and the number to words part is a local Java method, not a SOAP call.

## How to run

Step 1: Run `mvn package`. It builds `target/*.war`.

Step 2: Deploy the war file on Tomcat 9.
