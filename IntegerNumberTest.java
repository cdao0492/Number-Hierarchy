import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testing class for integer numbers
 *
 * @author Vo Linh Chi Dao
 */
public class IntegerNumberTest{

    /**
     * Test getter/setter method for the integer number
     */
    @Test
    public void testGetSetInteger(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {8,7,3,1};

        WholeNumbers n1 = new WholeNumbers(false,a);
        WholeNumbers n2 = new WholeNumbers(false,b);
        IntegerNumber i1 = new IntegerNumber(n1);

        //return the initial real value
        assertEquals(n1,i1.getRealPart());
        //change the real value
        i1.setInteger(n2);
        //return the new real value
        assertEquals(n2,i1.getRealPart());
    }

    /**
     * Test getter method for the real and imaginary part
     * of integer number
     */
    @Test
    public void testGetRealImaginary(){

        byte[] a = {1,2,3,4,8};

        WholeNumbers n1 = new WholeNumbers(false,a);
        IntegerNumber i1 = new IntegerNumber(n1);

        //return the real part, which is the integer value
        assertEquals(n1,i1.getRealPart());
        //return the default imaginary value
        assertEquals(null,i1.getImaginaryPart());
    }

    /**
     * Test getter method for the numerator and denominator part
     * of integer number
     */
    @Test
    public void testGetNumeratorDenominator(){

        byte[] a = {1,2,3,4,8};

        WholeNumbers n1 = new WholeNumbers(false,a);
        IntegerNumber i1 = new IntegerNumber(n1);

        //return the real part, which is the integer value
        assertEquals(n1,i1.getNumerator());
        //return the default imaginary value
        assertEquals(new WholeNumbers(false,new byte[]{1}),i1.getDenominator());
    }

    /**
     * Test the toString method for integer number
     */
    @Test
    public void testToString(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {0};

        WholeNumbers n1 = new WholeNumbers(false,a);
        IntegerNumber i1 = new IntegerNumber(n1);

        //Condition - the real number is either positive or negative
        assertEquals("84321",i1.toString());
        n1.setNegative(true);
        assertEquals("-84321",i1.toString());

        //Case 0: number 0 in string format
        n1.setNegative(false);
        n1.setDigits(b);
        assertEquals("0",i1.toString());

        //Account for leading zeros
        //Test 0 - no leading zero
        n1.setDigits(a);
        assertEquals("84321",i1.toString());
        //Test 1 - 1 leading zero
        n1.setDigits(new byte[]{1,2,3,4,8,0});
        assertEquals("84321",i1.toString());
        //Test many - multiple leading zeros
        n1.setDigits(new byte[]{1,2,3,4,8,0,0,0});
        assertEquals("84321",i1.toString());

    }

    /**
     * Test equals method for integer number
     */
    @Test
    public void testEquals(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {1,7,3,1};

        WholeNumbers n1 = new WholeNumbers(false,a);
        WholeNumbers n2 = new WholeNumbers(true,a);
        IntegerNumber i1 = new IntegerNumber(n1);
        IntegerNumber i2 = new IntegerNumber(n2);

        //Case 1 - same sign and digits
        assertTrue(i1.equals(i1));
        assertTrue(i2.equals(i2));
        //Case 2 - different signs
        assertFalse(i1.equals(i2));
        //Case 3 - different digits
        n2.setDigits(b);
        assertFalse(i1.equals(i2));
        assertFalse(i1.equals(i2));
        //Case 4 - different signs and digits
        assertFalse(i1.equals(i2));
        //Case 5 - different digits but represent same number
        n1.setDigits(new byte[]{1,2,3,4,0,0,0,0});
        n2.setDigits(new byte[]{1,2,3,4});
        n2.setNegative(false);
        assertTrue(i1.equals(i2));
    }

    /**
     * Test add method for integer number
     */
    @Test (expected = UnsupportedOperationException.class)
    public void testAdd(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {1,7,3,1};

        WholeNumbers n1 = new WholeNumbers(false,a);
        WholeNumbers n2 = new WholeNumbers(true,b);

        IntegerNumber i1 = new IntegerNumber(n1);
        IntegerNumber i2 = new IntegerNumber(n2);

        //Case 1 - accounts for exception
        i1.add(i2);

        //Case 2 - their components are positive
        n2.setNegative(false);
        assertEquals("85692",i1.add(i2).toString());
        //Case 3 - their components are negative
        n1.setNegative(true);
        n2.setNegative(true);
        assertEquals("-85692",i1.add(i2).toString());
        //Case 4 - one has smaller number of digits
        assertEquals("-85692",i1.add(i2).toString());
        //Case 5 - both has same number of digits
        n1.setDigits(new byte[]{9,8,1,5});
        assertEquals("-6560",i1.add(i2).toString());
    }

}
