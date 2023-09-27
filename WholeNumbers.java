/**
 * A class that represents integer with as many
 * digits as desired.
 *
 * @author Vo Linh Chi Dao
 */

public class WholeNumbers extends FloatingPointNumbers{

    /**
     * Constructor that initializes the fields for whole number
     *
     * @param isNegative indicates the sign of the number
     * @param digits stores the digits array of the number
     */
    public WholeNumbers(boolean isNegative, byte[] digits){
        super(0, isNegative, digits);
    }

    /**
     * Method that adds two whole numbers
     *
     * @param value1 represents the first value
     * @param value2 represents the second value
     *
     * @return the sum of two whole numbers
     *
     * @throws UnsupportedOperationException when two numbers do
     * not have the same sign
     */
    public WholeNumbers add(WholeNumbers value1, WholeNumbers value2){


        if(value1.isNegative() != value2.isNegative()){
            throw new UnsupportedOperationException();
        }

        //stores the digits of two numbers
        byte[] num1 = value1.getDigits();
        byte[] num2 = value2.getDigits();

        //add additional leading zeros for number with fewer number of digits
        if(value1.getDigits().length - value1.getPrecision() > value2.getDigits().length - value2.getPrecision()){
            num2 = addLeadingZeros(num2, (value1.getDigits().length - value1.getPrecision()) - (value2.getDigits().length - value2.getPrecision()));
        }
        else{
            num1 = addLeadingZeros(num1, (value2.getDigits().length - value2.getPrecision()) - (value1.getDigits().length - value1.getPrecision()));
        }

        //stores sum array of the two values
        byte[] sumArray;

        if(num1.length > num2.length){
            //add 1 to account for sum carry
            sumArray = new byte[num1.length + 1];
        }
        else{
            //add 1 to account for sum carry
            sumArray = new byte[num2.length + 1];
        }

        //add two elements at each index and store result in the sumArray
        for(int i = 0; i < sumArray.length && i < num1.length; i++){
            //stores the sum of at each index
            byte sum = (byte) (sumArray[i] + num1[i] + num2[i]);
            //account for sum carry
            if (sum >= 10 && i+1 < sumArray.length){
                sumArray[i] = (byte)(sum - 10);
                //add the carry to the next index
                sumArray[i+1] = 1;
            }
            else{
                sumArray[i] = sum;
            }
        }

        return new WholeNumbers(value1.isNegative(), sumArray);
    }

}
