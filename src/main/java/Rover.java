import java.util.Objects;

public class Rover {

    private Position roverPosition;
    private Coordinates roverCoordinate;

    Rover(Position roverPosition, Coordinates roverCoordinate, Plateau plateau) {
        if (isRoverOutOfPlateau(plateau, roverPosition.getCoordinateX(), roverPosition.getCoordinateY())) {
            throw new BadCoordinatesException("The rover's position is out of plateau. Retype new position for rover.");
        }
        this.roverPosition = roverPosition;
        this.roverCoordinate = roverCoordinate;
    }

    public Position getRoverPosition() {
        return roverPosition;
    }

    public void setRoverPosition(Position roverPosition) {
        this.roverPosition = roverPosition;
    }

    public Coordinates getRoverCoordinate() {
        return roverCoordinate;
    }

    public void setRoverCoordinate(Coordinates roverCoordinate) {
        this.roverCoordinate = roverCoordinate;
    }

    @Override
    public String toString() {
        return roverPosition + " " + roverCoordinate + " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(roverPosition, rover.roverPosition) &&
                roverCoordinate == rover.roverCoordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roverPosition, roverCoordinate);
    }

    private void move() {
        Position movingOnMars = this.roverPosition;
        int x = movingOnMars.getCoordinateX();
        int y = movingOnMars.getCoordinateY();
        switch (this.roverCoordinate) {
            case N:
                this.roverPosition.setCoordinateY(y + 1);
                //System.out.println("New position after moving once on Mars: " + this.roverPosition);
                break;
            case S:
                this.roverPosition.setCoordinateY(y - 1);
                //System.out.println("New position after moving once on Mars: " + this.roverPosition);
                break;
            case W:
                this.roverPosition.setCoordinateX(x - 1);
                //System.out.println("New position after moving once on Mars: " + this.roverPosition);
                break;
            case E:
                this.roverPosition.setCoordinateX(x + 1);
                //System.out.println("New position after moving once on Mars: " + this.roverPosition);
                break;
        }
    }

    private void spin(Instructions direction) {
        Coordinates spinning = this.roverCoordinate;
        switch (direction) {
            case L:
                switch (spinning) {
                    case N:
                        this.roverCoordinate = Coordinates.W;
                        break;
                    case W:
                        this.roverCoordinate = Coordinates.S;
                        break;
                    case S:
                        this.roverCoordinate = Coordinates.E;
                        break;
                    case E:
                        this.roverCoordinate = Coordinates.N;
                        break;
                }
                break;
            case R:
                switch (spinning) {
                    case N:
                        this.roverCoordinate = Coordinates.E;
                        break;
                    case E:
                        this.roverCoordinate = Coordinates.S;
                        break;
                    case S:
                        this.roverCoordinate = Coordinates.W;
                        break;
                    case W:
                        this.roverCoordinate = Coordinates.N;
                        break;
                }
                break;
        }
        //System.out.println("Coordinate after rotation of the rover: " + this.roverCoordinate);
    }

    public void exploringMars(String input, Plateau plateau) {
        for (int i = 0; i < input.length(); i++) {
            char action = input.charAt(i);
            if (action == 'L') {
                this.spin(Instructions.L);
            } else if (action == 'R') {
                this.spin(Instructions.R);
            } else if (action == 'M') {
                this.move();
                if (isRoverOutOfPlateau(plateau, roverPosition.getCoordinateX(), roverPosition.getCoordinateY())) {
                    throw new BadInstructionException("The rover crossed the perimeter of the plateau. You had lost control of it.");
                }
            } else {
                throw new BadInstructionException("Instruction not defined. Insert a new valid action string!");
            }
        }
    }

    private boolean isRoverOutOfPlateau(Plateau plateauMars, int coordinateX, int coordinateY) {
        return (coordinateX > plateauMars.getUpperRight().getCoordinateX())
                || (coordinateX < plateauMars.getLowerLeft().getCoordinateX())
                || (coordinateY > plateauMars.getUpperRight().getCoordinateY())
                || (coordinateY < plateauMars.getLowerLeft().getCoordinateY());
    }
}