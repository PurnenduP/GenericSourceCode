package Base;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.*;

class BarCoordinates 
{
	private int x,y;
	
	BarCoordinates(int x,int y)
	{
		this.x=x;this.y=y;
	}
	
	public void setXY(int x,int y)
	{
		this.x =x;
		this.y =y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}	
	
}

@SuppressWarnings("serial")
public class SampleFrame extends Frame
implements WindowListener,MouseListener,MouseMotionListener,KeyListener{
	
	String msg = "Start";
	int mouseX=10,mouseY=40;
	int moveX=0,moveY=0;
	Graphics frameGraphics;
	
	ArrayList<BarCoordinates> barArray= new ArrayList<BarCoordinates>();
	
	int x1=20,y1=60,w=40,h=10;
	
	int arr[] = new int[10];
	
	SampleFrame(String title)
	{
		super(title);
		//MyWindowAdapter ma = new MyWindowAdapter(this);
		addWindowListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
	}
	
	
	public void slideBar() 
	{
		
//			x1=x1+3;
			y1=y1+3;
			//Thread.sleep(10);
			//repaint();
		
		
	}
	
	public boolean anyCollision(int x,int y)
	{
		Enumeration<BarCoordinates> bars = Collections.enumeration(barArray);
		while(bars.hasMoreElements())
		{
//			System.out.println(x+","+y);
			BarCoordinates bar = (BarCoordinates)bars.nextElement();
			System.out.println(x+","+y+","+w+","+h+","+bar.getX()+","+bar.getY());
			if (((x>= bar.getX() && x <= bar.getX()+w) //Either the front is with in the boundary
					|| (x+w>= bar.getX() && x+w <= bar.getX()+w)) //Or the end is with in the boundary
					&& (y+h>= bar.getY()) // Height is within the boundary
					) 
				{
					System.out.println("Collision");
					return false;
				}			
		}
		return true;
	}
	public void paint(Graphics g)
	{
//		super.paint(g);
		g.drawString(msg, mouseX, mouseY);
		Enumeration<BarCoordinates> bars = Collections.enumeration(barArray);
		while(bars.hasMoreElements())
		{
			BarCoordinates bar = (BarCoordinates)bars.nextElement();
			g.fillRect(bar.getX(), bar.getY(),w, h);
		}
		
		g.drawString("Coordinates:"+x1+","+y1, 10, 40);
		g.drawString("Working", 10, 10);
		g.fillRect(x1, y1,w, h);
/*		g.drawString(msg, mouseX, mouseY);
		g.drawString("Mouse at " + moveX + ", " + moveY, 10, 40);
		g.drawLine(moveX, moveY,
		
		 mouseX, mouseY);*/
	}
	public static void main(String[] args) throws InterruptedException
	{
		SampleFrame win = new SampleFrame("HelloWindow");
		win.setSize(260,260);
		win.setVisible(true);
		int loop = 0;
		while(true)
		{
			if(win.x1<250-win.w && win.y1<250-win.h && win.anyCollision(win.x1,win.y1))
			{
				win.slideBar();
				win.repaint();
				Thread.sleep(100);
			}
			else
			{
				win.barArray.add(new BarCoordinates(win.x1,win.y1));
				win.y1=60;
				//break;
			}
			//loop++;
			
		}
//		Thread.sleep(100);
//		win.paint();
				

	}



	@Override
	public void mouseDragged(MouseEvent me) {
		// TODO Auto-generated method stub
		moveX=me.getX();
		moveY=me.getY();

	msg="Mouse is getting Dragged";
	////repaint();
		
	}



	@Override
	public void mouseMoved(MouseEvent me) {
		// TODO Auto-generated method stub
		moveX=me.getX();
		moveY=me.getY();
		mouseX=me.getX();
		mouseY=me.getY();
		msg="MouseAt("+me.getX()+","+me.getY()+")";
		repaint();
	
	}



	@Override
	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
		moveX=me.getX();
		moveY=me.getY();
		msg="MouseGotClicked";
		//repaint();
	}



	@Override
	public void mouseEntered(MouseEvent me) {
		// TODO Auto-generated method stub
		mouseX=10;
		mouseY=54;
		msg="Mouse Just entered window";
		//repaint();
	}



	@Override
	public void mouseExited(MouseEvent me) {
		// TODO Auto-generated method stub
		
		moveX=me.getX();
		moveY=me.getY();
		msg="MouseExited";
		//repaint();
	}



	@Override
	public void mousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		moveX=me.getX();
		moveY=me.getY();
		msg="Mouse Pressed";
		//repaint();
	}



	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub
		moveX=me.getX();
		moveY=me.getY();
		//mouseY=me.getY()+10;
		msg="Mouse Released";
		//repaint();
		
	}



	@Override
	public void windowActivated(WindowEvent ke) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowClosed(WindowEvent ke) {
		// TODO Auto-generated method stub
		//this.setVisible(false);
	}



	@Override
	public void windowClosing(WindowEvent ke) {
		// TODO Auto-generated method stub
		System.exit(0);
	}



	@Override
	public void windowDeactivated(WindowEvent ke) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowDeiconified(WindowEvent ke) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowIconified(WindowEvent ke) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowOpened(WindowEvent ke) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent ke) {
		// TODO Auto-generated method stub
		int keyCode = ke.getKeyCode();
		switch(keyCode)
		{
		case KeyEvent.VK_RIGHT:
			if(x1<=250-w-2) {this.x1=this.x1+2;}
			break;
		case KeyEvent.VK_LEFT:
			if(x1>=2) {this.x1=this.x1-2;}
			break;
		case KeyEvent.VK_DOWN:
			if(y1<=250-h-2) {this.y1=this.y1+2;}
			break;

		}
	}


	@Override
	public void keyTyped(KeyEvent ke) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

class MyWindowAdapter extends WindowAdapter
{
	SampleFrame sf;
	
	MyWindowAdapter(SampleFrame sf1)
	{
		this.sf = sf1;
	}
	
	public void windowClosing(WindowEvent we)
	{
		sf.setVisible(false);
	}
	
}
