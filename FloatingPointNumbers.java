/**
 * A class that represents number with as many
 * decimal digits as desired.
 *
 * @author Vo Linh Chi Dao
 */
public class FloatingPointNumbers {

    /*
    stores the precision - the number of decimal places
    of the number
    */
    private int precision;

    /*
    indicates whether the number is a negative value
    */
    private boolean isNegative;

    /*
    stores the digits of the number
    */
    private byte[] digits;

    /**
     * Constructor that initializes the field for arbitrary floating point number
     *
     * @param precision stores the number of decimal places
     * @param isNegative indicates the sign of the number
     * @param digits stores all digits of the number
     */
    public FloatingPointNumbers(int precision, boolean isNegative, byte[] digits){
        this.precision = precision;
        this.isNegative = isNegative;
        this.digits = this.removeLeadingZeros(digits);
    }

    /**
     * Method that returns the precision of the number
     *
     * @return the number of decimal places of the number
     */
    public int getPrecision(){
        return precision;
    }

    /**
     * Method that changes the precision of the number
     *
     * @param precision indicates the new number of decimal places
     */
    public void setPrecision(int precision){
        this.precision = precision;
    }

    /** Method that returns the indication of negative sign
     *
     * @return the indicator of the number's sign
     */
    public boolean isNegative(){
        return isNegative;
    }

    /**
     * Method that changes the sign of the number
     *
     * @param negative indicates the sign of the number
     */
    public void setNegative(boolean negative){
        this.isNegative = negative;
    }

    /**
     * Method that returns the digits array
     *
     * @return an array of digits of the number
     */
    public byte[] getDigits(){
        return digits;
    }

    /**
     * Method that changes the digits of the number
     *
     * @param digits indicates a new array of digits
     */
    public void setDigits(byte[] digits){
        this.digits = digits;
    }

    /**
     * Method that eliminates leading zeros
     *
     * @return a digits array without leading zeros
     */
    private byte[] removeLeadingZeros(byte[] digits){

        //if it is an empty array, the default value is 0
        if(digits.length == 0){
            return new byte[]{0};
        }

        //if length equal precision, there is no leading zeros
        if(digits.length <= getPrecision()){
            return digits;
        }

        //the current index of the digits array
        int i = digits.length - 1;

        //ignore all leading zeros of the digits array
        while(i != getPrecision() && digits[i] == 0){
            i = i - 1;
        }

        //the new digits array without leading zeros
        byte[] newList = new byte[i+1];

        //adding digits from input array to the new list
        for(;i >-1; i--){
            newList[i] = digits[i];
        }

        return newList;
    }

    /**
     * Method that eliminates trailing zeros in decimal places
     *
     * @return a new number with no trailing zeros
     */
    private FloatingPointNumbers removeTrailingZeros(){

        //return this number if it has no decimal places
        if(getPrecision() == 0){
            return this;
        }

        else{
            //stores the number of trailing zeros
            int count = 0;

            //the current index of list
            int i = 0;

            byte[] list = getDigits();

            //ignore the trailing zeros
            while (i != getPrecision() && list[i] == 0){
                i++;
                count++;
            }

            //stores the number without trailing zeros
            byte[] newList = new byte[list.length - count];

            //add digits from list to newList
            for (int j = 0; j < newList.length && i < list.length; j++, i++){
                newList[j] = list[i];
            }

            return new FloatingPointNumbers(getPrecision() - count, isNegative(), newList);
        }
    }

    /**
     * Method that adds leading zeros to number having fewer
     * integer parts
     *
     * @param numZero indicates the number of leading zeros
     *                will be added
     * @param numDigits indicates the digits array of the number
     *
     * @return a new digits array with additional leading zeros
     */
    protected byte[] addLeadingZeros(byte[] numDigits, int numZero){

        /* digits array that stores the new number with additional
        leading zeros */
        byte[] newVal = new byte[numDigits.length + numZero];

        //stores the current index of the newVal
        int i = 0;

        //add the digits of val to NewVal
        for(int j = 0; j < numDigits.length; j++, i++){
            newVal[i] = numDigits[j];
        }

        //add the trailing zeros to the newVal
        while(i < newVal.length){
            newVal[i] = 0;
            i++;
        }

        return newVal;
    }

