import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.miginfocom.swing.MigLayout;

public class gui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String qImG = "";

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui frame = new gui();
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
	public gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1285, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(
				new MigLayout("", "[55.00px][256px][88.00][][][][128px][128px][128px][128px][128px][][][31.00][][9.00]",
						"[90px][][128px][][128px][128px][][][][][][][][]"));

		JLabel ISELbl = new JLabel();
		ISELbl.setHorizontalAlignment(SwingConstants.CENTER);
		ISELbl.setFont(new Font("Calibri", ISELbl.getFont().getStyle() | Font.BOLD, ISELbl.getFont().getSize() + 2));
		// ISELbl.setBounds(63, 30, 171, 24);
		ISELbl.setText("Image Search Engine");
		contentPane.add(ISELbl, "cell 1 0,grow");

		JLabel resultsLbl = new JLabel();
		resultsLbl.setHorizontalAlignment(SwingConstants.CENTER);
		resultsLbl.setFont(
				new Font("Calibri", resultsLbl.getFont().getStyle() | Font.BOLD, resultsLbl.getFont().getSize() + 2));
		// resultsLbl.setBounds(542, 30, 60, 24);
		resultsLbl.setText("Results");
		contentPane.add(resultsLbl, "cell 8 0,grow");

		Border loweredbevel = BorderFactory.createLoweredBevelBorder();

		JButton btnUpdate = new JButton();
		btnUpdate.setText("Update Database");
		contentPane.add(btnUpdate, "cell 1 1,alignx center");

		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					saveData.HSVSaver();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("Save failed");
				}
			}
		});

		JButton btnBrowse = new JButton();
		btnBrowse.setText("Browse...");
		contentPane.add(btnBrowse, "cell 1 2,alignx center");

		JLabel lblResImg_1 = new JLabel("Image 1");
		lblResImg_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_1, "cell 6 2,grow");
		lblResImg_1.setBorder(loweredbevel);

		JLabel lblResImg_2 = new JLabel("Image 2");
		lblResImg_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_2, "cell 7 2,grow");
		lblResImg_2.setBorder(loweredbevel);

		JLabel lblResImg_3 = new JLabel("Image 3");
		lblResImg_3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_3, "cell 8 2,grow");
		lblResImg_3.setBorder(loweredbevel);

		JLabel lblResImg_4 = new JLabel("Image 4");
		lblResImg_4.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_4, "cell 9 2,grow");
		lblResImg_4.setBorder(loweredbevel);

		JLabel lblResImg_5 = new JLabel("Image 5");
		lblResImg_5.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_5, "cell 10 2,grow");
		lblResImg_5.setBorder(loweredbevel);

		JLabel lblResImg_6 = new JLabel("Image 6");
		lblResImg_6.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_6, "cell 6 4,grow");
		lblResImg_6.setBorder(loweredbevel);

		JLabel lblResImg_7 = new JLabel("Image 7");
		lblResImg_7.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_7, "cell 7 4,grow");
		lblResImg_7.setBorder(loweredbevel);

		JLabel lblResImg_8 = new JLabel("Image 8");
		lblResImg_8.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_8, "cell 8 4,grow");
		lblResImg_8.setBorder(loweredbevel);

		JLabel lblResImg_9 = new JLabel("Image 9");
		lblResImg_9.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_9, "cell 9 4,grow");
		lblResImg_9.setBorder(loweredbevel);

		JLabel lblResImg_10 = new JLabel("Image 10");
		lblResImg_10.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_10, "cell 10 4,grow");
		lblResImg_10.setBorder(loweredbevel);

		JLabel lblSearchImg = new JLabel("New label");
		lblSearchImg.setHorizontalAlignment(SwingConstants.CENTER);
		// lblNewLabel_1.setBounds(27, 142, 256, 256);
		lblSearchImg.setText("pending...");
		contentPane.add(lblSearchImg, "cell 1 4 1 2,grow");
		lblSearchImg.setBorder(loweredbevel);

		JLabel lblResImg_11 = new JLabel("Image 11");
		lblResImg_11.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_11, "cell 6 5,grow");
		lblResImg_11.setBorder(loweredbevel);

		JLabel lblResImg_12 = new JLabel("Image 12");
		lblResImg_12.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_12, "cell 7 5,grow");
		lblResImg_12.setBorder(loweredbevel);

		JLabel lblResImg_13 = new JLabel("Image 13");
		lblResImg_13.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_13, "cell 8 5,grow");
		lblResImg_13.setBorder(loweredbevel);

		JLabel lblResImg_14 = new JLabel("Image 14");
		lblResImg_14.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_14, "cell 9 5,grow");
		lblResImg_14.setBorder(loweredbevel);

		JLabel lblResImg_15 = new JLabel("Image 15");
		lblResImg_15.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_15, "cell 10 5,grow");
		lblResImg_15.setBorder(loweredbevel);

		JLabel lblQImg = new JLabel();
		lblQImg.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblQImg, "cell 0 7,alignx center");

		JButton btnSearch = new JButton();
		btnSearch.setText("Search");
		contentPane.add(btnSearch, "cell 1 12,alignx center,growy");

		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ArrayList<Image> proImgs = null;
				try {
					// proImgs = new ArrayList<Image>(images.details(lblSearchImg.getIcon(),
					// lblQImg.getText()));
					try {
						proImgs = new ArrayList<Image>(images.details(lblSearchImg.getIcon(), qImG));
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					ImageIcon resIcon1 = new ImageIcon(proImgs.get(0).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
					lblResImg_1.setIcon(resIcon1);
					lblResImg_1.setText("");

					ImageIcon resIcon2 = new ImageIcon(proImgs.get(1).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
					lblResImg_2.setIcon(resIcon2);
					lblResImg_2.setText("");

					ImageIcon resIcon3 = new ImageIcon(proImgs.get(2).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
					lblResImg_3.setIcon(resIcon3);
					lblResImg_3.setText("");

					ImageIcon resIcon4 = new ImageIcon(proImgs.get(3).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
					lblResImg_4.setIcon(resIcon4);
					lblResImg_4.setText("");

					ImageIcon resIcon5 = new ImageIcon(proImgs.get(4).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
					lblResImg_5.setIcon(resIcon5);
					lblResImg_5.setText("");

					ImageIcon resIcon6 = new ImageIcon(proImgs.get(5).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
					lblResImg_6.setIcon(resIcon6);
					lblResImg_6.setText("");

					ImageIcon resIcon7 = new ImageIcon(proImgs.get(6).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
					lblResImg_7.setIcon(resIcon7);
					lblResImg_7.setText("");

					ImageIcon resIcon8 = new ImageIcon(proImgs.get(7).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
					lblResImg_8.setIcon(resIcon8);
					lblResImg_8.setText("");

					ImageIcon resIcon9 = new ImageIcon(proImgs.get(8).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
					lblResImg_9.setIcon(resIcon9);
					lblResImg_9.setText("");

					ImageIcon resIcon10 = new ImageIcon(
							proImgs.get(9).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
					lblResImg_10.setIcon(resIcon10);
					lblResImg_10.setText("");

					ImageIcon resIcon11 = new ImageIcon(
							proImgs.get(10).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
					lblResImg_11.setIcon(resIcon11);
					lblResImg_11.setText("");

					ImageIcon resIcon12 = new ImageIcon(
							proImgs.get(11).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
					lblResImg_12.setIcon(resIcon12);
					lblResImg_12.setText("");

					ImageIcon resIcon13 = new ImageIcon(
							proImgs.get(12).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
					lblResImg_13.setIcon(resIcon13);
					lblResImg_13.setText("");

					ImageIcon resIcon14 = new ImageIcon(
							proImgs.get(13).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
					lblResImg_14.setIcon(resIcon14);
					lblResImg_14.setText("");

					ImageIcon resIcon15 = new ImageIcon(
							proImgs.get(14).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
					lblResImg_15.setIcon(resIcon15);
					lblResImg_15.setText("");

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("No image selected");
					JOptionPane.showMessageDialog(null, "No search image selected", "Warning",
							JOptionPane.WARNING_MESSAGE);
					// e1.printStackTrace();
				}
			}
		});

		JButton btnClear = new JButton();
		// btnClear.setBounds(531, 422, 87, 32);
		btnClear.setText("Clear data");
		contentPane.add(btnClear, "cell 8 12,grow");

		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				lblQImg.setText("");

				lblSearchImg.setText("waiting...");
				lblSearchImg.setIcon(null);

				lblResImg_1.setIcon(null);
				lblResImg_1.setText("Image 1");

				lblResImg_2.setIcon(null);
				lblResImg_2.setText("Image 2");

				lblResImg_3.setIcon(null);
				lblResImg_3.setText("Image 3");

				lblResImg_4.setIcon(null);
				lblResImg_4.setText("Image 4");

				lblResImg_5.setIcon(null);
				lblResImg_5.setText("Image 5");

				lblResImg_6.setIcon(null);
				lblResImg_6.setText("Image 6");

				lblResImg_7.setIcon(null);
				lblResImg_7.setText("Image 7");

				lblResImg_8.setIcon(null);
				lblResImg_8.setText("Image 8");

				lblResImg_9.setIcon(null);
				lblResImg_9.setText("Image 9");

				lblResImg_10.setIcon(null);
				lblResImg_10.setText("Image 10");

				lblResImg_11.setIcon(null);
				lblResImg_11.setText("Image 11");

				lblResImg_12.setIcon(null);
				lblResImg_12.setText("Image 12");

				lblResImg_13.setIcon(null);
				lblResImg_13.setText("Image 13");

				lblResImg_14.setIcon(null);
				lblResImg_14.setText("Image 14");

				lblResImg_15.setIcon(null);
				lblResImg_15.setText("Image 15");

			}
		});

		btnBrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("src\\test")); // set the directory to start in
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = new File(chooser.getSelectedFile().getAbsolutePath());

					String queryImg = file.toString();
					ImageIcon pic = new ImageIcon(queryImg);
					ImageIcon imageIcon = new ImageIcon(
							pic.getImage().getScaledInstance(256, 256, Image.SCALE_DEFAULT));

					qImG = queryImg;
					// lblQImg.setText(queryImg);
					lblSearchImg.setIcon(imageIcon);
					lblSearchImg.setText("");

				}
			}
		});
	}
}
