/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.SetChangeListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.sun.prism.Image;

/**
 * @author user
 * Самое что не есть трололо...
 * Ибо только мастер постигнет дао сего трололо...
 * Полтора часа мучений в аудитории и вынос моего мозга дома :(
 * самый рок-н-ролльный троллинг компилятора.
 * Я начал коментить это все т.к. минут 20 мой мозг с матюками "unknown command"
 * это все переваривал, конечно не по JCC, зато от души :) 
 */
@SuppressWarnings("serial")
public class GuiMain extends JFrame{
	
	private final JPanel content =new JPanel();
	private final static JTextField login =new JTextField();
	private final JPasswordField pass =new JPasswordField();
	private static JLabel label = new JLabel("Login");
	private static JLabel labpass = new JLabel("Password");
	private static JLabel labAdress = new JLabel("Address");
	private static JLabel labSex = new JLabel("Sex");
	private static JLabel labRegion = new JLabel("Region");
	private static JLabel labAge = new JLabel("Age");
	private static JLabel labResult ;
	public static String[] sexRecord =new String[] {"male","female"};
	public static String[] RegionRecord =new String[] {"Чернігів","Київ","Житомир","Рівне","Львів","Одесса","Харків"};
	private JButton butt;
	private JComboBox combo;
	private JComboBox comboRegion;
	private JTextField adressField;
	/**
	 * @return the comboRegion
	 */
	public JComboBox getComboRegion() {
		if(comboRegion==null)
			comboRegion =new JComboBox(RegionRecord);
		return comboRegion;
	}
	
	public void setLookAndFeel(int type)
	{
	    String laf= "";
	    switch(type){
	        case 1: laf = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	        break;
	        case 2: laf = "javax.swing.plaf.metal.MetalLookAndFeel";
	        break;
	        case 3: laf = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	        break;
	        case 4: laf = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
	        break;
	        case 5: laf = "com.sun.java.swing.plaf.mac.MacLookAndFeel";
	        break;
	        
	        
	    }
	    try {
	        //Изменяем менеджер
	        UIManager.setLookAndFeel(laf);
	        //Обновляем пользовательский интерфейс
	        SwingUtilities.updateComponentTreeUI(this);
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }
	}

	/**
	 * @return the adressField
	 */
	public JTextField getAdressField() {
		if(adressField==null)
			adressField=new JTextField();
		return adressField;
	}



	private JSpinner spinner;
	/**
	 * @return the spinner
	 */
	public JSpinner getSpinner() {
		if(spinner==null)
			spinner = new JSpinner();
		spinner.setValue(new Integer(20));
		return spinner;
	}


	/**
	 * @return the combo
	 */
	public JComboBox getCombo() {
		if(combo==null)
			combo = new JComboBox(sexRecord);
		return combo;
	}



	private static String Login;
	private static String Password;
	public static GuiMain instance;
	private static int max_id;
	
