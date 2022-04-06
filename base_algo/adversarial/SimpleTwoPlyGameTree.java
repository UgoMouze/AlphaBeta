package base_algo.adversarial;


import java.util.ArrayList;
import java.util.List;

public class SimpleTwoPlyGameTree<V extends Number> {
    private V value;
    private boolean max;
    private ArrayList<SimpleTwoPlyGameTree<V>> children = null;

    public SimpleTwoPlyGameTree(V value, boolean max) {
        this.value = value;
        this.max = max;
        children = new ArrayList<SimpleTwoPlyGameTree<V>>();
    }

    public SimpleTwoPlyGameTree(V value, boolean max, List<SimpleTwoPlyGameTree<V>> children) {
        this(value, max);
        for (SimpleTwoPlyGameTree<V> child : children)
            this.children.add(child);
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public boolean isMax() {
        return max;
    }

    public void addChild(SimpleTwoPlyGameTree<V> child) {
        this.children.add(child);
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public ArrayList<SimpleTwoPlyGameTree<V>> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<SimpleTwoPlyGameTree<V>> children) {
        this.children = children;
    }

    public String toString() {
        String s = "";
        s += "value = " + value + " | ";
        s += "child = " + children;
        return s;
    }
    /**
     *     public V minimax(){
     *         if(this.getChildren().isEmpty()){
     *             return this.value;
     *         }
     *         SimpleTwoPlyGameTree<V> child = this.children.get(0);
     *         V max = child.getValue();
     *         int index = 0;
     *         for( int i = 1; i<this.children.size(); i++){
     *             child = this.children.get(i);
     *             if( child.getValue().doubleValue() > max.doubleValue() ){
     *                 max = child.getValue();
     *                 index = i;
     *             }
     *         }
     *         return this.children.get(index).maximini();
     *     }
     *
     *     public V maximini(){
     *         if(this.getChildren().isEmpty()){
     *             return this.value;
     *         }
     *         SimpleTwoPlyGameTree<V> child = this.children.get(0);
     *         V max = child.getValue();
     *         int index = 0;
     *         for( int i = 1; i<this.children.size(); i++){
     *             child = this.children.get(i);
     *             if(child.getValue().doubleValue() < max.doubleValue()){
     *                 max = child.getValue();
     *                 index = i;
     *             }
     *         }
     *         return this.children.get(index).minimax();
     *     }
    */
}