package phonebook;

import java.io.Serializable;
import java.util.Comparator;

/**
 * 电话簿对象（实现可比较，比较器和序列化接口）
 */
public class Friend implements Comparable<Friend>, Comparator<Friend>,	Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
    String name, phonecode;// 姓名，电话号码

	public Friend(String name, String phonecode) {
		this.name = name;
		this.phonecode = phonecode;
	}

    public Object[] toArray() {// 返回包含对象的所有成员变量的数组
        Object[] vars = new Object[2];
        vars[0] = this.name;
		vars[1] = this.phonecode;
		return vars;
	}

    public String index() {// 索引函数，以姓氏为索引
        return this.name.substring(0, 1);
    }

    public int compare(Friend f1, Friend f2) {// 比较两个对象大小
        return f1.name.compareTo(f2.name);
    }

    public int compareTo(Friend f) {// 比较两个对象大小，实现comparable接口
        if (!this.name.equals(f.name))
            return f.name.compareTo(this.name);
        return f.phonecode.compareTo(this.phonecode);// 仅比较姓名
    }
}

// 比较姓氏字符串
class IndexComparator implements Comparator<Friend> {
	public int compare(Friend o1, Friend o2) {
		return o1.index().compareTo(o2.index());
	}
}

// 比较电话号码字符串
class CodeComparator implements Comparator<Friend> {
	public int compare(Friend o1, Friend o2) {
		return o1.phonecode.compareTo(o2.phonecode);
	}
}

//比较姓名字符串
class NameComparator implements Comparator<Friend>{
	public int compare(Friend o1, Friend o2) {
		return o1.name.compareTo(o2.name);
	}
}