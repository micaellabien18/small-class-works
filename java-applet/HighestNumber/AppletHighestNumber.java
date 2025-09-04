import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class AppletHighestNumber extends Applet implements ActionListener
{
	public void paint (Graphics g){
		g.drawString("FIND THE HIGHEST NUMBER",98,13);
	}
	
	TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    Button b1;
	
	public void init()
	{
		setLayout(null);
			t1 = new TextField(15);
		t1.setBounds(100,25,50,20);
			t2 = new TextField(15);
		t2.setBounds(100,50,50,20);
			t3 = new TextField(15);
		t3.setBounds(100,75,50,20);
			t4 = new TextField(15);
		t4.setBounds(100,100,50,20);
			t5 = new TextField(15);
		t5.setBounds(100,125,50,20);
			t6 = new TextField(15);
		t6.setBounds(100,150,50,20);
			t7 = new TextField(15);
		t7.setBounds(100,175,50,20);
			t8 = new TextField(15);
		t8.setBounds(100,200,50,20);
			t9 = new TextField(15);
		t9.setBounds(100,225,50,20);
			t10 = new TextField(15);
		t10.setBounds(100,250,50,20);
			t11 = new TextField(15);
		t11.setBounds(215,125,50,20);
			b1 = new Button("Find");
		b1.setBounds(215,150,50,30);
	add(t1);
	add(t2);
	add(t3);
	add(t4);
	add(t5);
	add(t6);
	add(t7);
	add(t8);
	add(t9);
	add(t10);
	add(t11);
	add(b1);
	b1.addActionListener(this);
    }
	
	public void actionPerformed(ActionEvent e)
	{
	int i,j,k,l,m,n,o,p,q,r,high;
		i=Integer.parseInt(t1.getText());
		j=Integer.parseInt(t2.getText());
		k=Integer.parseInt(t3.getText());
		l=Integer.parseInt(t4.getText());
		m=Integer.parseInt(t5.getText());
		n=Integer.parseInt(t6.getText());
		o=Integer.parseInt(t7.getText());
		p=Integer.parseInt(t8.getText());
		q=Integer.parseInt(t9.getText());
		r=Integer.parseInt(t10.getText());
	high = i;
	if (j > high){
		high = j;
	}if (k > high){
		high = k;
	}if (l > high){
		high = l;
	}if (m > high){
		high = m;
	}if (n > high){
		high = n;
	}if (o > high){
		high = o;
	}if (p > high){
		high = p;
	}if (q > high){
		high = q;
	}if (r > high){
		high = r;
	}
	t11.setText(""+high);
	}
}