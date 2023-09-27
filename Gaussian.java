/**
 * An interface that represents Gaussian Integer
 *
 * @author Vo Linh Chi Dao
 */
public interface Gaussian extends Complex{

    /**
     * Method that returns the real component
     *
     * @return the real part of the Gaussian Integer
     */
    @Override
    WholeNumbers getRealPart();

    /**
     * Method that returns the imaginary component
     *
     * @return the imaginary part of the Gaussian Integer
     */
    @Override
    WholeNumbers getImaginaryPart();

}
