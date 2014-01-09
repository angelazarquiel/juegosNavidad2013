package raya;



import java.awt.*;
import java.awt.event.*;
public class Raya //clase priccipal
{//inicia clase calculo
 //declaracion de las variables
 public static Frame ventana;
 public static TextField num1;
 public static TextField num2;
 public static Label gano;
 public static Label gano2;
 public static Label gano3;
 public static Button bot1;
 public static Button bot2;
 public static Button matris[][][];
 public static boolean xocir;
 public static ActionListener acciones;
 public static int cont=2,cont2=0,t=0,u=0,o=0;
 public static int opciones[][][];
 public static String nomb1="",nomb2="";
 
  public static void main (String [] args)
  {//inicia main
  try
  {
   inicio();
  }
  catch(Exception e)
  {
   System.out.println("ds");
  }
  }//fin main
  public static void ventana1()
  {
   matris=new Button[3][3][3];
   opciones=new int[3][3][3];
   xocir=true;
   cont2=0;
   //inicialisacion de las variables
   ventana= new Frame("Tres en raya");
 ventana.setForeground(Color.red);
 ventana.setBackground(Color.black);
 ventana.setFont(new Font("Balloon",Font.ITALIC,14));
 gano = new Label("Ganaste",Label.LEFT);
    gano.setFont(new Font("Dialog",Font.BOLD,12));
 bot1 = new Button("Nuevo");
    bot1.setFont(new Font("Dialog",Font.BOLD,14));
    bot2 = new Button("Salir");
    bot2.setFont(new Font("Dialog",Font.BOLD,14));  
   //ubicacion de las variables
   ventana.setLayout(null);  
   ventana.reshape(100,100,520,225);
   gano.reshape(230,170,120,21);
   bot1.reshape(180,195,60,21);
   bot2.reshape(280,195,60,21);     
   //accion para crrar ventana
   ventana.addWindowListener(new WindowAdapter ()
   {
    public void windowClosing(WindowEvent e)
    {
     System.exit(0);
    }
   });
   int b=0;
   for(int a=0;a<3;a++)
   {
    int y=50;    
     for(int q=0;q<3;q++)
     { 
       int x=50; 
      for(int w=0;w<3;w++)
      {      
       matris[a][q][w] = new Button("");
      matris[a][q][w].setForeground(Color.green);
      matris[a][q][w].setBackground(Color.blue);
      matris[a][q][w].setFont(new Font("Dialog",Font.BOLD,14));
       matris[a][q][w].reshape((b+x),y,40,40);      
       ventana.add(matris[a][q][w]);      
       x=x+40;
      }
    y=y+40;  
  }
  b=b+150;
 } 
   //cuando press boton
   acciones=(new ActionListener()
 {  
  public void actionPerformed(ActionEvent e)
  {
   for(int a=0;a<3;a++)
   {
    for(int j=0;j<3;j++)
       { 
        for(int k=0;k<3;k++)
        {  
      if(e.getSource()==matris[a][j][k])
      {
       t=a;         
       u=j;
       o=k;
       valores();      
       matris[a][j][k].setEnabled(false);
       matris[a][j][k].setBackground(Color.cyan);
       asigna();              
      } 
     }
    }
   }
  }
 });
 for(int a=0;a<3;a++)
 {
  for(int q=0;q<3;q++)
     {  
      for(int w=0;w<3;w++)
      {
       matris[a][q][w].addActionListener(acciones);
      }
  }
 }
 bot2.addActionListener(new ActionListener()
    {
     public void actionPerformed(ActionEvent e)
        {
         System.exit(0);
        }
    });
    bot1.addActionListener(new ActionListener()
    {
     public void actionPerformed(ActionEvent e)
        {
         ventana.setVisible(false);
         ventana1();         
        }
    });
   //agregar a la ventana  
   ventana.add(gano);
   ventana.add(bot1);
   ventana.add(bot2);
   gano.setVisible(false); 
   ventana.setVisible(true);   
  }
  public static void valores()
  {
   if(xocir==true)
   {
    matris[t][u][o].setLabel("O");
    xocir=false;
   }
   else
   {
    matris[t][u][o].setLabel("X");
    xocir=true;
   }
  }
  public static void asigna()
  {
   cont=2;
   for(int a=0;a<3;a++)
 {
  for(int y=0;y<3;y++)
     {  
      for(int x=0;x<3;x++)
      {
       if(matris[a][y][x].getLabel().equals("O"))
       opciones[a][y][x]=0;
       if(matris[a][y][x].getLabel().equals("X"))
       opciones[a][y][x]=1;
       if(matris[a][y][x].getLabel().equals(""))
       {
        opciones[a][y][x]=cont;       
        cont++;
       }
      }
  }
 }
 triunfo();
  }
  public static void triunfo()
  {
   cont2++;
   boolean resp=false;
   for(int a=0;a<3;a++)
 {
  if((opciones[a][0][0]==opciones[a][0][1])&&(opciones[a][0][1]==opciones[a][0][2]))
   resp=true;  
  if((opciones[a][0][0]==opciones[a][1][1])&&(opciones[a][1][1]==opciones[a][2][2]))
   resp=true;
  if((opciones[a][0][0]==opciones[a][1][0])&&(opciones[a][1][0]==opciones[a][2][0]))
   resp=true;
  if((opciones[a][0][1]==opciones[a][1][1])&&(opciones[a][1][1]==opciones[a][2][1]))
   resp=true;
  if((opciones[a][0][2]==opciones[a][1][2])&&(opciones[a][1][2]==opciones[a][2][2]))
   resp=true;
  if((opciones[a][0][2]==opciones[a][1][1])&&(opciones[a][1][1]==opciones[a][2][0]))
   resp=true;
  if((opciones[a][1][0]==opciones[a][1][1])&&(opciones[a][1][1]==opciones[a][1][2]))
   resp=true;
  if((opciones[a][2][0]==opciones[a][2][1])&&(opciones[a][2][1]==opciones[a][2][2]))
   resp=true;       
 }
 if((opciones[0][0][0]==opciones[1][0][0])&&(opciones[1][0][0]==opciones[2][0][0]))
  resp=true;
 if((opciones[0][0][0]==opciones[1][0][1])&&(opciones[1][0][1]==opciones[2][0][2]))
  resp=true;
 if((opciones[0][0][0]==opciones[1][1][1])&&(opciones[1][1][1]==opciones[2][2][2]))
  resp=true;
 if((opciones[0][0][0]==opciones[1][1][0])&&(opciones[1][1][0]==opciones[2][2][0]))
  resp=true;
 if((opciones[0][0][1]==opciones[1][0][1])&&(opciones[1][0][1]==opciones[2][0][1]))
  resp=true;
 if((opciones[0][0][1]==opciones[1][1][1])&&(opciones[1][1][1]==opciones[2][2][1]))
  resp=true;
 if((opciones[0][0][2]==opciones[1][0][1])&&(opciones[1][0][1]==opciones[2][0][0]))
  resp=true; 
 if((opciones[0][0][2]==opciones[1][0][2])&&(opciones[1][0][2]==opciones[2][0][2]))
  resp=true;
 if((opciones[0][0][2]==opciones[1][1][2])&&(opciones[1][1][2]==opciones[2][2][2]))
  resp=true;
 if((opciones[0][0][2]==opciones[1][1][1])&&(opciones[1][1][1]==opciones[2][2][0]))
  resp=true;
 if((opciones[0][1][0]==opciones[1][1][0])&&(opciones[1][1][0]==opciones[2][1][0]))
  resp=true;
 if((opciones[0][1][0]==opciones[1][1][1])&&(opciones[1][1][1]==opciones[2][1][2]))
  resp=true;
 if((opciones[0][1][1]==opciones[1][1][1])&&(opciones[1][1][1]==opciones[2][1][1]))
  resp=true;
 if((opciones[0][1][2]==opciones[1][1][2])&&(opciones[1][1][2]==opciones[2][1][2]))
  resp=true;
 if((opciones[0][1][2]==opciones[1][1][1])&&(opciones[1][1][1]==opciones[2][1][0]))
  resp=true;
 if((opciones[0][2][0]==opciones[1][2][0])&&(opciones[1][2][0]==opciones[2][2][0]))
  resp=true;
 if((opciones[0][2][0]==opciones[1][1][0])&&(opciones[1][1][0]==opciones[2][0][0]))
  resp=true;
 if((opciones[0][2][0]==opciones[1][1][1])&&(opciones[1][1][1]==opciones[2][0][2]))
  resp=true;
 if((opciones[0][2][0]==opciones[1][2][1])&&(opciones[1][2][1]==opciones[2][2][2]))
  resp=true;
 if((opciones[0][2][1]==opciones[1][2][1])&&(opciones[1][2][1]==opciones[2][2][1]))
  resp=true;
 if((opciones[0][2][1]==opciones[1][1][1])&&(opciones[1][1][1]==opciones[2][0][1]))
  resp=true;
 if((opciones[0][2][2]==opciones[1][2][2])&&(opciones[1][2][2]==opciones[2][2][2]))
  resp=true;
 if((opciones[0][2][2]==opciones[1][2][1])&&(opciones[1][2][1]==opciones[2][2][0]))
  resp=true;
 if((opciones[0][2][2]==opciones[1][1][1])&&(opciones[1][1][1]==opciones[2][0][0]))
  resp=true;
 if((opciones[0][2][2]==opciones[1][1][2])&&(opciones[1][1][2]==opciones[2][0][2]))
  resp=true;                
    
 if(resp==true)
 {
  if(cont2%2!=0)
  gano.setText("¡Gano "+nomb1+"!");
  else
  gano.setText("!Gano "+nomb2+"!");
  gano.setVisible(true);
  for(int a=0;a<3;a++)
  {
   for(int y=0;y<3;y++)
      {  
       for(int x=0;x<3;x++)
       {
        matris[a][y][x].setEnabled(false);
       }
   }
  }  
 }
  }
  public static void inicio()
  {
   //inicialisacion de las variables
   ventana= new Frame("Tres en raya");
 ventana.setForeground(Color.green);
 ventana.setBackground(Color.black);
 ventana.setFont(new Font("TimesRoman",Font.ITALIC,14));
 gano = new Label("Jugador 1",Label.LEFT);
    gano.setFont(new Font("Dialog",Font.BOLD,12));
    gano2 = new Label("Jugador 2",Label.LEFT);
    gano2.setFont(new Font("Dialog",Font.BOLD,12));
    gano3 = new Label("Nombre de jugadores",Label.LEFT);
    gano3.setFont(new Font("Dialog",Font.BOLD,12));
 bot1 = new Button("Jugar");
    bot1.setFont(new Font("Dialog",Font.BOLD,14));
    num1 = new TextField("");
   num1.setForeground(Color.green);
   num1.setBackground(Color.blue);
   num1.setFont(new Font("Dialog",Font.BOLD,14));
   num2 = new TextField("");
   num2.setForeground(Color.green);
   num2.setBackground(Color.blue);
   num2.setFont(new Font("Dialog",Font.BOLD,14));
    //ubicacion de las variables
   ventana.setLayout(null);  
   ventana.reshape(200,200,250,150);
   gano.reshape(32,55,60,21);
   gano2.reshape(160,55,60,21);
   gano3.reshape(60,30,125,21);
   num1.reshape(10,80,100,21);
   num2.reshape(140,80,100,21);
   bot1.reshape(95,120,60,21);
   //cerrar ventana
   ventana.addWindowListener(new WindowAdapter ()
   {
    public void windowClosing(WindowEvent e)
    {
     System.exit(0);
    }
   });
   //accion del boton
   bot1.addActionListener(new ActionListener()
    {
     public void actionPerformed(ActionEvent e)
        {
         nomb1=num1.getText();
         nomb2=num2.getText();
         if((nomb1.length()!=0)&&(nomb2.length()!=0))
         {
          ventana.setVisible(false);
          ventana1();
         }
         if((nomb1.length()!=0)&&(nomb2.length()==0))
         {
          nomb2="Jugador2";
          ventana.setVisible(false);
          ventana1();
         }
         if((nomb1.length()==0)&&(nomb2.length()==0))
         {
          nomb1="Jugador1";
          nomb2="Jugador2";
          ventana.setVisible(false);
          ventana1();
         }
         if((nomb1.length()==0)&&(nomb2.length()!=0))
         {
          nomb1="Jugador1";
          ventana.setVisible(false);
          ventana1();
         }         
        }
    });
    ventana.add(gano);
    ventana.add(gano2);
    ventana.add(gano3);
    ventana.add(num1);
    ventana.add(num2);
    ventana.add(bot1);
    ventana.setVisible(true);      
  }
}//fin clase calculo

