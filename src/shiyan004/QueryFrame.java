package shiyan004;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class QueryFrame extends Frame //��ܴ�����Ӧ�����¼�
{
    private TextField text_char, text_uni;                 //�����ı���
    private Button button_char, button_uni;                //������ť

    public QueryFrame()
    {
        super("Unicode�ַ���ѯ��");                      //���ڱ���
        this.setBounds(300,240,300,100);        //���ÿ�ܵ�λ�úͳߴ�
        this.setBackground(Color.lightGray);        //���ÿ�ܵı�����ɫ
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));   //����������������
        QueryHandler q= new QueryHandler();   //���ɼ���������
        this.add(new Label("�ַ�"));
        text_char = new TextField("����",10);
        this.add(text_char);
        button_char = new Button("��ѯUnicode��");
        this.add(button_char);
        button_char.addActionListener(q);  //Ϊ��ťע�ᵥ���¼�������
        this.add(new Label("Unicode��"));
        text_uni = new TextField(10);
        this.add(text_uni);        
        button_uni = new Button("     ��ѯ�ַ�      ");
        this.add(button_uni);
        button_uni.addActionListener(q);   //Ϊ��ťע�ᵥ���¼�������
        this.setVisible(true);                             //��ʾ���
        this.addWindowListener(new WinClose());            //Ϊ���ע�ᴰ���¼���������ί��WinClose��Ķ������¼�
    }
	class QueryHandler implements ActionListener
	{
    public void actionPerformed(ActionEvent e)             //�����¼���������ʵ��ActionListener�ӿ�
    {
        if (e.getSource()==button_char)         //e.getSource()��õ�ǰ�¼�Դ������Ƚ�����
        {
            String str = text_char.getText();        //����ı��е��ַ���
            char ch=str.charAt(0);                  //������ַ�
            text_char.setText(""+ch);           //���������ı�����ʾ�ַ�
            text_uni.setText(""+(int)ch);          //��ʾch��Unicode��
        }
        if (e.getSource()==button_uni)
        {
            int uni=Integer.parseInt(text_uni.getText());  //���ı����ַ���ת����������δ����NumberFormatException�쳣
            text_char.setText(""+(char)uni);  //��ʾuni��Unicode���Ӧ���ַ�
        }
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
        new QueryFrame();
    }
}

