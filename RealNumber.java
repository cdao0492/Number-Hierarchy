/**
 * A class that represents a finite real number
 *
 * @author Vo Linh Chi Dao
 */
public class RealNumber implements Real{

    //stores the floating point representation of real number
    private FloatingPointNumbers realNumber;

    /**
     * Constructor that initializes the fields for real number
     *
     * @param realNumber indicates the finite floating point number
     */
    public RealNumber(FloatingPointNumbers realNumber){
        this.realNumber = realNumber;
    }

    /**
     * Method that returns the real number
     *
     * @return the real number
     */
    @Override
    public FloatingPointNumbers getRealPart(){
        return realNumber;
    }

    /**
     * Method that changes the value of the real number
     *
     * @param realNumber indicates a new real number
     */
    public void setRealNumber(FloatingPointNumbers realNumber){
        this.realNumber = realNumber;
    }

    /**
     * Method that returns the imaginary component of a real number.
     * Real number has an imaginary value of 0
     *
     * @return the imaginary part of the real number
     */
    @Override
    public FloatingPointNumbers getImaginaryPart(){
        //imaginary part of real number has value of 0
        return new FloatingPointNumbers(0,false,new byte[]{0});
    }

    /**
     * Method that returns the string representation of the real number
     *
     * @return the string representation of the real number
     */
    @Override
    public String toString(){
        return getRealPart().toString();
    }

    /**
     * Method that determines whether two real numbers are equal
     *
     * @return boolean value indicates whether two values are equal
     */
    @Override
    public boolean equals(Object o){
        if(o instanceof RealNumber){
            RealNumber a = (RealNumber) o;
            return getRealPart().equals(a.getRealPart());
        }
        return false;
    }

    /**
     * Method that adds two real numbers
     *
     * @param value indicates the real number to be added
     *              with this real number
     *
     * @return the sum of two real numbers
     *
     * @throws UnsupportedOperationException where two real numbers
     * do not have the same sign
     */
    public RealNumber add(Real value){

        return new RealNumber(getRealPart().add(getRealPart(),value.getRealPart()));
    }

}
