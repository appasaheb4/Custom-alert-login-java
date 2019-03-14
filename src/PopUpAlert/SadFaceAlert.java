package PopUpAlert;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SadFaceAlert extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JLabel lblTitle;
	public JLabel lblMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SadFaceAlert dialog = new SadFaceAlert();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SadFaceAlert() {
		setBounds(100, 100, 403, 256);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(SadFaceAlert.class.getResource("/Icon/sadFace.png")));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(6, 6, 391, 83);
			contentPanel.add(lblNewLabel);
		}
		{
			lblTitle = new JLabel("New label");
			lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitle.setBounds(6, 101, 391, 16);
			contentPanel.add(lblTitle);
		}
		{
			lblMessage = new JLabel("New label");
			lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
			lblMessage.setBounds(6, 129, 391, 42);
			contentPanel.add(lblMessage);
		}
		{
			JButton btnOk = new JButton("Ok");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOk.setBounds(30, 179, 340, 36);
			contentPanel.add(btnOk);
		}
	}

}
