package map;

public class MapNode<K,V> {
	K key;
	V value;
	MapNode<K,V> next,prev,seqprev,seqnext;
	
	public MapNode(){
	}

	public MapNode(K key, V value ){
		this.key=key;
		this.value=value;
		
	}
	
	@Override
	public String toString(){
		return key+" - "+value;
	}
	
	@Override
	public boolean  equals (Object obj){
		if(!(obj instanceof MapNode)){
			return false;
		}
		MapNode<K, V> o=(MapNode<K,V>)obj;
		if(key.equals(o.key))
			return true;
		
		return false;
	}
	
	@Override
	public int hashCode(){
		int hashcode=key.hashCode();
		
		return hashcode;
	}
}
