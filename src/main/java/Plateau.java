import java.util.Objects;

/**
 * Plateau class creates the place on Mars that the rovers are going to explore according to NASA's instructions.
 * To determine the plateau's size we use two position objects: one for lower-left corner and one for upper-right.
 * We assume that the lower-left corner is (0,0) so that is why the field is final.
 * The upper-right value will be generated from the input given by NASA.
 */

public class Plateau {

    private final Position lowerLeft = new Position(0, 0);
    private Position upperRight;

    /**
     * There is a condition on Plateau's constructor that doesn't allow to create a plateau object if the values of the
     * upper-right corner are not positive numbers so we only use one quadrant of the Cartesian coordinate system.
     */
    Plateau(Position upperRight) {
        if (!(upperRight.getCoordinateX() > 0 && upperRight.getCoordinateY() > 0)) {
            throw new BadCoordinatesException("The value of the upper right corner is negative. Retype new positive " +
                    "value.");
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
