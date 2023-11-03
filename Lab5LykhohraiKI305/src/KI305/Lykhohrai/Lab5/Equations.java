package KI305.Lykhohrai.Lab5;
/**
 * Class <code>Equations</code> implements method for  y=tg(x)ctg(2x) expression calculation
 * @version 1.0
 */
class Equations
{
    public double calculate(double x) throws CalcException
    {
        double y, rad;
        rad = x * Math.PI / 180.0;
        try
        {
            y = (1 / Math.tan(rad)) / ( Math.sin(2 * rad) + 4 * Math.cos(rad));
            if (x==90 || x== -90 || x==0 || x==-180 || x==180 || 2*x == 90 || 2*x == -90 || 2*x == 180 || 2*x == -180 )
                throw new ArithmeticException();
        }
        catch (ArithmeticException ex)
        {
            if (x==90 || x== -90 || x==-180 || x==180 || 2*x == 90 || 2*x == -90 || 2*x == 180 || 2*x == -180 )
                throw new CalcException("Недопустиме значення при обчислені значення знаменника!");

            else if (x==0)
                throw new CalcException("Недопустиме значення при обчислені значення котангенса!");
            else
                throw new CalcException("Інша причина винятку!");
        }
        return y;
    }
}
