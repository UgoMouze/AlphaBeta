package adversarial.tictactoe;

import adversarial.Game;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe implements Game<List<Integer>, Integer, Integer> {

    public final static Integer[] players = {-1, 1};
    public final static List<Integer> initialState = new ArrayList<Integer>();

    /**
     * Sait qui commence
     * @param qui_commence joueur, pour que ce soit le joueur qui commence
     */
    public TicTacToe(String qui_commence) {
        if(qui_commence.equals("joueur"))initialState.add(-1);
        else initialState.add(1);
        for(int i=1; i<10; i++)initialState.add(0);
    }

    @Override
    public List<Integer> getInitialState() {
        return initialState;
    }

    @Override
    public Integer[] getPlayers() {
        return players;
    }

    @Override
    public Integer getPlayer(List<Integer> state) {
        return state.get(0);
    }

    @Override
    public List<Integer> getActions(List<Integer> state) {
        ArrayList<Integer> actions = new ArrayList<Integer>();
        for(int i=1; i<10; i++){
            if(state.get(i).equals(0))actions.add(i);
        }
        return actions;
    }

    @Override
    public List<Integer> getResult(List<Integer> state, Integer action) {
        ArrayList<Integer> newState = new ArrayList<Integer>();
        newState.add(-state.get(0));
        for(int i=1; i<10; i++){
            if(i!=action){
                newState.add(state.get(i));
            }
            else{
                newState.add(state.get(0));
            }
        }
        return newState;
    }

    @Override
    public boolean isTerminal(List<Integer> state) {
        Integer[] numbers = {0, 3, 6};
        Integer[] numbers2 = {1, 2, 3};
        boolean notFull=false;
        //vérification pour chaque joueur
        for(int p : TicTacToe.players){
            // vérification par ligne
            for(int i : numbers) {
                if (state.get(1 + i).equals(state.get(2 + i)) && state.get(3 + i).equals(p) && state.get(1 + i).equals(state.get(3+i))) {
                    return true;
                }
            }
            // vérification par colonne
            for(int j : numbers2){
                if(state.get(j).equals(state.get(j+3)) && state.get(j+6).equals(p) && state.get(j).equals(state.get(j+6))){
                    return true;
                }
            }
            //vérification pour les diagonales
            if(state.get(1).equals(state.get(5)) && state.get(5).equals(state.get(9)) && state.get(5).equals(p)){
                return true;
            }
            if(state.get(3).equals(state.get(5)) && state.get(5).equals(state.get(7)) && state.get(5).equals(p)){
                return true;
            }
        }
        for(int i=1; i<10; i++){
            if(state.get(i).equals(0)) notFull = true;
        }
        return !notFull;
    }


    @Override
    public double getUtility(List<Integer> state, Integer player) {
        Integer[] numbers = {0, 3, 6};
        Integer[] numbers2 = {1, 2, 3};
        //vérification pour chaque joueur
        for(int p : TicTacToe.players){
            // vérification par ligne
            for(int i : numbers) {
                if (state.get(1 + i).equals(state.get(2 + i)) && state.get(3 + i).equals(p) && state.get(1 + i).equals(state.get(3+i))) {
                    return p*player;
                }
            }
            // vérification par colonne
            for(int j : numbers2){
                if(state.get(j).equals(state.get(j+3)) && state.get(j+6).equals(p) && state.get(j).equals(state.get(j+6))){
                    return p*player;
                }
            }
            //vérification pour les diagonales
            if(state.get(1).equals(state.get(5)) && state.get(5).equals(state.get(9)) && state.get(5).equals(p)){
                return p*player;
            }
            if(state.get(3).equals(state.get(5)) && state.get(5).equals(state.get(7)) && state.get(5).equals(p)){
                return p*player;
            }
        }
        return 0;
    }

    /**
     * Fait en sorte que l'affichage corresponde au pavet numérique
      * @param state
     */
    public static void printState(List<Integer> state){
        Integer[] numbers = {7, 8, 9, 4, 5, 6, 1, 2, 3};
        for(int i : numbers){
            if(state.get(i).equals(-1)) System.out.printf("J ");
            else if(state.get(i).equals(1)) System.out.printf("M ");
            else System.out.printf("%d ", state.get(i));
            if(i==3||i==6||i==9) System.out.println("\n");
        }
    }
}
