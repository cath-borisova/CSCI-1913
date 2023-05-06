//Katya Borisova
//boris040
import java.util.Random;
class HBST<Key, Value> {
    private class PairNode{
        Key key;
        Value value;
        PairNode next;
        private PairNode(Key key, Value value, PairNode next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    private class TreeNode{
        int hash;
        private PairNode pairs;
        private TreeNode right;
        private TreeNode left;
        private TreeNode(int hash, PairNode pairs){
            this.hash = hash;
            this.pairs = pairs;
            right = null;
            left = null;
        }
    }
    private Random generator;
    private TreeNode root;
    public HBST(){
        root = new TreeNode(-1, null);
       generator = new Random();
    }
    public Value get(Key key){
        TreeNode below = root;
        int temp = hash(key);
        while(below != null){
            if(temp > below.hash){
                below = below.right;
            } else if (temp < below.hash){
                below = below.left;
            } else {
                PairNode tempP = below.pairs;
                while(tempP != null){
                    if(isEqual(tempP.key, key)){
                        return tempP.value;
                    }
                    tempP = tempP.next;
                }
            }
        }
        throw new IllegalArgumentException("No value is associated with key");
    }
    public int height() {
        if (isEmpty()) {
            return 0;
        } else {
            int right = height(root.right);
            int left = height(root.left);
            if (left > right) {
                return left;
            } else {
                return right;
            }
        }
    }
    public int height(TreeNode node){
        if(node == null){
            return 0;
        } else {
            int leftInt = height(node.left) + 1;
            int rightInt = height(node.right) + 1;
            if(leftInt > rightInt){
                return leftInt;
            } else {
                return rightInt;
            }
        }
    }

    private int hash(Key key){
        if(key == null){
            return 0;
        } else {
            generator.setSeed(key.hashCode());
            return Math.abs(generator.nextInt());
        }
    }
    public boolean isEmpty(){

        return root.right == null && root.left == null;
    }
    private boolean isEqual(Key left, Key right){
        if(left == null || right == null){
            return left == right;
        }
        return left.equals(right);
    }
    public void put(Key key, Value value){
        int temp = hash(key);
        TreeNode below = root;
        while(below != null) {
            if (temp > below.hash) {
                if(below.right == null) {
                    PairNode pairRight = new PairNode(key, value, null);
                    below.right = new TreeNode(temp, pairRight);
                    break;
                }
                below = below.right;
            } else if (temp < below.hash) {
                if(below.left == null){
                    PairNode pairLeft = new PairNode(key, value, null);
                    below.left = new TreeNode(temp, pairLeft);
                    break;
                }
                below = below.left;
            } else {
                if(isEqual(key, below.pairs.key)){
                    below.pairs.value = value;
                    break;
                } else {
                    PairNode p = new PairNode(key, value, below.pairs.next);
                    break;
                }
            }
        }
    }
}
//My tests are at the bottom
class CornedBeefHash {
    //Moen's test
    private final static String[] reserved =
            {"abstract", "assert", "boolean", "break",
                    "byte", "case", "catch", "char",
                    "class", "const", "continue", "default",
                    "do", "double", "else", "extends",
                    "false", "final", "finally", "float",
                    "for", "goto", "if", "implements",
                    "import", "instanceof", "int", "interface",
                    "long", "native", "new", "null",
                    "package", "private", "protected", "public",
                    "return", "short", "static", "super",
                    "switch", "synchronized", "this", "throw",
                    "throws", "transient", "true", "try",
                    "var", "void", "volatile", "while"};

    public static void main(String[] args) {
        HBST<Integer, Integer> intToInt = new HBST<Integer, Integer>();
        for (int key = -10; key <= 10; key += 1) {
            intToInt.put(key, key * key);
        }
        System.out.println(intToInt.height());
        for (int key = -10; key <= 10; key += 1) {
            System.out.format("%3d %3d", key, intToInt.get(key));
            System.out.println();
        }

        System.out.println();

        HBST<String, Integer> stringToInt = new HBST<String, Integer>();
        for (int index = 0; index < reserved.length; index += 1) {
            stringToInt.put(reserved[index], index);
        }
        System.out.println(stringToInt.height());
        for (int index = 0; index < reserved.length; index += 1) {
            String name = reserved[index];
            System.out.format("%02d %s", stringToInt.get(name), name);
            System.out.println();
        }
        //My test
        System.out.println("\nMy tests");
        HBST<Integer, Integer> test = new HBST<Integer, Integer>();
        System.out.println("Tree empty? " + test.isEmpty()); //true
        System.out.println("Height of tree: " + test.height()); //0
        System.out.println("Add Key 1 and Value 1");
        test.put(1, 1);
        System.out.println("Tree empty? " + test.isEmpty()); //false
        System.out.println("Height of tree: " + test.height()); //1
        System.out.println("What is Value of Key 1? " + test.get(1)); //1
        System.out.println("Add another Key 1 with Value 4");
        test.put(1, 4);
        System.out.println("Tree empty? " + test.isEmpty()); //false
        System.out.println("Height of tree: " + test.height()); //1
        System.out.println("What is Value of Key 1? " + test.get(1)); //4
        System.out.println("Add Key 2 and Value 8");
        test.put(2, 8);
        System.out.println("Add Key 10 and Value 5");
        test.put(10, 5);
        System.out.println("Height of tree: " + test.height());
        System.out.println("What is Value of Key 1? " + test.get(1)); //4
        System.out.println("What is Value of Key 10? " + test.get(10)); //5
        System.out.println("What is Value of Key 2? " + test.get(2)); //8
        System.out.println("Tree empty? " + test.isEmpty()); //false
        System.out.println("Getting a value for a non-existent key, such as 6, returns an IllegalArgumentException:");
        test.get(6);
    }
}





