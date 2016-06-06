public class Board {

    private Player[][] board = new Player[3][3];

    public boolean move(Player player, int x, int y) throws InvalidMoveException {
        if (!((x >= 0 && x <= 2) && (y >= 0 && y <= 2))) return false;
        if (playerAt(x, y) == null) {
                throw new InvalidMoveException();
        }
        board[x][y] = player;
        return true;
    }

    public Player playerAt(int x, int y) {
        return board[x][y];
    }
}
