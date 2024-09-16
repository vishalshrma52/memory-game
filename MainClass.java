import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class MainClass extends JFrame
{
 JPanel pa=new JPanel();
 JLabel ins1=new JLabel("<html><h1><u>Memory Game</u></h1></html>");	
 JLabel ins2=new JLabel("<html><h3>Train your brain! Keep your brain in shape!</h3></html>");
 JLabel ins3=new JLabel("<html><h3>Find pairs of images under the above tiles:</h3></html>");	
 int ins1x=60,ins2x=0,ins3x=0;
 ImageIcon baseimg=new ImageIcon(getClass().getResource("images/base.png"));
 ImageIcon doneimg=new ImageIcon(getClass().getResource("images/done.png"));
 public MainClass()
 {
	super("Memory Game");
	Va.game=this;
	setSize(Va.ww,Va.wh);
	setLocationRelativeTo(null);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(null);
	add(pa);
	addUI();
	arrangeUI();
	addButtons();
	Va.start.addActionListener(new NextActionListener());
	setVisible(true); 
 }
 private void addUI()
 {
	Va.timer.setFont(Va.fo);
        Va.timer.setForeground(Color.blue);
	add(Va.timer);
	Va.score.setFont(Va.fo);
	add(Va.score);
        Va.level.setForeground(Color.blue);
	Va.level.setFont(Va.fo);
	add(Va.level);
	add(Va.start);
	add(Va.totalscore);
	Va.totalscore.setFont(Va.fo1);
	Va.totalscore.setForeground(Color.red);
	add(Va.nlscore);
	Va.nlscore.setForeground(Color.red);
	add(ins1);add(ins2);add(ins3);
	add(Va.reset);add(Va.match);add(Va.mismatch);
	Va.reset.addActionListener(new ResetListener());
	Va.reset.setEnabled(false);
 } 
 void arrangeUI()
 {
	Va.nob=Va.nob+4;
	Va.nobh=Va.nob/2;
	Va.pw=Va.pw+100;
	Va.score.setBounds(90,520,200,30);
	Va.level.setBounds(Va.pw+5,520,200,30);
	Va.start.setBounds(90,70,100,30);
	Va.timer.setBounds(Va.pw+35,70,100,30);   	
	Va.totalscore.setBounds(Va.ttx+=50,545,200,30);   	
	Va.nlscore.setBounds(Va.nlx+=50,30,400,30);   	
        Va.level.setText("LEVEL:"+Va.glevel);
        Va.score.setText("SCORE:"+Va.sc);
        Va.nlscore.setText("<html><h2>Minimum score for next level:"+Va.tscore[Va.glevel]+"</h2></html>");
	ins1.setBounds(ins1x+=50,0,250,30);
	ins2.setBounds(ins2x+=50,610,500,30);
	ins3.setBounds(ins3x+=50,630,500,30);
	Va.reset.setBounds(ins1x+45,580,80,30);
	Va.match.setBounds(90,580,40,30);
	Va.mismatch.setBounds(Va.pw+65,580,40,30);
	Va.mismatch.setText("<html><h2 style='color:white;background-color:red'>&nbsp;-"+Va.dc[Va.glevel]+"&nbsp;&nbsp;</h2></html>");
	setTimer();
 } 
 void setTimer()
 {
	Va.tm=0;
	Va.ts=Va.timerv[Va.glevel];
	if(Va.ts>=60)
	{
	  Va.tm=Va.ts/60;
	  Va.ts=Va.ts%60;
	}
	Va.timer.setText("0"+Va.tm+":"+(Va.ts<10?"0"+Va.ts:Va.ts));
 }
 void addPanel()
 {
	pa.removeAll();
	pa.updateUI();
	Va.bt=new MemoryButton[Va.nob];
	pa.setBounds(90,115,Va.pw,400);
	pa.setLayout(new GridLayout(4,Va.noc));
 }     
 void addButtons()
 {
	addPanel();
	Insets margin=new Insets(0,0,0,0);
        MemoryListener listener=new MemoryListener();
	javax.swing.border.Border bb=BorderFactory.createLineBorder(Color.yellow,3);
	for(int i=0;i<Va.nob;i++)
	{
	  Va.bt[i]=new MemoryButton(i);
	  Va.bt[i].setMargin(margin);
	  Va.bt[i].setBorder(bb);
	  Va.bt[i].setIcon(baseimg);
	  Va.bt[i].addActionListener(listener);
	  pa.add(Va.bt[i]);
	}
	enableButtons(false);
	LoadImages.findPos();
 }
 void enableButtons(boolean st)
 {
   for(MemoryButton bc:Va.bt)
   {
	bc.setEnabled(st);
   }
 }   
 public static void main(String args[])
 { 
	JFrame.setDefaultLookAndFeelDecorated(true);
	new MainClass();
 }
}