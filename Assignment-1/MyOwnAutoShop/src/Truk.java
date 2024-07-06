public class Truk extends Mobil {
    private int weight;

    public Truk(int speed, double regularPrice, String color, int weight) {
        super(speed, regularPrice, color);
        this.weight = weight;
    }

    @Override
    public double getSalePrice() {
        if (weight > 2000) {
            return super.getRegularPrice() * 0.9; // 10% discount
        } else {
            return super.getRegularPrice();
        }
    }

    public int getWeight() {
        return weight;
    }
}