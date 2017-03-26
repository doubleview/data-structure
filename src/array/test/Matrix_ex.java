package array.test;

import array.Matrix;

/**
 * —È÷§æÿ’Û¿‡
 */
public class Matrix_ex {

	public static void main(String[] args) {
		int m1[][] = { { 1, 2, 3 }, { 4, 5, 6, 7, 8, 9 }, { 9, 10, 11 } };
		Matrix mata = new Matrix(3, 4, m1);
		System.out.println("A" + mata.toString());
		Matrix matb = new Matrix(3, 4);
		matb.set(0, 0, 1);
		matb.set(1, 1, 1);
		matb.set(2, 2, 1);
		System.out.println("B" + matb.toString());
		mata.add(matb);
		System.out.println("A+=B" + mata.toString());
	}
}