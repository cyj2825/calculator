import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;

public class MyCal extends JFrame implements Runnable
{
	JRadioButton takeout, in;
	JLabel la;
	int num = 0;
	public MyCal () {
		la=new JLabel("�ð�ǥ��",JLabel.CENTER);
		new Thread(this).start();
		addWindowListener(new WindowAdapter(){
			 public void windowClosing(WindowEvent w){
				  System.exit(0);
             }
        }); 
		this.setSize(1100, 800);
		this.setLayout(new BorderLayout());
		this.setTitle("ī�� Ű����ũ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p1 = new JPanel();
		p1.setBackground(Color.cyan);
		p1.setLayout(new GridLayout(2, 4, 35, 35));
		Font f = new Font("Serif", Font.BOLD, 21);

		JTextArea a = new JTextArea();
		a.setText("  <�ֹ� ���>\n   ���� ��ȣ    �ܰ�    ����    �� ����\n");
		a.setFont(f);
		a.setEditable(false);

        String m[] = {"����1", "����2", "����3", "����4", "����5", "����6", "����7", "����8"};
		int p[] = {5600, 5800, 5400, 5600, 5200, 4800, 5400, 5200};
		JButton b[] = new JButton[8];
		ImageIcon ic[] = new ImageIcon[8];

		for (int i =0; i<8; i++)
		{
			ic[i] = new ImageIcon(i+1 +".jpg");
			b[i] = new JButton(p[i]+ "��", ic[i]);
			p1.add(b[i]);
		}
		JPanel p2 = new JPanel();
		p2.setBackground(Color.cyan);
		p2.setFont(f);
		JButton b1 = new JButton("�ֹ��ϱ�");
		JButton b2 = new JButton("�ٽ� ���");
		p2.add(la);
		p2.add(b1);
		p2.add(b2);

		takeout = new JRadioButton("����");
		in = new JRadioButton("����");
		ButtonGroup bg = new ButtonGroup();
		bg.add(takeout);
		bg.add(in);

		p2.add(takeout);
		p2.add(in);

		for (int i=0; i<8; i++)
		{
			int j = i;
			b[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					a.append("     " + m[j] + "         " + p[j] + "       1       " + p[j] + "��\n");
					num ++;
				}
			});
		};
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, a.getText() + "�� " + num +"���� ���ᰡ �ֹ� �Ϸ�Ǿ����ϴ�.");
				for (int i=0; i<8; i++)
				{
					a.setText("  <�ֹ� ���>\n  ���� ��ȣ    �ܰ�    ����    �� ����\n");
				}
				num = 0;
			}
		});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				for (int i=0; i<8; i++)
				{
					a.setText("  <�ֹ� ���>\n  ���� ��ȣ    �ܰ�    ����    �� ����\n");
				}
				num=0;
			}
		});
		takeout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "���� ������ �����ϼ̽��ϴ�.");
			}
		});
		in.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "���Ḧ ���忡�� ��ô� ���� �����ϼ̽��ϴ�.");
			}
		});

		this.add(a, BorderLayout.CENTER);
		this.add(p1, BorderLayout.NORTH);
		this.add(p2, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	public void run() {
		while (true)
		{
			showt();
			try
			{
				Thread.sleep(1000);
			}
			catch (Exception e)
			{
			}
		}
	}
	public void showt() {
    	Calendar cal = Calendar.getInstance();
	    int y = cal.get(Calendar.YEAR);
	    int m = cal.get(Calendar.MONTH) + 1;
	    int d = cal.get(Calendar.DATE);
	    int h = cal.get(Calendar.HOUR);
	    int mi = cal.get(Calendar.MINUTE);
	    int s = cal.get(Calendar.SECOND);
	    la.setText(y + "-" + m + "-" + d + " " + h + ":" + mi + ":" + s);
	}	
		
	public static void main(String[] args) {
        new MyCal();
	}
}