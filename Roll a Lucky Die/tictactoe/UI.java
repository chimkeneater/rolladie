package tictactoe;

import java.util.Scanner;

public class UI {

    Scanner scanner;

    public UI() {
        scanner = new Scanner(System.in);
    }

    public String promptForName() {
        System.out.print(Constants.GET_PLAYER_NAME_PROMPT);
        return scanner.next();
    }

    public void promptRollDice() {
        System.out.print(Constants.ROLL_DICE_PROMPT);
        scanner.nextLine();
    }

    public void printBoard(State state) {
        System.out.println(Constants.DIVIDER_STRING);
        for (int col = 0; col < Constants.BOARD_COLUMNS; col++) {
            System.out.printf(Constants.BOARD_STRING, getSymbol(state.getBoardCell(col)));
        }
        System.out.println("|");
        System.out.println(Constants.DIVIDER_STRING);
    }

    private String getSymbol(int cellValue) {
        return (cellValue == Constants.PLAYER) ? "X" : " ";
    }

    public void printMove(State state) {
        System.out.printf(Constants.PRINT_MOVE, state.getPlayerName(), "X", state.getPlayerPosition() + 1);
        System.out.println();
    }

    public void printWinner(State state) {
        System.out.printf(Constants.WINNER, state.getPlayerName());
        System.out.println();
    }

    public void printRollCount(State state) {
        System.out.printf("You pressed Enter %d times.\n", state.getRollCounter());
    }

    public boolean startNewGame() {
        System.out.print(Constants.START_NEW_GAME);
        String yesOrNo = scanner.next();
        return yesOrNo.equalsIgnoreCase("Y");
    }
}
