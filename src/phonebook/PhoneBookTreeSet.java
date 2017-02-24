package phonebook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 电话簿存储与管理类
 */
public class PhoneBookTreeSet extends TreeSet<Friend> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String filename;// 文件名

	public PhoneBookTreeSet(String filename) {
        super();// 构造空集，由comparable接口提供排序规则
        this.filename = filename;
        this.readFromFile();// 从指定文件中读取对象添加到集合中
    }

    // 从指定文件中读取对象添加到集合中
    private void readFromFile() {
        try {
            FileInputStream fin = new FileInputStream(this.filename);// 文件字节输入流
            ObjectInputStream objin = new ObjectInputStream(fin);// 对象字节输入流
            while (true)
                // 读取流未结束时
                try {
                    this.add((Friend) objin.readObject());// 读取一个对象添加到集合
                } catch (Exception e) {
                    break;
                }// 捕获一个ClassCastFoundException和EOFEException异常
            objin.close();
            fin.close();
		} catch (IOException e) {
            e.printStackTrace();// 指定文件不存在时，集合为空
        }
    }

    // 将集合中所有对象写入指定文件，若文件不存在，创建文件
    public void writeToFile() {
        if (!this.isEmpty())
			try {
                FileOutputStream fout = new FileOutputStream(this.filename);// 文件字节输出流
                ObjectOutputStream objout = new ObjectOutputStream(fout);// 对象字节输出流
                Iterator<Friend> it = this.iterator();
                while (it.hasNext())
                    // 从未找到且有后继元素师迭代
                    objout.writeObject(it.next());// 写入一个对象
                objout.close();
                fout.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
	}

    // 查找x对象，返回首次出现的对象，比较则有Comparaotr比较器迭代
    public Friend search(Friend x, Comparator<Friend> c) {
        Iterator<Friend> it = this.iterator();
        while (it.hasNext()) {// 未找到且有后继元素时迭代
            Friend f = it.next();
            if (c.compare(f, x) == 0)// 由比较器c指定比较规则
                return f;
        }
        return null;// 未找到时返回null
    }
}