package KI305.Lykhohrai.Lab5;
/**
 * Class <code>CalcException</code> more precises ArithmeticException
 * @version 1.0
 */

class CalcException extends ArithmeticException
{
    public CalcException(){}
    public CalcException(String cause)
    {
        super(cause);
    }
}