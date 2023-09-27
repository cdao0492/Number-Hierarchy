/**
 * A class that represent natural number
 * (non-negative whole number)
 *
 * @author Vo Linh Chi Dao
 */
public class NaturalNumber implements Natural{

    //stores the natural number value
    private byte[] natural;

    /**
     * Constructor that initializes fields for natural number
     *
     * @param natural indicates the digits array of
     *                natural number
     */
    public NaturalNumber(byte[] natural){
        new WholeNumbers(false,natural);
        this.natural = natural;
    }

    /**
     * Method that returns the digits array storing
     * the natural number value
     *
     * @return the digits array of the natural number
     */
    public byte[] getNatural(){
        return natural;
    }

    /**
     * Method that changes the natural number value
     *
     * @param natural indicates the new array digits of
     *                the natural number
     */
    public void setNatural(byte[] natural){
        this.natural = natural;
    }

    /**
     * Method that returns the real part of natural number
     *
     * @return the natural number value
     */
    @Override
    public WholeNumbers getRealPart(){
        return new WholeNumbers(false, getNatural());
    }

    /**
     * Method that returns the imaginary part of natural number
     *
     * @return null
     */
    @Override
    public WholeNumbers getImaginaryPart(){
        return null;
    }

    /**
     * Method that returns the numerator of natural number
     *
     * @return the natural number value
     */
    @Override
    public WholeNumbers getNumerator(){
        return new WholeNumbers(false, getNatural());
    }

    /**
     * Method that returns the denominator of natural number.
     * Every natural value has denominator of 1.
     *
     * @return 1
     */
    @Override
    public WholeNumbers getDenominator(){
        return new WholeNumbers(false, new byte[]{1});
    }

    /**
     * Method that returns the string representation of natural number
     *
     * @return the string representation of the natural number
     */
    @Override
    public String toString(){
        return getRealPart().toString();
    }

    /**
     * Method that determines whether two natural numbers are equal
     *
     * @return boolean value indicates whether two values are equal
     *
     */
    @Override
    public boolean equals(Object o){
        if(o instanceof NaturalNumber){
            NaturalNumber a = (NaturalNumber) o;
            return getRealPart().equals(a.getRealPart());
        }
        return false;
    }

    /**
     * Method that adds two natural numbers
     *
     * @param value indicates the natural number to be added
     *              with this natural number
     *
     * @return the sum of two natural numbers
     */
    public NaturalNumber add(Natural value){

        //stores the sum digits of two numbers
        byte[] sumArray = (getRealPart().add(getRealPart(),value.getRealPart())).getDigits();
        return new NaturalNumber(sumArray);
    }

}
