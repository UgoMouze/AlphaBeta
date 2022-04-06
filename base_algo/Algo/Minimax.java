package base_algo.Algo;

import base_algo.adversarial.SimpleTwoPlyGameTree;

public class Minimax {

    SimpleTwoPlyGameTree<Integer> tree;

    public Minimax(SimpleTwoPlyGameTree<Integer> tree){
        this.tree = tree;
    }

    /**
     * minimax va retourner la meilleure valeure a jouer.
     * elle va parcourir tout l'arbre et va être en quelque sorte recursive avec la fonction maximini
     * @param node
     * @return
     */
    public Integer minimax(SimpleTwoPlyGameTree<Integer> node){
        if(node.isLeaf()){
            return node.getValue();
        }
        SimpleTwoPlyGameTree<Integer> child = node.getChildren().get(0);
        Integer maxichild = maximini(child);
        Integer max = maxichild;
        for( int i = 0; i<node.getChildren().size(); i++){
            child = node.getChildren().get(i);
            maxichild = maximini(child);
            if( maxichild > max){
                max = maxichild;
            }
        }
        return max;
    }

    /**
     * Il s'agit d'une implémentation plus facile de la fonction minimax pour son application
     * @return
     */
    public Integer minimax(){
        return minimax(tree);
    }

    /**
     * maximini va être utilisée dans minimax.
     * Il s'agit de la "fonction miroir" correspondant aux actions de l'autre joueur.
     * @param node
     * @return
     */
    private Integer maximini(SimpleTwoPlyGameTree<Integer> node){
        if(node.isLeaf()){
            return node.getValue();
        }
        SimpleTwoPlyGameTree<Integer> child = node.getChildren().get(0);
        Integer min = minimax(child);
        Integer miniChild;
        for( int i = 1; i<node.getChildren().size(); i++){
            child = node.getChildren().get(i);
            miniChild = minimax(child);
            if( miniChild< min){
                min = minimax(child);
            }
        }
        return min;
    }
}

