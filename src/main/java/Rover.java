public class Rover {

    private Position roverPosition;
    private Coordinates roverCoordinate;

    Rover(Position roverPosition, Coordinates roverCoordinate) {
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
        return "Rover{ " +
                "roverPosition -> " + roverPosition +
                ", roverCoordinate -> " + roverCoordinate +
                '}';
    }

    public void move() {
        System.out.println("Current position: " + this);
        Position movingOnMars = this.roverPosition;
        int x = movingOnMars.getCoordinateX();
        int y = movingOnMars.getCoordinateY();
        switch (this.roverCoordinate) {
            case N:
                this.roverPosition = new Position(x, y + 1);
                System.out.println("New position after moving once on Mars: " + this.roverPosition);
                break;
            case S:
                this.roverPosition = new Position(x, y - 1);
                System.out.println("New position after moving once on Mars: " + this.roverPosition);
                break;
            case W:
                this.roverPosition = new Position(x - 1, y);
                System.out.println("New position after moving once on Mars: " + this.roverPosition);
                break;
            case E:
                this.roverPosition = new Position(x + 1, y);
                System.out.println("New position after moving once on Mars: " + this.roverPosition);
                break;
        }
    }

    public void spin(Instructions direction) {
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
        System.out.println("Coordinate after rotation of the rover: " + this.roverCoordinate);
    }

    public void exploringMars(String input) {
        for (int i = 0; i < input.length(); i++) {
            char action = input.charAt(i);
            if (action == 'L') {
                this.spin(Instructions.L);
            } else if (action == 'R') {
                this.spin(Instructions.R);
            } else {
                this.move();
            }
        }
    }
}