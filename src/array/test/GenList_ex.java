package array.test;

import array.GenList;

public class GenList_ex {

	public static void main(String[] args) {
		String[] gliststr_l = {"b","c","e"};
		GenList<String> glist_L = new GenList<String>(gliststr_l);
		glist_L.insert(0, "a");
		glist_L.insert(3, "d");
		glist_L.append("f");
		System.out.print("glist_L = " + glist_L.toString() + "  ,   length=" + glist_L.length());
		System.out.println(",   depth=" + glist_L.depth());
		
		String[] gliststr_t = {"o","p","q"};
		GenList<String> glist_T = new GenList<String>(gliststr_t);
		glist_T.append(glist_L);
		System.out.print("glist_T = " + glist_T.toString() + ",   length=" + glist_T.length());
		System.out.println(", depth=" + glist_T.depth());
		String[] gliststr_g = {"x","y","z"};
		GenList<String> glist_G = new GenList<String>(gliststr_g);
		glist_G.append(glist_L);
		glist_G.append(glist_T);
		System.out.print("glist_G = " +glist_G.toString()+ ",  length=" + glist_G.length());
		System.out.println(", depth=" + glist_G.depth());
	}
}