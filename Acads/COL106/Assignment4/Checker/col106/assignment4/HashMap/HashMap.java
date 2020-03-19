package col106.assignment4.HashMap;
import java.util.Vector;
import java.util.ArrayList;

public class HashMap<V> implements HashMapInterface<V> {

	public class HashNode{
		private String key;
		private V value;

		public HashNode(String key, V value){
			this.key=key;
			this.value=value;
		}
	}

	public ArrayList<HashNode> hashTable;
	int occupied,size;

	public HashMap(int size){
		hashTable = new ArrayList<HashNode>();
		for(int i=0;i<size;i++){
			hashTable.add(null);
		}
		this.size = size;
		occupied = 0;
	}

	public V put(String key, V value){
		int index = 0;
		if(search(key)==-1){
			index = hashFunction(key);
			while(hashTable.get(index)!=null){
				index = (index+1) % this.size;
			}
			hashTable.set(index, new HashNode(key,value));
		}
		else{
			V oldValue = hashTable.get(search(key)).value;
			hashTable.set(search(key), new HashNode(key,value));
			return oldValue;
		}
		// write your code here
		return null;
	}

	public int hashFunction(String key){
		int coeff=41,offset=0;
		int sum =(int) key.charAt(key.length()-1);

		// System.out.println(sum);
		for(int i=key.length()-2;i>=0;i--){
			sum = (((int)key.charAt(i) -offset) + (coeff*sum)%this.size) % this.size;
		}
		return (sum % this.size);
	}

	public int search(String key){
		int index = hashFunction(key);
		while(hashTable.get(index)!=null){
			if(hashTable.get(index).key.equals(key)){
				return (index);
			}
			index = (index+1) % this.size;
		}
		return -1;
	}

	public V get(String key){
		int index = hashFunction(key);
		// System.out.println(index);
		while(hashTable.get(index)!=null){
			if(hashTable.get(index).key.equals(key)){
				return ((hashTable.get(index)).value);
			}
			index = (index+1) % this.size;
		}
		return null;
	}

	public boolean remove(String key){
		int index = hashFunction(key);
		if(hashTable.get(index)==null){
			return false;
		}
		else{
			while(!hashTable.get(index).key.equals(key)){
				index = (index+1) % this.size;
			}
			hashTable.set(index,null);
			index = (index+1) % this.size;
			// System.out.println(index);
			while(hashTable.get(index)!=null){
				
				String newKey = hashTable.get(index).key;
				V newValue = hashTable.get(index).value;
				hashTable.set(index,null);
				V value = put(newKey,newValue);
				index = (index+1) % this.size;
			}
			return true;
		}
	}

	// public boolean remove(String key){
	// 	int index = hashFunction(key);
	// 	if(hashTable.get(index)==null)	return false;
	// 	while(hashTable.get(index)!=null){
	// 		if(hashTable.get(index).key.equals(key)){
	// 			hashTable.set(index,null);
	// 			int forward=index,backward=index,Max_iter=0;
	// 			// ------------------------- Shifting --------------------------------------
	// 			while(Max_iter<=this.size){
	// 				if(hashTable.get(forward)==null)						break;
	// 				if(hashFunction(hashTable.get(forward).key)<=hashFunction(key)){
	// 					System.out.println("aaya toh hai");
	// 					hashTable.set(backward, hashTable.get(forward));
	// 					backward=forward;
	// 				}
	// 				forward=(forward+1)%this.size;
	// 				Max_iter++;
	// 			}
	// 			//---------------------------------------------------------------------------
	// 		}
	// 		index = (index+1) % this.size;
	// 	}
	// 	// this.occupied--;
	// 	return true;
	// }

	public void print_Hashmap(){
		System.out.println("\n-------------------- PRINTING HASHMAP---------------------------------------------------------");
		System.out.print("Index\tValue\tHash ");
		for(int i=0;i<this.size;i++){
			if(hashTable.get(i)!=null){
				System.out.println(i+" --> "+hashTable.get(i).key+" --> "+ hashFunction(hashTable.get(i).key));
			}
			
		}
		System.out.println("---------------------------------------------------------------------------------------------\n");
	}

	public boolean contains(String key){
		if (key == null || key.length() < 1){
			return false;
		}
		if(search(key)!=-1){
			return true;
		}
		return false;
	}

	public Vector<String> getKeysInOrder(){
		Vector<String> ans = new Vector<String>();
		for(int i=0;i<size;i++){
			if(hashTable.get(i)!=null){
				ans.add(hashTable.get(i).key);
			}
		}
		return ans;
	}
}
