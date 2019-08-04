import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlateauTest {

    @Test
    public void whenTwoPlateauWithSamePosition_thenEquals() {
        Position position = new Position(10, 10);
        Plateau expectedPlateau = new Plateau(position);
        Plateau actualPlateau = new Plateau(position);
        assertEquals(actualPlateau, expectedPlateau);
    }

    @Test(expected = BadCoordinatesException.class)
    public void whenNegativePosition_thenException() {
        Position position = new Position(-1, 10);
        new Plateau(position);
    }
}
