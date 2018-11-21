import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Image;
import java.lang.Math;
import java.util.Arrays;

public class supply_and_demand extends JFrame
{
	public supply_and_demand()
	{
		setSize(500, 500);
		setTitle("Java Example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		MyJPanel myJPanel = new MyJPanel();
		Container c = getContentPane();
		c.add(myJPanel);
		setVisible(true);
		setResizable(false);
	}

	public static void main(String[] args)
	{
		new supply_and_demand();
	}

	public class MyJPanel extends JPanel implements MouseListener, MouseMotionListener, ActionListener
	{

        Timer timer;
		int t = 0;
		int n = 20;
		int[] line = new int[n];
		int head = 0, tail=0;
		public MyJPanel()
		{
			getContentPane().addMouseListener(this);
            getContentPane().addMouseMotionListener(this);
            timer = new Timer(100,this);
			timer.start();
			Arrays.fill(line,0);
		}

		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.fillRect(100, 100, 160, 100);
			double r = Math.random();
			if(r<0.5){
				tail += 1;
				line[tail%n] = t;
			}
			if(head < tail && line[head%n] <= t-5)head += 1;
			for(int i=0;i<tail-head;i++){
				System.out.println(tail-head);
				g.fillOval(180, 200 + 10 * i,10,10);
			}
		}

		public void mouseClicked(MouseEvent me)
		{

		}

		public void mousePressed(MouseEvent me)
		{
		}

		public void mouseReleased(MouseEvent me)
		{
		}

		public void mouseExited(MouseEvent me)
		{
		}

		public void mouseEntered(MouseEvent me)
		{
		}

		public void mouseMoved(MouseEvent me)
		{

		}

		public void mouseDragged(MouseEvent me)
		{
		}

		public void actionPerformed(ActionEvent e)
		{
            if(e.getSource()==timer){
				t += 1;
            }
            repaint();
		}

     }
}