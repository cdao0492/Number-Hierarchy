import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testing class for arbitrary whole numbers
 *
 * @author Vo Linh Chi Dao
 */
public class WholeNumbersTest {

    /**
     * Test toString method for arbitrary whole numbers
     */
    @Test
    public void testToString(){

        byte[] a = {1,2,3,4};
        WholeNumbers n1 = new WholeNumbers(false,a);
        WholeNumbers n2 = new WholeNumbers(true,a);
        //Condition: accounts for negative sign
        assertEquals("4321",n1.toString());
        assertEquals("-4321",n2.toString());

        //Test 0 - no leading zero
        assertEquals("4321",n1.toString());
        //Test 1 - 1 leading zero
        n1.setDigits(new byte[]{4,3,2,1,0});
        assertEquals("1234",n1.toString());
        //Test many - many leading zeros
        n1.setDigits(new byte[]{4,3,2,1,0,0,0,0,0});
        assertEquals("1234",n1.toString());
    }

    /**
     * Test equals method for arbitrary whole numbers
     */
    @Test
    public void testEquals(){

        WholeNumbers n1 = new WholeNumbers(true,new byte[]{1,2,3,4});
        WholeNumbers n2 = new WholeNumbers(true,new byte[]{1,2,3,4});
        //Case 1 - same sign and digits
        assertTrue(n1.equals(n2));
        //Case 2 - same digits, different sign
        n2.setNegative(false);
        assertFalse(n1.equals(n2));
        //Case 3 - same sign, different digits
        n2.setNegative(true);
        n2.setDigits(new byte[]{1,2});
        assertFalse(n1.equals(n2));
        //Case 4 - different sign and digits
        n2.setNegative(false);
        assertFalse(n1.equals(n2));
        //Case 5 - different digits but represent same  number
        WholeNumbers n3 = new WholeNumbers(true,new byte[]{1,2,3,4,0,0,0,0});
        WholeNumbers n4 = new WholeNumbers(true,new byte[]{1,2,3,4});
        assertTrue(n3.equals(n4));
    }

    /**
     * Test the add method for arbitrary whole numbers
     */
    @Test (expected = UnsupportedOperationException.class)
    public void testAdd(){

        WholeNumbers n1 = new WholeNumbers(true,new byte[]{1,2,3,4,5});
        WholeNumbers n2 = new WholeNumbers(false,new byte[]{1,2,3,3,6,5});

        //Case 1 - two numbers do not have same sign
        n1.add(n1,n2);
        //Case 2 - one has a smaller number of digits
        n1.setNegative(true);
        assertEquals("617642", n1.add(n1,n2).toString());
        //Case 3 - two numbers have same number of digits
        n1.setDigits(new byte[]{1,3,4,5,6,7});
        assertEquals("1328752", n1.add(n1,n2).toString());

        WholeNumbers n3 = new WholeNumbers(false,new byte[]{1,2,3,4});
        WholeNumbers n4 = new WholeNumbers(false,new byte[]{1,2,3,5});

        //Test 0 - no sum carry
        assertEquals("9642", n3.add(n3,n4).toString());
        //Test 1 - 1 sum carry
        n4.setDigits(new byte[]{1,2,3,7});
        assertEquals("11642", n3.add(n3,n4).toString());
        //Test many - multiple sum carries
        n4.setDigits(new byte[]{1,2,8,7});
        assertEquals("12142", n3.add(n3,n4).toString());

        //Test first - sum carry occurs at the beginning
        n4.setDigits(new byte[]{9,2,3,4});
        assertEquals("8650", n3.add(n3,n4).toString());
        //Test middle - sum carry occurs at the beginning
        n4.setDigits(new byte[]{3,9,3,4});
        assertEquals("8714", n3.add(n3,n4).toString());
        //Test last - sum carry occurs at the end
        n4.setDigits(new byte[]{3,2,3,9});
        assertEquals("13644", n3.add(n3,n4).toString());
    }

}
