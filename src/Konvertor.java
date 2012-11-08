import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.im.InputContext;



import javax.swing.JTextField;


public class Konvertor extends JFrame {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField iznos1;
	private JTextField iznos2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Konvertor frame = new Konvertor();
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
	public Konvertor() {
		setTitle("Srbko");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		final JComboBox comboBox1 = new JComboBox();
		comboBox1.setBounds(12, 58, 86, 20);
		comboBox1.addItem("RSD");
		comboBox1.addItem("$");
		comboBox1.addItem("CHF");
		comboBox1.addItem("€");
		comboBox1.addItem("£");
		contentPane.add(comboBox1);
		comboBox1.setBounds(24, 58, 86, 20);
		contentPane.add(comboBox1);
		
		JLabel Source = new JLabel("SOURCE");
		Source.setBounds(37, 33, 61, 14);
		contentPane.add(Source);
		
		JLabel Target = new JLabel("TARGET");
		Target.setBounds(326, 33, 46, 14);
		contentPane.add(Target);
		

		
		
		final JComboBox comboBox2 = new JComboBox();
		comboBox2.setBounds(302, 58, 86, 20);
		comboBox2.addItem("RSD");
		comboBox2.addItem("$");
		comboBox2.addItem("CHF");
		comboBox2.addItem("€");
		comboBox2.addItem("£");
		contentPane.add(comboBox2);
		
		JButton Konvertuj = new JButton("");
		Konvertuj.setBounds(181, 219, 67, 36);
		Konvertuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Valute v = new Valute();
			
			
			if (comboBox1.getSelectedItem().equals("RSD") 
					&& (comboBox2.getSelectedItem().equals("CHF"))){
			float dinari = Float.parseFloat(iznos1.getText());
			float svajcarci = v.konvertujDUS(dinari);
			
			iznos2.setText(""+svajcarci);
			}
			if (comboBox1.getSelectedItem().equals("RSD") 
					&& (comboBox2.getSelectedItem().equals("€"))){
			float dinari = Float.parseFloat(iznos1.getText());
			float evri = v.konvertujDUE(dinari);
			
			iznos2.setText(""+evri);
			}
			if (comboBox1.getSelectedItem().equals("RSD") 
					&& (comboBox2.getSelectedItem().equals("RSD"))){
			float dinari = Float.parseFloat(iznos1.getText());
			iznos2.setText(iznos1.getText());
			}
			if (comboBox1.getSelectedItem().equals("RSD") 
					&& (comboBox2.getSelectedItem().equals("$"))){
			float dinari = Float.parseFloat(iznos1.getText());
			float dolari = v.konvertujDUDO(dinari);
			
			iznos2.setText(""+dolari);
			}
			if (comboBox1.getSelectedItem().equals("RSD") 
					&& (comboBox2.getSelectedItem().equals("£"))){
			float dinari = Float.parseFloat(iznos1.getText());
			float funte = v.konvertujDUF(dinari);
			
			iznos2.setText(""+funte);
			}
			if (comboBox1.getSelectedItem().equals("€") 
					&& (comboBox2.getSelectedItem().equals("RSD"))){
			float evri = Float.parseFloat(iznos1.getText());
			float dinari = v.konvertujEUD(evri);
			
			iznos2.setText(""+dinari);
			}
			if (comboBox1.getSelectedItem().equals("£") 
					&& (comboBox2.getSelectedItem().equals("RSD"))){
			float funte = Float.parseFloat(iznos1.getText());
			float dinari = v.konvertujFUD(funte);
			
			iznos2.setText(""+dinari);
			}
			
			if (comboBox1.getSelectedItem().equals("$") 
					&& (comboBox2.getSelectedItem().equals("RSD"))){
			float dolari = Float.parseFloat(iznos1.getText());
			float dinari = v.konvertujDOUD(dolari);
			
			iznos2.setText(""+dinari);
			}
			if (comboBox1.getSelectedItem().equals("CHF") 
					&& (comboBox2.getSelectedItem().equals("RSD"))){
			float svajcarci = Float.parseFloat(iznos1.getText());
			float dinari = v.konvertujSUD(svajcarci);
			
			iznos2.setText(""+dinari);
			}
			}
			});
	contentPane.add(Konvertuj);
	Konvertuj.setIcon(new ImageIcon("C:\\Documents and Settings\\srbko.jpg"));
	
	iznos1 = new JTextField();
	iznos1.setBounds(24, 235, 102, 20);
	contentPane.add(iznos1);
	iznos1.setColumns(10);
	
	iznos2 = new JTextField();
	iznos2.setBounds(286, 235, 102, 20);
	contentPane.add(iznos2);
	iznos2.setColumns(10);
	
	JLabel Iznos1 = new JLabel("IZNOS");
	Iznos1.setBounds(48, 210, 46, 14);
	contentPane.add(Iznos1);
	
	JLabel Iznos2 = new JLabel("IZNOS");
	Iznos2.setBounds(326, 210, 46, 14);
	contentPane.add(Iznos2);
	
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setBounds(0, 0, 421, 290);
	lblNewLabel.setIcon(new ImageIcon("C:\\Documents and Settings\\world-money.jpg"));
	contentPane.add(lblNewLabel);
	}
}
