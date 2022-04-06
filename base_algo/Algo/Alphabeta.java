package base_algo.Algo;

import base_algo.adversarial.SimpleTwoPlyGameTree;

public class Alphabeta extends Minimax {

    public Alphabeta(SimpleTwoPlyGameTree<Integer> tree) {
        super(tree);
    }

    /**
     * Il s'agit d'une amélioration de l'algorithme minimax, qui va parcourir moins d'éléments pour éviter les cas qui ne vont pas apparaître
     * @param node
     * @param a
     * @param b
     * @param parity
     * @return
     */
    public Integer alphabeta(SimpleTwoPlyGameTree<Integer> node, Integer a, Integer b, Boolean parity){
        if(node.isLeaf()){
            return node.getValue();
        }
        Integer aP = Integer.MIN_VALUE;
        Integer bP = Integer.MAX_VALUE;
        Integer val;
        if(parity){
            // On regarde les différents éléments et on  va retourner la valeur si on sait qu'il s'agit de la bonne valeur
            //Il faut regarder le cours pour comprendre comment cela marche, l'explication est trop longue
            for(int i=0; i<node.getChildren().size(); i++){
                val = alphabeta(node.getChildren().get(i), a, Math.min(b, bP), false);
                bP = Math.min(bP, val);
                if(a>=bP) return bP;
            }
            return bP;
        }
        // Il s'agit de la même chose pour la "fonction miroir"
        for(int i=0; i<node.getChildren().size(); i++){
            val = alphabeta(node.getChildren().get(i), Math.max(a, aP), b, true);
            aP = Math.max(aP, val);
            if(aP>=b) return aP;
        }
        return aP;
    }

    /**
     * Il s'agit d'une application plus simple dans le main de alphabeta
     * @return
     */
    public Integer alphabeta(){
        return alphabeta(tree, Integer.MIN_VALUE, Integer.MAX_VALUE, false);
    }

}
