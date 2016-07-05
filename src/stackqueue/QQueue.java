package stackqueue;

/**
 * 队列接口
 */
public interface QQueue<T> {

	boolean isEmpty();// 判断队列是否空

	void enquenu(T x);// 元素x入队

	T dequeue();// 出队,返回对头元素
}
