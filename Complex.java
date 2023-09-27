/**
 * An interface that represents complex number
 *
 * @author Vo Linh Chi Dao
 */
public interface Complex{

    /**
     * Method that returns the real component
     *
     * @return the real part of the complex number
     */
    FloatingPointNumbers getRealPart();

    /**
     * Method that returns the imaginary component
     *
     * @return the imaginary part of the complex number
     */
    FloatingPointNumbers getImaginaryPart();

    /**
     * Method that returns the string representation of the complex number
     *
     * @return the string representation of the complex number
     */
    String toString();

    /**
     * Method that determines whether two numbers are equal
     *
     * @return boolean value indicates whether two values are equal
     */
    boolean equals(Object o);

}
