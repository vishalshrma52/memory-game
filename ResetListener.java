import java.awt.event.*;
import javax.swing.*;
class ResetListener implements ActionListener
{
    public void actionPerformed(ActionEvent evt)
    {	
	  Va.timerst=false;
	  Va.exp(1100);
	  LoadImages.findPos();
	  Va.game.setTimer();
	  for(int i=0;i<Va.nob;i++)
	  {
		  Va.bt[i].setIcon(Va.game.baseimg);
		  Va.bt[i].img=false;
	  }
	  Va.game.enableButtons(false);
	  Va.done=false;
	  Va.total=Va.total-Va.sc;
	  Va.clickctr=Va.sc=Va.flag=Va.mc=0;
	  Va.mi=-1;
	  Va.score.setText("SCORE:0");
	  if(Va.glevel==1)
	    Va.total=0;
	  Va.totalscore.setText("TOTAL SCORE:"+Va.total);
	  Va.start.setEnabled(true);
	  Va.start.setText("START");
	  Va.reset.setEnabled(false);
    } 
}