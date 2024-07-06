public class ResizeableCircle extends Circle implements Resizeable {
    public ResizeableCircle(double radius) {
        super(radius);
    }

    @Override
    public void resize(int percent) {
        setRadius(getRadius() * (1.0 + percent / 100.0));
    }

    @Override
    public String toString() {
        return "Resizeable " + super.toString();
    }

    private void setRadius(double radius) {
        super.radius = radius;
    }

    private double getRadius() {
        return super.radius;
    }
}