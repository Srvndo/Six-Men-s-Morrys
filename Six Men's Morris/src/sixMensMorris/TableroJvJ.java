package sixMensMorris;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.*;

public class TableroJvJ extends JFrame {
	private Estado[] estado;
	private Ficha[] jugador; //Fichas Negras
	private Ficha[] com; //Fichas Blancas
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JTextField disponibleN;
	private JTextField disponibleB;
	private boolean turno; //True = Jugador.     False = Jugador 2.
	private int fplayer, fcom, contJugadas, click = 0, temp, aux, contEB = 0, contEN = 0, fSinJugarB, fSinJugarN;
	private short[] nX, nY, bX, bY;
	
	TableroJvJ(String j1, String j2){
		super("Six Men's Morris");
		this.setSize(800, 600);
		
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Inicializar Limitantes
		contJugadas = 0;
		if(Math.random()*10 > 4.5)
			turno = true;
		else
			turno = false;
		
		//Inicializacion de Labels y Botones
		label1 = new JLabel(j1);
		label1.setFont(new java.awt.Font("Tahoma", 1, 24));
		label1.setBounds(80, 209, 200, 500);
		
		label2 = new JLabel(j2);
		label2.setFont(new java.awt.Font("Tahoma", 1, 24));
		label2.setBounds(590, 209, 200, 500);
		
		label3 = new JLabel("Turno");
		label3.setFont(new java.awt.Font("Tahoma", 1, 24));
		label3.setBounds(355, 210, 400, 500);
		
		label4 = new JLabel("En Mesa");
		label4.setFont(new java.awt.Font("Tahoma", 1, 20));
		label4.setBounds(300, 500, 400, 500);
		
		label5 = new JLabel("En Mesa");
		label5.setFont(new java.awt.Font("Tahoma", 1, 20));
		label5.setBounds(255, 480, 400, 500);
		
		disponibleN = new JTextField(2);
		disponibleN.setBounds(255, 500, 30, 30);
		disponibleN.setText("" + fplayer);
		disponibleN.setEditable(false);
		
		disponibleB = new JTextField(2);
		disponibleB.setBounds(485, 500, 30, 30);
		disponibleB.setText("" + fcom);
		disponibleB.setEditable(false);
		
		//Inicializar Contador de Fichas
		fplayer = 0;
		fcom = 0;
		fSinJugarB = 6;
		fSinJugarN = 6;
		
		//Inicializar Fichas
		initFichas();
		
        //Inicializar Estados
        initEstados();
        
        //Eventos
        this.addMouseListener(new java.awt.event.MouseAdapter() {
        	public void mouseClicked(java.awt.event.MouseEvent evt) {
        		jugarSMM(evt);
        	}//Fin Mouse Listener
        });
        
        //add
        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
        add(disponibleN);
        add(disponibleB);
	}
	
	//Inicializacion de Estados
	private void initEstados(){
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
	}
	
	//Inicializacion de Fichas
	private void initFichas(){
		jugador = new Ficha[6];
		com = new Ficha[6];
		
		nX = new short[6];
		nX[0] = 82; nX[1] = 132; nX[2] = 182; nX[3] = 82; nX[4] = 132; nX[5] = 182; 
		nY = new short[6];
		nY[0] = 510; nY[1] = 510; nY[2] = 510; nY[3] = 560; nY[4] = 560; nY[5] = 560; 
		
		bX = new short[6];
		bX[0] = 595; bX[1] = 645; bX[2] = 695; bX[3] = 595; bX[4] = 645; bX[5] = 695;
		bY = new short[6];
		bY[0] = 510; bY[1] = 510; bY[2] = 510; bY[3] = 560; bY[4] = 560; bY[5] = 560;
		
		//Fichas Negras y Fichas Blanchas
		for(int i = 0; i < 6; i++){
			jugador[i] = new Ficha("", nX[i], nY[i], Color.BLACK);
			com[i] = new Ficha("", bX[i], bY[i], Color.WHITE);
		}
	}
	
