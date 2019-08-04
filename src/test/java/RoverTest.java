import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoverTest {

    @Test
    public void whenTwoRoversWithSameCoordinates_thenEquals() {
        Position plateauPosition = new Position(10, 10);
        Plateau plateau = new Plateau(plateauPosition);
        Position roverPosition = new Position(5, 5);
        Rover actualRover = new Rover(roverPosition, Coordinates.N, plateau);
        Rover expectedRover = new Rover(roverPosition, Coordinates.N, plateau);
        assertEquals(actualRover, expectedRover);
    }

    @Test(expected = BadCoordinatesException.class)
    public void whenRoverOutOfPlateau_thenException() {
        Position plateauPosition = new Position(10, 10);
        Plateau plateau = new Plateau(plateauPosition);
        Position roverPosition = new Position(11, 10);
        new Rover(roverPosition, Coordinates.N, plateau);
    }

    @Test(expected = BadInstructionException.class)
    public void whenRoverInstructionsIsNotDefined_thenException() {
        Position plateauPosition = new Position(5, 5);
        Plateau plateau = new Plateau(plateauPosition);
        Position roverPosition = new Position(1, 2);
        Rover rover = new Rover(roverPosition, Coordinates.N, plateau);
        rover.exploringMars("LMXLMLMLMM", plateau);
    }

    @Test(expected = BadInstructionException.class)
    public void whenRoverCrossThePlateau_thenException() {
        Position plateauPosition = new Position(5, 5);
        Plateau plateau = new Plateau(plateauPosition);
        Position roverPosition = new Position(1, 2);
        Rover rover = new Rover(roverPosition, Coordinates.N, plateau);
        rover.exploringMars("LMMMMMM", plateau);
    }

    @Test
    public void whenRoverSpinLeft_thenRoverCoordinateChange() {
        Position plateauPosition = new Position(5, 5);
        Plateau plateau = new Plateau(plateauPosition);
        Position roverPosition = new Position(1, 2);
        Rover rover = new Rover(roverPosition, Coordinates.N, plateau);
        rover.exploringMars("L", plateau);
        assertEquals(rover.getRoverCoordinate(), Coordinates.W);
    }

    @Test
    public void whenRoverSpinRight_thenRoverCoordinateChange() {
        Position plateauPosition = new Position(5, 5);
        Plateau plateau = new Plateau(plateauPosition);
        Position roverPosition = new Position(1, 2);
        Rover rover = new Rover(roverPosition, Coordinates.N, plateau);
        rover.exploringMars("R", plateau);
        assertEquals(rover.getRoverCoordinate(), Coordinates.E);
    }

    @Test
    public void whenRoverMoves_thenRoverPositionChange() {
        Position plateauPosition = new Position(5, 5);
        Plateau plateau = new Plateau(plateauPosition);
        Position roverPosition = new Position(1, 2);
        Rover rover = new Rover(roverPosition, Coordinates.N, plateau);
        rover.exploringMars("M", plateau);
        Position expectedPosition = new Position(1,3);
        assertEquals(roverPosition, expectedPosition);
    }
}
