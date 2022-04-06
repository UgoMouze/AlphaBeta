package adversarial.tictactoe;

import adversarial.AlphaBetaSearch;
import adversarial.IterativeDeepeningAlphaBetaSearch;
import adversarial.MinimaxSearch;

import java.util.List;
import java.util.Scanner;


public class TicTacToeGameplay {

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe("joueur");
        MinimaxSearch<List<Integer>, Integer, Integer> minimaxSearch = MinimaxSearch.createFor(game);
        AlphaBetaSearch<List<Integer>, Integer, Integer> alphabetaSearch = AlphaBetaSearch.createFor(game);
        IterativeDeepeningAlphaBetaSearch<List<Integer>, Integer, Integer> iterativeDeepeningAlphaBetaSearch = IterativeDeepeningAlphaBetaSearch.createFor(game, -1, 1, 10);
        List<Integer> state = game.getInitialState();
        while (!game.isTerminal(state)) {
            System.out.println("======================");
            TicTacToe.printState(state);
            int action = -1;
            if (state.get(0) == -1) {
                //human
                List<Integer> actions = game.getActions(state);
                Scanner in = new Scanner(System.in);
                while (!actions.contains(action)) {
                    System.out.println("Human player, what is your action? (number starting at 1 where value is 0)");
                    action = in.nextInt();
                }
            } else {
                //machine
                System.out.println("Machine player, what is your action? (number starting at 1 where value is 0)");
                action = minimaxSearch.makeDecision(state);
                System.out.println("Metrics for Minimax : " + minimaxSearch.getMetrics());
                alphabetaSearch.makeDecision(state);
                System.out.println("Metrics for AlphaBeta : " + alphabetaSearch.getMetrics());
                iterativeDeepeningAlphaBetaSearch.makeDecision(state);
                System.out.println("Metrics for IDAlphaBetaSearch : " + iterativeDeepeningAlphaBetaSearch.getMetrics());
            }
            System.out.println("Chosen action is " + action);
            state = game.getResult(state, action);
        }
        System.out.print("GAME OVER: ");
        if (game.getUtility(state, -1)==1)
            System.out.println("Human wins!");
        else if(game.getUtility(state, 1)==1){
            System.out.println("Machine wins!");
        }
        else
            System.out.println("No Winner");

    }
}
