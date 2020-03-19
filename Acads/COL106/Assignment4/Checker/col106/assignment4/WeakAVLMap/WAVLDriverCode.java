package col106.assignment4.WeakAVLMap; 
import java.util.Vector;
import java.io.*;

public class WAVLDriverCode{
	static PrintStream out;
	public PrintStream fileout() {
		return out;
	}
    public static void main(String[] args) throws IOException {
		WeakAVLMap<Integer, Integer> map = new WeakAVLMap<Integer, Integer>();

		File file;
		out = new PrintStream(new FileOutputStream(args[1], false), true);
		System.setOut(out);
		file = new File(args[0]);

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String st;
			while ((st = br.readLine()) != null) {
				String[] cmd = st.split(" ");
				if (cmd.length == 0) {
					System.err.println("Error parsing: " + st);
					return;
				}
				String key_value;
				int key, key1, key2;
				int value;
				switch (st.strip()) {
					case "PUT":
						key_value = br.readLine();
						key = Integer.parseInt(key_value.split(",")[0].trim());
						value = Integer.parseInt(key_value.split(",")[1].trim());
						Integer val = map.put(key, value);
						System.out.println("Put (" + key + "," + value + ")" + ": " + val);
						break;
					case "REMOVE":
						key_value = br.readLine();
						key = Integer.parseInt(key_value.trim());
						System.out.println("Remove " + key + ": " + map.remove(key));
						break;
					case "GET":
						key_value = br.readLine();
						key = Integer.parseInt(key_value.trim());
						System.out.println("Get " + key + ": " + map.get(key));
						break;
					case "SEARCH_RANGE":
						key_value = br.readLine();
						key1 = Integer.parseInt(key_value.split(",")[0].trim());
						key2 = Integer.parseInt(key_value.split(",")[1].trim());
						System.out.print("Search Range [" + key1 + ", " + key2 + "]: ");
						Vector<Integer> searchRes = map.searchRange(key1, key2);
						for(Integer i : searchRes){
							System.out.print(i + " ");
						}	
						System.out.println();
						break;
					case "ROTATE_COUNT":
						System.out.println("Rotate Count: " + map.rotateCount());
						break;
					case "HEIGHT":
						System.out.println("Height: " + map.getHeight());
						break;
					case "BFS_ORDER":
						System.out.print("Bfs order: ");
						Vector<Integer> order = map.BFS();
						for(Integer i : order){
							System.out.print(i + " ");
						}	
						System.out.println();
						break;
					default:
						System.err.println("Unknown command: " + st);
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Input file Not found. " + file.getAbsolutePath());
		} catch (NullPointerException ne) {
			ne.printStackTrace();
		} catch (Exception e) {
				e.printStackTrace();
		}
    }
}
