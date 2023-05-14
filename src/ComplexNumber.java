// HashCode для double

public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.re, re) == 0 && Double.compare(that.im, im) == 0;
    }

    @Override
    public int hashCode() {
        int result = 13;
        long lRe = result;
        long lIm = result;
        if (re != 0) {
            lRe = (long) ((re * 1000) % 10);
        }
        if (im != 0) {
            lIm = (long) ((im * 1000) % 10);
        }
        result = 37 * result + (int)(lRe ^ (lRe >>> 32));
        result = 37 * result + (int)(lIm ^ (lIm >>> 32));
        return result;
    }

    public static void main(String[] args) {
        ComplexNumber cn1 = new ComplexNumber(2.3412,7.2434);
        ComplexNumber cn2 = new ComplexNumber(2.3412,7.2434);
        ComplexNumber cn3 = new ComplexNumber(3.23124,1435.23);
        System.out.println("equals cn1 & cn2 true // " + cn1.equals(cn2));
        System.out.println("equals cn2 & cn1 true // " + cn2.equals(cn1));
        System.out.println("equals cn2 & cn3 false // " + cn2.equals(cn3));
        System.out.println("equals cn3 & cn1 false // " + cn3.equals(cn1));
        System.out.println("hash cn1 & cn2 true // " + (cn1.hashCode() == cn2.hashCode()));
        System.out.println("hash cn2 & cn1 true // " + (cn2.hashCode() == cn1.hashCode()));
        System.out.println("hash cn3 & cn1 false // " + (cn3.hashCode() == cn1.hashCode()));
        System.out.println("hash cn3 & cn2 false // " + (cn3.hashCode() == cn2.hashCode()));
    }
}
