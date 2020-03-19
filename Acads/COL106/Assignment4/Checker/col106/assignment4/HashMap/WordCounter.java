package col106.assignment4.HashMap;

public class WordCounter {
	HashMap<Integer> hash;

	public WordCounter(){
		hash = new HashMap<Integer>(100000000);
	}

	public int count(String str, String word){
		// HashMap<Integer> hash = new HashMap<Integer>();
		int value=0;
		for(int i=0;i<str.length()-word.length()+1;i++){
			if(hash.get(str.substring(i,i+word.length()))!=null){
				hash.put(str.substring(i,i+word.length()),hash.get(str.substring(i,i+word.length()))+1);
			}
			else{
				hash.put(str.substring(i,i+word.length()),1);
			}
		}
		hash.print_Hashmap();
		System.out.println(hash.get(word));

		// write your code here
		return hash.get(word);
	}
}
