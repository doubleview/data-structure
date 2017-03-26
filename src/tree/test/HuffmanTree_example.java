package tree.test;

import tree.HuffmanTree;

/**
 * ¹ş·òÂüÊ÷µ÷ÓÃ³ÌĞò
 */
public class HuffmanTree_example {

	public static void main(String[] args) {
		int[] weight = { 5, 29, 7, 8, 14, 23, 3, 11 };
		HuffmanTree htree = new HuffmanTree(weight);
		System.out.println(htree.toString());
		String[] code = htree.hufmanCodes();
        System.out.println("Huffman±àÂë:   ");
        for (int i = 0; i < code.length; i++) {
			System.out.println((char) ('A' + i) + " :    " + code[i]
					+ "       ");
		}
	}
}