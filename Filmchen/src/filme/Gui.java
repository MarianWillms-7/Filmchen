package filme;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.util.List;

public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAufsteigend;
	private JButton btnAbsteigend;
	private JButton btnSuchen;
	private JButton btnZurueck;
	private JList list;
	private JTextField textSuchwort;
	private JLabel lblNewLabel;
	private Controller controller;

	public Gui(Controller controller) {
		initialize();
		this.controller = controller;
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnAufsteigend());
		contentPane.add(getBtnAbsteigend());
		contentPane.add(getBtnSuchen());
		contentPane.add(getBtnZurueck());
		contentPane.add(getList());
		contentPane.add(getTextSuchwort());
		contentPane.add(getLblNewLabel());
		setVisible(true);
	}

	private JButton getBtnAufsteigend() {
		if (btnAufsteigend == null) {
			btnAufsteigend = new JButton("Aufsteigend");
			btnAufsteigend.setBounds(183, 11, 104, 74);
		}
		return btnAufsteigend;
	}

	private JButton getBtnAbsteigend() {
		if (btnAbsteigend == null) {
			btnAbsteigend = new JButton("Absteigend");
			btnAbsteigend.setBounds(183, 96, 104, 75);
		}
		return btnAbsteigend;
	}

	private JButton getBtnSuchen() {
		if (btnSuchen == null) {
			btnSuchen = new JButton("Suchen");
			btnSuchen.setBounds(183, 213, 163, 37);
		}
		return btnSuchen;
	}

	private JButton getBtnZurueck() {
		if (btnZurueck == null) {
			btnZurueck = new JButton("Zurück");
			btnZurueck.setBounds(356, 213, 168, 37);
		}
		return btnZurueck;
	}

	protected JList getList() {
		if (list == null) {
			list = new JList();
			list.setBounds(10, 11, 163, 239);
		}
		return list;
	}

	private JTextField getTextSuchwort() {
		if (textSuchwort == null) {
			textSuchwort = new JTextField();
			textSuchwort.setBounds(183, 182, 341, 20);
			textSuchwort.setColumns(10);
		}
		return textSuchwort;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(
					"C:\\Users\\willmsmarian\\OneDrive - Berufliches Schulzentrum für Wirtschaft und Datenverarbeitung\\Lars.jpg"));
			lblNewLabel.setBounds(301, 11, 223, 160);
		}
		return lblNewLabel;
	}

	public void setzeFilmeInListe(List<String> filme) {
		getList().setListData(filme.toArray());
	}
}
