import java.util.Objects;

/**
 * This class is used by plateau and rover objects to express their position on a cartesian coordinate system.
 * Coordinate X represents a point on X-axis and coordinate Y a point on Y-axis.
 * A point on the plane is composed by both values: (x-value, y-value).
 */

public class Position {

    private int coordinateX;
    private int coordinateY;

    Position(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return coordinateX == position.coordinateX &&
                coordinateY == position.coordinateY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinateX, coordinateY);
    }

    @Override
    public String toString() {
        return coordinateX + " " + coordinateY;
    }
}
