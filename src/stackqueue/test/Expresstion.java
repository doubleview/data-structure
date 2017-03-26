package stackqueue.test;

import stackqueue.LinkedStack;
import stackqueue.SeqStack;

/**
 * 利用栈进行表达式运算
 */
public class Expresstion {

	public static void main(String[] args) {
		String expstr = "121+10*(53-49+20)/((35-25)*2+10)+11";
		String postfix = toPostfix(expstr);
		System.out.println("expstr   " + expstr);
		System.out.println("postfix   " + postfix);
		System.out.println("value   " + value(postfix));
	}

	/**
     * 返回expstr的后缀表达式
     */
	public static String toPostfix(String expstr) {
        SeqStack<String> stack = new SeqStack<String>(expstr.length());// 创建运算符栈，顺序栈记载后缀表达式
        String postfix = "";// 记载后缀表达式
        int i = 0;
		while (i < expstr.length()) {
			char ch = expstr.charAt(i);
			switch (ch) {
                case '+':// 遇到+,-号与栈顶元素比较
                case '-':
				while (!stack.isEmpty() && !stack.get().equals("("))
					postfix += stack.pop();
				stack.push(ch + "");
				i++;
				break;
                case '*':// 遇到*，/与栈顶元素比较
                case '/':
				while (!stack.isEmpty()
						&& (stack.get().equals("*") || stack.get().equals("/")))
					postfix += stack.pop();
				stack.push(ch + "");
				i++;
				break;
                case '(':// 遇到左括号，入栈
                    stack.push(ch + "");
				i++;
				break;
			case ')':
                String out = stack.pop();// 遇到右括号，出栈，若栈空返回null
                while (out != null && !out.equals("(")) {// 判断出栈字符是否为左括号
                    postfix += out;
					out = stack.pop();
				}
				i++;
				break;
			default:
				while (i < expstr.length() && ch >= '0' && ch <= '9') {
                    postfix += ch;// 遇到数字时，加入到后缀表达式
                    i++;
					if (i < expstr.length())
						ch = expstr.charAt(i);
				}
                postfix += " ";// 添加空格作为数值之间的分隔符
            }
		}
		while (!stack.isEmpty())
			postfix += stack.pop();
		return postfix;
	}

	/**
     * 计算后缀表达式的值
     */
	public static int value(String postfix) {
        // 创建操作符栈，链式栈
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
		int i = 0, result = 0;
        // 逐个检查后缀表达式的字符
        while (i < postfix.length()) {
			char ch = postfix.charAt(i);
            if (ch >= '0' && ch <= '9') {// 遇到数字字符
                result = 0;
				while (ch != ' ') {
					result = result * 10 + Integer.parseInt(ch + "");
					i++;
					ch = postfix.charAt(i);
				}
				i++;
                stack.push(new Integer(result));// 操作数入栈
            } else {
                int y = stack.pop().intValue();// 出栈两个操作数
                int x = stack.pop().intValue();
				switch (ch) {
				case '+':
					result = x + y;
					break;
				case '-':
					result = x - y;
					break;
				case '*':
					result = x * y;
					break;
				case '/':
                    result = x / y;// 整除，除数为0时将抛出异常
                    break;
				}
                stack.push(new Integer(result));// 运算结果入栈
                i++;
			}
		}
        return stack.pop().intValue();// 返回运算结果
    }
}