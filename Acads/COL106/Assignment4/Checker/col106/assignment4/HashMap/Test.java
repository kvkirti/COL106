import java.util.Vector;
public class Test { 
    public static void main(String[] args) 
    {
		HashMap<Integer> hash = new HashMap<Integer>(43);
		hash.put("djxrt",87);
		hash.put("qocbq",1);
		hash.put("afgqj",764);
		hash.put("bpgln",83);
		hash.put("wvidq",12);
		Vector v=hash.getKeysInOrder();
        for(int i=0;i<v.size();i++){
            System.out.println(v.get(i));
        } 
		System.out.println(hash.get("wvidq"));
		System.out.println(hash.get("afgqj"));
		System.out.println(hash.get("djxrt"));
		System.out.println(hash.get("bpgln"));
		hash.remove("qocbq");
		v=hash.getKeysInOrder();
        for(int i=0;i<v.size();i++){
            System.out.println(v.get(i));
        } 
		System.out.println(hash.contains("qocbq"));
		System.out.println(hash.contains("bpgln"));
		System.out.println(hash.get("wvidq"));
		hash.put("wvidq",100);
		System.out.println(hash.get("wvidq"));
  	} 
} 
