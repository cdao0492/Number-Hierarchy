/**
 * A class that represents a complex number with two components:
 * Real Part and Imaginary Part
 *
 * @author Vo Linh Chi Dao
 */
public class ComplexNumber implements Complex{

    //stores the real part of the number
    private FloatingPointNumbers realPart;

    //stores the imaginary part of the number
    private FloatingPointNumbers imaginaryPart;

    /**
     * Constructor that initializes the fields for complex number
     *
     * @param realPart stores the real component of the number
     * @param imaginaryPart stores the imaginary component of the number
     */
    public ComplexNumber(FloatingPointNumbers realPart, FloatingPointNumbers imaginaryPart){
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    /**
     * Method that returns the real part of the number
     *
     * @return the real part of the complex number
     */
    @Override
    public FloatingPointNumbers getRealPart(){
        return realPart;
    }

    /**
     * Method that changes the real component of the complex number
     *
     * @param realPart indicates the new real part
     */
    public void setRealPart(FloatingPointNumbers realPart){
        this.realPart = realPart;
    }

    /**
     * Method that returns the imaginary part of the number
     *
     * @return the imaginary part of the complex number
     */
    @Override
    public FloatingPointNumbers getImaginaryPart(){
        return imaginaryPart;
    }

    /**
     * Method that changes the imaginary component of the complex number
     *
     * @param imaginaryPart indicates the new imaginary part
     */
    public void setImaginaryPart(FloatingPointNumbers imaginaryPart){
        this.imaginaryPart = imaginaryPart;
    }

    /**
     * Method that returns the string representation of the complex number
     *
     * @return the string representation of the complex number
     */
    @Override
    public String toString(){

        //account for negative sign in the imaginary part
        if(getImaginaryPart().isNegative()){
            return getRealPart().toString() + ' ' + getImaginaryPart().toString() + 'i';
        }
        //account for positive sign in the imaginary part
        else{
            return getRealPart().toString() + " + " + getImaginaryPart().toString() + 'i';
        }
    }

    /**
     * Method that determines whether two numbers are equal.
     * Two complex numbers are equal if both their real and imaginary
     * components are equal
     *
     * @return boolean value indicates whether two values are equal
     *
     */
    @Override
    public boolean equals(Object o){
        if(o instanceof ComplexNumber){
            ComplexNumber a = (ComplexNumber) o;
            return getRealPart().equals(a.getRealPart()) && getImaginaryPart().equals(a.getImaginaryPart());
        }
        return false;
    }

    /**
     * Method that adds two complex numbers
     *
     * @param value indicates the complex number to be added
     *              with this complex number
     *
     * @return the sum of two complex numbers
     *
     * @throws UnsupportedOperationException where the imaginary parts
     * of two numbers do not have the same sign or real parts of two numbers
     * do not have the same sign
     */
    public ComplexNumber add(Complex value){

        return new ComplexNumber(getRealPart().add(getRealPart(),value.getRealPart()),
                getImaginaryPart().add(getImaginaryPart(),value.getImaginaryPart()));
    }

}
