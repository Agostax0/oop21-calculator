package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.Conversion;

import utils.ConversionAlgorithms;

/**
 * This class tests conversions.
 */
public class ConversionsTest {
    /**
     * Test for decimal to binary conversions.
     */
    @org.junit.Test
    public void decimalToBinary() {
        assertTrue("01010".equals(ConversionAlgorithms.conversionToStringBase(2,(10))));
        assertTrue("11010".equals(ConversionAlgorithms.conversionToStringBase(2,(-10))));    
        assertTrue("01011".equals(ConversionAlgorithms.conversionToStringBase(2,(11))));
        assertTrue("11011".equals(ConversionAlgorithms.conversionToStringBase(2,(-11))));
        //System.out.println(ConversionAlgorithms.conversionToStringBase(2,(Integer.MAX_VALUE));
        //System.out.println(ConversionAlgorithms.conversionToStringBase(2,(Integer.MIN_VALUE));
    }
    /**
     * Test for decimal to hexadecimal conversions.
     */
    @org.junit.Test
    public void decimalToHexadecimal() {
        assertTrue("0A".equals(ConversionAlgorithms.conversionToStringBase(16,(10))));
        assertTrue("1A".equals(ConversionAlgorithms.conversionToStringBase(16,(-10))));
        assertTrue("0FF".equals(ConversionAlgorithms.conversionToStringBase(16,(255))));
        assertTrue("1FF".equals(ConversionAlgorithms.conversionToStringBase(16,(-255))));
        assertTrue("0100".equals(ConversionAlgorithms.conversionToStringBase(16,(256))));
        assertTrue("1100".equals(ConversionAlgorithms.conversionToStringBase(16,(-256))));
    }
    /**
     * Test for decimal to octal conversions.
     */
    @org.junit.Test
    public void decimalToOctal() {
        assertTrue("07".equals(ConversionAlgorithms.conversionToStringBase(8,(7))));
        assertTrue("17".equals(ConversionAlgorithms.conversionToStringBase(8,(-7))));
        System.out.println(ConversionAlgorithms.conversionToStringBase(8,(8)));
        assertTrue("010".equals(ConversionAlgorithms.conversionToStringBase(8,(8))));
        assertTrue("110".equals(ConversionAlgorithms.conversionToStringBase(8,(-8))));
        assertTrue("070".equals(ConversionAlgorithms.conversionToStringBase(8,(56))));
        assertTrue("170".equals(ConversionAlgorithms.conversionToStringBase(8,(-56))));
    }
    /**
     * Test for base to decimal conversions.
     */
    @org.junit.Test
    public void baseToDecimal() {
       assertTrue(10==ConversionAlgorithms.conversionToDecimal(2, ConversionAlgorithms.conversionToStringBase(2,(10))));
       //assertFalse(10==ConversionAlgorithms.conversionToDecimal(2, ConversionAlgorithms.conversionToStringBase(2,(-10)));
       assertTrue(-10==ConversionAlgorithms.conversionToDecimal(2, ConversionAlgorithms.conversionToStringBase(2,(-10))));
       assertTrue(-10==ConversionAlgorithms.conversionToDecimal(16, ConversionAlgorithms.conversionToStringBase(16,(-10))));
       //System.out.println("-10 1A is "+ConversionAlgorithms.conversionToStringBase(16,(-10));
        //-256 = 1100
       //System.out.println(ConversionAlgorithms.conversionToDecimal(16, ConversionAlgorithms.conversionToStringBase(16,(-256)));
       //System.out.println("-256 is "+ ConversionAlgorithms.conversionToDecimal(2, ConversionAlgorithms.conversionToStringBase(2,(-256)));
       assertTrue(80==ConversionAlgorithms.conversionToDecimal(8, ConversionAlgorithms.conversionToStringBase(8,(80))));
    }

    
}