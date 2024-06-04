package tictactoe;

/**
 * Game state variables for the new dice-based game.
 */
public class State
{
    private int gameState = Constants.STANDBY;
    private String playerName = "";
    private int[][] board = new int[Constants.BOARD_ROW][Constants.BOARD_COLUMNS];
    private int playerPosition = 0;
    private int rollCounter = 0;  // Counter to track the number of dice rolls

    public State() {
        resetGame();
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    public int getBoardCell(int col) {
        return this.board[0][col];
    }

    public void setBoardCell(int col, int value) {
        this.board[0][col] = value;
    }

    public void movePlayer(int diceRoll) {
        int newPosition = playerPosition + diceRoll;
        if (newPosition < 0) {
            newPosition = 0;
        } else if (newPosition >= Constants.BOARD_COLUMNS) {
            newPosition = Constants.BOARD_COLUMNS - 1;
        }
        board[0][playerPosition] = Constants.BLANK;
        playerPosition = newPosition;
        board[0][playerPosition] = Constants.PLAYER;
    }

    public boolean isWinner() {
        return playerPosition == Constants.BOARD_COLUMNS - 1;
    }

    public int getRollCounter() {
        return rollCounter;
    }

    public void incrementRollCounter() {
        this.rollCounter++;
    }

    public void resetGame() {
        // Clear the board
        for (int j = 0; j < Constants.BOARD_COLUMNS; j++) {
            board[0][j] = Constants.BLANK;
        }
        // Reset game-related variables
        gameState = Constants.STANDBY;
        playerName = "";
        playerPosition = 0;
        rollCounter = 0;  // Reset the roll counter
        board[0][playerPosition] = Constants.PLAYER;
    }
}
