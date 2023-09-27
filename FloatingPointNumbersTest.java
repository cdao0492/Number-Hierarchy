import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testing class for arbitrary floating point numbers
 *
 * @author Vo Linh Chi Dao
 */
public class FloatingPointNumbersTest {

    /**
     * Test getter/setter method for
     * floating point numbers' precision
     */
    @Test
    public void testGetSetPrecision(){

        FloatingPointNumbers n1 = new FloatingPointNumbers(3,false,new byte[]{1,2,3,4,5,6,7});
        //return initial precision
        assertEquals(3,n1.getPrecision());
        //change the precision
        n1.setPrecision(10);
        //return new precision
        assertEquals(10,n1.getPrecision());
    }

    /**
     * Test getter/setter method for
     * floating point numbers' negative sign
     */
    @Test
    public void testGetSetNegative(){

        FloatingPointNumbers n1 = new FloatingPointNumbers(3,false,new byte[]{1,2,3,4,5,6,7});
        //return initial indicator of negative sign
        assertFalse(n1.isNegative());
        //change the indicator
        n1.setNegative(true);
        //return new indicator of negative sign
        assertTrue(n1.isNegative());
    }

    /**
     * Test getter/setter method for
     * floating point numbers' digits array
     */
    @Test
    public void testGetSetDigits(){

        byte[] a = {1,2,3,4,5,6,7};
        byte[] b = {9,8,7,0,0,0,3,1};

        FloatingPointNumbers n1 = new FloatingPointNumbers(3,false,a);
        //return initial digits array
        assertArrayEquals(a,n1.getDigits());
        //change the digits array
        n1.setDigits(b);
        //return new digits array
        assertArrayEquals(b,n1.getDigits());
    }

    /**
     * Test toString method for arbitrary
     * floating point number
     */
    @Test
    public void testToString(){

        byte[] a = {1,2,3,4};
        FloatingPointNumbers n1 = new FloatingPointNumbers(3,false,a);
        FloatingPointNumbers n2 = new FloatingPointNumbers(3,true,a);
        //Condition 1: accounts for negative sign
        assertEquals("4.321",n1.toString());
        assertEquals("-4.321",n2.toString());


        FloatingPointNumbers n3 = new FloatingPointNumbers(4,false,a);
        //Condition 2: precision equal the digits array length
        assertEquals("0.4321",n3.toString());
        //Test 0 - no digit after the decimal point
        n3.setPrecision(0);
        n3.setDigits(new byte[]{});
        assertEquals("0",n3.toString());
        //Test 1 - 1 digit after the decimal point
        n3.setPrecision(1);
        assertEquals("0.0",n3.toString());
        //Test many - many digits after the decimal point
        n3.setPrecision(3);
        n3.setDigits(new byte[]{1,2,3});
        assertEquals("0.321",n3.toString());

        FloatingPointNumbers n4 = new FloatingPointNumbers(4,false,new byte[]{0});
        //Condition 3: precision larger the digits array length

        //Case 0 - represent 0 in string format
        assertEquals("0.0000", n4.toString());

        n4.setDigits(a);
        //First for loop testing: add leading zeros
        //Test 0 - no leading zero added after the decimal point
        assertEquals("0.4321",n4.toString());
        //Test 1 - 1 leading zero added after the decimal point
        n4.setPrecision(5);
        assertEquals("0.04321",n4.toString());
        //Test many - many leading zeros added after the decimal point
        n4.setPrecision(8);
        assertEquals("0.00004321",n4.toString());

        FloatingPointNumbers n5 = new FloatingPointNumbers(4,false,new byte[]{0});
        //Second for loop testing: add digits after leading zero
        //Test 0 - no digit added after the leading zeros
        assertEquals("0.0000",n5.toString());
        //Test 1 - 1 digit added after the leading zeros
        n5.setPrecision(5);
        n5.setDigits(new byte[]{1});
        assertEquals("0.00001",n5.toString());
        //Test many - many leading zeros added after the decimal point
        n5.setPrecision(7);
        assertEquals("0.0000001",n5.toString());

        FloatingPointNumbers n6 = new FloatingPointNumbers(0,false,a);
        //Condition 4: precision smaller than the digits array length

        //Test 0 - no digit in decimal part
        assertEquals("4321",n6.toString());
        //Test 1 - 1 digit in decimal part
        n6.setPrecision(1);
        assertEquals("432.1",n6.toString());
        //Test many - many digits in decimal part
        n6.setPrecision(3);
        assertEquals("4.321",n6.toString());

        //Test first - decimal point added from the beginning of the array digits
        n6.setPrecision(4);
        assertEquals("0.4321",n6.toString());
        //Test middle - decimal point added from the middle of the array digits
        n6.setPrecision(2);
        assertEquals("43.21",n6.toString());
        //Test last - decimal point added from the end of the array digits
        n6.setPrecision(0);
        assertEquals("4321",n6.toString());
    }

