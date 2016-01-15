import java.util.Queue;
import java.util.LinkedList;

public class BST <Key extends Comparable<Key>, Value>{
    public static void main(String[] args){
        BST<String, Integer> bst = new BST<>();
        String[] keys = new String[]{"S", "E", "A", "R", "C", "H", "X", "M", "P", "L"};
        Integer[] vals = new Integer[]{0, 1, 2, 3, 4, 5, 7, 9, 10, 11};
        for(int i=0; i<keys.length; i++){
            bst.put(keys[i], vals[i]);
        }
        for(int i=0; i<keys.length; i++){
            System.out.println(keys[i] + "=" + bst.get(keys[i]) + "  " + bst.size());
        }
        System.out.println("min=" + bst.min());
        System.out.println("max=" + bst.max());
        System.out.println("floor I = " + bst.floor("I"));
        /*
        for(int i=0; i<keys.length; i++){
            System.out.println(i + " is " + bst.select(i));
            System.out.println(bst.select(i) + " is the " + bst.rank(bst.select(i)));
        }
        for(int i=0; i<keys.length; i++){
            bst.delete(keys[i]);
            System.out.println("deleted " + keys[i]);
        }
        */
        System.out.println(bst.size());
        for(String s: bst.keys()){
            System.out.println(s);
        }
    }
   
    private TreeNode root;

    private class TreeNode{
        private Key key;
        private Value val;
        private TreeNode left, right;
        private int size;

        TreeNode(Key key, Value val, int size){
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }
    
    public int size(){
        return size(root);
    }
    private int size(TreeNode node){
        if(node == null){
            return 0;
        }else{
            return node.size;
        }
    }

    public Value get(Key key){
        return get(root, key);
    }
    private Value get(TreeNode node, Key key){
        if(node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp > 0){
            return get(node.right, key);
        }else if(cmp < 0){
            return get(node.left, key);
        }else{
            return node.val;
        }
    }

    public void put(Key key, Value val){
        root = put(root, key, val);
    }
    private TreeNode put(TreeNode node, Key key, Value val){
        if(node == null){
            return new TreeNode(key, val, 1);
        }
        int cmp = key.compareTo(node.key);
        if(cmp > 0){
            node.right = put(node.right, key, val);
        }else if(cmp < 0){
            node.left = put(node.left, key, val);
        }else{
            node.val = val;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Key min(){
        return min(root).key;
    }
    private TreeNode min(TreeNode node){
        if(node.left == null){
            return node;
        }else{
            return min(node.left);
        }
    }

    public Key max(){
        return max(root).key;
    }
    private TreeNode max(TreeNode node){
        if(node.right == null){
            return node;
        }else{
            return max(node.right);
        }
    }

    public Key floor(Key key){
        TreeNode node = floor(root, key);
        if(node == null){
            return null;
        }else{
            return node.key;
        }
    }
    private TreeNode floor(TreeNode node, Key key){
        if(node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp == 0){
            return node;
        }else if(cmp < 0){
            return floor(node.left, key);
        }
        TreeNode t = floor(node.right, key);
        if(t != null){
            return t;
        }else{
            return node;
        }
    }
    
    // select from zero
    public Key select(int k){
        return select(root, k).key;
    }
    private TreeNode select(TreeNode node, int k){
        if(node == null){
            return null;
        }
        if(k < size(node.left)){
            return select(node.left, k);
        }else if(k > size(node.left)){
            return select(node.right, k-size(node.left)-1);
        }else{
            return node;
        }
    }

    public int rank(Key key){
        return rank(root, key);
    }
    private int rank(TreeNode node, Key key){
        if(node == null){
            return 0;
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0){
            return rank(node.left, key);
        }else if(cmp > 0){
            return 1 + size(node.left) + rank(node.right, key);
        }else{
            return size(node.left);
        }
    }

    public void deleteMin(){
        root = deleteMin(root);
    }
    private TreeNode deleteMin(TreeNode node){
        if(node.left == null){
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void deleteMax(){
        root = deleteMax(root);
    }
    private TreeNode deleteMax(TreeNode node){
        if(node.right == null){
            return node.left;
        }
        node.right = deleteMax(node.right);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key){
        root = delete(root, key);
    }
    private TreeNode delete(TreeNode node, Key key){
        if(node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp > 0){
            node.right = delete(node.right, key);
        }else if(cmp < 0){
            node.left = delete(node.left, key);
        }else{
            if(node.left == null){
                return node.right;
            }
            if(node.right == null){
                return node.left;
            }
            TreeNode tmp = node;
            node = min(tmp.right);
            node.right = deleteMin(tmp.right);
            node.left = tmp.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Iterable<Key> keys(){
        return keys(min(), max());
    }
    public Iterable<Key> keys(Key lo, Key hi){
        Queue<Key> queue = new LinkedList<>();
        keys(root, queue, lo, hi);
        return queue;
    }
    private void keys(TreeNode node, Queue<Key> queue, Key lo, Key hi){
        if(node == null){
            return;
        }
        int cmplo = lo.compareTo(node.key);
        int cmphi = hi.compareTo(node.key);
        if(cmplo < 0){
            keys(node.left, queue, lo, hi);
        }
        if(cmplo <= 0 && cmphi >= 0){
            queue.add(node.key);
        }
        if(cmphi > 0){
            keys(node.right, queue, lo, hi);
        }
    }

}
