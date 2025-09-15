package com.soap.number;

/**
 * Wrapper class that mimics the SOAP service structure
 */
public class NumberConversion {
    
    private NumberConversionSoapType soapPort;
    
    public NumberConversion() {
        this.soapPort = new NumberConversionSoapType();
    }
    
    /**
     * Get the SOAP port (mimics the generated SOAP client method)
     * @return NumberConversionSoapType instance
     */
    public NumberConversionSoapType getNumberConversionSoap() {
        return this.soapPort;
    }
}