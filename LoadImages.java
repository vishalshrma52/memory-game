import javax.swing.*;
import java.util.Random;
class LoadImages
{
 static void findPos()
 {
   Random ra=new Random();
   Va.pos=new int[Va.nob];
   for(int i=0;i<Va.nob;i++)
      Va.pos[i]=-1;
   boolean []exist=new boolean[Va.totalimg];
   int ctr=0;		
   while(true)
   {
        int x=ra.nextInt(Va.totalimg);
	if(!exist[x])
	{
	  int c=0;
	  while(true)
	  {
	    int n=ra.nextInt(Va.nob);
	    if(Va.pos[n]==-1)
	    {
	      Va.pos[n]=x;
	      if(++c==2)
		break;
	    }
	  }
	  exist[x]=true;	
	  if(++ctr==Va.nobh)
	   break;
	}
   } 
 } 
}