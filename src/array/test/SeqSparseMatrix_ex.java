package array.test;

import array.SeqSparseMatrix;
import array.Triple;

/**
 * 进行稀疏矩阵的加法运算
 */
public class SeqSparseMatrix_ex {

	public static void main(String[] args) {
		Triple[] elemsa = { new Triple(0, 2, 11), new Triple(0, 4, 17),
				new Triple(1, 1, 20), new Triple(3, 0, 19),
				new Triple(3, 5, 18), new Triple(4, 4, 50) };
		SeqSparseMatrix smata = new SeqSparseMatrix(5, 6, elemsa);
		System.out.println("A" + smata.toString());
		Triple[] elemsb = { new Triple(0, 2, -11), new Triple(0, 4, -17),
				new Triple(2, 3, 51), new Triple(3, 0, 10),
				new Triple(4, 5, 99) };
		SeqSparseMatrix smatb = new SeqSparseMatrix(5, 6, elemsb);
		System.out.println("B " + smatb.toString());
		System.out.println("A+B" + smata.plus(smatb).toString());
	}
}
