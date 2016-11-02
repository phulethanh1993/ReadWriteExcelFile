package com.phulethanh.view;

import javax.swing.JFrame;

public class GUI extends JFrame {
	public static final int WITDH_FRAME = 600;
	public static final int HEIGHT_FRAME = 700;

	/**
	 * Phương thức khởi tạo GUI.
	 */
	public GUI() {
		initGUI();
		initComponent();
	}

	/**
	 * Khởi tạo các giá trị của GUI.
	 */
	private void initGUI() {
		this.setTitle("Quản Lý Sách");
		this.setSize(WITDH_FRAME, HEIGHT_FRAME);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Add Panel vào Frame.
	 */
	private void initComponent() {
		this.add(new BookManager());
	}
}
