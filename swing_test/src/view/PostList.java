package view;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.dto.PostDTO;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.SwingConstants;

public class PostList extends JFrame {
	private JTable table;
	private JTextField searchString;

	public PostList(List<PostDTO> vos) {
		setTitle("Post List");
//        setIconImage(Toolkit.getDefaultToolkit().getImage(PostList.class.getResource("/images/icon_docs_01.png")));
		setBounds(new Rectangle(0, 0, 600, 350));
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		JPanel searchPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) searchPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(searchPanel);

		JComboBox<String> comboBox = new JComboBox<>();
		searchPanel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] { "제목", "내용", "작성자" }));
		comboBox.setBounds(244, 17, 74, 21);

		searchString = new JTextField();
		searchPanel.add(searchString);
		searchString.setColumns(10);

		JButton btnSearch = new JButton("검색");
		searchPanel.add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);

//        BoardDAO dao = new BoardDAOImpl();
		List<PostDTO> list = vos;

		String[] colNames = new String[] { "글 번호", "제목", "내용", "댓글 수" };
		Object[][] rowDatas = new Object[list.size()][colNames.length];

		for (int i = 0; i < list.size(); i++) {
			rowDatas[i] = new Object[] { list.get(i).getId(), list.get(i).getTitle(), list.get(i).getContent(),
					list.get(i).getCommentCnt() };
		}
		table = new JTable();
		table.setModel(new DefaultTableModel(rowDatas, colNames) {
			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(164);
//        table.getColumnModel().getColumn(4).setResizable(false);
//        table.getColumnModel().getColumn(4).setPreferredWidth(140);

//        table.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                // TODO Auto-generated method stub
//                int rowNum = table.getSelectedRow();
//                BoardVO vos = new BoardVO();
//                vos = list.get(rowNum);
//               
//                new BoardUpdate(vos);
//            }
//        });
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panel);

		JButton btnWrite = new JButton("글 작성");
		panel.add(btnWrite);
		btnWrite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton btnDetail = new JButton("상세 보기");
		panel.add(btnDetail);

		setVisible(true);
	}

	public static void main(String[] args) {
		Controller c = new Controller();

		new PostList(c.getPostList());
	}
}
