package array.test;

import array.GenList;
import array.GenListNode;

/**
 *
 * 由字符串创建广义表
 */
public class GenLiat_String {

	private static int i = 0;

	public static void main(String[] args) {
		GenList<String> glist_S = create("(and,(begin,end),(my,your,(his,her)))");
		System.out
				.print("glist_S" + glist_S + ",  length =" + glist_S.length());
		System.out.println(",   depth = " + glist_S.depth());
	}

    // 以gliststr字符串创建并返回广义表
    public static GenList<String> createGenList(String gliststr) {
		i = 0;
		return create(gliststr);
	}

    // 返回从gliststr[i]开始的子串创建的子广义表，递归算法
    private static GenList<String> create(String gliststr) {
        i++;// 跳过''(
        GenList<String> glist = new GenList<>();// 构造空广义表，只有头结点
        GenListNode<String> p = glist.head;// 指向头结点
        while (i < gliststr.length()) {
			char ch = gliststr.charAt(i);
			switch (ch) {
			case ',':
				i++;
				break;
			case '(': {
				p.next = new GenListNode<String>();
				p = p.next;
                p.child = create(gliststr);// 创建子表，递归调用
                break;
			}
			case ')':
				i++;
				return glist;
                default: {// 字符串表示原子
                    int j = i + 1;
				ch = gliststr.charAt(j);
				while (ch != '(' && ch != ',' && ch != ')') {
					j++;
					ch = gliststr.charAt(j);
				}
                    p.next = new GenListNode<String>(gliststr.substring(i, j));// 创建结点
                    p = p.next;
				i = j;
			}
			}
		}
		return null;
	}
}