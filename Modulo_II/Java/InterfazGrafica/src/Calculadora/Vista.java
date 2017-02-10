package Calculadora;
//https://jonathanmelgoza.com/blog/como-hacer-una-calculadora-en-java/
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Vista {
		
	JFrame frame;
	JPanel panelInferior, panelSuperior, operaciones;
	JButton bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, btSum, btRes, btMul, btDiv, btIgual, btPunto;
	JTextField pantallaSup, pantallaInf;
	double op1 = 0, op2 = 0;
	String operacion = "";
	boolean nueva = true;
		
	public static void main(String[] args){
        new Vista();
    }
	
	public Vista(){
	       construyePanelSuperior();
	       construyePanelInferior();
	       construyeVentana();
	}
	
	public void construyePanelInferior(){
		panelInferior= new JPanel();
		panelInferior.setLayout(new GridLayout(4,4,8,8));
		JButton[] button = new JButton[16];
		button[0] = new JButton("7");
		button[1] = new JButton("8");
		button[2] = new JButton("9");
		button[3] = new JButton("/");
		button[4] = new JButton("4");
		button[5] = new JButton("5");
		button[6] = new JButton("6");
		button[7] = new JButton("x");
		button[8] = new JButton("1");
		button[9] = new JButton("2");
		button[10] = new JButton("3");
		button[11] = new JButton("-");
		button[12] = new JButton(".");
		button[13] = new JButton("0");
		button[14] = new JButton("=");
		button[15] = new JButton("+");
		
		for (int i = 0; i < button.length; i++) {
			panelInferior.add(button[i]);
		}
		
		button[0].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(nueva){pantallaSup.setText("");nueva=false;}
                pantallaSup.setText(pantallaSup.getText()+"7");
            }
        });
		button[1].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(nueva){pantallaSup.setText("");nueva=false;}
                pantallaSup.setText(pantallaSup.getText()+"8");
            }
        });
		button[2].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(nueva){pantallaSup.setText("");nueva=false;}
                pantallaSup.setText(pantallaSup.getText()+"9");
            }
        });
		button[4].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(nueva){pantallaSup.setText("");nueva=false;}
                pantallaSup.setText(pantallaSup.getText()+"4");
            }
        });
		button[5].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(nueva){pantallaSup.setText("");nueva=false;}
                pantallaSup.setText(pantallaSup.getText()+"5");
            }
        });
		button[6].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(nueva){pantallaSup.setText("");nueva=false;}
                pantallaSup.setText(pantallaSup.getText()+"6");
            }
        });
		button[8].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(nueva){pantallaSup.setText("");nueva=false;}
                pantallaSup.setText(pantallaSup.getText()+"1");
            }
        });
		button[9].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(nueva){pantallaSup.setText("");nueva=false;}
                pantallaSup.setText(pantallaSup.getText()+"2");
            }
        });
		button[10].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(nueva){pantallaSup.setText("");nueva=false;}
                pantallaSup.setText(pantallaSup.getText()+"3");
            }
        });
		button[13].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(nueva){pantallaSup.setText("");nueva=false;}
                pantallaSup.setText(pantallaSup.getText()+"0");
            }
        });
		button[12].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(nueva){pantallaSup.setText("");nueva=false;}
                pantallaSup.setText(pantallaSup.getText()+".");
            }
        });
		
		button[14].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                
                double resultado;
              
                if(operacion.equals("suma")){
                    resultado = op1 + op2;
                    pantallaInf.setText(String.valueOf(resultado));
                    
                }else if(operacion.equals("resta")){
                    resultado = op1 - op2;
                    pantallaInf.setText(String.valueOf(resultado));

                }else if(operacion.equals("multiplicacion")){
                    resultado = op1 * op2;
                    pantallaInf.setText(String.valueOf(resultado));

                }else if(operacion.equals("division")){
                    resultado = op1 / op2;
                    pantallaInf.setText(String.valueOf(resultado));

                }
                op1 = op2 = 0;
                operacion = "";
                nueva = true;
                resultado = 0;
            }
        });
		
		button[15].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                try{
                    if(op1 != 0)
                        op1 = op1 + Double.parseDouble(pantallaSup.getText());
                    else
                        op1 = Double.parseDouble(pantallaSup.getText());
                    operacion = "suma";
                }catch(Exception err){}
            }
        });
		button[11].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                try{
                    if(op1!=0)
                        op1=op1-Double.parseDouble(pantallaSup.getText());
                    else
                        op1=Double.parseDouble(pantallaSup.getText());
                    operacion="resta";
                    pantallaSup.setText("");
                }catch(Exception err){}
            }
        });
		button[7].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                try{
                    if(op1!=0)
                        op1=op1*Double.parseDouble(pantallaSup.getText());
                    else
                        op1=Double.parseDouble(pantallaSup.getText());
                    operacion="multiplicacion";
                    pantallaSup.setText("");
                }catch(Exception err){}
            }
        });
        button[3].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                try{
                    if(op1!=0)
                        op1=op1/Double.parseDouble(pantallaSup.getText());
                    else
                        op1=Double.parseDouble(pantallaSup.getText());
                    operacion="division";
                    pantallaSup.setText("");
                }catch(Exception err){}
            }
        });
		
	}
	
	public void construyePanelSuperior(){
		panelSuperior = new JPanel ();
		operaciones = new JPanel ();
		
		panelSuperior.setLayout(new FlowLayout());
		operaciones.setLayout(new FlowLayout());
		
		pantallaSup = new JTextField(30);
		pantallaInf = new JTextField(30);
		
		panelSuperior.add(pantallaSup);
		operaciones.add(pantallaInf);
	}
	
	public void construyeVentana(){
		
        frame =new JFrame("Calculadora");
        frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
        frame.add(panelSuperior);
        frame.add(operaciones);
        frame.add(panelInferior);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
