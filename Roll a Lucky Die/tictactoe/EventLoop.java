package tictactoe;

import java.util.Random;

public class EventLoop {

    State state = new State();
    UI ui = new UI();
    Random random = new Random();

    public static void main(String[] args) {
        EventLoop eventLoop = new EventLoop();
        eventLoop.run();
    }

    public void run() {
        while (state.getGameState() != Constants.QUIT_PROGRAM) {
            int gameState = state.getGameState();
            if (gameState == Constants.STANDBY) {
                state.setGameState(Constants.GET_PLAYER_NAME);

            } else if (gameState == Constants.GET_PLAYER_NAME) {
                state.setPlayerName(ui.promptForName());
                state.setGameState(Constants.ROLL_DICE);

            } else if (gameState == Constants.ROLL_DICE) {
                ui.printBoard(state);
                ui.promptRollDice();
                state.incrementRollCounter();  // Increment the roll counter
                int diceRoll = rollDice();
                System.out.println("You rolled a " + diceRoll);
                state.movePlayer(diceRoll);
                state.setGameState(Constants.MOVE_PLAYER);

            } else if (gameState == Constants.MOVE_PLAYER) {
                ui.printMove(state);
                state.setGameState(Constants.CHECK_WIN);

            } else if (gameState == Constants.CHECK_WIN) {
                if (state.isWinner()) {
                    ui.printBoard(state);
                    ui.printWinner(state);
                    ui.printRollCount(state);  // Print the roll count
                    state.setGameState(Constants.GAME_OVER);
                } else {
                    state.setGameState(Constants.ROLL_DICE);
                }

            } else if (gameState == Constants.GAME_OVER) {
                if (ui.startNewGame()) {
                    state.resetGame();
                    state.setGameState(Constants.STANDBY);
                } else {
                    state.setGameState(Constants.QUIT_PROGRAM);
                }
            }
        }
    }

    private int rollDice() {
        return random.nextInt(6) - 2;  // Roll dice and get number between -2 and 3
    }
}
