package Wator;

import java.awt.GridLayout; 
import java.util.ArrayList; 
 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.border.EtchedBorder; 
 
public class WtorS { 
     
    static int MAX_X=20; 
    static int MAX_Y=20; 
     
    PrThread[][] mundo = new PrThread[MAX_X][MAX_Y]; 
    JLabel[][] mundo_label = new JLabel[MAX_X][MAX_Y]; 
 
    static int T_M = 10; 
    static int T_F = 10; 
    static int P_M = 20; 
    static int P_F = 20; 
 
    public ArrayList<PrThread> waTor = new ArrayList<WtorS.PrThread>(); 
 
    public Especie getEspecie() { 
        return new Especie(); 
    } 
 
    public PrThread getHilo(Especie e, int x, int y) { 
        return new PrThread(e, x, y); 
    } 
     
    public void born(Especie esp, int x, int y){ 
        PrThread p = new PrThread(esp, x, y); 
        waTor.add(p); 
        p.start(); 
    } 
     
    public void execute(){ 
         
        JFrame frame = new JFrame(); 
        frame.setLayout(new GridLayout(20, 20)); 
        frame.setSize(600, 600); 
        frame.setVisible(true); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
         
        for (int i = 0; i < MAX_X; i++) { 
            for (int j = 0; j < MAX_Y; j++) { 
                JLabel l = new JLabel(); 
                l.setBorder(new EtchedBorder()); 
                frame.add(l); 
                mundo_label[i][j] = l; 
            } 
        } 
         
        for (int i = 0; i < waTor.size(); i++) { 
            waTor.get(i).start(); 
        } 
         
    } 
     
    public static void main(String[] args) { 
        WtorS w = new WtorS(); 
        int x = 0; 
        int y = 0; 
        for (int i = 0; i < T_M; i++) { 
            Especie e = w.getEspecie(); 
            e.nombre = "t"; 
            e.sexo = "M"; 
 
            x = (int)(Math.random()*(0 - 19)+ 19); 
            y = (int)(Math.random()*(0 - 19)+ 19);
 
            PrThread p = w.getHilo(e, x, y); 
            w.waTor.add(p); 
 
        } 
 
        for (int i = 0; i < T_F; i++) { 
            Especie e = w.getEspecie(); 
            e.nombre = "t"; 
            e.sexo = "F"; 
 
            x = (int)(Math.random()*(0 - 19)+ 19); 
            y = (int)(Math.random()*(0 - 19)+ 19); 
 
            PrThread p = w.getHilo(e, x, y); 
            w.waTor.add(p); 
        } 
 
        for (int i = 0; i < P_M; i++) { 
            Especie e = w.getEspecie(); 
            e.nombre = "p"; 
            e.sexo = "M"; 
 
            x = (int)(Math.random()*(0 - 19)+ 19);
            y = (int)(Math.random()*(0 - 19)+ 19); 
 
            PrThread p = w.getHilo(e, x, y); 
            w.waTor.add(p); 
        } 
 
        for (int i = 0; i < P_F; i++) { 
            Especie e = w.getEspecie(); 
            e.nombre = "p"; 
            e.sexo = "F"; 
 
            x = (int)(Math.random()*(0 - 19)+ 19);
            y = (int)(Math.random()*(0 - 19)+ 19);
 
            PrThread p = w.getHilo(e, x, y); 
            w.waTor.add(p); 
        } 
        w.execute(); 
    } 
 
    public class Especie { 
 
        String nombre; 
        String sexo; // M = Male / F = Female 
 
    } 
 
    public class PrThread extends Thread { 
 
        Especie esp; 
        int x = 0; 
        int y = 0; 
 
        public PrThread(Especie s, int x, int y) { 
            this.esp = s; 
            this.x = x; 
            this.y = y; 
            mundo[x][y] = this; 
        } 
         
        public void move(){ 
            int move = (int)(Math.random()*(1 - 4)+ 4);
             
            if(move==1){ 
                if(x==0){ 
                    x = MAX_X-1; 
                }else{ 
                    x--; 
                } 
            } 
            if(move==2){ 
                if(x==MAX_X-1){ 
                    x = 0; 
                }else{ 
                    x++; 
                } 
            } 
             
            if(move==3){ 
                if(y==0){ 
                    y = MAX_Y-1; 
                }else{ 
                    y--; 
                } 
            } 
            if(move==4){ 
                if(y==MAX_Y-1){ 
                    y = 0; 
                }else{ 
                    y++; 
                } 
            } 
             
        } 
         
         
 
        @SuppressWarnings("deprecation")
		public final void run() { 
             
             
             
            while(true){ 
                try { 
                    Thread.sleep(200); 
                } catch (InterruptedException e) { 
                    // TODO Auto-generated catch block 
                    e.printStackTrace(); 
                }                 
                JLabel lx = mundo_label[x][y]; 
                lx.setText(""); 
                mundo[x][y] = null; 
                move(); 
                 
                PrThread aux = mundo[x][y]; 
                if(aux!=null){ 
                    if(aux.esp.nombre.equals(esp.nombre)&&aux.esp.sexo.equals(esp.sexo)){ 
                        System.out.println("a Muerto un "+esp.nombre+" "+esp.sexo); 
                        aux.stop(); 
                    } 
                     
                    else if(aux.esp.nombre.equals(esp.nombre)&&(!aux.esp.sexo.equals(esp.sexo))){ 
                        System.out.println("a Muerto un "+esp.nombre+" "+esp.sexo); 
                        Especie esp2 = new Especie(); 
                        int a = (int)(Math.random()*(1 - 2)+ 2);                         
                        if(a==1) esp2.sexo = "F";else esp2.sexo="M"; 
                        esp2.nombre = aux.esp.nombre; 
                        born(esp2, x, y); 
                        System.out.println("Nacio :D "); 
                    } 
                    else if(aux.esp.nombre.equals("t")&&esp.nombre.equals("p")){ 
                        this.stop(); 
                        System.out.println("murio un pez"); 
                    } 
                    else if(aux.esp.nombre.equals("p")&&esp.nombre.equals("t")){ 
                        aux.stop(); 
                        System.out.println("murio un pez"); 
                    } 
                     
                } 
                 
                 
                JLabel l2 = mundo_label[x][y]; 
                l2.setText(esp.nombre+" "+esp.sexo);     
                mundo[x][y] = this; 
                 
            } 
             
        } 
 
    } 
 
} 