/**
 * A class that represents Integer Number
 *
 * @author Vo Linh Chi Dao
 */
public class IntegerNumber implements Integer{

    //stores the Integer number
    private WholeNumbers integer;

    /**
     * Constructor that initializes fields for integer number
     * @param integer indicates the integer value
     */
    public IntegerNumber(WholeNumbers integer){
        this.integer = integer;
    }

    /**
     * Method that returns the integer value
     *
     * @return this integer value
     */
    @Override
    public WholeNumbers getRealPart(){
        return integer;
    }

    /**
     * Method that changes the integer value
     *
     * @param integer indicates the new Integer value
     */
    public void setInteger(WholeNumbers integer){
        this.integer = integer;
    }

    /**
     * Method that returns the imaginary part of the value.
     *
     * @return null
     */
    @Override
    public WholeNumbers getImaginaryPart(){
        return null;
    }

    /**
     * Method that returns the numerator of the value
     *
     * @return this integer value
     */
    @Override
    public WholeNumbers getNumerator(){
        return integer;
    }

    /**
     * Method that returns the denominator of the value.
     * Integer number will have a denominator of 1.
     *
     * @return 1
     */
    @Override
    public WholeNumbers getDenominator(){
        return new WholeNumbers(false, new byte[]{1});
    }

    /**
     * Method that returns the string representation of integer number
     *
     * @return the string representation of the integer number
     */
    @Override
    public String toString(){
        return getRealPart().toString();
    }

    /**
     * Method that determines whether two integer numbers are equal
     *
     * @return boolean value indicates whether two values are equal
     *
     */
    @Override
    public boolean equals(Object o){
        if(o instanceof IntegerNumber){
            IntegerNumber a = (IntegerNumber) o;
            return getRealPart().equals(a.getRealPart());
        }
        return false;
    }

    /**
     * Method that adds two integer numbers
     *
     * @param value indicates the integer number to be added
     *              with this integer number
     *
     * @return the sum of two integer numbers
     *
     * @throws UnsupportedOperationException where two integer numbers
     * do not have the same sign
     */
    public IntegerNumber add(Integer value){

        return new IntegerNumber(getRealPart().add(getRealPart(),value.getRealPart()));
    }

}
