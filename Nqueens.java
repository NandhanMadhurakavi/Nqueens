import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;
/*<applet code="Nqueens" align="center" width="605" height="650"></applet>*/
public class Nqueens extends Applet implements ActionListener
{
int dim;
int timedelay=0;
Button b[][]=new Button[30][30];
int a[][]=new int[30][30];
TextField t=new TextField();
TextField tdelay=new TextField();
Button board=new Button("Board");
Button delay=new Button("Delay");
Button s=new Button("Start");
int n=0,n1=0;
public void init()
{
setLayout(null);
if(n==0){
for(int i=0;i<30;i++)
for(int j=0;j<30;j++)
{

b[i][j]=new Button(" ");
add(b[i][j]);


if(i%2==0){
if(j%2==0)
b[i][j].setBackground(Color.green);
else
b[i][j].setBackground(Color.white);
}
if(i%2==1){
if(j%2==1)
b[i][j].setBackground(Color.green);
else
b[i][j].setBackground(Color.white);
}

b[i][j].setVisible(false);
}
}

add(t);
add(board);
add(s);
add(delay);
add(tdelay);
board.addActionListener(this);
delay.addActionListener(this);
s.addActionListener(this);
t.setBounds(140,5,60,30);
tdelay.setBounds(520,5,60,30);
s.setBounds(320,5,80,30);
delay.setBounds(420,5,80,30);
board.setBounds(215,5,80,30);
t.setFont(new Font("Arial",Font.PLAIN,20));
s.setFont(new Font("Arial",Font.PLAIN,20));
board.setFont(new Font("Arial",Font.PLAIN,20));
delay.setFont(new Font("Arial",Font.PLAIN,20));
tdelay.setFont(new Font("Arial",Font.PLAIN,20));
}
public void actionPerformed(ActionEvent ae)
{
String sp=ae.getActionCommand();
if(sp.equals("Delay"))
{
timedelay=Integer.parseInt(tdelay.getText());
}
if(sp.equals("Board"))
{
n1=n;
n=Integer.parseInt(t.getText());
dim=600/n;

//init();
if(n!=0)
{
for(int i=0;i<n;i++)
for(int j=0;j<n;j++)
{
a[i][j]=0;
b[i][j].setLabel(" ");
b[i][j].setBounds(2+(dim*i),41+(dim*j),dim,dim);
b[i][j].setFont(new Font("Arial",Font.BOLD,dim/2));
b[i][j].setVisible(true);
}
if(n1>n)
{
for(int i=n;i<n1;i++)
for(int j=0;j<n1;j++)
{
b[i][j].setVisible(false);
}
for(int i=0;i<n;i++)
for(int j=n;j<n1;j++)
{
b[i][j].setVisible(false);
}
}

}

//init ends
}
if(sp.equals("Start") )
{
showStatus("Problem solving Starts");
for(int i1=0;i1<30;i1++)
for(int j1=0;j1<30;j1++)
a[i1][j1]=0;

if(nqueen(0)==1)
showStatus("Found the Solution for given "+n+"Queens Problem");
else
showStatus("The given "+n+"Queens Problem has no solution");
}

}

int nqueen(int r)
{
	int bb;

	if(r==n)
	{	
	
		return 1;		
	}
	else {

	for(int i=0;i<n;i++)
	{
		if(place(r,i)!=0)
		{
		    
			a[r][i]=r+1;
			bb=nqueen(r+1);
			if(bb==1){
			return 1;
			}
			a[r][i]=0;
		}
	}
	return 0;
	}//else ends
}

int place(int r,int i)
{  

    
	 a[r][i]=r+1;
	for(int i1=0;i1<n;i1++)
		{
			
			for(int j=0;j<n;j++)
			{    
				
				
				if(a[i1][j]!=0){
				b[i1][j].setLabel("q"+a[i1][j]);
				
				}
				else{
				
				b[i1][j].setLabel(" ");
				}
				if(timedelay<=100)
				try{Thread.sleep(timedelay);}catch(InterruptedException e){}
				else
				try{Thread.sleep(80);}catch(InterruptedException e){}
			}
			
		}
		
		a[r][i]=0;
       
	for(int j=r-1;j>=0;j--)
	{
		if(a[j][i]!=0)
		{
			if(timedelay>150){
		 for(int k=j;k<=r;k++)
		   b[k][i].setBackground(Color.red);
     		   try{Thread.sleep(500);}catch(InterruptedException e){}
		  for(int z1=0;z1<n;z1++) {	
	   		
		                   if(z1%2==0 && i%2==0)
			b[z1][i].setBackground(Color.green);
			else if(z1%2==1 && i%2==1)
			b[z1][i].setBackground(Color.green);
			else
			b[z1][i].setBackground(Color.white);
			}
			 
		 	  }
		  
		return 0;
		}
	}
	for(int j=i-1;j>=0;j--)
	{
		if(a[r][j]!=0){
		return 0;
		}
	}
	int k=r-1,m=i-1;
	while(k>=0 && m>=0)
	{  int temp=m;
		if(a[k][m]!=0){
			if(timedelay>150){
		for(int z1=k;z1<=r;z1++)
		b[z1][temp++].setBackground(Color.red);
		try{Thread.sleep(500);}catch(InterruptedException e){}
		temp=m;
		for(int z1=k;z1<=r;z1++)
		if(z1%2==0 && temp%2==0)
		b[z1][temp++].setBackground(Color.green);
		else if(z1%2==1 && temp%2==1)
		b[z1][temp++].setBackground(Color.green);
		else
		b[z1][temp++].setBackground(Color.white);
				}
		return 0;
		}
		k--;
		m--;
	}
	
	k=r-1;
	m=i+1;
	while(k>=0 && m<n)
	{
                   int  temp=m;
		if(a[k][m]!=0){
			if(timedelay>150){
		for(int z1=k;z1<=r;z1++)
		b[z1][temp--].setBackground(Color.red);
		try{Thread.sleep(500);}catch(InterruptedException e){}
		temp=m;
		for(int z1=k;z1<=r;z1++)
		if(z1%2==0 && temp%2==0)
		b[z1][temp--].setBackground(Color.green);
		else if(z1%2==1 && temp%2==1)
		b[z1][temp--].setBackground(Color.green);
		else
		b[z1][temp--].setBackground(Color.white);
		                       }
		return 0;
		}
		k--;
		m++;
	}
	return 1;
}
public void paint(Graphics g)
{
g.setColor(Color.black);
g.fillRect(0,0,getSize().width,40);
g.setColor(Color.white);
g.setFont(new Font("Arial",Font.PLAIN,20));
g.drawString("No of Queens:",5,30);
}
}