	//Juego 1 VS 1
	private void jugarSMM(java.awt.event.MouseEvent evt){
		//Las Primeras 12 jugadas
    	if(fSinJugarN > 0 || fSinJugarB > 0){
    		if(turno){
        		for(int i = 0; i < 16; i++){
            		if((evt.getX() <= estado[i].getX()+30 && evt.getX() >= estado[i].getX()-30) && (evt.getY() <= estado[i].getY()+30 && evt.getY() >= estado[i].getY()-30)){
                  	  if(!estado[i].getOcup()){
                  		jugador[fplayer].setX(estado[i].getX());
                  		jugador[fplayer].setY(estado[i].getY());
                  		jugador[fplayer].setNombre(estado[i].getNombre());
                  		disponibleN.setText("" + ++fplayer);
                  		estado[i].setOcup(true);
                		fSinJugarN--;
                		contJugadas++;
                		repaint();
                  	    System.out.println("Estado " + (i+1) + " Jugador " + contJugadas);
                  	    break;
                  	  }
                    }
            	}//Fin For
        		if(contJugadas == 5){ //aqui se va a poner la condicion del 3 en Linea
        			for(int x = 0; x < 16; x++){
        				System.out.println("Eliminar Blanca");
        	    		if((evt.getX() <= estado[x].getX()+30 && evt.getX() >= estado[x].getX()-30) && (evt.getY() <= estado[x].getY()+30 && evt.getY() >= estado[x].getY()-30)){
        	    			if(estado[x].getOcup()){
        	    				for(int y = 0; y < fplayer; y++){
        	    					if(com[y].getNombre().compareTo(estado[x].getNombre()) == 0 && com[y].getColor() == Color.WHITE){
        	    						com[y].setX(nX[contEB]);
        	    						com[y].setY(nY[contEB++]);
        	    						com[y].setUso(false);
        	    						System.out.println("Estado " + (x+1) + " Jugador " + contJugadas);
        	    						contJugadas++;
        	    						estado[x].setOcup(false);
        	    						disponibleB.setText("" + (fcom-contEB));
        	    						turno = false;
        	    	        			repaint();
        	    						break;
        	    					}//Fin if comparar nombres
        	    				}//fin for buscar fichas
        	          	  }
        	    		}
        			}
        		}
        		else {
        			turno = false;
        			repaint();
        		}
        	}// Fin if(turno)
        	else if(turno == false){
        		for(int i = 0; i < 16; i++){
            		if((evt.getX() <= estado[i].getX()+30 && evt.getX() >= estado[i].getX()-30) && (evt.getY() <= estado[i].getY()+30 && evt.getY() >= estado[i].getY()-30)){
                  	  if(!estado[i].getOcup()){
                  		com[fcom].setX(estado[i].getX());
                  		com[fcom].setY(estado[i].getY());
                  		com[fcom].setNombre(estado[i].getNombre());
                  		disponibleB.setText("" + ++fcom);
                  		estado[i].setOcup(true);
                		contJugadas++;
                  	    System.out.println("Estado " + (i+1) + " Com " + contJugadas);
                  	    turno = true;
                  	    fSinJugarB--;
                  	    repaint();
                  	    break;
                  	  }
                    }
            	}//Fin For
        		if(contJugadas == 11){ //aqui se va a poner la condicion del 3 en Linea
        			for(int x = 0; x < 16; x++){
        				System.out.println("Eliminar Negra");
        	    		if((evt.getX() <= estado[x].getX()+30 && evt.getX() >= estado[x].getX()-30) && (evt.getY() <= estado[x].getY()+30 && evt.getY() >= estado[x].getY()-30)){
        	    			if(estado[x].getOcup()){
        	    				for(int y = 0; y < fplayer; y++){
        	    					if(jugador[y].getNombre().compareTo(estado[x].getNombre()) == 0 && jugador[y].getColor() == Color.BLACK){
        	    						jugador[y].setX(bX[contEN]);
        	    						jugador[y].setY(bY[contEN++]);
        	    						jugador[y].setUso(false);
        	    						System.out.println("Estado " + (x+1) + " Jugador 2 " + contJugadas);
        	    						contJugadas++;
        	    						estado[x].setOcup(false);
        	    						disponibleB.setText("" + (fplayer-contEN));
        	    						turno = true;
        	    	        			repaint();
        	    						break;
        	    					}//Fin if comparar nombres
        	    				}//fin for buscar fichas
        	          	  }
        	    		}
        			}
        		}
        		else {
        			turno = true;
        			repaint();
        		}
        	}//Fin else(turno)
    	}//Fin If(contJugadas)
    	//Despues de 12 jugadas (todas las fichas en la mesa).
    	else if(fSinJugarN == 0 && fSinJugarB == 0){
    		if(turno){
        		if(click == 0){
        			for(int i = 0; i < 16; i++){
                		if((evt.getX() <= estado[i].getX()+30 && evt.getX() >= estado[i].getX()-30) && (evt.getY() <= estado[i].getY()+30 && evt.getY() >= estado[i].getY()-30)){
                      	  if(estado[i].getOcup()){
                      		for(int j = 0; j < fplayer; j++){
                      			if(jugador[j].getNombre().compareTo(estado[i].getNombre()) == 0){
                      				temp = j;
                      				aux = i;
                      				click++;
                      				System.out.println(jugador[temp].getNombre());
                      				System.out.println("Ficha Negra Encontrada");
                      				break;
                      			}//Fin if comparar nombres
                      		}//fin for buscar fichas
                      	  }//fin if estado ocupado
                        }//fin if pos
        			}//fin for
        		}//fin if(click)
        		else if(click > 0){
        			System.out.println(click);
        			for(int i = 0; i < 16; i++){
                		if((evt.getX() <= estado[i].getX()+30 && evt.getX() >= estado[i].getX()-30) && (evt.getY() <= estado[i].getY()+30 && evt.getY() >= estado[i].getY()-30)){
                      	  if(!estado[i].getOcup()){
                      		jugador[temp].setX(estado[i].getX());
                      		jugador[temp].setY(estado[i].getY());
                      		jugador[temp].setNombre(estado[i].getNombre());
                      		estado[i].setOcup(true);
                      		estado[aux].setOcup(false);
                      		repaint();
                      		click = 0;
                    		turno = false;
                    		contJugadas++;
                    		break;
                      	  }
                      	}
                    }
        		}
        	}// Fin if(turno)
        	else if(turno == false){
        		if(click == 0){
        			for(int i = 0; i < 16; i++){
                		if((evt.getX() <= estado[i].getX()+30 && evt.getX() >= estado[i].getX()-30) && (evt.getY() <= estado[i].getY()+30 && evt.getY() >= estado[i].getY()-30)){
                      	  if(estado[i].getOcup()){
                      		for(int j = 0; j < fcom; j++){
                      			if(com[j].getNombre().compareTo(estado[i].getNombre()) == 0){
                      				temp = j;
                      				click++;
                      				aux = i;
                      				System.out.println(com[temp].getNombre());
                      				System.out.println("Ficha Blanca Encontrada");
                      				break;
                      			}
                      		}
                      	  }
                        }
        			}
        		}
        		else if(click > 0){
        			for(int i = 0; i < 16; i++){
                		if((evt.getX() <= estado[i].getX()+30 && evt.getX() >= estado[i].getX()-30) && (evt.getY() <= estado[i].getY()+30 && evt.getY() >= estado[i].getY()-30)){
                      	  if(!estado[i].getOcup()){
                      		com[temp].setX(estado[i].getX());
                      		com[temp].setY(estado[i].getY());
                      		com[temp].setNombre(estado[i].getNombre());
                      		estado[i].setOcup(true);
                      		estado[aux].setOcup(false);
                      		click = 0;
                      		repaint();
                      		turno = true;
                    		contJugadas++;
                    		break;
                      	  }
                      	}
                    }
        		}
        	}//Fin else(truno)
    	}
	}
	
