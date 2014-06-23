/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;
import java.util.Scanner;

/**
 *
 * @author Francisco Céspedes
 */
public class JavaApplication1 {

  /**
   * @param args the command line arguments
   */
  private static Scanner scanner = new Scanner( System.in );
  public static void main(String[] args) {
    // TODO code application logic here
    JavaApplication1 app = new JavaApplication1();
    while(true){
    System.out.print("\n Ingrese una opcion del 1 al 7 (7 es para salir): ");
    String input = scanner.nextLine();
     switch (input){
       case "1": 
         app.izquerdaDerecha();
         break;
       case "2":
         app.derechaIzquerda();
         break;
       case "3":
         app.piramideDiagonalDerechaInferior();
         break;
       case "4":
         app.piramideAbajo();
         break;
       case "5":
         app.piramideArriba();
         break;
       case "6":
         app.piramideDiagonalDerechaSuperior();
         break;
       case "7":
         System.out.print("Adios :)");
         System.exit(0);
         break;
       default: System.out.print("Digite entre el 1-7");
                     break;
     }
    }
  }
  public void  izquerdaDerecha(){
    int a,b,c,d;
    c=5;d=5;
    
    for (a=0;a < c;a++){
      System.out.print("\n ");
      for(b=0;b < d; b++){
        if(b==a){
          System.out.print("1 ");
        }else{
          System.out.print("0 ");
        }
        
      }
      
    }
  }
  public void derechaIzquerda(){
    int a,b,c,d;
    c=5;d=5;
    for (a=0;a < c;a++){
      System.out.print("\n ");
      for(b=0;b < d; b++){
        if((b+1) ==(c-a)){
          System.out.print("1 ");
        }else{
          System.out.print("0 ");
        }
        
      }
      
    }
  }
  public void piramideDiagonalDerechaInferior()
  {
    int a,b,c,d;
    c=5;d=5;
    for (a=0;a < c;a++){
      System.out.print("\n ");
      for(b=0;b < d; b++){
        if((b+1)>= (c-a)){
          System.out.print("1 ");
        }else{
          System.out.print("0 ");
        }
        
      }
      
    }
    
  }
  public void piramideAbajo(){
  int a,b,c,d;
    c=5;d=5;
    for (a=0;a < c;a++){
      System.out.print("\n ");
      for(b=0;b < d; b++){
        if((b+1)>= (c-a) && b <=a ){
          System.out.print("1 ");
        }else{
          System.out.print("0 ");
        }
        
      }
      
    }
  }
  
  public void piramideDiagonalDerechaSuperior(){
  int a,b,c,d;
    c=5;d=5;
    for (a=0;a < c;a++){
      System.out.print("\n ");
      for(b=0;b < d; b++){
        if(a == b || a < b ){
          System.out.print("1 ");
        }else{
          System.out.print("0 ");
        }
        
      }
      
    }
  }
  
  public void piramideArriba(){
    int a,b,c,d;
    c=5;d=5;
    for (a=0;a < c;a++){
      System.out.print("\n ");
      for(b=0;b < d; b++){
        if( (b+1) <= (c-a) && b >=a  ){
          System.out.print("1 ");
        }else{
          System.out.print("0 ");
        }
        
      }
      
    }
  }
  
}
