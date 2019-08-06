import java.util.Objects;

/**
 * This class generates the rover objects that are going to explore the Mars according to NASA's instructions.
 * roverPosition determine the actual position of the rover on the plateau.
 * roverCoordinate determine the cardinal direction that the rover is facing.
 */

public class Rover {

    private Position roverPosition;
    private Coordinates roverCoordinate;

    /**
     * This constructor checks if the position of the rover is outside the plateau.
     * If it is outside the plateau, it throws a BadCoordinatesException.
     * In this way, all rovers will be created inside the plateau.
     */
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

    /**
     * This method creates the moving action that the rover will do while exploring the plateau.
     * The 'M' instruction from input triggers the rover to move forward one grid.
     * The method is private because it is called from exploringMars() method inside the same class.
     */
    private void move() {
        Position movingOnMars = this.roverPosition;
        int x = movingOnMars.getCoordinateX();
        int y = movingOnMars.getCoordinateY();
        switch (this.roverCoordinate) {
            case N:
                this.roverPosition.setCoordinateY(y + 1);
                break;
            case S:
                this.roverPosition.setCoordinateY(y - 1);
                break;
            case W:
                this.roverPosition.setCoordinateX(x - 1);
                break;
            case E:
                this.roverPosition.setCoordinateX(x + 1);
                break;
        }
    }

    /**
     * This method creates the spinning action that the rover will do while exploring the plateau.
     * The 'L' and 'R' instructions from input triggers the rover to rotate left or right.
     * The method is private because it is called from exploringMars() method inside the same class.
     *
     * @param direction This parameter shows the way that the rover should spin.
     */
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
    }

    /**
     * This method takes the string input character by character and calls the right method for rover object
     * If the character is 'L' or 'R' it will call spin() method, if i is 'M' it calls move() method.
     * It also calls the isRoverOutOfPlateau() method while moving to assure that the rover doesn't cross the edge of
     * the plateau.
     * In case that the character is not defined it throws a BadInstructionException.
     *
     * @param input   The string input inserted by NASA that contains the instruction for the rover
     * @param plateau The plateau where the rover is placed to explore
     */
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
                    throw new BadInstructionException("The rover crossed the perimeter of the plateau. You had lost " +
                            "control of it.");
                }
            } else {
                throw new BadInstructionException("Instruction not defined. Insert a new valid action string!");
            }
        }
    }

    /**
     * This method checks if the rovers cross the plateau's edges.
     *
     * @param plateauMars The plateau that the rover has to explore
     * @param coordinateX Coordinate X of the rover's position
     * @param coordinateY Coordinate Y of the rover's position
     * @return It returns true if the rover is out of plateau and false if it doesn't cross the plateau edges.
     */
    private boolean isRoverOutOfPlateau(Plateau plateauMars, int coordinateX, int coordinateY) {
        return (coordinateX > plateauMars.getUpperRight().getCoordinateX())
                || (coordinateX < plateauMars.getLowerLeft().getCoordinateX())
                || (coordinateY > plateauMars.getUpperRight().getCoordinateY())
                || (coordinateY < plateauMars.getLowerLeft().getCoordinateY());
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

    @Override
    public String toString() {
        return roverPosition + " " + roverCoordinate + " ";
    }
}