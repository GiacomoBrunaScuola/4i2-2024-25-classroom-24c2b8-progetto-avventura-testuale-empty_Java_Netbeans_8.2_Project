/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esavanzato;

/**
 *
 * @author GIACOMO
 */
public class Scena {
      
    protected String id;
    protected String descrizione;

    public Scena(String id, String descrizione){
        this.id=id;
        this.descrizione=descrizione;
    
    }
  
    public String getId(){
        return id;
    }
    public String getDescrizione(){
        return descrizione;
    }
       public void StampaDescrizione(){
       System.out.println("descrizione: "+descrizione);
      
   }
       @Override
   public String toString(){
       return  id + " "+ descrizione ;
   }
  public String getType(){
      return "Scena";
  }
}

