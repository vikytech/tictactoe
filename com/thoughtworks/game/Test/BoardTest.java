import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class BoardTest {
    private Board board;

    @Before
    public void setup() {
        board = new Board();
    }

    @Test
    public void shouldMoveThePlayer() throws InvalidMoveException {
        assertTrue(board.move(Player.COMPUTER, 0, 0));
    }

    @Test
    public void shouldNotMoveWhenInvalidXBoundary() throws InvalidMoveException {
        assertFalse(board.move(Player.HUMAN, -100, 0));
    }

    @Test
    public void shouldNotMoveWhenInvalidYBoundary() throws InvalidMoveException {
        assertFalse(board.move(Player.COMPUTER, 0, -1));
    }

    @Test
    public void shouldReturnPlayerTypeGivenPosition() throws InvalidMoveException {
        board.move(Player.COMPUTER, 0, 0);
        assertEquals(Player.COMPUTER, board.playerAt(0, 0));
    }

    @Test(expected = InvalidMoveException.class)
    public void shouldThrowExceptionWhenPositionIsOccupied() throws InvalidMoveException {
        board.move(Player.COMPUTER, 0, 0);
        board.move(Player.HUMAN, 0, 0);

    }
}