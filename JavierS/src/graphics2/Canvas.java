package graphics2;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.MainView;

public class Canvas
{
    private static Canvas canvas = new Canvas();

    private ArrayList<Shape> shapes = new ArrayList<Shape>();
    private BufferedImage background;
    private static JFrame frame;
    private CanvasComponent component;
    private MyMouseListener mouseListener;

    

    private static final int MIN_SIZE = 900;
    private static final int MARGIN = 0;
    private static final int LOCATION_OFFSET = 200;
    public static int width = 800;
    public static int height = 600;


    class CanvasComponent extends JComponent
    {
        
        public void paintComponent(Graphics g)
        {
           // g.setColor(java.awt.Color.BLACK);
        	g.setColor(java.awt.Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(java.awt.Color.GRAY);
            
            if (background != null)
            {
                g.drawImage(background, 0, 0, null);
            }               
            for (Shape s : new ArrayList<Shape>(shapes))
            {
                Graphics2D g2 = (Graphics2D) g.create();
                s.paintShape(g2);
                g2.dispose();
            }
        }

        public Dimension getPreferredSize()
        {
            int maxx = width;
            int maxy = height;
            return new Dimension(maxx + MARGIN, maxy + MARGIN);
        }
        
    }
    
    
    class MyMouseListener implements MouseListener,MouseMotionListener{
    	
    	private Point mouseLocation = new java.awt.Point();
    	private Object mouseState = new Object();;

    	
    	// MouseListener

    	  private void getMouseLocation(MouseEvent e) {
    	    mouseLocation.x = e.getX();
    	    mouseLocation.y = e.getY();
    	  }
    	  
    	  public void mouseClicked(MouseEvent e) {
    		 //System.out.println("Click");
    		
    	  }

    	  public void mousePressed(MouseEvent e) {
    		  MainView.nuevoMisil = true;
    		    synchronized(mouseLocation) {
    		      getMouseLocation(e);
    		    }
    		  }

    		  public void mouseReleased(MouseEvent e) {
    		    synchronized(mouseLocation) {
    		      getMouseLocation(e);
    		      mouseLocation.notify();
    		    }
    		    synchronized(mouseState) {
    		      mouseState.notify();
    		    }
    		  }

    		  public void mouseEntered(MouseEvent e) {
    		    synchronized(mouseLocation) {
    		      getMouseLocation(e);
    		    }
    		  }

    		  public void mouseExited(MouseEvent e) {
    		  }
    		  
    		  /**
    		   * Returns the current mouse location (relative to the corresponding 
    		   * drawing panel) as a <code>java.awt.Point</code>.
    		   *
    		   * @return      the <code>java.awt.Point</code> object
    		   */
    		  public java.awt.Point getMouse() {
    			    synchronized(mouseLocation) {
    			      return mouseLocation;
    			    }
    			  }
    		 
