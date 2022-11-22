//import java.io.*;
//class MapEntry<K extends Comparable<K>,E> implements Comparable<K>{
//	K key;
//	E val;
//
//	public MapEntry(K key, E val) {
//		this.key = key;
//		this.val = val;
//	}
//
//	@Override
//	public int compareTo(K that) {
//		MapEntry<K,E> other=(MapEntry<K, E>) that;
//		return this.key.compareTo(other.key) ;
//	}
//
//	@Override
//	public String toString() {
//		return "" + key + "," + val + "";
//	}
//
//
//}
// interface DoublyHashable<K> extends Comparable<K> {
//public int hashCode ();
//public int stepCode ();
//}
//
// class DoublyHashedOBHT <K extends DoublyHashable<K>,E>{
//	 private MapEntry<K,E> [] buckets;
//	 private static final MapEntry former = new MapEntry(null, null);
//	// private int occupancy = 0;
//	   static final int NONE = -1;
//	public DoublyHashedOBHT(int m) {
//		buckets= (MapEntry<K,E>[])   new MapEntry[m];
//	}
//	public MapEntry<K,E> atIndex(int m) {
//		return buckets[m];
//	}
//	private int hesh(K key) {
//		return Math.abs((key.hashCode())) % buckets.length;
//	}
//
//	private int step (K key) {
//		return Math.abs(key.stepCode()) % buckets.length;
//	}
//	public int search(K targetKey) {
//		int b= hesh(targetKey);
//		int s= step(targetKey);
//		int n_search=0;
//		for(;;) {
//			MapEntry<K,E> oldEntry=buckets[b];
//			if(oldEntry == null) {
//				return NONE;
//			}else if(oldEntry.key.equals(targetKey)) {
//				return b;
//			}else {
//				b=(b+s) % buckets.length;
//				n_search++;
//				if(n_search==buckets.length) return NONE;
//			}
//		}
//	}
//	public void insert(K key,E val) {
//		MapEntry<K,E> newEntry=new MapEntry<K,E>(key,val);
//		int b=hesh(key);
//		int s=step(key);
//		int n_search=0;
//		for(;;) {
//			MapEntry<K,E> oldEntry=buckets[b];
//			if(oldEntry==null) {
//				buckets[b]=newEntry;
//				return;
//			}else if(oldEntry == former || oldEntry.key.equals(newEntry.key)) {
//				buckets[b]=newEntry;
//				return;
//			}else {
//				b=(b+s)%buckets.length;
//				n_search++;
//				if(n_search==buckets.length)return;
//			}
//
//		}
//	}
//	public void delete(K key) {
//		int b=hesh(key);
//		int s=step(key);
//		int n_search=0;
//		for(;;) {
//			MapEntry<K,E> oldEntry=buckets[b];
//			if(oldEntry== null) {
//				return;
//			}else if(oldEntry.key.equals(key)) {
//				buckets[b]=former;
//				return;
//			}else {
//				b=(b+s)% buckets.length;
//				n_search++;
//				if(n_search== buckets.length)return;
//			}
//
//		}
//	}
//	  public String toString () {
//	    	String temp = "";
//	    	for (int i = 0; i < buckets.length; i++) {
//	    	    temp += i + ":";
//	    	    if (buckets[i] == null)
//	    	        temp += "\n";
//	    	    else if (buckets[i] == former)
//	    	        temp += "former\n";
//	    	    else
//	    	        temp += buckets[i] + "\n";
//	    	}
//	    	return temp;
//	    }
//	  public DoublyHashedOBHT <K,E> clone(K key,E val){
//		  DoublyHashedOBHT <K,E> copy=new DoublyHashedOBHT<K,E>(buckets.length);
//		  for(int i=0;i<buckets.length;i++) {
//			  MapEntry <K,E> e=buckets[i];
//			  if(e != null && e!=former ) {
//				  copy.buckets[i]=new MapEntry<K,E> (e.key,e.val);
//			  }else {
//				  copy.buckets[i]=e;
//			  }
//		  }
//		  return copy;
//	  }
//
// }
//
// class address implements DoublyHashable<address>{
//	 String ip;
//
//	public address(String s) {
//		super();
//		this.ip = s;
//	}
//
//	@Override
//	public int compareTo(address arg0) {
//		// TODO Auto-generated method stub
//		return this.ip.compareTo(arg0.ip);
//	}
//
//	@Override
//	public String toString() {
//		return "" + ip + "";
//	}
//	public int hashCode() {
//		return ip.charAt(0) -'0';
//	}
//	public int stepCode() {
//
//		if(ip.length()!=1) {
//			return ip.charAt(1)-'0' +2;
//		}else {
//			return 1;
//		}
//	}
//
//
// }
//
//
//public class RoutingHashJava {
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		// TODO Auto-generated method stub
//		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
//		int N=Integer.parseInt(input.readLine());
//		DoublyHashedOBHT <address,String> tabela=new DoublyHashedOBHT<address,String>(N +N/2+N/8);
//		for(int i=0;i<N;i++) {
//			String ruter=input.readLine();
//			String pristap=input.readLine();
//			tabela.insert(new address(ruter), pristap);
//
//		}
//		int M=Integer.parseInt(input.readLine());
//		for(int i=0;i<M;i++) {
//			String ruter=input.readLine();
//			String pristap=input.readLine();
//			address add=new address(ruter);
//			int n=tabela.search(add);
//			System.out.println(n);
//			if(n!=-1) {
//				MapEntry<address,String> rezz=tabela.atIndex(n);
//			}else {
//				System.out.println("ne postoi");
//			}
//
//
//		}
//
//
//
//	}
//
//}
