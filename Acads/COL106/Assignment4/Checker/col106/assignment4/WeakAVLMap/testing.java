import java.util.Vector;
public class testing{
    public static void main(String[] args){
        WeakAVLMap tree = new WeakAVLMap();
        tree.put(30886,92777);
        tree.put(47793,38335);
        tree.put(60492,16649);
        tree.put(2362,90027);
        tree.put(20059,97763);
        
        tree.put(89172,55736);  
        // Vector v=tree.BFS();
        // for(int i=0;i<v.size();i++){
        //     System.out.println(v.get(i));
        // } 
        
        tree.remove(89172);
        tree.put(33069,98167);
        tree.remove(47793);
        tree.remove(84421);
        // // tree.put(33069,98167);
        // // tree.remove(47793);
        // // tree.remove(84421);
        // System.out.println("height - "+tree.getHeight());
        // // System.out.println(tree.get(2362));
        // // tree.put(2362,900);
        // // System.out.println(tree.get(2362));
        tree.remove(2362);
        tree.put(30886,59956);
        // v=tree.BFS();
        // for(int i=0;i<v.size();i++){
        //     System.out.println(v.get(i));
        // } 
        // System.out.println("height - "+tree.getHeight());
        tree.remove(30886);
        tree.remove(33069);
        // System.out.println("height - "+tree.getHeight());
        tree.put(99932,95060);
        // v=tree.BFS();
        // for(int i=0;i<v.size();i++){
        //     System.out.println(v.get(i));
        // }
        // tree.printRank(60492);
        // tree.printRank(20059);
        // tree.printRank(99932);
        // System.out.println("-----------------------------");

        tree.put(10012,36226);
        tree.put(26652,60756);
        tree.put(9441,53865);
        
        System.out.println(tree.rotateCount());
        System.out.println("height - "+tree.getHeight());
        Vector v=tree.BFS();
        for(int i=0;i<v.size();i++){
            System.out.println(v.get(i));
        } 
        tree.printRank(60492);
        
    }
}