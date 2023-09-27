/**
 * An interface that represents rational number
 *
 * @author Vo Linh Chi Dao
 */
public interface Rational extends Real{

    /**
     * Method that returns the numerator
     *
     * @return the numerator of the rational number
     */
    WholeNumbers getNumerator();

    /**
     * Method that returns the denominator
     *
     * @return the denominator of the rational number
     */
    WholeNumbers getDenominator();

}
