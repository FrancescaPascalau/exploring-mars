import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoverControlTest {

    @Test
    public void whenPassingValidInput_thenGetExpectedOutput() {
        String input = "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM";
        String actualOutput = RoverControl.roverControlOnMars(input);
        String expectedOutput = "1 3 N 5 1 E";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test(expected = BadCoordinatesException.class)
    public void whenNotIntegerPositionForPlateau_thenException() {
        String input = "Z 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM";
        RoverControl.roverControlOnMars(input);
    }

    @Test(expected = BadCoordinatesException.class)
    public void whenNotIntegerPositionForRover_thenException() {
        String input = "5 5 W 2 N LMLMLMLMM 3 3 E MMRMMRMRRM";
        RoverControl.roverControlOnMars(input);
    }

    @Test(expected = BadInstructionException.class)
    public void whenNotEnoughInstructionsGivenForLastRover_thenException() {
        String input = "5 5 1 2 N LMLMLMLMM 3 3 E";
        RoverControl.roverControlOnMars(input);
    }

    @Test
    public void whenControllingMoreThanTwoRovers_thenEachRoverFinishSequentiall() {
        String input = "6 6 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM 3 2 N LMLMLMLMM 2 2 E MMRMMRMRRM 3 2 N LMLMLMLMM";
        String actualOutput = RoverControl.roverControlOnMars(input);
        String expectedOutput = "1 3 N 5 1 E 3 3 N 4 0 E 3 3 N";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void whenControllingOnlyOneRover_thenEachRoverFinishSequentiall() {
        String input = "6 6 1 2 N LMLMLMLMM";
        String actualOutput = RoverControl.roverControlOnMars(input);
        String expectedOutput = "1 3 N";
        assertEquals(expectedOutput, actualOutput);
    }
}
