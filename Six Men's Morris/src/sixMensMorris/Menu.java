package sixMensMorris;
import java.awt.*;
import javax.swing.*;

public class Menu extends JFrame {
	private JLabel sixMens;
	private JButton jugar;
	private JButton ayuda;
	private JButton salir;
	private JButton acerca;
	private JRadioButton pvp, pvc;	

	Menu()
	{
		
		super("Menu");
		this.setSize(600, 500);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		sixMens = new JLabel("SIX MEN'S MORRIS");
		jugar = new JButton("JUGAR");
		ayuda = new JButton("Ayuda");
		salir = new JButton("Salir");
		acerca = new JButton("Acerca de");
		
		pvp = new JRadioButton("JUGADOR VS JUGADOR", true);
		pvp.setBounds(225, 250, 150, 50);
		
		pvc = new JRadioButton("JUGADOR VS COM");
		pvc.setBounds(225, 290, 150, 50);
		
		ButtonGroup group = new ButtonGroup();
		group.add(pvp);
		group.add(pvc);
		
		
		sixMens.setFont(new java.awt.Font("Tahoma", 1, 36));
		sixMens.setBounds(115, 50, 400, 50);
		
		jugar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jugar.setFont(new java.awt.Font("Tahoma", 1, 36));
		jugar.setForeground(new java.awt.Color(15, 142, 255));
		jugar.setBounds(187, 200, 200, 50);
		
		ayuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		ayuda.setFont(new java.awt.Font("Tahoma", 1, 18));
		ayuda.setBounds(10, 400, 100, 50);
		
		salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		salir.setFont(new java.awt.Font("Tahoma", 1, 18));
		salir.setBounds(473, 400, 100, 50);
		
		acerca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		acerca.setFont(new java.awt.Font("Tahoma", 1, 18));
		acerca.setBounds(220, 400, 140, 50);
		
		jugar.addActionListener(new java.awt.event.ActionListener()
		{
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnJugar();
            }
        });
		
		ayuda.addActionListener(new java.awt.event.ActionListener() 
		{
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	btnAyuda();
            }
        });
		
		salir.addActionListener(new java.awt.event.ActionListener()
		{
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	btnSalir();
            }
        });
		
		acerca.addActionListener(new java.awt.event.ActionListener() 
		{
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
            	btnAcerca();
            }
        });
		
		add(sixMens);
		add(jugar);
		add(ayuda);
		add(salir);
		add(acerca);
		add(pvp);
		add(pvc);
	}

	public void btnJugar()
	{
		if(pvp.isSelected())
		{
			String j1 = JOptionPane.showInputDialog(null, "Jugador 1", JOptionPane.QUESTION_MESSAGE);

			String j2 = JOptionPane.showInputDialog(null, "Jugador 2", JOptionPane.QUESTION_MESSAGE);
			
			TableroJvJ tablero2 = new TableroJvJ(j1,j2);
		    tablero2.setVisible(true);
		    this.setVisible(false);

		}
		else if(pvc.isSelected())
		{
			String j1 = JOptionPane.showInputDialog(null, "Jugador 1", JOptionPane.QUESTION_MESSAGE);
			
			Tablero tablero = new Tablero(j1);
	        tablero.setVisible(true);
	        this.setVisible(false);
		}
	}
	
	public void btnAyuda()
	{
		JOptionPane.showMessageDialog(null, "Instructiones.\nEste es un juego basado en turnos para dos jugadores.\n"
                + "Un Jugador usa el NEGRO, y el otro el BLANCO. El Objetivo del juego es crear molinos\n"
                + "de 3 piezas seguidas, hasta reducir la cantidad de fichas del oponente a 2 y ganar.\n\n"
                + "1.Se empieza con la mesa vacia y se decide quien ira primero.\n\n"
                + "2.Los jugadores colocan sus fichas en los puntos marcados. "
                + "Las fichas pueden estar en cualquier lugar, pero 2 fichas no pueden compartir el mismo punto.\n\n"
                + "3.Si un jugador coloca 3 de sus ficha en una línea (Vertical o Horizontal). Esto se denomina un Molino, "
                + "por cada molino formado, el jugador puede remover una ficha de su oponente.\nEmpezando por cualquier ficha que no pertenezca a un molino.\n\n"
                + "4.Una vez que todas las fichas estan en la mesa, los jugadores toman turnos para mover sus fichas.\nLas Fichas solo se pueden mover a un punto adyacente conectado por una línea y no se puede saltar ninguna ficha. El Objetivo es Mantener los molinos.\n\n"
                + "5.Los molinos pueden deshacerce y hacerce otra vez por un moviento del jugador. Cada vez, el Jugador puede eliminar una ficha de su Oponente.\n\n"
                + "6.Cuando alguno de los Jugadores solo le quedan 2 fichas, el otro Jugador GANA!. \n\n");
		
		
	}
		
	public void btnSalir()
	{
		System.exit(0);
	}
	
	public void btnAcerca()
	{
		JOptionPane.showMessageDialog(null, "Acerca de: \n                     SIX MEN'S MORRIS\nCreado por: Servando Bermúdez C.I: 23.997.749\n"
				+ "                      Guillermo Lunar C.I: 24.983.503\n\n          Lenguajes de Programación\n            Prof. Aquiles Barreto, PhD.");
	}
	
	public static void main(String[] arg) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
	{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		Menu menu = new Menu();
		menu.setVisible(true);
	}
}
