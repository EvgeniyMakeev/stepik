public class AsciiCharSequence implements CharSequence{
    private byte[] biteArr;

    public AsciiCharSequence(byte[] biteArr) {
        this.biteArr = biteArr;
    }

    @Override
    public int length() {
        return biteArr.length;
    }

    @Override
    public char charAt(int index) {
        return index >= 0 && index < biteArr.length ? charAt(biteArr[index]) : null;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        StringBuilder stringBuilder = new StringBuilder();
        if (start >= 0 && start < biteArr.length && end >= 0 && end < biteArr.length) {
            for (int i = start; i <= end; i++) {
                stringBuilder.append(charAt(biteArr[i]));
            }
            return stringBuilder;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
