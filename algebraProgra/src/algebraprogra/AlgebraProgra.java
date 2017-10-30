/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algebraprogra;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

/**
 *
 * @author gerald
 */
public class AlgebraProgra extends JPanel{
    
    public Shape x; // ... ...
    public Shape y; // 600 500 
    public Shape z; // 400 ...
        
    public Shape x1;
    public Shape y1;
    public Shape z1;
        
    public Shape x2;
    public Shape y2;
    public Shape z2;
    
    Ellipse2D.Double circule;
    
    public boolean graficarPlanos;
    
    public AlgebraProgra(double posicionX1, double posicionY1,double posicionX2, double posicionY2,double posicionX3, double posicionY3, boolean graficar){
        setSize(new Dimension(800,800));
        setPreferredSize(new Dimension(800,800));
        //
        x = new Line2D.Double(400,400,posicionX1,posicionY1);
        //System.out.println("X = Valor x: "+posicionX1+" Valor y: "+posicionY1);
        y = new Line2D.Double(400,400,posicionX2,posicionY2);
        //System.out.println("Y = Valor x: "+posicionX2+" Valor y: "+posicionY2);
        z = new Line2D.Double(400,400,posicionX3,posicionY3);
        //System.out.println("Z = Valor x: "+posicionX3+" Valor y: "+posicionY3);
        
        graficarPlanos = graficar;
    }
    
    public AlgebraProgra(double posicionX1, double posicionY1,double posicionX2, double posicionY2,double posicionX3, double posicionY3, boolean graficar,double posicionX4, double posicionY4,double posicionX5, double posicionY5,double posicionX6, double posicionY6,double posicionX7, double posicionY7,double posicionX8, double posicionY8,double posicionX9, double posicionY9,double posicionX10, double posicionY10,double pointX,double pointY){
        setSize(new Dimension(800,800));
        setPreferredSize(new Dimension(800,800));
        //
        x = new Line2D.Double(400,400,posicionX1,posicionY1);
        y = new Line2D.Double(400,400,posicionX2,posicionY2);
        z = new Line2D.Double(400,400,posicionX3,posicionY3);
        
        x1 = new Line2D.Double(400,400,posicionX4,posicionY4);
        y1 = new Line2D.Double(400,400,posicionX5,posicionY5);
        z1 =  new Line2D.Double(400,400,posicionX6,posicionY6);
        
        x2 = new Line2D.Double(posicionX7,posicionY7,posicionX8,posicionY8);
        y2 = new Line2D.Double(posicionX9,posicionY9,posicionX8,posicionY8);
        z2 = new Line2D.Double(posicionX8,posicionY8,posicionX10,posicionY10);
        
        circule = new Ellipse2D.Double(pointX, pointY, 10, 10);
        
        graficarPlanos = graficar;
        
    }


    /**
     *
     * @param g
     * @param f
     */
    public void paint(Graphics g) {
        //Dibuja una línea desde la coordenada (0,70) es decir columna 0 y fila 70 en píxeles, hasta la coordenada (100,70). La línea es de color azul:
        //g.drawLine (0, 70, 100, 70);
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        
        //g2.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL, 10, new float[] {5,5}, 0)); //Sirve para hacer lineas punteadas
        g2.setStroke( new BasicStroke(2));
        
        //Pinta las linea X
        g2.setPaint(Color.GRAY);
        
        g2.draw(x);
        
        
        //Pinta las linea Y
        g2.setPaint(Color.GRAY);
        g2.draw(y);
        
        //Pinta las linea Z
        g2.setPaint(Color.GRAY);
        g2.draw(z);
        
        if(graficarPlanos){
            g2.setPaint(Color.BLUE);
            g2.draw(x1);

            g2.setPaint(Color.BLUE);
            g2.draw(y1);

            g2.setPaint(Color.BLUE);
            g2.draw(z1);

            g2.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL, 10, new float[] {5,5}, 0));
            g2.setPaint(Color.GREEN);
            g2.draw(x2);

            g2.setPaint(Color.GREEN);
            g2.draw(y2);

            g2.setPaint(Color.GREEN);
            g2.draw(z2);

            g2.setStroke( new BasicStroke(2));
            g2.setPaint(Color.RED);
            //g2.fillOval(435.3, 335, 10, 10);
            g2.draw(circule);
        }
        
        this.setBackground(Color.WHITE);
        
        repaint();
  }
   /*@Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g); // first draw a clear/empty panel
    // then draw using your custom logic.
  }*/
   
    
}
