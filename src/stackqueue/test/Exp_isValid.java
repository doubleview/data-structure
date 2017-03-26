package stackqueue.test;

import stackqueue.SeqStack;

/**
 * 利用栈判断左右括号是否匹配
 */
public class Exp_isValid {

	public static String isValid(String expstr) {
        SeqStack<String> stack = new SeqStack<String>(expstr.length());// 顺序栈
        for (int i = 0; i < expstr.length(); i++) {
			char ch = expstr.charAt(i);
			switch (ch) {
			case '(':
                stack.push(ch + "");// 左括号入栈
                break;
			case ')':
                // 遇见右括号时，出栈
                if (stack.isEmpty() || !stack.pop().equals("("))
                    return "期望(";// 判断出战字符是否为左括号
            }
		}

        return (stack.isEmpty()) ? "" : "期望)";// 返回空串表示没有错误
    }

	public static void main(String[] args) {
		String expstr = "((1+2)*3+4))(";
		System.out.println(expstr + "   " + isValid(expstr));
	}
}
