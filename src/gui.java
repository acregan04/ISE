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

/*
 * @author Adam Cregan
 * @version 2, 30/03/2023
 * 
 * This class represents the front-end. It creates the GUI and holds the event
 * listeners for the application to function.
 * 
 */
public class gui extends JFrame {

	private static final long serialVersionUID = 1L;
	String qImG = "";
	private JPanel contentPane;

	// Launch the application.
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

	//Create the frame
	public gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1285, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(
				new MigLayout("", "[55.00px][256px][88.00][][][][128px][128px][128px][128px][128px][][][31.00][][9.00]", "[44.00px][40.00][128px,center][128][128px,center][-3.00][52.00][][]"));


		JLabel ISELbl = new JLabel();
		ISELbl.setHorizontalAlignment(SwingConstants.CENTER);
		ISELbl.setFont(new Font("Calibri", ISELbl.getFont().getStyle() | Font.BOLD, ISELbl.getFont().getSize() + 2));
		ISELbl.setText("Image Search Engine");
		contentPane.add(ISELbl, "cell 1 0,grow");

		Border loweredbevel = BorderFactory.createLoweredBevelBorder();

		JLabel resultsLbl = new JLabel();
		resultsLbl.setHorizontalAlignment(SwingConstants.CENTER);
		resultsLbl.setFont(new Font("Calibri", resultsLbl.getFont().getStyle() | Font.BOLD, resultsLbl.getFont().getSize() + 2));
		resultsLbl.setText("Results");
		contentPane.add(resultsLbl, "cell 8 0,grow");


		JButton btnBrowse = new JButton();
		btnBrowse.setText("Browse...");
		contentPane.add(btnBrowse, "cell 1 2,alignx center");

		JButton btnUpdate = new JButton();
		btnUpdate.setText("Update Database");
		contentPane.add(btnUpdate, "cell 1 1,alignx center");
		
