import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testing class for real numbers
 *
 * @author Vo Linh Chi Dao
 */
public class RealNumberTest {

    /**
     * Test getter/setter method for the real number
     */
    @Test
    public void testGetSetReal(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {8,7,3,1};

        FloatingPointNumbers n1 = new FloatingPointNumbers(3,false,a);
        FloatingPointNumbers n2 = new FloatingPointNumbers(3,false,b);
        RealNumber r1 = new RealNumber(n1);

        //return the initial real value
        assertEquals(n1,r1.getRealPart());
        //change the real value
        r1.setRealNumber(n2);
        //return the new real value
        assertEquals(n2,r1.getRealPart());
    }

    /**
     * Test getter method for the imaginary part
     * of real number
     */
    @Test
    public void testGetImaginary(){

        byte[] a = {1,2,3,4,8};

        FloatingPointNumbers n1 = new FloatingPointNumbers(3,false,a);
        FloatingPointNumbers n2 = new FloatingPointNumbers(0,false,new byte[]{0});
        RealNumber r1 = new RealNumber(n1);

        //return the default imaginary value
        assertEquals(n2,r1.getImaginaryPart());
    }

    /**
     * Test the toString method for real number
     */
    @Test
    public void testToString(){

        byte[] a = {1,2,3,4,8};

        FloatingPointNumbers n1 = new FloatingPointNumbers(3,false,a);
        RealNumber c1 = new RealNumber(n1);

        //Condition - the real number is either positive or negative
        assertEquals("84.321",c1.toString());
        n1.setNegative(true);
        assertEquals("-84.321",c1.toString());

        //Case 0 - number 0 in string format
        n1.setDigits(new byte[]{0});
        n1.setNegative(false);
        assertEquals("0.000",c1.toString());

        //Account for leading zeros
        n1.setDigits(a);
        n1.setNegative(true);
        //Test 0 - no leading zero
        assertEquals("-84.321",c1.toString());
        //Test 1 - 1 leading zero
        n1.setDigits(new byte[]{1,2,3,4,8,0});
        assertEquals("-84.321",c1.toString());
        //Test many - multiple leading zeros
        n1.setDigits(new byte[]{1,2,3,4,8,0,0,0});
        assertEquals("-84.321",c1.toString());

        //Account for trailing zeros
        //Test 0 - no trailing zero
        assertEquals("-84.321",c1.toString());
        //Test 1 - 1 trailing zero
        n1.setDigits(new byte[]{0,1,2,3,4,8});
        n1.setPrecision(4);
        assertEquals("-84.3210",c1.toString());
        //Test many - multiple trailing zeros
        n1.setDigits(new byte[]{0,0,0,1,2,3,4,8});
        n1.setPrecision(6);
        assertEquals("-84.321000",c1.toString());
    }

    /**
     * Test equals method for real number
     */
    @Test
    public void testEquals(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {1,7,3,1};

        FloatingPointNumbers n1 = new FloatingPointNumbers(3,false,a);
        FloatingPointNumbers n2 = new FloatingPointNumbers(3,true,a);
        RealNumber r1 = new RealNumber(n1);
        RealNumber r2 = new RealNumber(n2);

        //Case 1 - same sign and digits
        assertTrue(r1.equals(r1));
        assertTrue(r2.equals(r2));
        //Case 2 - different signs
        assertFalse(r1.equals(r2));
        //Case 3 - different digits
        n2.setDigits(b);
        assertFalse(r1.equals(r2));
        assertFalse(r1.equals(r2));
        //Case 4 - different signs and digits
        assertFalse(r1.equals(r2));
    }

    /**
     * Test add method for real number
     */
    @Test (expected = UnsupportedOperationException.class)
    public void testAdd(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {1,7,3,1};

        FloatingPointNumbers n1 = new FloatingPointNumbers(3,false,a);
        FloatingPointNumbers n2 = new FloatingPointNumbers(3,true,b);

        RealNumber c1 = new RealNumber(n1);
        RealNumber c2 = new RealNumber(n2);

        //Case 1 - accounts for exception
        c1.add(c2);

        //Case 2 - their components are positive
        n2.setNegative(false);
        assertEquals("85.692",c1.add(c2).toString());
        //Case 3 - their components are negative
        n1.setNegative(true);
        n2.setNegative(true);
        assertEquals("-85.692",c1.add(c2).toString());
    }

}
