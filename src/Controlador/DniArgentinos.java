package Controlador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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

public class DniArgentinos extends JFrame {

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
	Icon imgAr = new ImageIcon(getClass().getResource("/Img/ar2.png"));
	private JButton button;
	private JTextField textFieldNumero8;
	private JTextField textFieldNumero9;
	private JTextField textFieldNumero10;
	Codigo codigo = new Codigo();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CedulaIdentidadUruguaya frame = new CedulaIdentidadUruguaya();
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
	public DniArgentinos() {
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(600, 200, 728, 354);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textAreaResumen = new JTextArea();
		textAreaResumen.setFont(new Font("Monospaced", Font.BOLD, 20));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 11, 682, 280);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(new Color(135, 206, 235));
		panel.setToolTipText("");
		tabbedPane.addTab("DNI Argentino", null, panel, null);
		panel.setLayout(null);
		
		
		
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
		


		JLabel lblCodigoVerificador = new JLabel("");
		lblCodigoVerificador.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoVerificador.setForeground(new Color(0, 0, 128));
		lblCodigoVerificador.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCodigoVerificador.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblCodigoVerificador.setBounds(262, 136, 118, 94);
		panel.add(lblCodigoVerificador);
		
		JButton btnGenerarCdigo = new JButton("Generar C\u00F3digo");
		btnGenerarCdigo.setForeground(Color.WHITE);
		btnGenerarCdigo.setBackground(new Color(0, 0, 139));
		btnGenerarCdigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				codigo.sonidos();
				try{
				

					String n1= textFieldNumero1.getText();
					int num1 = Integer.parseInt(n1);
					
					String n2= textFieldNumero2.getText();
					int num2 = Integer.parseInt(n2);
					
					String n3= textFieldNumero3.getText();
					int num3 = Integer.parseInt(n3);
					
					String n4= textFieldNumero4.getText();
					int num4 = Integer.parseInt(n4);
					
					String n5= textFieldNumero5.getText();
					int num5 = Integer.parseInt(n5);
					
					String n6= textFieldNumero6.getText();
					int num6 = Integer.parseInt(n6);
					
					String n7= textFieldNumero7.getText();
					int num7 = Integer.parseInt(n7);
					
					String n8= textFieldNumero5.getText();
					int num8 = Integer.parseInt(n8);
					
					String n9= textFieldNumero6.getText();
					int num9 = Integer.parseInt(n9);
					
					String n10= textFieldNumero7.getText();
					int num10 = Integer.parseInt(n10);
					
					// ----------------- APLICO LOS MÉTODOS ---------------
					
					int resultado = codigo.multiplicacionArg(num1, num2, num3, num4, num5, num6, num7, num8, num9, num10);
					
					int codigoVerificador = codigo.sacarCodigoVerificadorArg(resultado);
					
					String codVerif = String.valueOf(codigoVerificador);
					lblCodigoVerificador.setText(codVerif);
					
				}catch (Exception error){
					
					JOptionPane.showMessageDialog(null, "Debes ingresar todos los numeros, gracias","Deberías prestar más atención",JOptionPane.ERROR_MESSAGE, imgAr);
					
				}

				}
				
			
		});
		btnGenerarCdigo.setBounds(21, 102, 620, 23);
		panel.add(btnGenerarCdigo);
		
		btnNewButton = new JButton("Resumen");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 0, 139));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codigo.sonidoPasar();
				try{
				textAreaResumen.setText("\tRESUMEN DE DNI ARGENTINO:\n\n"
						+"\t"+textFieldNumero1.getText()+textFieldNumero2.getText()+textFieldNumero3.getText()+
						textFieldNumero4.getText()+textFieldNumero5.getText()+textFieldNumero6.getText()+
						textFieldNumero7.getText()+
						textFieldNumero8.getText()+textFieldNumero9.getText()+textFieldNumero10.getText()+"-"+lblCodigoVerificador.getText()
				);
				}catch(Exception error){
					JOptionPane.showMessageDialog(null, "Debes ingresar todos los numeros y crear el verificador primero, gracias");
				}
			}
		});
		btnNewButton.setBounds(399, 136, 242, 23);
		panel.add(btnNewButton);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.setBackground(new Color(0, 0, 139));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				codigo.sonidoCerrar();
				DniArgentinos.this.dispose();
				
			}
		});
		btnCerrar.setBounds(399, 207, 242, 23);
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
				textFieldNumero10.setText(null);
				lblCodigoVerificador.setText(null);
				
				
			}
		});
		btnResetear.setForeground(Color.WHITE);
		btnResetear.setBackground(new Color(0, 0, 139));
		btnResetear.setBounds(399, 173, 242, 23);
		panel.add(btnResetear);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblImagen.setBounds(21, 136, 198, 94);
		
		
		// ------------------ AGREGO IMAGEN AL JLABEL ------------------------
		
		ImageIcon imagen2 = new ImageIcon(CedulaIdentidadUruguaya.class.getResource("/Img/ar.png"));
		Image imag2 = imagen2.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
		lblImagen.setIcon(new ImageIcon(imag2));
		panel.add(lblImagen);
		
		textFieldNumero8 = new JTextField();
		textFieldNumero8.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNumero8.setFont(new Font("Tahoma", Font.BOLD, 17));
		textFieldNumero8.setColumns(10);
		textFieldNumero8.setBounds(462, 25, 53, 50);
		panel.add(textFieldNumero8);
		
		textFieldNumero9 = new JTextField();
		textFieldNumero9.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNumero9.setFont(new Font("Tahoma", Font.BOLD, 17));
		textFieldNumero9.setColumns(10);
		textFieldNumero9.setBounds(525, 25, 53, 50);
		panel.add(textFieldNumero9);
		
		textFieldNumero10 = new JTextField();
		textFieldNumero10.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNumero10.setFont(new Font("Tahoma", Font.BOLD, 17));
		textFieldNumero10.setColumns(10);
		textFieldNumero10.setBounds(588, 25, 53, 50);
		panel.add(textFieldNumero10);
		
		
		panel_3 = new JPanel();
		tabbedPane.addTab("Resumen", null, panel_3, null);
		panel_3.setLayout(null);
		
		textAreaResumen.setBounds(10, 5, 657, 247);
		panel_3.add(textAreaResumen);
		
		btnInfo = new JButton("");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Creado el 08/11/2016","Información developer",JOptionPane.ERROR_MESSAGE, imgAr);
			}
		});
		btnInfo.setBounds(689, 293, 13, 11);
		contentPane.add(btnInfo);
		
		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Estamos buscando trabajo, \nen todas partes del Mundo. \n\nSi buscas developers, agradezco nos tenga presente\n\nCel: +598 091074131","Información importante",JOptionPane.ERROR_MESSAGE, imgAr);
				
			}
		});
		button.setBounds(666, 293, 13, 11);
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
						if (c<'0'|| c>'9') event.consume();
					}});
				
				// genero que sólo pueda haber numero
				textFieldNumero10.addKeyListener(new KeyAdapter() {
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
				 // limito cantidad de ingresos por textfield
				textFieldNumero10.addKeyListener(new KeyListener(){
				public void keyTyped(KeyEvent e)
				 {if (textFieldNumero10.getText().length()== limite)
				 				     e.consume(); }
				public void keyPressed(KeyEvent arg0) {
				}
				public void keyReleased(KeyEvent arg0) {
				}
				});
				
				
	}
}