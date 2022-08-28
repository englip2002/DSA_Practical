package Practical2.Fraction;

//INPLEMENTER FOR INTERFACE FRACTION
public class FractionConcrete implements Fraction {

    //class attribute
    private String numerator;
    private String denominator;

    @Override
    public void setNumerator(String N) {
        numerator = N;
    }

    @Override
    public void setDenominator(String D) {
        denominator = D;
    }

    @Override
    public String getNumerator() {
        return numerator;
    }

    @Override
    public String getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    //arithmetric operation
    @Override
    public Fraction add(Fraction B) {
        int nA = Integer.parseInt(this.numerator);
        int dA = Integer.parseInt(this.denominator);
        int nB = Integer.parseInt(B.getNumerator());
        int dB = Integer.parseInt(B.getDenominator());

        //build result
        Fraction result = new FractionConcrete();
        result.setNumerator(Integer.toString((nA * dB) + (dA * nB)));
        result.setDenominator(Integer.toString(dA * dB));
        return result;
    }

    @Override
    public Fraction minus(Fraction B) {
        int nA = Integer.parseInt(this.numerator);
        int dA = Integer.parseInt(this.denominator);
        int nB = Integer.parseInt(B.getNumerator());
        int dB = Integer.parseInt(B.getDenominator());

        //build result
        Fraction result = new FractionConcrete();
        result.setNumerator(Integer.toString((nA * dB) - (dA * nB)));
        result.setDenominator(Integer.toString(dA * dB));
        return result;
    }

    @Override
    public Fraction multiply(Fraction B){
        int nA = Integer.parseInt(this.numerator);
        int dA = Integer.parseInt(this.denominator);
        int nB = Integer.parseInt(B.getNumerator());
        int dB = Integer.parseInt(B.getDenominator());

        //build result
        Fraction result = new FractionConcrete();
        result.setNumerator(Integer.toString(nA * nB));
        result.setDenominator(Integer.toString(dA * dB));
        return result;
    }

    @Override
    public Fraction division(Fraction B){
         int nA = Integer.parseInt(this.numerator);
        int dA = Integer.parseInt(this.denominator);
        int nB = Integer.parseInt(B.getNumerator());
        int dB = Integer.parseInt(B.getDenominator());

        //build result
        Fraction result = new FractionConcrete();
        result.setNumerator(Integer.toString(nA * dB));
        result.setDenominator(Integer.toString(dA * nB));
        return result;
    }
}
