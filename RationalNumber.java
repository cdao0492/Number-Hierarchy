/**
 * A class that represents rational number
 * (division of an integer over a non-zero integer)
 *
 * @author Vo Linh Chi Dao
 */
public class RationalNumber implements Rational{

    //stores the numerator of the rational number
    private WholeNumbers numerator;

    //stores the denominator of the rational number
    private WholeNumbers denominator;

    /**
     * Constructor that initializes fields for the rational number
     *
     * @param numerator indicates the numerator of the number
     * @param denominator indicates the denominator of the number
     */
    public RationalNumber(WholeNumbers numerator, WholeNumbers denominator){
        this.numerator = numerator;
        //account for zero denominator
        if(!denominator.equals(new WholeNumbers(false,new byte[]{0}))){
            this.denominator = denominator;
        }
        //if denominator is 0, change to default value of 1
        else{
            this.denominator = new WholeNumbers(false,new byte[]{1});
        }
    }

    /**
     * Method that returns the numerator
     *
     * @return the numerator of the rational number
     */
    @Override
    public WholeNumbers getNumerator(){
        return numerator;
    }

    /**
     * Method that changes the numerator of the value
     *
     * @param numerator indicates the new numerator
     */
    public void setNumerator(WholeNumbers numerator){
        this.numerator = numerator;
    }

    /**
     * Method that returns the denominator
     *
     * @return the denominator of the rational number
     */
    @Override
    public WholeNumbers getDenominator(){
        return denominator;
    }

    /**
     * Method that changes the denominator of the value
     *
     * @param denominator indicates the new denominator
     */
    public void setDenominator(WholeNumbers denominator){
        this.denominator = denominator;
    }

    /**
     * Method that returns the real part of the rational number
     *
     * @return null
     */
    @Override
    public FloatingPointNumbers getRealPart(){
        return null;
    }

    /**
     * Method that returns the imaginary part of the rational number
     *
     * @return null
     */
    @Override
    public FloatingPointNumbers getImaginaryPart(){
        return null;
    }

    /**
     * Method that returns the string representation of the rational number
     *
     * @return the string representation of the rational number
     */
    @Override
    public String toString(){
        return getNumerator().toString() + " / " + getDenominator().toString();
    }

    /**
     * Method that returns determine if two real numbers are equal.
     * Two rational numbers are equal if their numerators and denominators
     * are the same.
     *
     * @return boolean value indicates whether two rational numbers
     * are equal
     */
    @Override
    public boolean equals(Object o){
        if(o instanceof RationalNumber){
            RationalNumber a = (RationalNumber) o;
            return getNumerator().equals(a.getNumerator()) &&
                    getDenominator().equals(a.getDenominator());
        }
        return false;
    }

    /**
     * Method that adds two rational numbers
     *
     * @param value indicates the rational number to be added
     *              with this rational number
     *
     * @return the sum of two rational numbers
     *
     * @throws UnsupportedOperationException when the denominators
     * are different or the numerators do not have the same sign
     * for two numbers
     */
    public RationalNumber add(Rational value){

        return new RationalNumber(getNumerator().add(getNumerator(),value.getNumerator()),getDenominator());
    }

}
