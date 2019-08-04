import java.util.Objects;

public class Plateau {

    private Position upperRight;
    private final Position lowerLeft = new Position(0, 0);

    Plateau(Position upperRight) {
        if (!(upperRight.getCoordinateX() > 0 && upperRight.getCoordinateY() > 0)) {
            throw new BadCoordinatesException("The value of the upper right corner is negative. Retype new positive value.");
        }
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plateau plateau = (Plateau) o;
        return Objects.equals(upperRight, plateau.upperRight) &&
                Objects.equals(lowerLeft, plateau.lowerLeft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(upperRight, lowerLeft);
    }

    @Override
    public String toString() {
        return "Plateau on Mars with coordinates: " +
                "Upper right corner -> " + upperRight +
                ", lower left corner -> " + lowerLeft;
    }
}
