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

    @Test
    public void whenMoreThan1000Rovers_thenOk() {
        String actualOutput = RoverControl.roverControlOnMars(TestConstants.VERY_LONG_INPUT);
        assertEquals(TestConstants.EXPECTED_VERY_LONG_OUTPUT, actualOutput);
    }

    @Test
    public void whenOneRoverHasMoreThan1000Instructions_thenOk() {
        String actualOutput = RoverControl.roverControlOnMars(TestConstants.VERY_LONG_INSTUCTION_INPUT);
        String expectedOutput = "1 2 N";
        assertEquals(expectedOutput, actualOutput);
    }

    private static class TestConstants {

        private static final String VERY_LONG_INPUT =
                "5 5 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM " +
                        "1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM 1 2 N LMLMLMLMM ";

        private static final String EXPECTED_VERY_LONG_OUTPUT =
                "1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N" +
                        " 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N 1 3 N";

        private static final String VERY_LONG_INSTUCTION_INPUT = "5 5 1 2 N " +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL";
    }
}