		JLabel lblSearchImg = new JLabel("pending...");
		lblSearchImg.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSearchImg, "cell 1 3 1 2,grow");
		lblSearchImg.setBorder(loweredbevel);

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
		contentPane.add(lblResImg_6, "cell 6 3,grow");
		lblResImg_6.setBorder(loweredbevel);

		JLabel lblResImg_7 = new JLabel("Image 7");
		lblResImg_7.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_7, "cell 7 3,grow");
		lblResImg_7.setBorder(loweredbevel);

		JLabel lblResImg_8 = new JLabel("Image 8");
		lblResImg_8.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_8, "cell 8 3,grow");
		lblResImg_8.setBorder(loweredbevel);

		JLabel lblResImg_9 = new JLabel("Image 9");
		lblResImg_9.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_9, "cell 9 3,grow");
		lblResImg_9.setBorder(loweredbevel);

		JLabel lblResImg_10 = new JLabel("Image 10");
		lblResImg_10.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_10, "cell 10 3,grow");
		lblResImg_10.setBorder(loweredbevel);

		JLabel lblResImg_11 = new JLabel("Image 11");
		lblResImg_11.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_11, "cell 6 4,grow");
		lblResImg_11.setBorder(loweredbevel);

		JLabel lblResImg_12 = new JLabel("Image 12");
		lblResImg_12.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_12, "cell 7 4,grow");
		lblResImg_12.setBorder(loweredbevel);

		JLabel lblResImg_13 = new JLabel("Image 13");
		lblResImg_13.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_13, "cell 8 4,grow");
		lblResImg_13.setBorder(loweredbevel);

		JLabel lblResImg_14 = new JLabel("Image 14");
		lblResImg_14.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_14, "cell 9 4,grow");
		lblResImg_14.setBorder(loweredbevel);

		JLabel lblResImg_15 = new JLabel("Image 15");
		lblResImg_15.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResImg_15, "cell 10 4,grow");
		lblResImg_15.setBorder(loweredbevel);

		JButton btnSearch = new JButton();
		btnSearch.setText("Search");
		contentPane.add(btnSearch, "cell 1 7,alignx center,growy");

		JButton btnClear = new JButton();
		btnClear.setText("Clear data");
		contentPane.add(btnClear, "cell 8 7,grow");

		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				//lblQImg.setText("");
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

				//insert for rest of images
			}
		});

		// User browses and selects query image
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
					lblSearchImg.setIcon(imageIcon);
					lblSearchImg.setText("");

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
			}
		});

		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					saveData.HSVSaver();
				} catch (IOException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Image save failed", "Warning",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		// Run calculations to get closest images
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Image> proImgs = null;
				try {
					try {
						proImgs = new ArrayList<Image>(images.details(lblSearchImg.getIcon(), qImG));
					} catch (ClassNotFoundException e1) {
						JOptionPane.showMessageDialog(null, "Image search failed", "Warning",
								JOptionPane.WARNING_MESSAGE);
						e1.printStackTrace();
						return;
					}
					if (proImgs.isEmpty()==false) {
						
						// Set the load the closest images to the GUI
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

						ImageIcon resIcon10 = new ImageIcon(proImgs.get(9).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
						lblResImg_10.setIcon(resIcon10);
						lblResImg_10.setText("");

						ImageIcon resIcon11 = new ImageIcon(proImgs.get(10).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
						lblResImg_11.setIcon(resIcon11);
						lblResImg_11.setText("");

						ImageIcon resIcon12 = new ImageIcon(proImgs.get(11).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
						lblResImg_12.setIcon(resIcon12);
						lblResImg_12.setText("");

						ImageIcon resIcon13 = new ImageIcon(proImgs.get(12).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
						lblResImg_13.setIcon(resIcon13);
						lblResImg_13.setText("");

						ImageIcon resIcon14 = new ImageIcon(proImgs.get(13).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
						lblResImg_14.setIcon(resIcon14);
						lblResImg_14.setText("");

						ImageIcon resIcon15 = new ImageIcon(proImgs.get(14).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
						lblResImg_15.setIcon(resIcon15);
						lblResImg_15.setText("");

						/*
										ImageIcon resIcon16 = new ImageIcon(proImgs.get(15).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
										lblResImg_16.setIcon(resIcon16);
										lblResImg_16.setText("");

										ImageIcon resIcon17 = new ImageIcon(proImgs.get(16).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
										lblResImg_17.setIcon(resIcon17);
										lblResImg_17.setText("");

										ImageIcon resIcon18 = new ImageIcon(proImgs.get(17).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
										lblResImg_18.setIcon(resIcon18);
										lblResImg_18.setText("");

										ImageIcon resIcon19 = new ImageIcon(proImgs.get(18).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
										lblResImg_19.setIcon(resIcon19);
										lblResImg_19.setText("");

										ImageIcon resIcon20 = new ImageIcon(proImgs.get(19).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
										lblResImg_20.setIcon(resIcon20);
										lblResImg_20.setText("");

										ImageIcon resIcon21 = new ImageIcon(proImgs.get(20).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
										lblResImg_21.setIcon(resIcon21);
										lblResImg_21.setText("");

										ImageIcon resIcon22 = new ImageIcon(proImgs.get(21).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
										lblResImg_22.setIcon(resIcon22);
										lblResImg_22.setText("");

										ImageIcon resIcon23 = new ImageIcon(proImgs.get(22).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
										lblResImg_23.setIcon(resIcon23);
										lblResImg_23.setText("");

										ImageIcon resIcon24 = new ImageIcon(proImgs.get(23).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
										lblResImg_24.setIcon(resIcon24);
										lblResImg_24.setText("");

										ImageIcon resIcon25 = new ImageIcon(proImgs.get(24).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
										lblResImg_25.setIcon(resIcon25);
										lblResImg_25.setText("");

										ImageIcon resIcon26 = new ImageIcon(proImgs.get(25).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
										lblResImg_26.setIcon(resIcon26);
										lblResImg_26.setText("");

										ImageIcon resIcon27 = new ImageIcon(proImgs.get(26).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
										lblResImg_27.setIcon(resIcon27);
										lblResImg_27.setText("");

										ImageIcon resIcon28 = new ImageIcon(proImgs.get(27).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
										lblResImg_28.setIcon(resIcon28);
										lblResImg_28.setText("");

										ImageIcon resIcon29 = new ImageIcon(proImgs.get(28).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
										lblResImg_29.setIcon(resIcon29);
										lblResImg_29.setText("");

										ImageIcon resIcon30 = new ImageIcon(proImgs.get(29).getScaledInstance(128, 128, Image.SCALE_DEFAULT));
										lblResImg_30.setIcon(resIcon30);
										lblResImg_30.setText("");
						 */
					}
				} catch (IOException e1) {
					System.out.println("No image selected");
					JOptionPane.showMessageDialog(null, "No search image selected", "Warning",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
		});
	}
}
