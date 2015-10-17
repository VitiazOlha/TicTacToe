public class HumanPlayer implements Player {
    private ConsoleUserInputProvider userInputProvider;

    public HumanPlayer(ConsoleUserInputProvider userInputProvider) {
        this.userInputProvider = userInputProvider;
    }

    @Override
    public void doStep(Board board, int value) {
        int x, y;
        do {
            x = userInputProvider.inputCoordinatesForNextHumanStep('X');
            y = userInputProvider.inputCoordinatesForNextHumanStep('Y');
        } while (board.isPossibleToMove(x, y));
        board.setFieldValue(x - 1, y - 1, value);
        System.out.print(board.convertToString());
        // TODO impolement putting symbol by keyboard input
    }


}
