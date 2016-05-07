package sixMensMorris;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.*;

public class Tablero extends JFrame {
	
	private Estado[] estado;
	private Ficha[] jugador;
	private Ficha[] com;
	private JLabel label1;
	private JLabel label2;
	private boolean turno; //True = Jugador.     False = COM.
	private int fplayer, fcom, contJugadas, click = 0, temp;
	
	Tablero(){
		super("Six Men's dorris");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);     
		
		
		contJugadas = 0;
		turno = true;
		
		//Inicializacion de Labels
		label1 = new JLabel("JUGADOR 1");
		label1.setFont(new java.awt.Font("Tahoma", 1, 36));
		label1.setBounds(700, 55, 400, 500);
		
		//Inicializar Contador de Fichas
		fplayer = 0;
		fcom = 0;
		
		//Inicializar Fichas
		jugador = new Ficha[6];
		com = new Ficha[6];
		
		
		
        //Inicializar Estados
        estado = new Estado[16];
        
        	//Cuadrado Externo
        	estado[0] = new Estado("q1", 130, 55);
       
        	estado[1] = new Estado("q2", 378, 55);
        
        	estado[2] = new Estado("q3", 627, 55);
       
        	estado[3] = new Estado("q4", 627, 245);
        
        	estado[4] = new Estado("q5", 627, 426);
       
        	estado[5] = new Estado("q6", 378, 430);
        
        	estado[6] = new Estado("q7", 130, 428);
       
        	estado[7] = new Estado("q8", 130, 245);
        
        	//Cuadrado Interno
        	estado[8] = new Estado("q9", 250, 245);
       
        	estado[9] = new Estado("q10", 250, 145);
        
        	estado[10] = new Estado("q11", 378, 145);
       
        	estado[11] = new Estado("q12", 500, 145); 
        
        	estado[12] = new Estado("q13", 500, 245);
       
        	estado[13] = new Estado("q14", 500, 332);
        
        	estado[14] = new Estado("q15", 378, 332);
       
        	estado[15] = new Estado("q16", 250, 332);
        	
