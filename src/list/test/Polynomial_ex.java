package list.test;

import list.Polynomial;
import list.TermX;

/**
 * 验证一元多项式的算法
 */
public class Polynomial_ex {

	public static void main(String[] args) {
		TermX aterms[] = { new TermX(-7, 9), new TermX(2, 7), new TermX(-9, 4),
				new TermX(1, 2), new TermX(-1, 1), new TermX(2, 0) };
		Polynomial apoly = new Polynomial(aterms);
		System.out.println("A:   " + apoly.toString());

		Polynomial bpoly = new Polynomial("-1+x-x^2+10x^4+3x^8+5x10+9x^11");
		System.out.println("B:  " + bpoly.toString());
		apoly.add(bpoly);
		System.out.println("A+B:  " + apoly.toString());
	}
}