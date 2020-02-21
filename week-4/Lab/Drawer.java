//Chauncey Smith
//Lab 3

//import statements
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.Random;

class Drawer extends JPanel {
  //now we set our rows and columns to nothing, same
  //with the colorado data and min/max
    public static int ROWS;
    public static int COLUMNS;

    //we set elev_total to a high number so it cant be exceeded
    public static int elev_total = 100000;
   
    //now we make a 2D array and set max and min as global variables
    int[][] colorado_data;
    int max;
    int min;

    private static final long serialVersionUID = 1L;
    private JFrame window = new JFrame();

    public Drawer(String fileName) {
      //now we string slice the file name to find the 
      //rows and columns using indexOf/substring
      int underscore_pos = fileName.indexOf("_");
      int x = fileName.indexOf("x");
      int dot = fileName.indexOf(".");

      //now we parse the substring
      COLUMNS = Integer.parseInt(fileName.substring(underscore_pos+1,x));
      ROWS = Integer.parseInt(fileName.substring(x+1,dot));

      //now we set our main array
      colorado_data = new int[ROWS][COLUMNS];

      //lets call our methods from "Drawing"
      Drawing.fillArray(colorado_data, fileName, ROWS, COLUMNS);
       max = Drawing.findMax(colorado_data);
       min = Drawing.findMin(colorado_data);
      //also we are in constructor
        initUI();
    }

    private void initUI() {
        //now we make the window
        window.add(this);
        //title
        window.setTitle("Topographic Land Elevation");
        //set the size to the array size
        window.setSize(COLUMNS, ROWS+38);
        //dont know what this does
        window.setLocationRelativeTo(null);
        //we are able to close the window and see it
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    //this stuff is fishy and i dont know what it does
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //call drawing so we can see paint the window
        doDrawing(g);
        //now i make an array to put all the elevation changes in them
        int[] elevation = new int[ROWS];
        for(int i = 0; i<ROWS; i++){
          elevation[i] = drawLowestElevPath(g, colorado_data, i, Color.RED);
          g.setColor(Color.RED);
        }
        //now we are going to find the index of the minimum value
        //set min to first value
        int min_one = elevation[0];
        //iterate through finding min
        for(int i = 0; i < elevation.length; i++){
          //if min is found then set min to index
          if(min_one > elevation[i]){
            min_one = i;         
          }         
        }
        //set the color to green now that we have found the lowest value
        {g.setColor(Color.GREEN);
        //call the method one more time to draw the green line 
      elevation[min_one] = drawLowestElevPath(g, colorado_data, min_one, Color.GREEN);
      //g.setColor(Color.GREEN);
        }
      }
      //YOUR CODE
    private void doDrawing(Graphics g) {
        /*
            RGB Colors:
            ================================================
            Black       => (0, 0, 0)        => low elevation
            Mid Grey    => (128, 128, 128)  => mid elevation
            White       => (255, 255, 255)  => high elevation

            Grey Scale colors are scaled in matching set of 3 numeric values
        */
        Graphics2D g2d = (Graphics2D) g;
        //MY CODE GOES HERE
        //ok heres when things get complicated
        //first we find the range
        int range = max - min;
        //now we set a basic nested loop
        for(int i = 0; i < ROWS; i++){
          for (int j = 0; j < COLUMNS; j++){
            //here is my math to calaculate the elevation into the 
            //correct color 
            double ratio = (double) (colorado_data[i][j] - min) / range;

            //ok I know this is unreadable but I Just wanted to make the colors interesting
            int red = Math.max(Math.min(Math.abs((int) (50 * ratio) - 200), 100), 0);
            int green = Math.min(Math.abs((int) (200 * ratio) + 50), 255);
            int blue = (int) (255 * ratio);
            //set the color and create a new color
            g2d.setColor(new Color(red, green, blue));
            //now we fill rect column major order to fill it 
            g2d.fillRect(j, i, 1, 1);
          }
        }     
      }
      //now we open our main method
    public static void main(String[] args) {
      //user must enter a filename for program to run
      //and draw
      if(args.length > 0){
          String fileName = args[0];

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Drawer ex = new Drawer(fileName);
                ex.setVisible(true);
            }
        });
      } else {
        System.out.println("Please enter file name");
      }
    } // end main

    //OK STAY WITH ME, this code is not that well written
    //but it works, so just please be patient
    public static int drawLowestElevPath(Graphics g, int[][] matrix, int s,Color color){
      //total is our total elevation
      int total = 0;
      for(int i = 0; i < COLUMNS-1; i++){
        int top;    //x
        int bottom;  //z
        int middle = matrix[s][i+1];   //middle  //y
        
        //set s to something big so the loop wont go out of bounds
        if(s == 0){
          top = 1000000;
        }
        else{
          top = matrix[s-1][i+1];  //top
        }
       //same thing with rows
        if(s == ROWS -1){
          bottom = 1000000;
        }
        else{
        bottom = matrix[s+1][i+1];   //bottom
        }
        int start = matrix[s][i];   //starting

        //now we must find the elevation change
        int top_change = Math.abs(top - start);
        int middle_change = Math.abs(middle - start);
        int bottom_change = Math.abs(bottom - start);

        //if top is smaller than middle and bottom move to top and record elevation change
        if(top_change < middle_change && top_change < bottom_change){
          g.fillRect(i+1, s-1, 1, 1);
          total = top_change + total;
          s = s - 1;
        }
        //if middle is smaller than top or bot, or it is == to top or bot, go foward, record elevation change
        if((middle_change < top_change && middle_change < bottom_change) || middle_change == top_change || middle_change == bottom_change){
          g.fillRect(i+1,s,1,1);
          total = middle_change + total;
        }
        //if bot is smaller than top or mid, go bot and record elevation change
        if(bottom_change < top_change && bottom_change < middle_change){
          g.fillRect(i+1,s+1,1,1);
          total = bottom_change + total;
          s = s + 1;
        }
        //if top == bot then coin toss
        if(top_change == bottom_change){
          if (Math.random() < 0.5){
            g.fillRect(i+1, s-1,1,1);
            total = top_change + total;
            s = s - 1;
          }
          else{
            g.fillRect(i+1, s+1,1,1);
            total = bottom_change + total;
            s = s + 1;
          }
        }
      }
      //return total elevation change
      return total;
    }
}
 // end class
