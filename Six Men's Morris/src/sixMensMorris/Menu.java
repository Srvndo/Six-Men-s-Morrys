package sixMensMorris;
import java.awt.*;
import javax.swing.*;

public class Menu extends JFrame {
	private JLabel sixMens;
	private JButton jugar;
	private JButton ayuda;
	private JButton salir;

	Menu(){
		
		super("Menu");
		this.setSize(600, 500);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		sixMens = new JLabel("SIX MEN'S MORRIS");
		jugar = new JButton("JUGAR");
		ayuda = new JButton("Ayuda");
		salir = new JButton("Salir");
		
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
		
		jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnJugar();
            }
        });
		
		ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnAyuda();
            }
        });
		
		salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnSalir();
            }
        });
		
		add(sixMens);
		add(jugar);
		add(ayuda);
		add(salir);
	}

	public void btnJugar(){
		Tablero tablero = new Tablero();
        tablero.setVisible(true);
        this.setVisible(false);
	}
	
	public void btnAyuda(){
		JOptionPane.showMessageDialog(null, "Instructions\n This is a turn-based game for two players. "
                + "One player plays black, the other white. The goal is to create “mills”\n "
                + "of three pieces in a row, thereby reducing the opponent’s pieces to two and winning the game.\n "
                + "1.Start with an empty board. Decide who will go first.\n"
                + "2.Players take turns placing their pieces on the points around "
                + "the board. Pieces may be placed anywhere, but no two pieces may share a point.\n"
                + "3.If a player puts three of their own pieces in an unbroken line (horizontal or vertical), it’s called a mill. "
                + "For every mill formed, that player may remove one of the opponent’s pieces, starting with unattached pieces that are not currently part of a mill.\n"
                + "4.Once all the pieces are on the board, players take turns moving their pieces around. Pieces may only move to an adjacent point connected by a line and they can’t jump any pieces. The goal is to keep making mills.\n"
                + "5.Mills can be broken and reformed by moving a player out of the mill and then back in. Each time, the player may remove an opponent’s piece.\n"
                + "6.When a player is reduced to two pieces, the game is over, and the other player wins. \n\n");
	}
		
	public void btnSalir(){
		System.exit(0);
	}
	
	
	public static void main(String[] arg) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		Menu menu = new Menu();
		menu.setVisible(true);
	}
}
