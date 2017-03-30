package phonebook;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Comparator;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 * 电话簿窗口类
 */
public class PhoneBookJFrame extends JFrame implements ListSelectionListener,
		ActionListener, WindowListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
    private PhoneBookTreeSet book;// 电话簿，使用一个树集合存储所有Friend对象
    private JList<String> list;// 列表框
    private DefaultListModel<String> listModel;// 默认列表框组件
    private JTable table;// 表格组件
    private DefaultTableModel tableModel;// 默认表格组件
    private JComboBox<String> combobox_name;// 姓名组合框
    private DefaultComboBoxModel<String> comboModel;// 默认组合框模型，选择姓氏
    private JTextField text_code;// 电话号码文本行

	public static void main(String[] args) {
		new PhoneBookJFrame("friends.dat");
	}

	public PhoneBookJFrame(String filename) {
        super("电话簿");
        this.setBounds(300, 300, 510, 390);
        this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addWindowListener(this);// 注册窗口时间监听器
        Font f = new Font("微软雅黑", Font.BOLD, 15);

        JSplitPane split_h = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);// 水平分割窗格
        split_h.setDividerLocation(70);// 设置分隔条的位置
        this.add(split_h);
        JSplitPane split_v = new JSplitPane(JSplitPane.VERTICAL_SPLIT);// 垂直分割窗格
        split_v.setDividerLocation(260);// 设置垂直分隔条的位置
        this.book = new PhoneBookTreeSet(filename);
        this.listModel = new DefaultListModel<String>();// 默认列表框模型
        this.listModel.addElement("全部");
        this.list = new JList<>(listModel);// 创建列表框
        this.list.setFont(f);
        this.list.setBackground(new Color(205, 250, 215));
		this.list.setSelectionBackground(Color.GREEN);
		this.list
                .setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);// 设置单选模式
        this.list.addListSelectionListener(this);// 列表框注册选择事件监听器
        split_h.add(new JScrollPane(this.list));// 添加在滚动窗格中
        split_h.add(split_v);

        String[] columns = {"姓名", "电话号码"};// 表格各列的中文标题
        this.tableModel = new DefaultTableModel(columns, 0);// 默认表格模型，指定列标题，0行
        this.table = new JTable(tableModel);// 创建空表格，有列标题
        this.table.setFont(f);
        this.table.setSelectionBackground(Color.green);
		this.table.setBackground(new Color(205, 250, 215));
        this.list.setSelectedIndex(0);// 选中空表格第一项，执行valueChange()方法
        split_v.add(new JScrollPane(table));// 将表格添加进去

        // 以下面板包含组合框，文本行，添加删除，查找等按钮
        JPanel friendpanel = new JPanel(new GridLayout(2, 1));
        split_v.add(friendpanel);
		JPanel panels[] = { new JPanel(), new JPanel() };
		for (int i = 0; i < panels.length; i++)
			friendpanel.add(panels[i]);
		JLabel label1 = new JLabel(columns[0]);
		label1.setFont(f);
		panels[0].add(label1);
        this.comboModel = new DefaultComboBoxModel<String>();// 默认组合框模型
        combobox_name = new JComboBox<String>(this.comboModel);
        this.combobox_name.setFont(f);
		combobox_name.setEditable(true);
		panels[0].add(combobox_name);
		JLabel label2 = new JLabel(columns[1]);
		label2.setFont(f);
		panels[0].add(label2);
		this.text_code = new JTextField("12345678901", 12);
		panels[0].add(text_code);
        this.addIndex();// JList添加电话簿中的所有姓氏索引项
        String[] buttonstr = {"添加", "按姓名查找", "按电话号码查找", "删除行"};
        JButton[] buttons = new JButton[buttonstr.length];
        for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(buttonstr[i]);
			buttons[i].setFont(f);
			buttons[i].setBackground(Color.ORANGE);
			panels[1].add(buttons[i]);
			buttons[i].addActionListener(this);
		}
		this.setVisible(true);
	}

    // JList中添加电话簿中的所有姓氏索引项
    private void addIndex() {
        Iterator<Friend> it = this.book.iterator();// 返回一个迭代器对象
        while (it.hasNext()) {// 若有后继元素,使用迭代器遍历集合
            String indexstr = it.next().index();// 获得后继元素姓氏索引项
            if (!this.listModel.contains(indexstr)) {
                this.listModel.addElement(indexstr);// 列表框模型添加不重复数据项
                this.comboModel.addElement(indexstr);// 组合框添加不重复数据项
            }
        }
	}

	@Override
	public void windowOpened(WindowEvent e) {
        // TODO 自动生成的方法存根
    }

	@Override
	public void windowClosing(WindowEvent e) {
        this.book.writeToFile();// 将电话簿中所有对象写入指定文件，若文件不存在，创建文件

	}

	@Override
	public void windowClosed(WindowEvent e) {
        // TODO 自动生成的方法存根
    }

	@Override
	public void windowIconified(WindowEvent e) {
        // TODO 自动生成的方法存根

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
        // TODO 自动生成的方法存根

	}

	@Override
	public void windowActivated(WindowEvent e) {
        // TODO 自动生成的方法存根

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
        // TODO 自动生成的方法存根

	}

    // 单击事件处理方法
    public void actionPerformed(ActionEvent e) {
        String name = (String) combobox_name.getSelectedItem();
		String code = text_code.getText();

        if (e.getActionCommand().equals("添加")) {// 单击添加按钮
            Friend f = new Friend(name, code);
            if (!name.equals("") && !this.book.contains(f)) {
                this.book.add(f);// 添加对象，TreeSet不插入重复元素
                String surname = f.index();
                if (list.getSelectedValue().equals(surname))
					tableModel.addRow(f.toArray());
				else {
					if (!listModel.contains(surname))
						;
                    {// 列表中添加不重复的元素
                        listModel.addElement(surname);
                        comboModel.addElement(surname);
					}
                    list.setSelectedValue(surname, true);// 设置列表框为选中项
                }
            } else
				JOptionPane.showMessageDialog(this,
                        "不能添加姓名空串或重复对象 " + f.toString());
            return;
        }

        if (e.getActionCommand().equals("删除行")) {
            if (this.book.isEmpty())
                JOptionPane.showMessageDialog(this, "表格空，不能删除数据项");
            else {
                int i = table.getSelectedRow();// 表格当前选中行号
                if (i == -1)
                    JOptionPane.showMessageDialog(this, "请选择数据项");
                else {
                    name = (String) table.getValueAt(i, 0);
                    int yes = JOptionPane.showConfirmDialog(null, "删除\"" + name
                            + "\"行？");// 确认单击对话框的yes按钮
                    if (yes == 0) {
                        code = (String) table.getValueAt(i, 1);
						Friend f = new Friend(name, code);
                        this.book.remove(f);// 电话簿中删除对象
                        tableModel.removeRow(i);// 表格行中删除对象
                        if (this.book.search(f, new IndexComparator()) == null) {// 按姓氏查找，电话簿中没有相同姓氏
                            listModel.removeElement(f.index());// 列表框中删除指定姓氏
                            comboModel.removeElement(f.index());
                        }
					}
				}
			}
		}

        if (e.getActionCommand().equals("按姓名查找")) {
            if (!this.book.isEmpty()
                    && book.search(
					new Friend(
							(String) combobox_name.getSelectedItem(),
							""), new NameComparator()) != null) {
				for (int i = this.tableModel.getRowCount() - 1; i >= 0; i--)
                    // 清空表格
                    this.tableModel.removeRow(i);

				this.addAll(new Friend(
								(String) combobox_name.getSelectedItem(), ""),
						new NameComparator());
			} else
                JOptionPane.showMessageDialog(this, "没有查找到!");
        }

        if (e.getActionCommand().equals("按电话号码查找")) {
            if (!this.book.isEmpty()
                    && book.search(new Friend("", text_code.getText()),
					new CodeComparator()) != null) {
				for (int i = this.tableModel.getRowCount() - 1; i >= 0; i--)
                    // 清空表格
                    this.tableModel.removeRow(i);

				this.addAll(new Friend("", text_code.getText()),
						new CodeComparator());
			} else
                JOptionPane.showMessageDialog(this, "没有查找到!");
        }
    }

    // 列表框的选择事件处理方法
    public void valueChanged(ListSelectionEvent e) {
        String surname = list.getSelectedValue();// 返回列表框选中数据项对象
        if (!this.book.isEmpty() && surname != null && surname != "") {// 以选中姓氏更新表格
            for (int i = this.tableModel.getRowCount() - 1; i >= 0; i--)
                // 清空表格
                this.tableModel.removeRow(i);
            if (surname == "全部")
                this.addAll();// 表格添加所有对象
            else
                this.addAll(new Friend(surname, ""), new IndexComparator());// 表格添加指定姓氏的所有行
        }
    }

    // 将电话簿满足friend对象和比较器c指定条件的所有对象添加到tableModel表格模型中
    private void addAll(Friend friend, Comparator<Friend> c) {
        Iterator<Friend> it = this.book.iterator();
        while (it.hasNext()) {// 迭代查找
            Friend f = it.next();
            if (c == null || c.compare(friend, f) == 0)// 比较器c指定对象比较规则
                this.tableModel.addRow(f.toArray());// 表格添加一行，参数数组指定个列值
        }
    }

	private void addAll() {
		this.addAll(null, null);
	}
}