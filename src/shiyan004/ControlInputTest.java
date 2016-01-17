package shiyan004;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import shiyan004.QueryFrame.WinClose;

public class ControlInputTest extends JFrame{
	  private TextField text1;                //�ı���
	  private Button button1;                //��ť
	  private TextField tf=new TextField();
	  final Frame f= new Frame("��֤���ݺϷ���");
	ControlInputTest(){
		f.setLayout(new FlowLayout());
		f.setSize(350, 100);
		f.setLocation(350, 100);
		f.setVisible(true);
		f.add(new Label("���֤�ţ�"));
		text1 = new TextField("���������֤�ţ�",15);
		f.add(text1);
		button1 = new Button("ȷ��");
		f.add(button1);
		new MyFocus();
		new MyKey();
		f.addWindowListener(new WinClose());
	}
	class MyFocus{
		MyFocus(){
			text1.addMouseListener(new MouseListener() {
	
				public void mouseReleased(MouseEvent arg0) {}	
				public void mousePressed(MouseEvent arg0) {}
				public void mouseExited(MouseEvent e) {
						  f.remove(tf);
						  if(text1.getText().equals("")){
						  text1.setText("���������֤�ţ�");
						  }
						 
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
					System.out.println("77777777777777779");
					if (text1.getText().equals("���������֤�ţ�")) {
						text1.setText(null);
					}
						
				}
				@Override
				public void mouseClicked(MouseEvent arg0) {}
			});
			button1.addMouseListener(new MouseListener(){
				public void mouseReleased(MouseEvent e) {}
				public void mousePressed(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseClicked(MouseEvent e) {
					 int e1 = text1.getText().length();
					
					  if (e1<=15||e1>=18||e1==0) {
						  tf.setBounds(150, 70, 190, 20);
			              tf.setText("���֤��ֻ����15λ��18λ�����֣�");
			              f.add(tf);
					  }	
				}
			});
		}
	}
		class MyKey {
			MyKey(){
				text1.addKeyListener(new KeyListener(){
					public void keyPressed(KeyEvent e) {}
					public void keyReleased(KeyEvent arg0) {}
					public void keyTyped(KeyEvent e) {
						char c=e.getKeyChar();
						if(!Character.isDigit(c)){
							tf.setBounds(150, 70, 190, 20);
				              tf.setText("���֤��ֻ����15λ��18λ�����֣�");
				              f.add(tf);
				              System.out.println("77777777777777779000");
						}
					}
					});
			}
		}
		class WinClose implements WindowListener   //ʵ�ִ����¼��������ӿ�
		{
    	public void windowClosing(WindowEvent e) //���ڹر��¼�������
    	{
        System.exit(0);                          //������������
   		 }

    	public void windowOpened(WindowEvent e)         {  }
    	public void windowActivated(WindowEvent e)      {  }
   	 	public void windowDeactivated(WindowEvent e)    {  }
    	public void windowClosed(WindowEvent e)         {  }
    	public void windowIconified(WindowEvent e)      {  }
    	public void windowDeiconified(WindowEvent e)    {  }
		}
	public static void main(String arg[])
    {
		System.out.println("77777777777777778");
       new ControlInputTest();
    }
}
