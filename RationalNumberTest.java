/* Vo Linh Chi Dao */

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testing class for rational numbers
 *
 * @author Vo Linh Chi Dao
 */
public class RationalNumberTest {

    /**
     * Test getter/setter method for numerator
     * of the rational number
     */
    @Test
    public void testGetSetNumerator(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {8,7,3,1};

        WholeNumbers n1 = new WholeNumbers(false,a);
        WholeNumbers n2 = new WholeNumbers(false,b);
        RationalNumber r1 = new RationalNumber(n1,n2);

        //return the initial numerator
        assertEquals(n1,r1.getNumerator());
        //change the numerator
        r1.setNumerator(n2);
        //return the new numerator
        assertEquals(n2,r1.getNumerator());
    }

    /**
     * Test getter/setter method for denominator
     * of the rational number
     */
    @Test
    public void testGetSetDenominator(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {8,7,3,1};

        WholeNumbers n1 = new WholeNumbers(false,a);
        WholeNumbers n2 = new WholeNumbers(false,b);
        RationalNumber r1 = new RationalNumber(n1,n2);

        //return the initial denominator
        assertEquals(n2,r1.getDenominator());
        //change the denominator
        r1.setDenominator(n1);
        //return the new denominator
        assertEquals(n1,r1.getDenominator());
    }

    /**
     * Test getter method for real and imaginary components
     * of the rational number
     */
    @Test
    public void testGetRealImaginaryPart(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {8,7,3,1};

        WholeNumbers n1 = new WholeNumbers(false,a);
        WholeNumbers n2 = new WholeNumbers(false,b);
        RationalNumber r1 = new RationalNumber(n1,n2);

        //return the real component
        assertNull(r1.getRealPart());
        //return the imaginary component
        assertNull(r1.getImaginaryPart());
    }

    /**
     * Test toString method for rational number
     */
    @Test
    public void testToString(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {8,7,3,1};
        byte[] c = {0};

        WholeNumbers n1 = new WholeNumbers(false,a);
        WholeNumbers n2 = new WholeNumbers(false,b);
        WholeNumbers n3 = new WholeNumbers(false,c);
        RationalNumber r1 = new RationalNumber(n1,n2);
        RationalNumber r2 = new RationalNumber(n3,n3);

        //Case 0 - both components are 0
        assertEquals("0 / 1", r2.toString());
        //Case 1 - both components are positive
        assertEquals("84321 / 1378",r1.toString());
        //Case 2 - both components are negative
        n1.setNegative(true);
        n2.setNegative(true);
        assertEquals("-84321 / -1378",r1.toString());
        //Case 3 - numerator component is negative
        n2.setNegative(false);
        assertEquals("-84321 / 1378",r1.toString());
        //Case 4 - denominator component is negative
        n2.setNegative(true);
        n1.setNegative(false);
        assertEquals("84321 / -1378",r1.toString());
    }

    /**
     * Test equals method for rational number
     */
    @Test
    public void testEquals(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {1,7,3,1};

        WholeNumbers n1 = new WholeNumbers(false,a);
        WholeNumbers n2 = new WholeNumbers(false,b);
        RationalNumber r1 = new RationalNumber(n1,n2);
        RationalNumber r2 = new RationalNumber(n1,n2);

        //Case 1 - same numerator and denominator
        assertTrue(r1.equals(r2));
        //Case 2 - same numerator but different denominator
        r1.setDenominator(n1);
        assertFalse(r1.equals(r2));
        //Case 3 - same denominator but different numerator
        r1.setDenominator(n2);
        r1.setNumerator(n2);
        assertFalse(r1.equals(r2));
        //Case 4 - different numerator and denominator
        r1.setDenominator(n1);
        assertFalse(r1.equals(r2));
    }

    /**
     * Test add method for rational number
     */
    @Test (expected = UnsupportedOperationException.class)
    public void testAdd(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {1,7,3,1};

        WholeNumbers n1 = new WholeNumbers(false,a);
        WholeNumbers n2 = new WholeNumbers(true,b);
        WholeNumbers n3 = new WholeNumbers(false,a);

        RationalNumber r1 = new RationalNumber(n1,n2);
        RationalNumber r2 = new RationalNumber(n2,n2);
        RationalNumber r3 = new RationalNumber(n1,n3);

        //Case 1 - accounts for exception
        r1.add(r2);
        r1.add(r3);

        //Case 2 - their numerators are positive
        n2.setNegative(true);
        n3.setNegative(true);
        n1.setNegative(false);
        assertEquals("168642 / -84321",r1.add(r3));
        //Case 3 - their numerators are negative
        n2.setNegative(false);
        assertEquals("-168642 / 84321",r1.add(r3));
        //Case 4 - their denominator are negative
        n2.setNegative(true);
        n3.setNegative(true);
        n1.setNegative(false);
        assertEquals("168642 / -84321",r1.add(r3));
        //Case 5 - their components are positive
        n2.setNegative(false);
        assertEquals("85692 / 1371",r1.add(r2));
        //Case 6 - their components are negative
        n1.setNegative(true);
        n2.setNegative(true);
        assertEquals("-85692 / -1371",r1.add(r2));
    }

}
