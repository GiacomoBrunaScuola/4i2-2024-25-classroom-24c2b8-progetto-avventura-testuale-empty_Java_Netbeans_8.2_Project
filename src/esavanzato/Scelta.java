/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esavanzato;

/**
 *
 * @author GIACOMO
 */
public class Scelta extends Scena{
     private String introduzione;
     private String[] opzioni;
     public Scelta(String id, String descrizione,String introduzione,String[]opzioni){
     super(id,descrizione);
     this.introduzione=introduzione;
     this.opzioni=opzioni;
    }
     public String[] getOpzioni(){
         return opzioni;
     }
   
    public String stampaOpzioni(){
        String stringa="";
     for(String s:opzioni){
         stringa=stringa+" "+s; 
     }
     return stringa;
    }
    
    public boolean controlloId (Scena scena){
        boolean b=false;
        //controlla se scena è contenuta in opzioni
        for(String s:opzioni){
            if(s.equals(scena.getId()))
            {b=true; break;}
        }
        return b;
    }
  @Override
    public String getType(){
      return "Scelta";
  }
    @Override
    public String toString(){
        String stringa=" ";
     for(String s:opzioni){
         stringa=stringa+" "+s; 
     }
    
    return super.toString()+stringa;
    }
}