	/** кнопка чтоб зарегаться
	 * и заполнить абстрактно БД
	 */
	public JButton getButt() {
		butt =new JButton();
		butt.setText("зарегаться");
		ImageIcon icon =new ImageIcon("/home/user/workspace/workspace/code.png");
		butt.setIcon(icon);
		butt.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent args) {
				Login = login.getText();
				Password = pass.getText().toString();
				System.out.println(Login);
				System.out.println(Password);
				try {
					fillDB();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return butt;
	}
	
	
	/**
	 * тут консоль начинает ругаться
	 * если пароль с 1 символа то все ок,
	 * но если больше - в консоли появляются матюки что нельза больше 1 и куча ексепшинов
	 * @throws SQLException
	 */
	public static void fillDB() {

		Connection c = connect();
		max_id = 0;
		if (c != null) {
			PreparedStatement pst;
			try {
				pst = c.prepareStatement("SELECT MAX(id) FROM students");
				ResultSet rs = pst.executeQuery();
				if (rs != null)
					while (rs.next())
						max_id = rs.getInt(1) + 1;
				rs.close();
				System.out.println("max " + max_id);
				System.out.println(Integer.parseInt(getInstance().getSpinner().getValue().toString()));
				PreparedStatement statement = c.prepareStatement("INSERT into students (id,login,password,region,age,sex,address) VALUES (?,?,?,?,?,?,?)");
				statement.setInt(1, max_id);
				statement.setString(2, Login);
				statement.setString(3, Password);
				statement.setString(4, getInstance().getComboRegion().getSelectedItem().toString());
				statement.setInt(5,Integer.parseInt(getInstance().getSpinner().getValue().toString()));
				statement.setString(6, getInstance().getCombo().getSelectedItem().toString());
				statement.setString(7, getInstance().getAdressField().getText().toString());
				statement.execute();
				statement.close();
				JOptionPane.showMessageDialog(null, "All is ok", "Title", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "All is not ok");
				e.printStackTrace();
			}

		}

	}
	
	/**
	 * @return the instance
	 */
	public static GuiMain getInstance() {
		if(instance==null)
			instance = new GuiMain();
		return instance;
	}

	/**
	 * коннектимся к базе данных
	 */
	private static Connection connect(){
		Connection c = null;
		
		try
	    {
	    	  Class.forName("org.postgresql.Driver");
		      String url = "jdbc:postgresql://localhost:5432/homework";
		      c = DriverManager.getConnection(url,"postgres", "12345678");
	    }
	    catch (ClassNotFoundException e)
	    {
	      e.printStackTrace();
	      System.exit(1);
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	      System.exit(2);
	    }
		
		return c;
	}
	
	

	

	/**
     * ACHTUNG! Главный пункт троллинга со стороны компилятора 
	 * если нет лейаута - компонеты вполне норм и сетПреффередСайз адекватно работает
	 * как только тут появится лейаут - сколько бы сетсайзов сюда не впихнули,
	 * компилятор покажет кулак дружбы и сделает так как он этого хочет :( 
     */
	public JPanel getContent() {
		content.setSize(new Dimension(200, 200));
		content.setBackground(Color.PINK);
		
		
		GridBagLayout thisLayout = new GridBagLayout();
		thisLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		thisLayout.rowHeights = new int[] {7, 20, 7, 20, 7, 20, 7, 20, 7, 20, 7 ,20,7 ,20};
		
		thisLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0};
		thisLayout.columnWidths = new int[] {7, 50, 7, 80, 7};
		content.setLayout(thisLayout);
		content.add(label, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		content.add(login, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		content.add(labpass, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		content.add(pass, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		content.add(labRegion, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		content.add(labAdress, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		content.add(labAge, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		content.add(labSex, new GridBagConstraints(1, 11, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		content.add(getCombo(), new GridBagConstraints(3, 11, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		content.add(getSpinner(), new GridBagConstraints(3, 9, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		content.add(getAdressField(), new GridBagConstraints(3, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		content.add(getComboRegion(), new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		
		content.add(getButt(), new GridBagConstraints(1, 13, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		return content;
	}

	/** я хз зачем оно здесь
	 */
	public GuiMain() {
		//this.setContentPane(getContent());
		//getContentPane().add(login);
		setLookAndFeel(5);
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}



	/**
	 * @param args
	 * аццкий пускач того ужаса что написан выше 
	 * здесь же можно пошвырять наш фрейм по экрану
	 * походу только сюда трололо компилятора не добралось 
	 * хотя я не уверен :( 
	 */
	public static void main(String[] args) {
		GuiMain frame = new GuiMain();
		frame.setSize(new Dimension(400, 400));
		frame.setTitle("Frame");
		frame.getContentPane().add(getInstance().getContent(),BorderLayout.CENTER);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((int) (d.getWidth() / 2 - frame.getWidth() / 2),(int) (d.getHeight() / 3));
		//frame.setUndecorated(true); //без границ и вернего меню бара
		// ((JFrame) frame).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