    		  /**
    		   * Waits until the mouse button is pressed or released, then returns the 
    		   * location of the mouse.
    		   * 
    		   * @return      <code>java.awt.Point</code> object;
    		   */
    		  /*public java.awt.Point waitClick() {
    		    synchronized(mouseState) {
    		      try {
    		        mouseState.wait();
    		      }
    		      catch( InterruptedException it ) {}
    		    }
    		    return mouseLocation;
    		  }*/

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				synchronized (mouseLocation) {
					 MainView.nuevoMisil = true;
					 getMouseLocation(e);
				}
			
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				synchronized(mouseLocation) {
					getMouseLocation(e);
	    		    }
			}

	
    		  
    }
   
    
    private Canvas()
    {
        component = new CanvasComponent();
        mouseListener = new MyMouseListener();

        if (System.getProperty("com.horstmann.codecheck") == null)
        {
            frame = new JFrame("Invasores de Toledo v1.0");
            if (!System.getProperty("java.class.path").contains("bluej"))
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(component);
            frame.pack();
            //frame.setBounds(0,0 , width, height);
            
            frame.setLocation(LOCATION_OFFSET, LOCATION_OFFSET);
            //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
           
            frame.setVisible(true);
            
            component.addMouseListener(mouseListener);
            component.addMouseMotionListener(mouseListener);
            frame.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					MainView.CONTINUAR = true;
				
				}
			});
            
            /*
            this.width = frame.getWidth();
            this.height = frame.getHeight();
            System.out.println("[FRAME] width:" + width + "  height:" + height);
            */
            
            
        }
        else
        {
        	System.out.println("HOLAAAAAAAAAAAAAAAAA");
        	
            final String SAVEFILE ="canvas.png";
            final Thread currentThread = Thread.currentThread();
            Thread watcherThread = new Thread() 
                {
                    public void run()
                    {
                      	long startTime;
                    	long sleepTime;
                    	long FPS = 10;
                    	long ticksPS = 1000 / FPS;
                    	long DELAY;
                    	startTime = System.currentTimeMillis();
                        try
                        {
                        	
                        	while(true)
                        	{
                        		sleepTime = ticksPS-(System.currentTimeMillis() - startTime);
                        		try{
                        			if (sleepTime > 0){
                        				System.out.println("sleep:" + sleepTime);
                        				sleep(sleepTime);
                        				startTime = System.currentTimeMillis();
                        			}
                        			else
                        			Thread.sleep(sleepTime);
                        		}
                        		catch ( InterruptedException exception )
                        		{
                        			System.out.printf( "%s \n","terminated prematurely due to interruption" );
                        		} // end catch
                        	}
                        	
                        	/*int dl = 100000;
                        	while (currentThread.getState() != Thread.State.TERMINATED)
                            {
                        		Thread.sleep(dl);
                                
                            }*/
                        	
                        	
                        }
                        catch (Exception ex)
                        {
                            ex.printStackTrace();
                        }
                    }
                };
            watcherThread.start();
            
            
        }
        
    
        
    }

    public static Canvas getInstance()
    {
        return canvas;
    }
    
    public static void updateWidthHeight(){
    	width = frame.getWidth();
    	height = frame.getHeight();
    }
    
   

    public void show(Shape s)
    {
        if (!shapes.contains(s))
        {
            shapes.add(s);
        }
        //repaint();
    }
    
    public void hide(Shape s)
    {
        shapes.remove(s);
        //repaint();
    }

    public void repaint()
    {    	
    	frame.repaint();
    }
    public void pack(){
    	   if (frame == null) return;
           Dimension dim = component.getPreferredSize();
           if (dim.getWidth() > component.getWidth()
                   || dim.getHeight() > component.getHeight())
           {
               frame.pack();
           }
    }
    
    public void setMaximizado(){
    	frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * Pauses so that the user can see the picture before it is transformed.
     */
    public static void pause()
    {
        JFrame frame = getInstance().frame;
        if (frame == null) return;
        JOptionPane.showMessageDialog(frame, "Click Ok to continue");
    }

    /**
     * Takes a snapshot of the screen, fades it, and sets it as the background.
     *//*
    public static void snapshot()
    {
        Dimension dim = getInstance().component.getPreferredSize();
        java.awt.Rectangle rect = new java.awt.Rectangle(0, 0, dim.width, dim.height);
        BufferedImage image = new BufferedImage(rect.width, rect.height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(java.awt.Color.WHITE);
        g.fillRect(0, 0, rect.width, rect.height);
        g.setColor(java.awt.Color.BLACK);
        getInstance().component.paintComponent(g);
        float factor = 0.8f;
        float base = 255f * (1f - factor);
        RescaleOp op = new RescaleOp(factor, base, null);
        BufferedImage filteredImage
           = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        op.filter(image, filteredImage);
        getInstance().background = filteredImage;
        getInstance().component.repaint();
    }*/
    /*
    public void saveToDisk(String fileName)
    {
        Dimension dim = component.getPreferredSize();
    	java.awt.Rectangle rect = new java.awt.Rectangle(0, 0, dim.width, dim.height);
    	BufferedImage image = new BufferedImage(rect.width, rect.height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(java.awt.Color.WHITE);
        g.fill(rect);
        g.setColor(java.awt.Color.BLACK);
        component.paintComponent(g);
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1);
        try
        {
            ImageIO.write(image, extension, new File(fileName));
        } 
        catch(IOException e)
        {
            System.err.println("Was unable to save the image to " + fileName);
        }
    	g.dispose();    	
    }*/
    
    public Point getMousePosition() {
    	
    	return this.mouseListener.getMouse();
    }
    /*
    public Point waitMouseClick() {
    	//return this.mouseListener.waitClick();
    }*/
    
    
    
    

}
