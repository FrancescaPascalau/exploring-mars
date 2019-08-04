import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionTest {

    @Test
    public void whenCreatingTwoPositionObjects_thenEquals() {
        Position actualPosition = new Position(5, 5);
        Position expectedPosition = new Position(5, 5);
        assertEquals(actualPosition, expectedPosition);
    }
}