    /**
     * Test equals method for arbitrary floating
     * point numbers
     */
    @Test
    public void testEquals(){

        FloatingPointNumbers n1 = new FloatingPointNumbers(3,true,new byte[]{1,2,3,4});
        FloatingPointNumbers n2 = new FloatingPointNumbers(3,true,new byte[]{1,2,3,4});
        //Case 1 - same precision, sign, and digits
        assertTrue(n1.equals(n2));
        //Case 2 - same precision and digits, different sign
        n2.setNegative(false);
        assertFalse(n1.equals(n2));
        //Case 3 - same sign and digits, different precision
        n2.setPrecision(1);
        n2.setNegative(true);
        assertFalse(n1.equals(n2));
        //Case 4 - same precision and sign, different digits
        n2.setPrecision(3);
        n2.setDigits(new byte[]{1,4,5,7,8,9});
        assertFalse(n1.equals(n2));
        //Case 5 - two numbers only have same sign
        n2.setPrecision(1);
        assertFalse(n1.equals(n2));
        //Case 6 - two numbers only have same digits
        n2.setNegative(false);
        n2.setDigits(new byte[]{1,2,3,4});
        assertFalse(n1.equals(n2));
        //Case 7 - two numbers only have same precision
        n2.setPrecision(3);
        assertFalse(n1.equals(n2));
        //Case 8 - different precision, sign, and digits
        n2.setPrecision(6);
        assertFalse(n1.equals(n2));
        //Case 9 - different precision and digits but represent
        //the same number
        FloatingPointNumbers n3 = new FloatingPointNumbers(5,true,new byte[]{0,0,1,2,3,4});
        FloatingPointNumbers n4 = new FloatingPointNumbers(7,true,new byte[]{0,0,0,0,1,2,3,4});
        assertTrue(n1.equals(n3));
        assertTrue(n1.equals(n4));
    }

    /**
     * Test add method for arbitrary whole numbers
     */
    @Test (expected = UnsupportedOperationException.class)
    public void testAdd(){

        FloatingPointNumbers n1 = new FloatingPointNumbers(3,true,new byte[]{1,2,3,4,7,8});
        FloatingPointNumbers n2 = new FloatingPointNumbers(3,false,new byte[]{1,2,3,4,7,8});

        //Case 1 - two numbers have different sign
        n1.add(n1,n2);
        //Case 2 - one has smaller precision and integer parts
        n2.setNegative(true);
        n2.setPrecision(1);
        n2.setDigits(new byte[]{1,2,6});
        assertEquals("-880.531", n1.add(n1,n2).toString());
        //Case 3 - one has smaller precision and larger integer parts
        n2.setDigits(new byte[]{1,2,5,6,8});
        assertEquals("-7777.779", n1.add(n1,n2).toString());
        //Case 4 - one has larger precision and smaller integer parts
        n2.setPrecision(5);
        assertEquals("-875.18621", n1.add(n1,n2).toString());
        //Case 5 - one has larger precision and larger integer parts
        n2.setPrecision(4);
        n2.setDigits(new byte[]{1,5,8,0,4,5,7,2});
        assertEquals("-3628.4061", n1.add(n1,n2).toString());
        //Case 6 - two numbers have same integer parts and precision
        assertEquals("-1748.642", n1.add(n1,n1).toString());

        FloatingPointNumbers n3 = new FloatingPointNumbers(2,false,new byte[]{1,2,3,4});
        FloatingPointNumbers n4 = new FloatingPointNumbers(2,false,new byte[]{1,2,3,5});

        //Test 0 - no sum carry
        assertEquals("96.42", n3.add(n3,n4).toString());
        //Test 1 - 1 sum carry
        n4.setDigits(new byte[]{1,2,3,7});
        assertEquals("116.42", n3.add(n3,n4).toString());
        //Test many - multiple sum carries
        n4.setDigits(new byte[]{1,2,8,7});
        assertEquals("121.42", n3.add(n3,n4).toString());

        //Test first - sum carry occurs at the beginning
        n4.setDigits(new byte[]{9,2,3,4});
        assertEquals("86.50", n3.add(n3,n4).toString());
        //Test middle - sum carry occurs at the beginning
        n4.setDigits(new byte[]{3,9,3,4});
        assertEquals("87.14", n3.add(n3,n4).toString());
        //Test last - sum carry occurs at the end
        n4.setDigits(new byte[]{3,2,3,9});
        assertEquals("136.44", n3.add(n3,n4).toString());
    }

}
