import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testing class for natural numbers
 *
 * @author Vo Linh Chi Dao
 */
public class NaturalNumberTest {

    /**
     * Test getter/setter method for the natural number
     */
    @Test
    public void testGetSetNatural(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {8,7,3,1};

        NaturalNumber n1 = new NaturalNumber(a);

        //return the initial natural value
        assertEquals(a,n1.getNatural());
        //change the natural value
        n1.setNatural(b);
        //return the new natural value
        assertEquals(b,n1.getNatural());
    }

    /**
     * Test getter method for the real and imaginary part
     * of natural number
     */
    @Test
    public void testGetRealImaginary(){

        byte[] a = {1,2,3,4,8};

        WholeNumbers w1 = new WholeNumbers(false,a);
        NaturalNumber n1 = new NaturalNumber(a);

        //return the real part, which is the natural value
        assertEquals(w1,n1.getRealPart());
        //return the default imaginary value
        assertEquals(null,n1.getImaginaryPart());
    }

    /**
     * Test getter method for the numerator and denominator part
     * of natural number
     */
    @Test
    public void testGetNumeratorDenominator(){

        byte[] a = {1,2,3,4,8};

        WholeNumbers w1 = new WholeNumbers(false,a);
        NaturalNumber n1 = new NaturalNumber(a);

        //return the real part, which is the natural value
        assertEquals(w1,n1.getNumerator());
        //return the default imaginary value
        assertEquals(new WholeNumbers(false,new byte[]{1}),n1.getDenominator());
    }

    /**
     * Test the toString method for natural number
     */
    @Test
    public void testToString(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {0};

        NaturalNumber n1 = new NaturalNumber(a);

        assertEquals("84321",n1.toString());
        //Case 0: number 0 in string format
        n1.setNatural(b);
        assertEquals("0",n1.toString());

        //Account for leading zeros
        //Test 0 - no leading zero
        n1.setNatural(a);
        assertEquals("84321",n1.toString());
        //Test 1 - 1 leading zero
        n1.setNatural(new byte[]{1,2,3,4,8,0});
        assertEquals("84321",n1.toString());
        //Test many - multiple leading zeros
        n1.setNatural(new byte[]{1,2,3,4,8,0,0,0});
        assertEquals("84321",n1.toString());
    }

    /**
     * Test equals method for natural number
     */
    @Test
    public void testEquals(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {1,7,3,1};

        NaturalNumber n1 = new NaturalNumber(a);
        NaturalNumber n2 = new NaturalNumber(a);

        //Case 1 - same sign and digits
        assertTrue(n1.equals(n1));
        assertTrue(n2.equals(n2));
        //Case 2 - different digits
        n2.setNatural(b);
        assertFalse(n1.equals(n2));
        //Case 3 - different digits but represent same  number
        n1.setNatural(new byte[]{1,2,3,4,0,0,0,0});
        n2.setNatural(new byte[]{1,2,3,4});
        assertTrue(n1.equals(n2));
    }

    /**
     * Test add method for natural number
     */
    @Test
    public void testAdd(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {1,7,3,1};

        NaturalNumber n1 = new NaturalNumber(a);
        NaturalNumber n2 = new NaturalNumber(b);

        //Case 1 - one has smaller number of digits
        assertEquals("85692",n1.add(n2).toString());
        //Case 2 - both has same number of digits
        n1.setNatural(new byte[]{9,8,1,5});
        assertEquals("6560",n1.add(n2).toString());
    }

}
