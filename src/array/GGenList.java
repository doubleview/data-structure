package array;

/**
 * 广义表接口
 */
public interface GGenList<T> {

	boolean isEmpty();// 判断广义表是否为空

	int length();// 返回广义表长度

	int depth();// 返回广义表深度
}