	//Paint
	private void cuadros(Graphics gg){
		if (gg instanceof Graphics2D){
		    Graphics2D g2 = (Graphics2D)gg;
		    g2.setStroke(new BasicStroke(5.0f)); // grosor de 5.0 pixels
		    
		    g2.setColor(Color.GRAY);
			g2.fillRect(50, 0, getSize().width-130, getSize().height-130);
			g2.setColor(Color.LIGHT_GRAY);
			g2.fillRect(60, 5, getSize().width-150, getSize().height-145);
			
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
			for(int i = 0; i < 6; i++)
				jugador[i].paint(g2);
		}
	}
	private void ficha2(Graphics gg){
		if (gg instanceof Graphics2D){
			Graphics2D g2 = (Graphics2D)gg;
		    g2.setStroke(new BasicStroke(5.0f)); // Grosor de 5.0 pixels
		    g2.setColor(Color.WHITE);
			for(int i = 0; i < 6; i++)
				com[i].paint(g2);
		}
	}	
	
	public void paint(Graphics gg){
		super.paint(gg);
		cuadros(gg);
		estados(gg);
		ficha1(gg);
		ficha2(gg);
		if (gg instanceof Graphics2D){
			Graphics2D g2 = (Graphics2D)gg;
		    g2.setStroke(new BasicStroke(5.0f)); // Grosor de 5.0 pixels
			if(turno){
				g2.setColor(Color.BLACK);
				g2.drawRoundRect(369, 515, 50, 40, 15, 15);
				g2.fillRoundRect(369, 515, 50, 40, 15, 15);
			}
			else{
				g2.setColor(Color.BLACK);
				g2.drawRoundRect(369, 515, 50, 40, 15, 15);
				g2.setColor(Color.WHITE);
				g2.fillRoundRect(369, 515, 50, 40, 15, 15);
			}
		}
	}
}
