package gato;
import java.util.Scanner;

public class gato
{
   

   public static void menu()
   {
     int opc=0;
		System.out.println("1) JUGAR");
		System.out.println("2) INSTRUCCIONES");
		System.out.println("3) INSTRUCIONES SIMPLES");
		System.out.println("4) SALIR");
		System.out.println("ELIGE UNA OPCION");
		Scanner input=new Scanner(System.in);
		opc=input.nextInt();
		if(opc<=4 && opc!=0){
			

			switch(opc)
				{
					case 1:
						gato();                     
						menu();
					break;

					case 2:
						System.out.println("HOLA BIENVENIDO AL GATOJOR ESTE JUEGO ES MUY SENCILLO YA QUE ES EL TIPICO JEGO DE GATO.");
						System.out.println("LA UNICA DIFERENCIA SON LAS CASILLAS QUE ESTAN REPRESENTADAS DE LA SIGUIENTE FORMA.");
						System.out.println("");
						System.out.println(" 1 - 2 - 3 ");
						System.out.println("----------");
						System.out.println(" 4 - 5- 6 ");
						System.out.println("----------");
						System.out.println(" 7- 8 - 9 ");
						System.out.println("");
						System.out.println("ASI QUE SI QUIERES COLOCAR TU MARCA SOLO TECLEA EL NUMERO DE LA POSICION Y LISTO.");
						System.out.println("ASI QUE VE Y DIVIERTETE!!!!!!!!!!!!!!!!!!!1.");
						menu();
					break;

					case 3:
						System.out.println("Este juego es para dos personas no contra el ordenador asi que al jugar cuidado no equivocarse.");
						menu();

					break;

					case 4:
						System.out.println("adios");
						
						
					break;

              } 
		}
		else{
			
			System.out.println("Estas loco(a) solo hay 4 opciones");
			menu();
			}
	}
   public static void gato()
   {
      char gato[]=new char[10];
      short ganador=0,ocp=0,casilla;
      String nombre1,nombre2;
      Scanner input=new Scanner(System.in);

      System.out.println("Jugador 1 introduce tu nombre...");
      nombre1=input.next();
      System.out.println("Jugador 2 introduce tu nombre...");
      nombre2=input.next();
      System.out.println("");
      while(ganador==0&&(gato[1]==0||gato[2]==0||gato[3]==0||gato[4]==0||gato[5]==0||gato[6]==0||gato[7]==0||gato[8]==0||gato[9]==0))
      {
         System.out.println(" "+gato[1]+" - "+gato[2]+" - "+gato[3]);
         System.out.println("----------");
         System.out.println(" "+gato[4]+" - "+gato[5]+" - "+gato[6]);
         System.out.println("----------");
         System.out.println(" "+gato[7]+" - "+gato[8]+" - "+gato[9]);
         ocp=0;
         while(ocp==0){
            System.out.println(nombre1+" es tu turno (X)");
            casilla=input.nextShort();
            if(casilla>0&&casilla<10)
            {
               if(gato[casilla]==0)
               {
                  gato[casilla]='X';
                  ocp=1;
               }
               else
               {
                  System.out.println("La casilla esta ocupada, vuelve a intentar...");
               }
            }
            else
            {
               System.out.println("La casilla no existe, vuelve a intentar...");
            }
         }
         if((gato[1]=='X'&&gato[2]=='X'&&gato[3]=='X')||(gato[4]=='X'&&gato[5]=='X'&&gato[6]=='X')||(gato[7]=='X'&&gato[8]=='X'&&gato[9]=='X')||(gato[1]=='X'&&gato[4]=='X'&&gato[7]=='X')||(gato[2]=='X'&&gato[5]=='X'&&gato[8]=='X')||(gato[9]=='X'&&gato[3]=='X'&&gato[6]=='X')||(gato[1]=='X'&&gato[5]=='X'&&gato[9]=='X')||(gato[3]=='X'&&gato[5]=='X'&&gato[7]=='X'))
         {
            ganador=1;
         }
         if(ganador==0&&(gato[1]==0||gato[2]==0||gato[3]==0||gato[4]==0||gato[5]==0||gato[6]==0||gato[7]==0||gato[8]==0||gato[9]==0))
         {
            System.out.println(" "+gato[1]+" - "+gato[2]+" - "+gato[3]);
            System.out.println("----------");
            System.out.println(" "+gato[4]+" - "+gato[5]+" - "+gato[6]);
            System.out.println("----------");
            System.out.println(" "+gato[7]+" - "+gato[8]+" - "+gato[9]);
            ocp=0;
            while(ocp==0)
            {
               System.out.println(nombre2+ " es tu turno (O)");
               casilla=input.nextShort();
               if(casilla>0&&casilla<10)
               {
                  if(gato[casilla]==0)
                  {
                     gato[casilla]='O';
                     ocp=1;
                  }
                  else
                  {
                     System.out.println("La casilla esta ocupada, vuelve a intentar...");
                  }
               }
               else
               {
                  System.out.println("La casilla no existe, vuelve a intentar...");
               }
            }
            if((gato[1]=='O'&&gato[2]=='O'&&gato[3]=='O')||(gato[4]=='O'&&gato[5]=='O'&&gato[6]=='O')||(gato[7]=='O'&&gato[8]=='O'&&gato[9]=='O')||(gato[1]=='O'&&gato[4]=='O'&&gato[7]=='O')||(gato[2]=='O'&&gato[5]=='O'&&gato[8]=='O')||(gato[9]=='O'&&gato[3]=='O'&&gato[6]=='O')||(gato[1]=='O'&&gato[5]=='O'&&gato[9]=='O')||(gato[3]=='O'&&gato[5]=='O'&&gato[7]=='O'))
            {
               ganador=2;
            }
         }
      }
      System.out.println(" "+gato[1]+" - "+gato[2]+" - "+gato[3]);
      System.out.println("----------");
      System.out.println(" "+gato[4]+" - "+gato[5]+" - "+gato[6]);
      System.out.println("----------");
      System.out.println(" "+gato[7]+" - "+gato[8]+" - "+gato[9]);
      System.out.println("");
      if(ganador==1)
      {
         System.out.println(nombre1+" es el ganador!!!");
      }
      else
      {
         if(ganador==2)
         {
            System.out.println(nombre2+" es el ganador!!!");
         }
         else
         {
            System.out.println("Empate");
         }
      }
   }

   public static void main(String args[])
   {
      menu();
   }
}

