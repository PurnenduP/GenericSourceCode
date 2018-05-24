package Base;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.*;
import javax.swing.*;
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
public class SampleFrame extends JFrame
implements WindowListener,MouseListener,MouseMotionListener,KeyListener{
	
	String msg = "Start";
	int mouseX=10,mouseY=40;
	int moveX=0,moveY=0;
	Graphics frameGraphics;
	JButton pause;
	boolean pause_action;
	
	ArrayList<BarCoordinates> barArray= new ArrayList<BarCoordinates>();
	
	final int bar_width=40;
	final int bar_height=10;
	final int start_x_pos = 20;
	final int start_y_pos = 60;
	final int speed_factor=5;
	final int x_max = 250;
	final int y_max = 250;
	final int win_x_max = 250;
	final int win_y_max = 250;
	int bar_x_pos,bar_y_pos;
	int arr[] = new int[10];
	
	SampleFrame(String title)
	{
		super(title);
		pause_action = false;
		bar_x_pos=start_x_pos;
		bar_y_pos=start_y_pos;
		
		//MyWindowAdapter ma = new MyWindowAdapter(this);
		addWindowListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
//		pause = new JButton("Pause");
//		pause.setBounds(50,50,10,10); 
//		this.add(pause);
//		//pause.setLocation(30, 40);		
//		pause.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				
//				pause_action = !(pause_action);
//				System.out.println("Button Pressed:"+pause_action);
//			}
//		});
		this.getContentPane().setLayout(null);
		
	}
	
	
	public boolean continueAction()
	{
		int dummy;
		if(bar_x_pos<=x_max-bar_width-speed_factor && bar_y_pos<=y_max-bar_height-speed_factor && anyCollision(bar_x_pos,bar_y_pos) && !pause_action)
		{
			return true;
		}
		else
		{		
			return false;
		}
	}
	
	public void slideBar() 
	{
		
//			x1=x1+3;
			this.bar_y_pos=this.bar_y_pos+speed_factor;
			
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
//			System.out.println(x+","+y+","+bar_width+","+bar_height+","+bar.getX()+","+bar.getY());
			if (((x>= bar.getX() && x <= bar.getX()+bar_width) //Either the front is with in the boundary
					|| (x+bar_width>= bar.getX() && x+bar_width <= bar.getX()+bar_width)) //Or the end is with in the boundary
					&& (y+bar_height>= bar.getY()) // Height is within the boundary
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
		super.paint(g);
		g.drawRect(0, 0, win_x_max, win_y_max);
		g.drawString(msg, mouseX, mouseY);
		Enumeration<BarCoordinates> bars = Collections.enumeration(barArray);
		while(bars.hasMoreElements())
		{
			BarCoordinates bar = (BarCoordinates)bars.nextElement();
			g.fillRect(bar.getX(), bar.getY(),bar_width, bar_height);
		}
		
		g.drawString("Coordinates:"+bar_x_pos+","+bar_y_pos, 10, 40);
		g.drawString("Working", 10, 10);
		g.fillRect(bar_x_pos, bar_y_pos,bar_width, bar_height);
/*		g.drawString(msg, mouseX, mouseY);
		g.drawString("Mouse at " + moveX + ", " + moveY, 10, 40);
		g.drawLine(moveX, moveY,
		
		 mouseX, mouseY);*/
	}
	public static void main(String[] args) throws InterruptedException
	{
		SampleFrame win = new SampleFrame("HelloWindow");
		win.setSize(win.win_x_max+10,win.win_y_max+10);
		win.setVisible(true);
		while(!win.pause_action)
		{
			if(win.continueAction())
			{
				win.slideBar();
				win.repaint();
				Thread.sleep(100);
			}
			else
			{
				win.barArray.add(new BarCoordinates(win.bar_x_pos,win.bar_y_pos));
				win.bar_x_pos=win.start_x_pos;
				win.bar_y_pos=win.start_y_pos;
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
		System.out.println("Key Pressed");
		int keyCode = ke.getKeyCode();
		switch(keyCode)
		{
			case KeyEvent.VK_RIGHT:
				if(continueAction()) {this.bar_x_pos=this.bar_x_pos+speed_factor;}
				break;
			case KeyEvent.VK_LEFT:
				if(continueAction()) {this.bar_x_pos=this.bar_x_pos-speed_factor;}
				break;
			case KeyEvent.VK_DOWN:
				if(continueAction()) {this.bar_y_pos=this.bar_y_pos+speed_factor;}
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
