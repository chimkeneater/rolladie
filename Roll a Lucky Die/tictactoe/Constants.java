package tictactoe;

/**
 * Game constants for the new dice-based game.
 */
public class Constants
{
    // Valid board size
    public static final int BOARD_ROW = 1;
    public static final int BOARD_COLUMNS = 10;

    // Valid board values
    public static final int PLAYER = 1;    // Indicates the player's symbol "X"
    public static final int BLANK = 0; // Indicates a blank square

    // Game states
    public static final int STANDBY = 0;
    public static final int GET_PLAYER_NAME = 1;
    public static final int ROLL_DICE = 2;
    public static final int MOVE_PLAYER = 3;
    public static final int CHECK_WIN = 4;
    public static final int GAME_OVER = 5;
    public static final int QUIT_PROGRAM = 6;

    // Strings
    public static final String DIVIDER_STRING = "|---|---|---|---|---|---|---|---|---|---|";
    public static final String BOARD_STRING = "| %s ";
    public static final String GET_PLAYER_NAME_PROMPT = "Player: What is your name? -->";
    public static final String ROLL_DICE_PROMPT = "Press Enter to roll the dice.";
    public static final String PRINT_MOVE = "Player %s (%s) moves to position %d";
    public static final String WINNER = "Congratulations %s! You reached the end!";
    public static final String START_NEW_GAME = "Start a new game (Y or N)? -->";
}
