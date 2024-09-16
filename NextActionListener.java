import java.awt.event.*;
import javax.swing.*;
class NextActionListener implements ActionListener
{
     public void actionPerformed(ActionEvent evt)
     {	
	String btext=Va.start.getText();
	Va.reset.setEnabled(true);
	if(btext.equals("START"))
	{
	    new TimerThread().start();	  
	    Va.game.enableButtons(true);
	    Va.start.setEnabled(false);
	}
	else if(btext.equals("RESTART"))
	{
	  LoadImages.findPos();
	  Va.game.setTimer();
	  for(int i=0;i<Va.nob;i++)
	  {
		  Va.bt[i].setIcon(Va.game.baseimg);
		  Va.bt[i].img=false;
	  }
	  Va.done=false;
	  Va.clickctr=Va.sc=Va.flag=Va.mc=0;
	  Va.mi=-1;
	  Va.score.setText("SCORE:0");
	  Va.start.setEnabled(false);
	  new TimerThread().start();
	}
	else
	{
	  nextLevel();	
	}
     }
     void nextLevel()
     {
	Va.nextlevel=false;
	Va.game.setSize(Va.ww+=100,Va.wh);
	Va.game.setLocationRelativeTo(null);
	Va.glevel++;
	Va.game.arrangeUI();
	Va.game.addButtons();
	Va.start.setText("START");
     }
}