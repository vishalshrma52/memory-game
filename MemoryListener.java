import java.awt.event.*;
import javax.swing.*;
class MemoryListener implements ActionListener
{
    public void actionPerformed(ActionEvent evt)
    {	
      if(!Va.done)
      { 
	MemoryButton clickedbutton=(MemoryButton)evt.getSource();
	if(!clickedbutton.img)
	{
	   Va.imagebutton[++Va.mi]=clickedbutton.imagei;
	   int ci=Va.pos[clickedbutton.imagei];
	   Va.imagefile[Va.mi]=ci;
	   clickedbutton.setIcon(new ImageIcon(getClass().getResource("images/d"+ci+".jpg")));
	   clickedbutton.img=true;
	   Va.clickctr++;
	   if(Va.clickctr==2)
	   {
	     Va.done=true;
	     new MatchThread().start(); 
	   }
	}
      } 
   }
}