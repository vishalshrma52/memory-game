import java.awt.*;
import javax.swing.*;
class Va
{
   static int []pos;
   static boolean done=false,timerst=true,nextlevel=false; 
   static JLabel score=new JLabel("SCORE:0");
   static JLabel level=new JLabel("LEVEL:1");
   static JLabel match=new JLabel("<html><h2 style='color:white;background-color:green'>+20</h2></html>");
   static JLabel mismatch=new JLabel();
   static JLabel totalscore=new JLabel("TOTAL SCORE:0");
   static JLabel nlscore=new JLabel();
   static JLabel timer=new JLabel();
   static Font fo=new Font("elephant",1,16); 
   static Font fo1=new Font("terminal",1,18); 
   static JButton start=new JButton("START"); 
   static JButton reset=new JButton("RESET");
   static int clickctr=0,mi=-1,sc=0,flag=0,mc=0,nob=4,noc=2,pw=100,px=100,glevel=1,tm,ts,nobh;
   static int total=0,ww=400,wh=700,ttx=70,nlx=10,totalimg=30;
   static int []imagebutton={-1,-1};
   static int []imagefile={-1,-1};
   static MemoryButton [] bt;
   static MemoryButton buttonclicked;
   static MainClass game;
   static int[] timerv={0,15,35,50,70,100,140,190,250}; 	
   static int[] tscore={0,60,90,120,150,180,210,240,270}; 	
   static int[] dc={0,6,5,5,4,3,3,3,2};
   static void exp(int t)
   {
	try{
	  Thread.sleep(t);
	}catch(Exception ex){}
   }
}