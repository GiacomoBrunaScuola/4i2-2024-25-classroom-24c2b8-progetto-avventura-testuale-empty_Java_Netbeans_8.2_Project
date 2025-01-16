/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esavanzato;

/**
 *
 * @author GIACOMO
 */
public class Descrizione extends Scena{
    public Descrizione(String id, String descrizione){
     super(id,descrizione);
    }
   @Override
    public String getType(){
      return "Descrizione";
  }
}