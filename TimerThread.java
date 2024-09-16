import javax.swing.*;
import java.awt.*;
class TimerThread extends Thread
{
  public void run()
  {
     Va.timerst=true;	
     while(Va.timerst)
     {
	if(Va.nextlevel)
	{
	     Va.timerst=false; 	
	     break;
	}
	if(Va.ts==0)
        {
   	   if(Va.tm==0)
	   {
		  Va.reset.setEnabled(false);
		  Va.done=true;	
		  JOptionPane.showMessageDialog(Va.game,"Time is over...try again");
		  Va.start.setEnabled(true);
		  Va.total-=Va.sc;
		  Va.totalscore.setText("TOTAL SCORE:"+Va.total);
		  Va.start.setText("RESTART");
		  break;
	   }
	   Va.tm--;
	   Va.ts=60;
         } 	
	 Va.ts--;
	 Va.exp(1000);
	 Va.timer.setText((Va.tm<10?"0"+Va.tm:Va.tm)+":"+(Va.ts<10?"0"+Va.ts:Va.ts));		     
     }
   }
}