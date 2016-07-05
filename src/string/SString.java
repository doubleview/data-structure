package string;

/**
 * 串接口
 */
public interface SString {

	int length();// 返回串的长度

	char charAt(int i);// 返回第i个字符

	SString concat(SString str);// 返回当前str串连接生成的新串

	SString substring(int begin, int end);// 返回串中begin 到end - 1的子串

	void setCharAt(int i, char ch);// 设置第i个字符处为ch

	SString insert(int i, SString str);// 在第i个字符处插入str串

	SString delete(int begin, int end);// 删除begin到end-1的子串

	int indexOf(SString pattern);// 返回模式字符串在串中的首次匹配位置
}
