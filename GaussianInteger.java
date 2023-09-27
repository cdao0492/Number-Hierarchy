/**
 * A class that represents Gaussian Integer, where
 * real part and imaginary part are integers
 *
 * @author Vo Linh Chi Dao
 */
public class GaussianInteger implements Gaussian{

    //stores the real part of the Gaussian Integer
    private WholeNumbers realPart;

    //stores the imaginary part of the Gaussian Integer
    private WholeNumbers imaginaryPart;

    /**
     * Constructor that initializes fields for Gaussian Integer
     *
     * @param realPart indicates the real component of the number
     * @param imaginaryPart indicates the imaginary component of the number
     */
    public GaussianInteger(WholeNumbers realPart, WholeNumbers imaginaryPart){
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    /**
     * Method that returns the real component
     *
     * @return the integer real part of the Gaussian Integer
     */
    @Override
    public WholeNumbers getRealPart(){
        return realPart;
    }

    /**
     * Method that changes the real component
     *
     * @param realPart indicates the new real part
     */
    public void setRealPart(WholeNumbers realPart){
        this.realPart = realPart;
    }

    /**
     * Method that returns the imaginary component
     *
     * @return the integer imaginary part of the Gaussian Integer
     */
    @Override
    public WholeNumbers getImaginaryPart(){
        return imaginaryPart;
    }

    /**
     * Method that changes the imaginary component
     *
     * @param imaginaryPart indicates the new imaginary part
     */
    public void setImaginaryPart(WholeNumbers imaginaryPart){
        this.imaginaryPart = imaginaryPart;
    }

    /**
     * Method that returns the string representation of the number
     *
     * @return string representation of the Gaussian Integer
     */
    @Override
    public String toString(){

        //case 1: negative imaginary part
        if(getImaginaryPart().isNegative()){
            return getRealPart().toString() + ' ' + getImaginaryPart().toString() + 'i';
        }
        //case 2: positive imaginary part, add a positive sign before the imaginary part
        else{
            return getRealPart().toString() + " + " + getImaginaryPart().toString() + 'i';
        }
    }

    /**
     * Method that determines if two numbers are equal.
     * Two Gaussian Integer are equal if both real and imaginary
     * components are equal.
     *
     * @return boolean value indicates whether two values are equal
     *
     */
    @Override
    public boolean equals(Object o){
        if(o instanceof GaussianInteger){
            GaussianInteger a = (GaussianInteger) o;
            return getRealPart().equals(a.getRealPart()) && getImaginaryPart().equals(a.getImaginaryPart());
        }
        return false;
    }

    /**
     * Method that adds two Gaussian Integer numbers
     *
     * @param value indicates the gaussian number to be added
     *              with this gaussian number
     *
     * @return the sum of two gaussian integer numbers
     *
     * @throws UnsupportedOperationException where the imaginary parts
     * of two numbers do not have the same sign or real parts of two numbers
     * do not have the same sign
     */
    public GaussianInteger add(Gaussian value){

        return new GaussianInteger(getRealPart().add(getRealPart(),value.getRealPart()),
                getImaginaryPart().add(getImaginaryPart(),value.getImaginaryPart()));
    }

}
