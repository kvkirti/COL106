// package col106.assignment4.WeakAVLMap;
import java.util.Vector;
import java.util.Queue;
import java.util.LinkedList;

public class WeakAVLMap<K extends Comparable,V> implements WeakAVLMapInterface<K,V>{

	public class Node{
		private K key;
		private V value;
		private Node left;
		private Node right;
		private int rank;
		private Node parent;

		public Node(K key, V value, Node parent){
			this.key=key;
			this.value=value;
			this.left=null;
			this.right=null;
			this.parent=parent;
			this.rank = 0;
		}
	}
	Node root;
	int rotations;

	public WeakAVLMap(){
		root=null;
		rotations=0;
	} 
//////////INSERT/////////////////
	public V put(K key, V value){
		
		Node e = this.root;
		Node p=null;
		if(get(key)==null){
			if(this.root == null){
				this.root = new Node(key,value,null);
			}
			else{
				
				while(e!=null){
					p = e;
					if(key.compareTo(e.key)<0){
						e=e.left;
					}
					else if(key.compareTo(e.key)>0){
						e=e.right;
					}
				}
				Node node = new Node(key,value,p);
				// System.out.println(node.key);
				if(key.compareTo(p.key)<0){
					p.left = node;
				}
				else{
					p.right = node;
				}
				// BFS();

				if(p.rank==0){
					p.rank++;
					// System.out.println(e.key);
					rebalancing(this.root,p);
				}
				// BFS();
			}
			return null;
		}
		else{
			return(update(this.root,key,value));
		}
	}

	public V update(Node root, K key, V value){
		Node R = this.root;           //this.root changes or not?
		while(R!=null){
			if(key.compareTo(R.key)<0){
				R = R.left;
			}
			else if(key.compareTo(R.key)>0){
				R=R.right;
			}
			else{
				V oldValue = R.value;
				R.value = value;
				// System.out.println(oldValue);
				return(oldValue);
			}
		}
		// write your code her 
		return null;
	}

	public void rebalancing(Node root, Node q){
		Node p = q.parent;
		
		while(q!=this.root && p.rank - q.rank!=1){
			// System.out.println(p.key);
			if(p.left==q){
				if(right(p)){
					if(q.left==null || q.rank - q.left.rank>=2){
						q.rank--;
						q.right.rank++;
						rotateLeft(q);
					}
					p.rank--;
					rotateRight(p);
					break;
				}
				else{
					p.rank++;
					q=p;
					p=q.parent;
				}
			}

			else if(p.right==q){
				if((p.left==null && p.rank==1) || p.rank-p.left.rank>=2){
					if(q.right==null||q.rank-q.right.rank>=2){
						q.rank--;
						q.left.rank++;
						rotateRight(q);
					}
					p.rank--;
					rotateLeft(p);
					break;
				}
				else{
					p.rank++;
					q=p;
					p=q.parent;
				}
			}	
		}
	}

	public boolean right(Node p){
		if(p.right==null){
			if(p.rank==1){
				return true;
			}
			return false;
		}
		else if(p.rank - p.right.rank>=2){
			return true;
		}
		return false;
	}

	public void rotateRight(Node q){
		this.rotations++;
		Node t = q.left;
		q.left=t.right;
		/////parent ka jugaad
		if(t.right!=null){
			t.right.parent = q;
		}
		if(q.parent==null){
			t.parent= null;
			this.root = t;
		}
		else if(q.parent.right==q){
			t.parent = q.parent;
			q.parent.right=t;
		}

		else{
			t.parent=q.parent;
			q.parent.left = t;
		}

		t.right=q;
		q.parent=t;
	}

	public void rotateLeft(Node q){
		this.rotations++;
		Node t = q.right;
		q.right=t.left;
		/////parent ka jugaad
		if(t.left!=null){
			t.left.parent = q;
		}
		if(q.parent==null){
			t.parent= null;
			this.root = t;
		}
		else if(q.parent.left==q){
			t.parent = q.parent;
			q.parent.left=t;
		}

		else{
			t.parent=q.parent;
			q.parent.right = t;
		}

		t.left=q;
		q.parent=t;
		
	}
////////////////////INSERT DONE////////////////////

////////////////////DELETE/////////////////////////
	public V remove(K key){
		Node remove = searchKey(key);
		if(remove==null){
			return null;
		}
		V oldValue = remove.value;
		// System.out.println(remove.key);
		delete(this.root, remove);
		return(oldValue);
	}

	public Node searchKey(K key){
		Node root = this.root;
		while(root!=null){
			if(key.compareTo(root.key)<0){
				root=root.left;
			}
			else if(key.compareTo(root.key)>0){
				root=root.right;
			}
			else{
				return root;
			}
		}
		return null;
	}

