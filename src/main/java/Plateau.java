public class Plateau {

    private Position upperRight;
    private final Position lowerLeft = new Position(0, 0);

    Plateau(Position upperRight){
        this.upperRight = upperRight;
    }

    public Position getUpperRight() {
        return upperRight;
    }

    public void setUpperRight(Position upperRight) {
        this.upperRight = upperRight;
    }

    public Position getLowerLeft() {
        return lowerLeft;
    }

    @Override
    public String toString() {
        return "Plateau on Mars with coordinates: " +
                "Upper right corner -> " + upperRight +
                ",lower left corner -> " + lowerLeft;
    }
}
