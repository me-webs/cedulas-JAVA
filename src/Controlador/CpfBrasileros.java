package Controlador;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.*;
import sun.audio.*;	
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class CpfBrasileros extends JFrame {

	Codigo codigo = new Codigo();
	private JPanel contentPane;
	private JTextField textFieldNumero3;
	private JTextField textFieldNumero2;
	private JTextField textFieldNumero1;
	private JTextField textFieldNumero6;
	private JTextField textFieldNumero5;
	private JTextField textFieldNumero4;
	private JTextField textFieldNumero7;
	private JButton btnNewButton;
	private JButton btnCerrar;
	private JPanel panel_3;
	private JTextArea textAreaResumen;
	private int limite  = 1;
	private JButton btnInfo;
	Icon imgBr = new ImageIcon(getClass().getResource("/Img/br2.png"));
	private JButton button;
	private JTextField textFieldNumero9;
	private JTextField textFieldNumero8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CpfBrasileros frame = new CpfBrasileros();
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
	public CpfBrasileros() {
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 300, 640, 354);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textAreaResumen = new JTextArea();
		textAreaResumen.setFont(new Font("Monospaced", Font.BOLD, 20));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 11, 596, 280);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 102, 0));
		panel.setBackground(new Color(51, 204, 102));
		panel.setToolTipText("");
		tabbedPane.addTab("Cadastro de Pessoa Fisica", null, panel, null);
		panel.setLayout(null);
		
		
		JLabel lblCodigoVerificador = new JLabel("");
		textFieldNumero1 = new JTextField(limite);
		
		
		
		
		textFieldNumero1.setBounds(21, 25, 53, 50);
		panel.add(textFieldNumero1);
		textFieldNumero1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNumero1.setFont(new Font("Tahoma", Font.BOLD, 17));
		textFieldNumero1.setColumns(10);
		
		// genero que sólo pueda haber numero
		textFieldNumero1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent event) {
				
				char c = event.getKeyChar();
				if (c<'0'|| c>'9') event.consume();
			}});
		
		textFieldNumero2 = new JTextField();
		textFieldNumero2.setBounds(84, 25, 53, 50);
		panel.add(textFieldNumero2);
		textFieldNumero2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNumero2.setFont(new Font("Tahoma", Font.BOLD, 17));
		textFieldNumero2.setColumns(10);
		
		textFieldNumero3 = new JTextField();
		textFieldNumero3.setBounds(147, 25, 53, 50);
		panel.add(textFieldNumero3);
		textFieldNumero3.setFont(new Font("Tahoma", Font.BOLD, 17));
		textFieldNumero3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNumero3.setColumns(10);
		
		textFieldNumero6 = new JTextField();
		textFieldNumero6.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNumero6.setFont(new Font("Tahoma", Font.BOLD, 17));
		textFieldNumero6.setColumns(10);
		textFieldNumero6.setBounds(336, 25, 53, 50);
		panel.add(textFieldNumero6);
		
		textFieldNumero5 = new JTextField();
		textFieldNumero5.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNumero5.setFont(new Font("Tahoma", Font.BOLD, 17));
		textFieldNumero5.setColumns(10);
		textFieldNumero5.setBounds(273, 25, 53, 50);
		panel.add(textFieldNumero5);
		
		textFieldNumero4 = new JTextField();
		textFieldNumero4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNumero4.setFont(new Font("Tahoma", Font.BOLD, 17));
		textFieldNumero4.setColumns(10);
		textFieldNumero4.setBounds(210, 25, 53, 50);
		panel.add(textFieldNumero4);
		
		textFieldNumero7 = new JTextField();
		textFieldNumero7.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNumero7.setFont(new Font("Tahoma", Font.BOLD, 17));
		textFieldNumero7.setColumns(10);
		textFieldNumero7.setBounds(399, 25, 53, 50);
		panel.add(textFieldNumero7);
		


		JLabel lblCodigoVerificador2 = new JLabel("");
		lblCodigoVerificador2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoVerificador2.setForeground(new Color(0, 0, 0));
		lblCodigoVerificador2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCodigoVerificador2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblCodigoVerificador2.setBounds(336, 136, 118, 94);
		panel.add(lblCodigoVerificador2);
		
		JButton btnGenerarCdigo = new JButton("Generar C\u00F3digo");
		btnGenerarCdigo.setForeground(Color.WHITE);
		btnGenerarCdigo.setBackground(new Color(0, 0, 0));
		btnGenerarCdigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				codigo.sonidos();
				try{
				

					String n1= textFieldNumero1.getText();
					double num1 = Double.parseDouble(n1);
					
					String n2= textFieldNumero2.getText();
					double num2 = Double.parseDouble(n2);
					
					String n3= textFieldNumero3.getText();
					double num3 = Double.parseDouble(n3);
					
					String n4= textFieldNumero4.getText();
					double num4 = Double.parseDouble(n4);
					
					String n5= textFieldNumero5.getText();
					double num5 = Double.parseDouble(n5);
					
					String n6= textFieldNumero6.getText();
					double num6 = Double.parseDouble(n6);
					
					String n7= textFieldNumero7.getText();
					double num7 = Double.parseDouble(n7);
					
					String n8= textFieldNumero8.getText();
					double num8 = Double.parseDouble(n8);
					
					String n9= textFieldNumero9.getText();
					double num9 = Double.parseDouble(n9);
					
					// ----------------- APLICO LOS MÉTODOS PARA EL PRIMER CÓDIGO VERIFICADOR ---------------
					
					double resultado = codigo.multiplicacionPrimeraBr(num1, num2, num3, num4, num5, num6, num7, num8, num9);
					
					double codigoVerificador = codigo.sacarCodigoVerificadorPrimeroBr(resultado);
					
					int codigoVerificador2 = (int) Math.ceil(codigoVerificador);
					
					// ----------------- APLICO LOS MÉTODOS PARA EL SEGUNDO CÓDIGO VERIFICADOR ---------------
					double resultadoMultiplicoCodigoVerif = codigoVerificador2 *2;
					
					double sumar = codigo.multiplicacionSegundaBr(num1, num2, num3, num4, num5, num6, num7, num8, num9);
					int sumarInt = (int) Math.ceil(sumar);
					double sumaTotal = resultadoMultiplicoCodigoVerif+sumar;
					
					double resultadoCodigoVerifSegundo = codigo.sacarCodigoVerificadorSegundoBr(sumaTotal);
					int codigoVerificador3 = (int) Math.ceil(resultadoCodigoVerifSegundo);
					
					// ---------------------- CODIGO VERIFICADOR ----------------
					
					String codVerif = String.valueOf(codigoVerificador2);
					lblCodigoVerificador.setText(codVerif);
					
					String codVerifSegundo = String.valueOf(codigoVerificador3);
					lblCodigoVerificador2.setText(codVerifSegundo);
					
				}catch (Exception error){
					
					JOptionPane.showMessageDialog(null, "Debes ingresar todos los numeros, gracias","Deberías prestar más atención",JOptionPane.ERROR_MESSAGE, imgBr);
					
				}

				}
				
			
		});
		btnGenerarCdigo.setBounds(21, 102, 556, 23);
		panel.add(btnGenerarCdigo);
		
		btnNewButton = new JButton("Resumen");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codigo.sonidoPasar();
				try{
				textAreaResumen.setText("\tRESUMEN DE CPF:\n\n"
						+"\t"+textFieldNumero1.getText()+textFieldNumero2.getText()+textFieldNumero3.getText()+
						textFieldNumero4.getText()+textFieldNumero5.getText()+textFieldNumero6.getText()+
						textFieldNumero7.getText()+
						textFieldNumero8.getText()+textFieldNumero9.getText()+"-"+lblCodigoVerificador.getText()+lblCodigoVerificador2.getText()
						
				);
				}catch(Exception error){
					JOptionPane.showMessageDialog(null, "Debes ingresar todos los numeros y crear el verificador primero, gracias");
				}
			}
		});
		btnNewButton.setBounds(464, 136, 113, 23);
		panel.add(btnNewButton);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.setBackground(new Color(0, 0, 0));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				codigo.sonidoCerrar();
				CpfBrasileros.this.dispose();
				
			}
		});
		btnCerrar.setBounds(464, 207, 113, 23);
		panel.add(btnCerrar);
		
		JButton btnResetear = new JButton("Resetear");
		btnResetear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codigo.sonidoLimpiar();
				textFieldNumero1.setText(null);
				textFieldNumero2.setText(null);
				textFieldNumero3.setText(null);
				textFieldNumero4.setText(null);
				textFieldNumero5.setText(null);
				textFieldNumero6.setText(null);
				textFieldNumero7.setText(null);
				textFieldNumero8.setText(null);
				textFieldNumero9.setText(null);
				lblCodigoVerificador.setText(null);
				lblCodigoVerificador2.setText(null);
				
				
			}
		});
		btnResetear.setForeground(Color.WHITE);
		btnResetear.setBackground(new Color(0, 0, 0));
		btnResetear.setBounds(464, 173, 113, 23);
		panel.add(btnResetear);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblImagen.setBounds(21, 136, 179, 94);
		
		
		// ------------------ AGREGO IMAGEN AL JLABEL ------------------------
		
		ImageIcon imagen2 = new ImageIcon(CpfBrasileros.class.getResource("/Img/br.png"));
		Image imag2 = imagen2.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
		lblImagen.setIcon(new ImageIcon(imag2));
		panel.add(lblImagen);
		
		
		lblCodigoVerificador.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoVerificador.setForeground(Color.BLACK);
		lblCodigoVerificador.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCodigoVerificador.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblCodigoVerificador.setBounds(210, 136, 118, 94);
		panel.add(lblCodigoVerificador);
		
		textFieldNumero9 = new JTextField();
		textFieldNumero9.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNumero9.setFont(new Font("Tahoma", Font.BOLD, 17));
		textFieldNumero9.setColumns(10);
		textFieldNumero9.setBounds(525, 25, 53, 50);
		panel.add(textFieldNumero9);
		
		textFieldNumero8 = new JTextField();
		textFieldNumero8.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNumero8.setFont(new Font("Tahoma", Font.BOLD, 17));
		textFieldNumero8.setColumns(10);
		textFieldNumero8.setBounds(462, 25, 53, 50);
		panel.add(textFieldNumero8);
		
		
		panel_3 = new JPanel();
		tabbedPane.addTab("Resumen", null, panel_3, null);
		panel_3.setLayout(null);
		
		textAreaResumen.setBounds(10, 5, 465, 247);
		panel_3.add(textAreaResumen);
		
		btnInfo = new JButton("");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Creado el 08/11/2016","Información developer",JOptionPane.ERROR_MESSAGE, imgBr);
			}
		});
		btnInfo.setBounds(603, 293, 13, 11);
		contentPane.add(btnInfo);
		
		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Estamos buscando trabajo, \nen todas partes del Mundo. \n\nSi buscas developers, agradezco nos tenga presente\n\nCel: +598 091074131 - 095036103","Información importante",JOptionPane.ERROR_MESSAGE, imgBr);
				
			}
		});
		button.setBounds(580, 293, 13, 11);
		contentPane.add(button);
		
		
		// -------------------- LIMITO LA ENTRADA DE LOS TEXT-FIELD A NUMERICO -----------------------
		
				// genero que sólo pueda haber numero
				textFieldNumero2.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent event) {
						
						char c = event.getKeyChar();
						if (c<'0'|| c>'9') event.consume();
					}});
				
				// genero que sólo pueda haber numero
				textFieldNumero3.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent event) {
						
						char c = event.getKeyChar();
						if (c<'0'|| c>'9') event.consume();
					}});
				
				// genero que sólo pueda haber numero
				textFieldNumero4.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent event) {
						
						char c = event.getKeyChar();
						if (c<'0'|| c>'9') event.consume();
					}});
				
				// genero que sólo pueda haber numero
				textFieldNumero5.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent event) {
						
						char c = event.getKeyChar();
						if (c<'0'|| c>'9') event.consume();
					}});
				
				// genero que sólo pueda haber numero
				textFieldNumero6.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent event) {
						
						char c = event.getKeyChar();
						if (c<'0'|| c>'9') event.consume();
					}});
				
				// genero que sólo pueda haber numero
				textFieldNumero7.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent event) {
						char c = event.getKeyChar();
						if ((c<'0'|| c>'9')) event.consume();
					}});
				
				// genero que sólo pueda haber numero
				textFieldNumero8.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent event) {
						
						char c = event.getKeyChar();
						if (c<'0'|| c>'9') event.consume();
					}});
				
				// genero que sólo pueda haber numero
				textFieldNumero9.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent event) {
						char c = event.getKeyChar();
						if ((c<'0'|| c>'9')) event.consume();
					}});
				
				
	// --------------------- BLOQUEA LA CANTIDAD DE NUMEROS A INGRESAR
				
				 // limito cantidad de ingresos por textfield
				textFieldNumero1.addKeyListener(new KeyListener(){
				public void keyTyped(KeyEvent e)
				 {if (textFieldNumero1.getText().length()== limite)
				 				     e.consume(); }
				public void keyPressed(KeyEvent arg0) {
				}
				public void keyReleased(KeyEvent arg0) {
				}
				});
				 // limito cantidad de ingresos por textfield
				textFieldNumero2.addKeyListener(new KeyListener(){
				public void keyTyped(KeyEvent e)
				 {if (textFieldNumero2.getText().length()== limite)
				 				     e.consume(); }
				public void keyPressed(KeyEvent arg0) {
				}
				public void keyReleased(KeyEvent arg0) {
				}
				});
				 // limito cantidad de ingresos por textfield
				textFieldNumero3.addKeyListener(new KeyListener(){
				public void keyTyped(KeyEvent e)
				 {if (textFieldNumero3.getText().length()== limite)
				 				     e.consume(); }
				public void keyPressed(KeyEvent arg0) {
				}
				public void keyReleased(KeyEvent arg0) {
				}
				});
				 // limito cantidad de ingresos por textfield
				textFieldNumero4.addKeyListener(new KeyListener(){
				public void keyTyped(KeyEvent e)
				 {if (textFieldNumero4.getText().length()== limite)
				 				     e.consume(); }
				public void keyPressed(KeyEvent arg0) {
				}
				public void keyReleased(KeyEvent arg0) {
				}
				});
				 // limito cantidad de ingresos por textfield
				textFieldNumero5.addKeyListener(new KeyListener(){
				public void keyTyped(KeyEvent e)
				 {if (textFieldNumero5.getText().length()== limite)
				 				     e.consume(); }
				public void keyPressed(KeyEvent arg0) {
				}
				public void keyReleased(KeyEvent arg0) {
				}
				});
				 // limito cantidad de ingresos por textfield
				textFieldNumero6.addKeyListener(new KeyListener(){
				public void keyTyped(KeyEvent e)
				 {if (textFieldNumero6.getText().length()== limite)
				 				     e.consume(); }
				public void keyPressed(KeyEvent arg0) {
				}
				public void keyReleased(KeyEvent arg0) {
				}
				});
				 // limito cantidad de ingresos por textfield
				textFieldNumero7.addKeyListener(new KeyListener(){
				public void keyTyped(KeyEvent e)
				 {if (textFieldNumero7.getText().length()== limite)
				 				     e.consume(); }
				public void keyPressed(KeyEvent arg0) {
				}
				public void keyReleased(KeyEvent arg0) {
				}
				});
				 // limito cantidad de ingresos por textfield
				textFieldNumero8.addKeyListener(new KeyListener(){
				public void keyTyped(KeyEvent e)
				 {if (textFieldNumero8.getText().length()== limite)
				 				     e.consume(); }
				public void keyPressed(KeyEvent arg0) {
				}
				public void keyReleased(KeyEvent arg0) {
				}
				});
				 // limito cantidad de ingresos por textfield
				textFieldNumero9.addKeyListener(new KeyListener(){
				public void keyTyped(KeyEvent e)
				 {if (textFieldNumero9.getText().length()== limite)
				 				     e.consume(); }
				public void keyPressed(KeyEvent arg0) {
				}
				public void keyReleased(KeyEvent arg0) {
				}
				});
				
				
				
				
	}
}
