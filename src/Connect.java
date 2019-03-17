import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Connect {
	
	private static ServerSocket ss;
	private static Socket s;
	private static BufferedReader br;
	private static InputStreamReader isr;	
	private static String messageX;
	private static String messageY;
	private static String numberofString2;
	private static String msg_recieved;
	
	
	private static ServerSocket ss1;
	private static Socket s1;
	private static BufferedReader br1;
	private static InputStreamReader isr1;
	
	
	private static float Yco;
	private static float Xco;
	private static float Click;
	private static float Right;
	
	static Dimension screenS = Toolkit.getDefaultToolkit().getScreenSize();
	private static int ScreenW = (int) screenS.getWidth();
	private static int ScreenH = (int) screenS.getHeight();
	
	private static int screenW = 1000;//less number foes to the left
	private static int screenH = 500;//the lower the number the higher 
	
	
	
	
	
	
	
	
	public static void main (String [] args) throws IOException {
		
		
		
		
//		try {
//			Robot robot = new Robot();
//			robot.mouseMove(screenW, screenH);
//		} catch (AWTException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		
//		ServerSocket socket = new ServerSocket(4000);
//		Socket clientSocket = socket.accept();
//		DataInputStream DIS = new DataInputStream(clientSocket.getInputStream());
//		msg_recieved = DIS.readUTF();
//		clientSocket.close();
//		socket.close();
		
		
		
	
		try {
			
				
				
			ss = new ServerSocket(4006);
			int count = 0;
			while(true) {
			
			
			s = ss.accept();
			
			isr = new InputStreamReader(s.getInputStream());
			br = new BufferedReader(isr);
			messageX = br.readLine();
			
			
			


			count++;
//			System.out.println(count);
			
			 if (count % 4 == 3) {
				Click = new Float(messageX);

				System.out.println("Click: " + Click);
				if(Click > 0 ) {
					LeftC();
				}
				
			}else if ( count % 4 == 1) {
				Xco = new Float(messageX);
				System.out.println("X: " + Xco);
				if(Xco >= 1) {
					screenW = (int) (screenW - Xco); 
					Move(screenW,screenH);
//					System.out.println(screenW);
				}else if ( Xco <= -1) {
					screenW = (int) (screenW - Xco); 
					Move(screenW,screenH);
//					System.out.println(screenW);
				}
			}else if (count % 4 == 2) {
				Yco = new Float(messageX);
				System.out.println("Y: " + Yco);
				if(Yco >= 1) {
					screenH = (int) (screenH - Yco); //moves mouse up by 2 pixels
					Move(screenW,screenH);
//					System.out.println(screenH);
				}else if(Yco <= -1){
					screenH = (int) (screenH - Yco); //moves down by 2 pixels
					Move(screenW,screenH);
//					System.out.println(screenH);
				}
				
			}else if (count % 4 == 0 ) {
				Right = new Float(messageX);
				if(Right > 0) {
				System.out.println("Right: !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + Right);
				RightC();
				}
			}
			
			
			

			
			}
		 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void  Move(int s, int s1) {
		
		try {
			Robot robot = new Robot();
			robot.mouseMove(s, s1);
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void LeftC() {
		try {
			Robot robot = new Robot();
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void RightC() {
		try {
			Robot robot = new Robot();
			robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public static void send() {
		
		try {
			while(true) {
				
				
			ss = new ServerSocket(5015);
			
			System.out.println("Please Work!");
			s = ss.accept();
			
			isr = new InputStreamReader(s.getInputStream());
			br = new BufferedReader(isr);
			messageX = br.readLine();
//			numberofString2 = br.readLine();
			System.out.println("Please Work!");
			System.out.println(messageX);
//			System.out.println(numberofString2);
			
			isr.close();
			br.close();
			ss.close();
			s.close();
			
			}
		 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 
	
	

}