        	this.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                	//Las Primeras 12 jugadas
                	if(contJugadas >= 0 && contJugadas <= 11){
                		if(turno){
                    		for(int i = 0; i < 16; i++){
                        		if((evt.getX() <= estado[i].getX()+20 && evt.getX() >= estado[i].getX()-20) && (evt.getY() <= estado[i].getY()+20 && evt.getY() >= estado[i].getY()-20)){
                              	  if(!estado[i].getOcup()){
                              		jugador[fplayer] = new Ficha(estado[i].getNombre(), estado[i].getX(), estado[i].getY());
                              		repaint();
                              		fplayer++;
                              		estado[i].setOcup(true);
                            		turno = false;
                            		contJugadas++;
                              	    System.out.println("Estado " + (i+1) + " Jugador " + contJugadas);
                              	  }
                                }
                        	}
                    	}// Fin if(turno)
                    	else if(turno == false){
                    		for(int i = 0; i < 16; i++){
                        		if((evt.getX() <= estado[i].getX()+20 && evt.getX() >= estado[i].getX()-20) && (evt.getY() <= estado[i].getY()+20 && evt.getY() >= estado[i].getY()-20)){
                              	  if(!estado[i].getOcup()){
                              		com[fcom] = new Ficha(estado[i].getNombre(), estado[i].getX(), estado[i].getY());
                              		repaint();
                              		fcom++;
                              		estado[i].setOcup(true);
                            		turno = true;
                            		contJugadas++;
                              	    System.out.println("Estado " + (i+1) + " Com " + contJugadas);
                              	  }
                                }
                        	}
                    	}//Fin else(turno)
                	}
                	//Despues de 12 jugadas (todas las fichas en la mesa).
                	else if(contJugadas > 11){
                		if(turno){
                    		if(click == 0){
                    			for(int i = 0; i < 16; i++){
                            		if((evt.getX() <= estado[i].getX()+20 && evt.getX() >= estado[i].getX()-20) && (evt.getY() <= estado[i].getY()+20 && evt.getY() >= estado[i].getY()-20)){
                                  	  if(estado[i].getOcup()){
                                  		for(int j = 0; j < fplayer; j++){
                                  			if(jugador[j].getNombre().compareTo(estado[i].getNombre()) == 0){
                                  				temp = j;
                                  				click++;
                                  				estado[i].setOcup(false);
                                  				System.out.println(jugador[temp].getNombre());
                                  				System.out.println("Ficha Negra Encontrada");
                                  			}
                                  		}
                                  	  }
                                    }
                    			}
                    		}
                    		else if(click > 0){
                    			System.out.println(click);
                    			for(int i = 0; i < 16; i++){
                            		if((evt.getX() <= estado[i].getX()+20 && evt.getX() >= estado[i].getX()-20) && (evt.getY() <= estado[i].getY()+20 && evt.getY() >= estado[i].getY()-20)){
                                  	  if(estado[i].getOcup() == false){
                                  		jugador[temp].setX(estado[i].getX());
                                  		jugador[temp].setY(estado[i].getY());
                                  		jugador[temp].setNombre(estado[i].getNombre());
                                  		estado[i].setOcup(true);
                                  		repaint();
                                  	  }
                                  	}
                                }
                    		}
                    		turno = false;
                    		contJugadas++;
                    		click = 0;
                    	}// Fin if(turno)
                    	else if(turno == false){
                    		if(click == 0){
                    			for(int i = 0; i < 16; i++){
                            		if((evt.getX() <= estado[i].getX()+20 && evt.getX() >= estado[i].getX()-20) && (evt.getY() <= estado[i].getY()+20 && evt.getY() >= estado[i].getY()-20)){
                                  	  if(estado[i].getOcup()){
                                  		for(int j = 0; j < fcom; j++){
                                  			if(com[j].getNombre().compareTo(estado[i].getNombre()) == 0){
                                  				temp = j;
                                  				click++;
                                  				estado[i].setOcup(false);
                                  				System.out.println("Ficha Blanca Encontrada");
                                  			}
                                  		}
                                  	  }
                                    }
                    			}
                    		}
                    		else if(click > 0){
                    			for(int i = 0; i < 16; i++){
                            		if((evt.getX() <= estado[i].getX()+20 && evt.getX() >= estado[i].getX()-20) && (evt.getY() <= estado[i].getY()+20 && evt.getY() >= estado[i].getY()-20)){
                                  	  if(!estado[i].getOcup()){
                                  		com[temp].setX(estado[i].getX());
                                  		com[temp].setY(estado[i].getY());
                                  		com[temp].setNombre(estado[i].getNombre());
                                  		estado[i].setOcup(true);
                                  		click = 0;
                                  		repaint();
                                  	  }
                                  	}
                                }
                    		}
                    		turno = true;
                    		contJugadas++;
                    	}//Fin else(truno)
                	}
                }//Fin Mouse Listener
            });
	}
	
	
	private void cuadros(Graphics gg){
		if (gg instanceof Graphics2D){
		    Graphics2D g2 = (Graphics2D)gg;
		    g2.setStroke(new BasicStroke(5.0f)); // grosor de 5.0 pixels
		    
		    g2.setColor(Color.LIGHT_GRAY);
			g2.fillRect(0, 0, getSize().width, getSize().height);
			
		    g2.setColor(Color.RED);
			//Cuadrados
			g2.drawRect(133, 60, (getSize().width/2) + (getSize().width/8), (getSize().height/2) + (getSize().height/8)); //Grande
			g2.drawRect(255, 149, ((getSize().width/2) + (getSize().width/8))/2, ((getSize().height/2) + (getSize().height/8))/2);//Pequeño
			
			//Lineas Horizontales
			g2.drawLine(133, 248, 250, 248);
			g2.drawLine(504, 248, 627, 248);
			//Lineas Verticales
			g2.drawLine(382, 60, 382, 145);
			g2.drawLine(382, 336, 382, 430);
		}
	}
	private void estados(Graphics gg){
		if (gg instanceof Graphics2D){
			Graphics2D g2 = (Graphics2D)gg;
		    g2.setStroke(new BasicStroke(5.0f)); // grosor de 5.0 pixels
		    g2.setColor(Color.BLACK);
			for(int i = 0; i < 16; i++)
				estado[i].paint(g2);
		}
	}
	private void ficha1(Graphics gg){
		if (gg instanceof Graphics2D){
			Graphics2D g2 = (Graphics2D)gg;
		    g2.setStroke(new BasicStroke(5.0f)); // Grosor de 5.0 pixels
		    g2.setColor(Color.BLACK);
			for(int i = 0; i < fplayer; i++)
				jugador[i].paint(g2);
		}
	}
	private void ficha2(Graphics gg){
		if (gg instanceof Graphics2D){
			Graphics2D g2 = (Graphics2D)gg;
		    g2.setStroke(new BasicStroke(5.0f)); // Grosor de 5.0 pixels
		    g2.setColor(Color.WHITE);
			for(int i = 0; i < fcom; i++)
				com[i].paint(g2);
		}
	}	
	
	public void paint(Graphics gg){
		super.paint(gg);
		cuadros(gg);
		estados(gg);
		ficha1(gg);
		ficha2(gg);
		if(turno){
			gg.setColor(Color.BLACK);
			gg.drawString("TURNO", 700, 55);
			gg.drawRect(710, 75, 20, 20);
			gg.fillRect(710, 75, 20, 20);
		}
		else{
			gg.setColor(Color.BLACK);
			gg.drawString("TURNO", 700, 55);
			gg.setColor(Color.WHITE);
			gg.drawRect(710, 75, 20, 20);
			gg.fillRect(710, 75, 20, 20);
		}
	}
}
