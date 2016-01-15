public class RedBlackTree <Key extends Comparable<Key>, Value>{
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    
    Node root;

    private class Node{
        Key key;
        Value val;
        Node left, right;
        int size;
        boolean color;

        Node(Key key, Value val, int size, boolean color){
            this.key = key;
            this.val = val;
            this.size = size;
            this.color = color;
        }
    }

    public static void main(String[] args){
        RedBlackTree<String, Integer> tree = new RedBlackTree<>();
        String[] str = new String[]{"A", "C", "E", "H", "L", "M", "P", "R", "S", "X"};
        for(int i=0; i<str.length; i++){
            tree.put(str[i], i);
        }
        for(int i=0; i<str.length; i++){
            tree.deleteMin();
        }
        for(int i=0; i<str.length; i++){
            System.out.println("Key: " + str[i] + "; Value: " + tree.get(str[i]));
        }
    }

    public int size(){
        return size(root);
    }
    private int size(Node node){
       if(node == null){
            return 0;
        }else{
            return node.size;
        }
    }

    public boolean isRed(){
        return isRed(root);
    }
    private boolean isRed(Node node){
        if(node == null){
            return false;
        }else{
            return node.color == RED;
        }
    }

    private Node rotateLeft(Node node){
        Node x = node.right;
        node.right = x.left;
        x.left = node;

        x.color = node.color;
        node.color = RED;

        x.size = node.size;
        node.size = size(node.left) + size(node.right) + 1;

        return x;
    }

    private Node rotateRight(Node node){
        Node x = node.left;
        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED;

        x.size = node.size;
        node.size = size(node.left) + size(node.right) + 1;

        return x;
    }

    private void flipColor(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    public void put(Key key, Value val){
        root = put(root, key, val);
    }
    private Node put(Node node, Key key, Value val){
        if(node == null){
            return new Node(key, val, 1, RED);
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0){
            node.left = put(node.left, key, val);
        }else if(cmp > 0){
            node.right = put(node.right, key, val);
        }else{
            node.val = val;
        }
        if(isRed(node.right) && !isRed(node.left)){
            node = rotateLeft(node);
        }
        if(isRed(node.left) && isRed(node.left.left)){
            node = rotateRight(node);
        }
        if(isRed(node.left) && isRed(node.right)){
            flipColor(node);
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }
    
    public boolean isEmpty(){
        return isEmpty(root);
    }
    private boolean isEmpty(Node node){
        if(node == null){
            return true;
        }else{
            return node.key == null;
        }
    }

    public Value get(Key key){
        if(key == null){
            return null;
        }else{
            return get(root, key);
        }
    }
    private Value get(Node node, Key key){
        if(node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0){
            return get(node.left, key);
        }else if(cmp > 0){
            return get(node.right, key);
        }else{
            System.out.print("  " + isRed(node) + "  " + size(node) + "  ");
            return node.val;
        }
    }

    public void deleteMin(){
        if(!isRed(root.left) && !isRed(root.right)){
            root.color = RED;
        }
        root = deleteMin(root);
        if(!isEmpty()){
            root.color = BLACK;
        }
    }
    private Node deleteMin(Node node){
        if(node.left == null){
            return null;
        }
        if(!isRed(node.left) && !isRed(node.left.left)){
            node = moveRedLeft(node);
        }
        node.left = deleteMin(node.left);
        return balance(node);
    }
    private Node balance(Node node){
        if(isRed(node.right)){
            node = rotateLeft(node);
        }
        if(isRed(node.left) && isRed(node.left.left)){
            node = rotateRight(node);
        }
        if(isRed(node.left) && isRed(node.right)){
            flipColor(node);
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }
    private Node moveRedLeft(Node node){
        // flipColor(node);
        node.color = BLACK;
        node.right.color = RED;
        node.left.color = RED;
        if(isRed(node.right.left)){
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
        }else{
            node = rotateLeft(node);
        }
        return node;
    }

    public void delete(Key key){
        if(!isRed(root.left) && !isRed(root.right)){
            root.color = RED;
        }
        root = delete(root, key);
        if(!isEmpty(root)){
            root.color = BLACK;
        }
    }
    private Node delete(Node node, Key key){
        if(key.compareTo(node.key) < 0){
            if(!isRed(node.left) && !isRed(node.left.left)){
                node = moveRedLeft(node);
            }
            node.left = delete(node.left, key);
        }else{
            
        }
        return node;
    }
}