	public void delete(Node root, Node v){
		if(v.left!=null && v.right!=null){
			Node suc = successor(v);
			v.key=suc.key;
			v.value=suc.value;
			v = suc;
		}

		Node q=null;
		if(v.right!=null){
			q=v.right;
		}
		else if(v.left!=null){
			q = v.left;
		}

		if(q!=null && v==this.root){
			this.root = q;
		}
		else if(q!=null){
			q.parent = v.parent;
			if(v.parent.right==v){
				v.parent.right = q;
			}
			else{
				v.parent.left=q;
			}
			v.left=null;
			v.right=null;
			v.parent=null;

			rebalanceDelete(this.root, q, q.rank);
		}
		else if(q==null){
			if(v.parent.right==v){
				v.parent.right= null;
			}
			else if(v.parent.left==v){
				v.parent.left=null;
			}
			int rank = v.rank-1;
			Node p = v.parent;
			// System.out.println(p.key);
			v.parent=null;
			rebalanceDelete(this.root, p,rank);
		}
	}

	public void rebalanceDelete(Node root, Node q, int rank){
		Node p = q.parent;
		Node s =null;
		if(p==null){
			if(q.left==null){
				s=q.right;
			}
			else{
				s=q.left;
			}
			p=q;
		}
		else if(q==p.right){
			s = p.left;
		}
		else if(q==p.left){
			s = p.right;
		}
		int rankDiff = p.rank- rank;
		while(p.rank-q.rank==3 ){
			if(s==null){
				s.rank = -1;
			}
			if(p.rank-s.rank>=2){
				p.rank--;
				q=p;
				p=q.parent;
			}
			else if(p.rank-s.rank==1){
				if(s.rank-s.left.rank == 2 && s.rank-s.right.rank==2){
					p.rank--;
					s.rank--;
					q=p;
					p=q.parent;
				}
				else if(p.left==s){
					Node t = s.left;
					if(s.rank-t.rank==1){
						p.rank--;
						s.rank++;
						if(s.right==null){
							p.rank--;
						}
						rotateRight(p);
					}
					else{
						p.rank-=2;
						s.rank--;
						s.right.rank+=2;
						rotateLeft(s);
						rotateRight(p);
					}
					break;
				}
				else if(p.right==s){
					Node t = s.right;
					if(s.rank-t.rank==1){
						p.rank--;
						s.rank++;
						if(s.left==null){
							p.rank--;
						}
						rotateLeft(p);
					}
					else{
						p.rank-=2;
						s.rank--;
						s.left.rank+=2;
						rotateRight(s);
						rotateLeft(p);
					}
					break;
				}
			}
		}

	}

	public Node successor(Node node){
		if(node==null){
			return null;
		}
		else if(node.right!=null){
			Node r = node.right;
			while(r.left!=null){
				r=r.left;
			}
			return r;
		}

		else{
			Node p = node.parent;
			while(p!=null && node==p.right){
				node=p;
				p=p.parent;
			}
			return p;
		}
	}

//////////////////////////DELETE DONE//////////////////////

	public V get(K key){
		Node R = this.root;           //this.root changes or not?
		while(R!=null){
			if(key.compareTo(R.key)<0){
				R = R.left;
			}
			else if(key.compareTo(R.key)>0){
				R=R.right;
			}
			else{
				return R.value;
			}
		}
		// write your code her 
		return null;
	}

	public Vector<V> searchRange(K key1, K key2){
		Vector<V> vec = new Vector<V>();
		vec = inOrder(this.root, vec, key1, key2);
		// write your code her 
		if(vec.isEmpty()){
			return null;
		}
		return vec;
	}

	public Vector<V> inOrder(Node root, Vector<V> vec, K key1, K key2){
		if(root==null){
			return vec;
		}
		inOrder(root.left, vec, key1, key2);
		if(root.key.compareTo(key1)>=0 && root.key.compareTo(key2)<=0){
			vec.add(root.value);
		}
		inOrder(root.right, vec, key1, key2);
		return vec;
	}

	public int rotateCount(){
		return(this.rotations);
	}

	public int getHeight(){
		return(height(this.root));
	}

	public int height(Node root){
		if(root==null){
			return 0;
		}
		return(1+max(height(root.left),height(root.right)));
	}

	public Vector<K> BFS(){
		return (bfsTraversal(this.root));
	}

	public Vector<K> bfsTraversal(Node root){
		Queue<Node> q = new LinkedList<>(); 
		Vector v = new Vector();
		q.add(root);
		while(q.size()!=0){
			root = q.remove();
			v.add(root.key);
			if(root.left!=null){
				q.add(root.left);
			}
			if(root.right!=null){
				q.add(root.right);
			}

		}
		for(int i=0;i<v.size();i++){
			System.out.println(v.get(i));
		}
		return v;
	}

	public int max(int a, int b){
		if(a>b){
			return a;
		}
		else{
			return b;
		}
	}

}

//reference: 
//https://slideplayer.com/slide/9342397/
//https://drive.google.com/file/d/1zbKRJhWIGWXrqyqRI7dqrS2S6fZdQHk9/view
// https://github.com/dmcmanam/bbst-showdown/blob/master/src/main/java/bbst_showdown/WAVLTreeMap.java#L496

