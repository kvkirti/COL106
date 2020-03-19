public class testing{
    public static void main(String[] args){
        WeakAVLMap tree = new WeakAVLMap();
        tree.put(1,1);
        tree.put(2,2);
        tree.put(3,3);
        // tree.BFS();
        tree.remove(2);
        // System.out.println(tree.searchRange(1,2).get(1));
        // System.out.println(tree.getHeight()+"   ye rha");
        tree.BFS();
        
    }
}