    /**
     * Method that adds trailing zeros to number with
     * fewer precision
     *
     * @param numZero indicates the number of trailing zeros
     *                will be added
     * @param numDigits indicates the digits array of the number
     *
     * @return a new number with additional leading zeros
     */
    private byte[] addTrailingZeros(byte[] numDigits, int numZero){

        //stores new digits array with additional trailing zeros
        byte[] newVal = new byte[numDigits.length + numZero];

        //stores the current index of the newVal
        int i = 0;

        //add the trailing zeros to the newVal
        while(i < newVal.length && i < numZero ){
            newVal[i] = 0;
            i++;
        }

        //add the digits of val to NewVal
        for(int j = 0; j < numDigits.length && i < newVal.length; j++, i++){
            newVal[i] = numDigits[j];
        }

        return newVal;
    }

    /**
     * Method that returns the string representation
     * of the arbitrary floating point number
     *
     * @return string representation of the number
     */
    @Override
    public String toString(){

        //stores the digits of the number
        byte[] list = removeLeadingZeros(getDigits());

        //stores the string representation of the number
        StringBuilder b = new StringBuilder();

        //add the negative sign for the number
        if(isNegative){
            b.append('-');
        }

        //precision equals length of the list means that
        //number is between 0 and 1
        if(list.length == getPrecision()){
            b.append('0');
            //only append decimal point if precision larger than 0
            if(list.length != 0){
                b.append('.');
            }
            //add the decimal places to the string builder
            for(int i = list.length - 1; i > -1; i--){
                b.append(list[i]);
            }
        }

        //precision larger than length of the list
        else if(list.length < getPrecision()){
            b.append('0');
            b.append('.');
            //add leading zeros in the decimal parts
            for(int j = 0; j < getPrecision() - list.length; j++){
                b.append('0');
            }
            //add the decimal number from the list
            for(int i = list.length - 1; i > -1; i--){
                b.append(list[i]);
            }
        }

        //precision less than length of the list
        else{
            for(int i = list.length - 1; i > -1; i--) {
                //add decimal point when reaches first decimal number
                if(i == getPrecision() - 1){
                    b.append('.');
                }
                b.append(list[i]);
            }
        }
        return b.toString();
    }

    /**
     * Method that determines if two numbers are equal.
     * Numbers are considered equal if they represent
     * the same value.
     *
     * @return boolean value indicate whether two numbers
     * are equal
     */
    @Override
    public boolean equals(Object o){

        if (o instanceof FloatingPointNumbers){
            FloatingPointNumbers a = (FloatingPointNumbers) o;
            //compare two values after removing trailing zeros
            return removeTrailingZeros().toString().equals(a.removeTrailingZeros().toString());
        }
        return false;
    }

    /**
     * Method that adds two arbitrary floating point numbers
     *
     * @param value1 represents the first value in the operation
     * @param value2 represents the second value in the operation
     *
     * @return the sum of the two values
     *
     * @throws UnsupportedOperationException when two numbers do
     * not have the same sign
     */
    public FloatingPointNumbers add(FloatingPointNumbers value1, FloatingPointNumbers value2){

        //throw exception when sign of two numbers are not
        //the same
        if(value1.isNegative() != value2.isNegative()){
            throw new UnsupportedOperationException();
        }

        //stores the digits of two numbers
        byte[] num1 = value1.getDigits();
        byte[] num2 = value2.getDigits();

        //stores the precision of the number with
        //larger precision
        int largerPrecision;

        //add additional trailing zeros for number with smaller precision
        //and stores the precision of the number with larger precision
        if(value1.getPrecision() > value2.getPrecision()){
            num2 = addTrailingZeros(value2.getDigits(), value1.getPrecision() - value2.getPrecision());
            largerPrecision = value1.getPrecision();
        }
        else{
            num1 = addTrailingZeros(value1.getDigits(), value2.getPrecision() - value1.getPrecision());
            largerPrecision = value2.getPrecision();
        }

        //add additional leading zeros for number with fewer integer parts
        if(value1.getDigits().length - value1.getPrecision() > value2.getDigits().length - value2.getPrecision()){
            num2 = addLeadingZeros(num2, (value1.getDigits().length - value1.getPrecision()) - (value2.getDigits().length - value2.getPrecision()));
        }
        else{
            num1 = addLeadingZeros(num1, (value2.getDigits().length - value2.getPrecision()) - (value1.getDigits().length - value1.getPrecision()));
        }

        //stores sum array of the two values
        byte[] sumArray;

        if(num1.length > num2.length) {
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

        return new FloatingPointNumbers(largerPrecision, value1.isNegative(), sumArray);
    }

}

