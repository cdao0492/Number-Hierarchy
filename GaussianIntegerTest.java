import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testing class for Gaussian Integer
 *
 * @author Vo Linh Chi Dao
 */
public class GaussianIntegerTest {

    /**
     * Test getter/setter method for real component
     * of the gaussian integer
     */
    @Test
    public void testGetSetRealPart(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {8,7,3,1};

        WholeNumbers n1 = new WholeNumbers(false,a);
        WholeNumbers n2 = new WholeNumbers(false,b);
        GaussianInteger g1 = new GaussianInteger(n1,n2);

        //return the initial real part
        assertEquals(n1,g1.getRealPart());
        //change the real component
        g1.setRealPart(n2);
        //return the new real part
        assertEquals(n2,g1.getRealPart());
    }

    /**
     * Test getter/setter method for imaginary component
     * of the gaussian integer
     */
    @Test
    public void testGetSetImaginaryPart(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {8,7,3,1};

        WholeNumbers n1 = new WholeNumbers(false,a);
        WholeNumbers n2 = new WholeNumbers(false,b);
        GaussianInteger g1 = new GaussianInteger(n1,n2);

        //return the initial imaginary part
        assertEquals(n2,g1.getImaginaryPart());
        //change the imaginary component
        g1.setImaginaryPart(n1);
        //return the new imaginary part
        assertEquals(n1,g1.getImaginaryPart());
    }

    /**
     * Test toString method for gaussian integer
     */
    @Test
    public void testToString(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {8,7,3,1};
        byte[] c = {0};

        WholeNumbers n1 = new WholeNumbers(false,a);
        WholeNumbers n2 = new WholeNumbers(false,b);
        WholeNumbers n3 = new WholeNumbers(false,c);
        GaussianInteger g1 = new GaussianInteger(n1,n2);
        GaussianInteger g2 = new GaussianInteger(n3,n3);

        //Case 0 - both components are 0
        assertEquals("0 + 0i", g2.toString());
        //Case 1 - both components are positive
        assertEquals("84321 + 1378i",g1.toString());
        //Case 2 - both components are negative
        n1.setNegative(true);
        n2.setNegative(true);
        assertEquals("-84321 -1378i",g1.toString());
        //Case 3 - real component is negative
        n2.setNegative(false);
        assertEquals("-84321 + 1378i",g1.toString());
        //Case 4 - imaginary component is negative
        n2.setNegative(true);
        n1.setNegative(false);
        assertEquals("84321 -1378i",g1.toString());
    }

    /**
     * Test equals method for gaussian integer
     */
    @Test
    public void testEquals(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {1,7,3,1};

        WholeNumbers n1 = new WholeNumbers(false,a);
        WholeNumbers n2 = new WholeNumbers(false,b);
        GaussianInteger g1 = new GaussianInteger(n1,n2);
        GaussianInteger g2 = new GaussianInteger(n1,n2);

        //Case 1 - same real and imaginary parts
        assertTrue(g1.equals(g2));
        g1.setImaginaryPart(n1);
        //Case 2 - same real but different imaginary part
        g1.setImaginaryPart(n1);
        assertFalse(g1.equals(g2));
        //Case 3 - same imaginary but different real part
        g1.setImaginaryPart(n2);
        g1.setRealPart(n2);
        assertFalse(g1.equals(g2));
        //Case 4 - different real and imaginary parts
        g1.setImaginaryPart(n1);
        assertFalse(g1.equals(g2));
    }

    /**
     * Test add method for gaussian integer
     */
    @Test (expected = UnsupportedOperationException.class)
    public void testAdd(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {1,7,3,1};

        WholeNumbers n1 = new WholeNumbers(false,a);
        WholeNumbers n2 = new WholeNumbers(true,b);
        WholeNumbers n3 = new WholeNumbers(false,a);

        GaussianInteger g1 = new GaussianInteger(n1,n2);
        GaussianInteger g2 = new GaussianInteger(n2,n2);
        GaussianInteger g3 = new GaussianInteger(n1,n3);

        //Case 1 - accounts for exception
        g1.add(g2);
        g1.add(g3);

        //Case 2 - their components are positive
        n2.setNegative(false);
        assertEquals("85692 + 2742i",g1.add(g2));
        //Case 3 - their components are negative
        n1.setNegative(true);
        n2.setNegative(true);
        assertEquals("-85692 -2742i",g1.add(g2));
        //Case 4 - their real components are negative
        n2.setNegative(false);
        assertEquals("-168642 + 1455321i",g1.add(g3));
        //Case 5 - their imaginary components are negative
        n2.setNegative(true);
        n3.setNegative(true);
        n1.setNegative(false);
        assertEquals("168642 -1455321i",g1.add(g3));
    }

}
