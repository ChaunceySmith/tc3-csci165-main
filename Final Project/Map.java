//Chauncey Smith

//This is our map class

//I am going to use an Array of Ints that will act as a grid, each creature will have an x,y coordinate in the map

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Map extends JPanel implements ActionListener{

    Timer t = new Timer(1000,this);

    private JFrame window = new JFrame();


    private Hobbit h = new Hobbit(9,9);
    private Hobbit h2 = new Hobbit(0,5);
        //Hobbit h3 = new Hobbit(3,4);
        private Nazgul n = new Nazgul(12,12);
    //GRID.C[0][0] = h;
    
    //GRID.C[0][1] = n; 
  
    

    public Map(){
        t.start();

        //makeMap();
        
        initUI();
    }


    private void initUI() {
        //now we make the window
        window.add(this);
        //title
        window.setTitle("Middle Earth");
        //set the size to the array size
        window.setSize(2000, 1800);
        //dont know what this does
        window.setLocationRelativeTo(null);
        //we are able to close the window and see it
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ev){
        
        for(int i=0; i<GRID.C.length; i++){
            for(int j=0; j<GRID.C.length; j++){
                if(GRID.C[i] != null && GRID.C[i][j] != null){
                    
                    GRID.C[i][j].chooseAction();
                                
                }        
            }
        }
    
    if(ev.getSource()==t){
        repaint();// this will call at every 1 second
      }
        
    
    }
       
   @Override
   public void paintComponent(Graphics g) {
       super.paintComponent(g);
       doDrawing(g);
       
   }
   public void doDrawing(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        for(int i=0;i<GRID.C.length;i++){
            for(int j = 0;j<GRID.C.length;j++){
                if(GRID.C[i] != null && GRID.C[i][j] != null) {
                   
                    g2D.setColor(GRID.C[i][j].color());
                    g2D.fillRect(i*50, j*50,50, 50);
                    
                    
                }
                else{
                    g2D.setColor(Color.BLACK);
                    g2D.drawRect(i*50, j*50, 50, 50);
                }

                
            }
        }
    }
}
