import java.awt.*;
import javax.swing.*;
class MatchThread extends Thread
{
      public void run()
      {
	   Va.exp(500);
	   if(Va.imagefile[0]==Va.imagefile[1])
	   {
		Va.bt[Va.imagebutton[0]].setIcon(Va.game.doneimg);
		Va.bt[Va.imagebutton[1]].setIcon(Va.game.doneimg);
		Va.sc+=20;
		Va.total+=20;
		Va.score.setText("SCORE:"+Va.sc);
		Va.totalscore.setText("TOTAL SCORE:"+Va.total);
		Va.mc++;
		if(Va.mc==Va.nobh)
		{
		  Va.timerst=false;
		  if(Va.sc>=Va.tscore[Va.glevel])
		  {
		    Va.nextlevel=true;
		    Va.start.setText("NEXT");
		    JOptionPane.showMessageDialog(Va.game,"Congrtulations!!!!");
	  	  }
		  else
		  {
		    Va.start.setText("RESTART");
		    JOptionPane.showMessageDialog(Va.game,"Try again...");
		    Va.total-=Va.sc;
		    Va.totalscore.setText("TOTAL SCORE:"+Va.total);
	 	  }
		  Va.sc=Va.mc=0;
		  Va.start.setEnabled(true);
		  Va.reset.setEnabled(false);
		}
	   }	
	   else
	   {
		Va.bt[Va.imagebutton[0]].setIcon(Va.game.baseimg);
		Va.bt[Va.imagebutton[1]].setIcon(Va.game.baseimg);
		Va.bt[Va.imagebutton[0]].img=false;
		Va.bt[Va.imagebutton[1]].img=false;
		Va.sc-=Va.dc[Va.glevel];
		Va.total-=Va.dc[Va.glevel];
		Va.score.setText("SCORE:"+Va.sc);
		Va.totalscore.setText("TOTAL SCORE:"+Va.total);
	   }
	   Va.imagefile[0]=Va.imagefile[1]=-1;
	   Va.clickctr=0;
	   Va.mi=-1;
	   Va.done=false;
      }
}