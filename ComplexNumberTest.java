import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testing class for complex numbers
 *
 * @author Vo Linh Chi Dao
 */
public class ComplexNumberTest {

    /**
     * Test getter/setter method for real component
     * of the complex number
     */
    @Test
    public void testGetSetRealPart(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {8,7,3,1};

        FloatingPointNumbers n1 = new FloatingPointNumbers(3,false,a);
        FloatingPointNumbers n2 = new FloatingPointNumbers(3,false,b);
        ComplexNumber c1 = new ComplexNumber(n1,n2);

        //return the initial real part
        assertEquals(n1,c1.getRealPart());
        //change the real component
        c1.setRealPart(n2);
        //return the new real part
        assertEquals(n2,c1.getRealPart());
    }

    /**
     * Test getter/setter method for imaginary component
     * of the complex number
     */
    @Test
    public void testGetSetImaginaryPart(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {8,7,3,1};

        FloatingPointNumbers n1 = new FloatingPointNumbers(3,false,a);
        FloatingPointNumbers n2 = new FloatingPointNumbers(3,false,b);
        ComplexNumber c1 = new ComplexNumber(n1,n2);

        //return the initial imaginary part
        assertEquals(n2,c1.getImaginaryPart());
        //change the imaginary component
        c1.setImaginaryPart(n1);
        //return the new imaginary part
        assertEquals(n1,c1.getImaginaryPart());
    }

    /**
     * Test toString method for complex number
     */
    @Test
    public void testToString(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {8,7,3,1};
        byte[] c ={0};

        FloatingPointNumbers n1 = new FloatingPointNumbers(3,false,a);
        FloatingPointNumbers n2 = new FloatingPointNumbers(3,false,b);
        FloatingPointNumbers n3 = new FloatingPointNumbers(0,false,c);
        ComplexNumber c1 = new ComplexNumber(n1,n2);
        ComplexNumber c2 = new ComplexNumber(n3,n3);

        //Case 0 - number 0 in string format
        assertEquals("0 + 0i",c2.toString());
        //Case 1 - both components are positive
        assertEquals("84.321 + 1.378i",c1.toString());
        //Case 2 - both components are negative
        n1.setNegative(true);
        n2.setNegative(true);
        assertEquals("-84.321 -1.378i",c1.toString());
        //Case 3 - real component is negative
        n2.setNegative(false);
        assertEquals("-84.321 + 1.378i",c1.toString());
        //Case 4 - imaginary component is negative
        n2.setNegative(true);
        n1.setNegative(false);
        assertEquals("84.321 -1.378i",c1.toString());
    }

    /**
     * Test equals method for complex number
     */
    @Test
    public void testEquals(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {1,7,3,1};

        FloatingPointNumbers n1 = new FloatingPointNumbers(3,false,a);
        FloatingPointNumbers n2 = new FloatingPointNumbers(3,false,b);
        ComplexNumber c1 = new ComplexNumber(n1,n2);
        ComplexNumber c2 = new ComplexNumber(n1,n2);

        //Case 1 - same real and imaginary parts
        assertTrue(c1.equals(c2));
        c1.setImaginaryPart(n1);
        //Case 2 - same real but different imaginary part
        c1.setImaginaryPart(n1);
        assertFalse(c1.equals(c2));
        //Case 3 - same imaginary but different real part
        c1.setImaginaryPart(n2);
        c1.setRealPart(n2);
        assertFalse(c1.equals(c2));
        //Case 4 - different real and imaginary parts
        c1.setImaginaryPart(n1);
        assertFalse(c1.equals(c2));
    }

    /**
     * Test add method for complex number
     */
    @Test (expected = UnsupportedOperationException.class)
    public void testAdd(){

        byte[] a = {1,2,3,4,8};
        byte[] b = {1,7,3,1};

        FloatingPointNumbers n1 = new FloatingPointNumbers(3,false,a);
        FloatingPointNumbers n2 = new FloatingPointNumbers(3,true,b);
        FloatingPointNumbers n3 = new FloatingPointNumbers(6,false,a);

        ComplexNumber c1 = new ComplexNumber(n1,n2);
        ComplexNumber c2 = new ComplexNumber(n2,n2);
        ComplexNumber c3 = new ComplexNumber(n1,n3);

        //Case 1 - accounts for exception
        c1.add(c2);
        c1.add(c3);

        //Case 2 - their components are positive
        n2.setNegative(false);
        assertEquals("85.692 + 2.742i",c1.add(c2));
        //Case 3 - their components are negative
        n1.setNegative(true);
        n2.setNegative(true);
        assertEquals("-85.692 -2.742i",c1.add(c2));
        //Case 4 - their real components are negative
        n2.setNegative(false);
        assertEquals("-168.642 + 1.455321i",c1.add(c3));
        //Case 5 - their imaginary components are negative
        n2.setNegative(true);
        n3.setNegative(true);
        n1.setNegative(false);
        assertEquals("168.642 -1.455321i",c1.add(c3));
    }

}
