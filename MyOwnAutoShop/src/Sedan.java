public class Sedan extends Mobil {
    private int length;

    public Sedan(int speed, double regularPrice, String color, int length) {
        super(speed, regularPrice, color);
        this.length = length;
    }

    @Override
    public double getSalePrice() {
        if (length > 6) {
            return super.getRegularPrice() * 0.95; // 5% discount
        } else {
            return super.getRegularPrice();
        }
    }

    public int getLength() {
        return length;
    }
}
