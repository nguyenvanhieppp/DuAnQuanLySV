package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;

import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JFileChooser;


public class QLSVView extends JFrame{
	private static final String File = null;
	private JPanel contentPane;
	public QLSVModel model;
	public JTextField textField_MaThiSinh_TimKiem;
	public JTable table;
	public JTextField textField_ID;
	public JTextField textField_HoVaTen;
	public JTextField textField_NgaySinh;
	public JTextField textField_Mon1;
	public JTextField textField_Mon2;
	public JTextField textField_Mon3;
	public ButtonGroup btn_gioiTinh;
	public JComboBox<String> comboBox_queQuan;
	public JRadioButton radioButton_nam;
	public JRadioButton radioButton_nu;
	public JComboBox<String> comboBox_queQuan_timKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLSVView() {
		this.model = new QLSVModel();
		this.setTitle("Project: Students");	
		setBounds(150, 150, 771, 696);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Action ac = new QLSVController(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuFile.setForeground(new Color(45, 45, 255));
		menuFile.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(menuFile);

		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.setForeground(new Color(222, 222, 222));
		menuOpen.setBackground(new Color(94, 94, 255));
		menuOpen.setHorizontalAlignment(SwingConstants.LEFT);
		menuOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		menuOpen.addActionListener(ac);
		menuOpen.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuFile.add(menuOpen);

		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.setHorizontalAlignment(SwingConstants.LEFT);
		menuSave.setForeground(new Color(222, 222, 222));
		menuSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		menuSave.setBackground(new Color(94, 94, 255));
		menuSave.addActionListener(ac);
		menuSave.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuFile.add(menuSave);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.setHorizontalAlignment(SwingConstants.LEFT);
		menuExit.setForeground(new Color(222, 222, 222));
		menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		menuExit.setBackground(new Color(94, 94, 255));
		menuExit.addActionListener(ac);
		menuExit.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuFile.add(menuExit);

		JMenu menuAbout = new JMenu("About");
		menuAbout.setForeground(new Color(45, 45, 255));
		menuAbout.addActionListener(ac);
		menuAbout.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(menuAbout);

		JMenuItem menuAboutMe = new JMenuItem("About Me");
		menuAboutMe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.ALT_DOWN_MASK));
		menuAboutMe.setForeground(new Color(222, 222, 222));
		menuAboutMe.setBackground(new Color(113, 113, 255));
		menuAboutMe.addActionListener(ac);
		menuAboutMe.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 255), 6, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBounds(44, 144, -28, -35);
		contentPane.add(verticalBox_1);

		JLabel label_QueQuan = new JLabel("Qu\u00EA qu\u00E1n");
		label_QueQuan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_QueQuan.setBounds(10, 21, 71, 35);
		contentPane.add(label_QueQuan);

		JLabel label_maThiSinh = new JLabel("M\u00E3 th\u00ED sinh");
		label_maThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_maThiSinh.setBounds(274, 24, 91, 29);
		contentPane.add(label_maThiSinh);

		textField_MaThiSinh_TimKiem = new JTextField();
		textField_MaThiSinh_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_MaThiSinh_TimKiem.setColumns(10);
		textField_MaThiSinh_TimKiem.setBounds(355, 28, 126, 23);
		contentPane.add(textField_MaThiSinh_TimKiem);

		JButton btnTim = new JButton("T\u00ECm");
		btnTim.setBackground(new Color(128, 128, 255));
		btnTim.setForeground(new Color(238, 238, 238));
		btnTim.addActionListener(ac);
		btnTim.setFont(new Font("Arial", Font.BOLD, 15));
		btnTim.setBounds(534, 24, 91, 29);
		contentPane.add(btnTim);

		comboBox_queQuan_timKiem = new JComboBox<String>();
		comboBox_queQuan_timKiem.setBackground(new Color(216, 216, 216));
		comboBox_queQuan_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		comboBox_queQuan_timKiem.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_queQuan_timKiem.addItem(tinh.getTenTinh());
		}
		comboBox_queQuan_timKiem.setBounds(83, 28, 130, 23);
		contentPane.add(comboBox_queQuan_timKiem);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 76, 738, 2);
		contentPane.add(separator_1);

		JLabel label_QueQuan_2 = new JLabel("Danh s\u00E1ch th\u00ED sinh");
		label_QueQuan_2.setForeground(new Color(64, 128, 128));
		label_QueQuan_2.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		label_QueQuan_2.setBounds(10, 68, 251, 54);
		contentPane.add(label_QueQuan_2);

		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table.setForeground(new Color(235, 235, 235));
		table.setBackground(new Color(0, 0, 255));
		table.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 th\u00ED sinh", "H\u1ECD t\u00EAn", "Qu\u00EA qu\u00E1n", "Ngày sinh",
						"Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m 1", "\u0110i\u1EC3m 2", "\u0110i\u1EC3m 3" }));

		table.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 112, 738, 214);
		contentPane.add(scrollPane);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 336, 738, 2);
		contentPane.add(separator_1_1);

		JLabel label_QueQuan_1 = new JLabel("Th\u00F4ng tin th\u00ED sinh");
		label_QueQuan_1.setForeground(new Color(64, 128, 128));
		label_QueQuan_1.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		label_QueQuan_1.setBounds(10, 327, 233, 54);
		contentPane.add(label_QueQuan_1);

		JLabel label_ID = new JLabel("M\u00E3 th\u00ED sinh");
		label_ID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_ID.setBounds(10, 370, 99, 54);
		contentPane.add(label_ID);

		textField_ID = new JTextField();
		textField_ID.setBackground(new Color(240, 240, 240));
		textField_ID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_ID.setColumns(10);
		textField_ID.setBounds(104, 385, 139, 26);
		contentPane.add(textField_ID);

		JLabel label_HoVaTen = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		label_HoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_HoVaTen.setBounds(10, 415, 99, 54);
		contentPane.add(label_HoVaTen);

		textField_HoVaTen = new JTextField();
		textField_HoVaTen.setBackground(new Color(240, 240, 240));
		textField_HoVaTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_HoVaTen.setColumns(10);
		textField_HoVaTen.setBounds(104, 430, 139, 26);
		contentPane.add(textField_HoVaTen);

		JLabel label_HoVaTen_1 = new JLabel("Qu\u00EA qu\u00E1n");
		label_HoVaTen_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_HoVaTen_1.setBounds(10, 468, 99, 54);
		contentPane.add(label_HoVaTen_1);

		comboBox_queQuan = new JComboBox<String>();
		comboBox_queQuan.setBackground(new Color(216, 216, 216));
		comboBox_queQuan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_queQuan.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_queQuan.addItem(tinh.getTenTinh());
		}

		comboBox_queQuan.setBounds(104, 485, 139, 26);
		contentPane.add(comboBox_queQuan);

		JLabel label_NgaySinh = new JLabel("Ng\u00E0y sinh");
		label_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_NgaySinh.setBounds(10, 521, 99, 54);
		contentPane.add(label_NgaySinh);

		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setBackground(new Color(240, 240, 240));
		textField_NgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBounds(104, 534, 139, 26);
		contentPane.add(textField_NgaySinh);

		JLabel label_ID_1 = new JLabel("Gi\u1EDBi t\u00EDnh");
		label_ID_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_ID_1.setBounds(437, 380, 81, 35);
		contentPane.add(label_ID_1);

		radioButton_nam = new JRadioButton("Nam");
		radioButton_nam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioButton_nam.setBounds(564, 383, 59, 27);
		contentPane.add(radioButton_nam);

		radioButton_nu = new JRadioButton("Nữ");
		radioButton_nu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioButton_nu.setBounds(636, 382, 51, 29);
		contentPane.add(radioButton_nu);

		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(radioButton_nam);
		btn_gioiTinh.add(radioButton_nu);

		JLabel label_HoVaTen_2 = new JLabel("M\u00F4n 1");
		label_HoVaTen_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_HoVaTen_2.setBounds(437, 421, 100, 29);
		contentPane.add(label_HoVaTen_2);

		textField_Mon1 = new JTextField();
		textField_Mon1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Mon1.setBackground(new Color(240, 240, 240));
		textField_Mon1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_Mon1.setColumns(10);
		textField_Mon1.setBounds(564, 423, 124, 26);
		contentPane.add(textField_Mon1);

		JLabel label_HoVaTen_2_1 = new JLabel("M\u00F4n 2");
		label_HoVaTen_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_HoVaTen_2_1.setBounds(437, 461, 100, 29);
		contentPane.add(label_HoVaTen_2_1);

		textField_Mon2 = new JTextField();
		textField_Mon2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Mon2.setBackground(new Color(240, 240, 240));
		textField_Mon2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_Mon2.setColumns(10);
		textField_Mon2.setBounds(564, 463, 124, 26);
		contentPane.add(textField_Mon2);

		JLabel label_Mon3 = new JLabel("M\u00F4n 3");
		label_Mon3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_Mon3.setBounds(437, 507, 100, 26);
		contentPane.add(label_Mon3);

		textField_Mon3 = new JTextField();
		textField_Mon3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Mon3.setBackground(new Color(240, 240, 240));
		textField_Mon3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_Mon3.setColumns(10);
		textField_Mon3.setBounds(564, 507, 124, 26);
		contentPane.add(textField_Mon3);

		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.setBackground(new Color(128, 128, 255));
		btnThem.setForeground(new Color(238, 238, 238));
		btnThem.addActionListener(ac);
		btnThem.setFont(new Font("Arial", Font.BOLD, 15));
		btnThem.setBounds(20, 585, 89, 25);
		contentPane.add(btnThem);

		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.setBackground(new Color(128, 128, 255));
		btnXoa.setForeground(new Color(238, 238, 238));
		btnXoa.addActionListener(ac);
		btnXoa.setFont(new Font("Arial", Font.BOLD, 15));
		btnXoa.setBounds(164, 585, 89, 25);
		contentPane.add(btnXoa);

		JButton btnCapNhat = new JButton("C\u1EADp nh\u1EADt");
		btnCapNhat.setBackground(new Color(128, 128, 255));
		btnCapNhat.setForeground(new Color(238, 238, 238));
		btnCapNhat.addActionListener(ac);
		btnCapNhat.setFont(new Font("Arial", Font.BOLD, 15));
		btnCapNhat.setBounds(310, 585, 100, 25);
		contentPane.add(btnCapNhat);

		JButton btnLuu = new JButton("L\u01B0u");
		btnLuu.setBackground(new Color(128, 128, 255));
		btnLuu.setForeground(new Color(238, 238, 238));
		btnLuu.addActionListener(ac);
		btnLuu.setFont(new Font("Arial", Font.BOLD, 15));
		btnLuu.setBounds(474, 585, 99, 25);
		contentPane.add(btnLuu);

		JButton btnHuyBo = new JButton("H\u1EE7y b\u1ECF");
		btnHuyBo.setBackground(new Color(128, 128, 255));
		btnHuyBo.setForeground(new Color(238, 238, 238));
		btnHuyBo.addActionListener(ac);
		btnHuyBo.setFont(new Font("Arial", Font.BOLD, 15));
		btnHuyBo.setBounds(629, 585, 99, 25);
		contentPane.add(btnHuyBo);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(15, 628, 733, -22);
		contentPane.add(separator_2);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 573, 738, 2);
		contentPane.add(separator_1_1_1);

		JButton btnHuyTim = new JButton("Hủy Tìm");
		btnHuyTim.setBackground(new Color(128, 128, 255));
		btnHuyTim.setForeground(new Color(238, 238, 238));
		btnHuyTim.addActionListener(ac);
		btnHuyTim.setFont(new Font("Arial", Font.BOLD, 15));
		btnHuyTim.setBounds(635, 24, 99, 29);
		contentPane.add(btnHuyTim);

		this.setVisible(true);
	}

	public void xoaForm() {
		textField_ID.setText("");
		textField_HoVaTen.setText("");
		textField_MaThiSinh_TimKiem.setText("");
		textField_NgaySinh.setText("");
		textField_Mon1.setText("");
		textField_Mon2.setText("");
		textField_Mon3.setText("");
		comboBox_queQuan.setSelectedIndex(0);
		btn_gioiTinh.clearSelection();
		textField_MaThiSinh_TimKiem.setText("");
		comboBox_queQuan_timKiem.setSelectedIndex(0);
	}

	public void themThiSinhVaoTable(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { ts.getMaThiSinh() + "",
										  ts.getTenThiSinh(),
										  ts.getQueQuan().getTenTinh(),
										  ts.getNgaySinh().getDate() + "/" 
										    +(ts.getNgaySinh().getMonth() + 1) + "/"
						                    +(ts.getNgaySinh().getYear() + 1900),
						                 (ts.isGioiTinh() ? "Nam" : "Nữ"),
						                  ts.getDiemMon1() + "", 
						                  ts.getDiemMon2() + "",
						                  ts.getDiemMon3() + "", });
	}

	public void themHoacCapNhatThiSinh(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.model.kiemTraTonTai(ts)) {
			this.model.insert(ts);
			this.themThiSinhVaoTable(ts);
		} else {
			this.model.update(ts);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(ts.getMaThiSinh() + "")) {
					model_table.setValueAt(ts.getMaThiSinh() + "", i, 0);
					model_table.setValueAt(ts.getTenThiSinh() + "", i, 1);
					model_table.setValueAt(ts.getQueQuan().getTenTinh() + "", i, 2);
					model_table.setValueAt(ts.getNgaySinh().getDate() + "/" 
											+ (ts.getNgaySinh().getMonth() + 1) + "/"
											+ (ts.getNgaySinh().getYear() + 1900) + "", i, 3);
					model_table.setValueAt((ts.isGioiTinh() ? "Nam" : "Nữ"), i, 4);
					model_table.setValueAt(ts.getDiemMon1() + "", i, 5);
					model_table.setValueAt(ts.getDiemMon2() + "", i, 6);
					model_table.setValueAt(ts.getDiemMon3() + "", i, 7);
				}
			}
		}
	}

	public ThiSinh getThiSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();

		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String tenThiSinh = model_table.getValueAt(i_row, 1) + "";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2) + "");
		String s_ngaySinh = model_table.getValueAt(i_row, 3) + "";
		Date ngaySinh = new Date(s_ngaySinh);
		String textGioiTinh = model_table.getValueAt(i_row, 4) + "";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5) + "");
		float diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
		float diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 7) + "");

		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return ts;
	}

	public void hienThiThongTinThiSinhDaChon() {
		ThiSinh ts = getThiSinhDangChon();

		this.textField_ID.setText(ts.getMaThiSinh() + "");
		this.textField_HoVaTen.setText(ts.getTenThiSinh() + "");
		this.comboBox_queQuan.setSelectedItem(ts.getQueQuan().getTenTinh());
		String s_ngaySinh = ts.getNgaySinh().getDate() + "/" 
							+(ts.getNgaySinh().getMonth() + 1) + "/"
							+(ts.getNgaySinh().getYear() + 1900);
		this.textField_NgaySinh.setText(s_ngaySinh + "");
		if (ts.isGioiTinh()) {
			radioButton_nam.setSelected(true);
		} else {
			radioButton_nu.setSelected(true);
		}
		this.textField_Mon1.setText(ts.getDiemMon1() + "");
		this.textField_Mon2.setText(ts.getDiemMon2() + "");
		this.textField_Mon3.setText(ts.getDiemMon3() + "");
	}
	
	public void thucHienThemThiSinh() {
		// Get du lieu
		int maThiSinh = Integer.valueOf(this.textField_ID.getText());
		String tenThiSinh = this.textField_HoVaTen.getText();
		int queQuan = this.comboBox_queQuan.getSelectedIndex() - 1;
		Tinh tinh = Tinh.getTinhById(queQuan);
		Date ngaySinh = new Date(this.textField_NgaySinh.getText());
		boolean gioiTinh = true;
		if (this.radioButton_nam.isSelected()) {
			gioiTinh = true;
		} else if (this.radioButton_nu.isSelected()) {
			gioiTinh = false;
		}
		float diemMon1 = Float.valueOf(this.textField_Mon1.getText());
		float diemMon2 = Float.valueOf(this.textField_Mon2.getText());
		float diemMon3 = Float.valueOf(this.textField_Mon3.getText());

		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		this.themHoacCapNhatThiSinh(ts);
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn muốn xóa dòng đã chọn?");
		if (luaChon == JOptionPane.YES_OPTION) {
			ThiSinh ts = getThiSinhDangChon();
			this.model.delete(ts);
			model_table.removeRow(i_row);
		}
	}

	public void thucHienTim() {
		//Xóa Hết Dữ Liệu Hiện Tại Trong Table và Thêm Lại
		this.huyTim();
		
		//Thực hiện Tìm
		int queQuan = this.comboBox_queQuan_timKiem.getSelectedIndex() - 1;
		String idTimKiem = this.textField_MaThiSinh_TimKiem.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		
		Set<Integer> idthiSinhCanXoa = new TreeSet<Integer>();
		if(queQuan >=0) {
			Tinh tinh = Tinh.getTinhById(queQuan);
			for (int i = 0; i < soLuongDong; i++) {
			String tenTinhTrongTable = model_table.getValueAt(i, 2) +"";
			String idTable = model_table.getValueAt(i, 0)+"";
			if(!tenTinhTrongTable.equals(tinh.getTenTinh())) {
				idthiSinhCanXoa.add(Integer.valueOf(idTable));	
				
			  }
		   }
		}
		
		if(idTimKiem.length()>0) {
			for (int i = 0; i < soLuongDong; i++) {
				String maThiSinhTable = model_table.getValueAt(i, 0)+"";
				if(!idTimKiem.equals(maThiSinhTable)) {
					idthiSinhCanXoa.add(Integer.valueOf(maThiSinhTable));
				}
			}
		}
			
		for (Integer maTS : idthiSinhCanXoa) {
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i ++) {
				String maThiSinhTable = model_table.getValueAt(i, 0)+"";
				if(maTS.toString().equals(maThiSinhTable)) {
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
		
	}

	public void huyTim() {
		while(true) {
			  DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			  int soLuongDong = model_table.getRowCount();
		   if(soLuongDong==0) {
			   break;
		   }else { 
			  try {
				model_table.removeRow(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		  }
		}	
		for (ThiSinh ts : this.model.getDsThiSinh()) {
			this.themThiSinhVaoTable(ts);
			
		}
    }

	public void thongTinHeThong() {
		JOptionPane.showMessageDialog(this,"Phần mềm quản lý dự án sinh viên  2.1.1 !","System",
				JOptionPane.INFORMATION_MESSAGE);
		
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát khỏi chương trình ?", "Exit",
				JOptionPane.YES_OPTION);
		if(luaChon==JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void SaveFile() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());	
		}else {
			
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());	
			}
		}	
	}
		
	public void saveFile(String tenFile) {
		try {
			this.model.setTenFile(tenFile);
			FileOutputStream fos = new FileOutputStream(tenFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (ThiSinh ts : this.model.getDsThiSinh()) {
				oos.writeObject(ts);
			}
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public void OpenFile() { 
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			huyTim();
		}
    }

	public void openFile(File file) {
		ArrayList<ThiSinh> ds = new ArrayList<ThiSinh>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ThiSinh ts = null;
			while(true) {
			 ts = (ThiSinh) ois.readObject();
			  if(ts == null) {
				break ;
			  }else {
				ds.add(ts);
				this.model.setDsThiSinh(ds);
			  } 
		    }
		   ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}		
}	
