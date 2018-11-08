package ds;

public interface IBinaryHeap<T> {
	
	void insert(T p);
	T delete(T i);
	T root();
	boolean heapEmpty();
	
}
