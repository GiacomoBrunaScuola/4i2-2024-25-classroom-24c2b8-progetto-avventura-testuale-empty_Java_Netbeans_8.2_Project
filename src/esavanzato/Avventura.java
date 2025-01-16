/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esavanzato;

/**
 *
 * @author GIACOMO
 */public class Avventura {
    private   Scena[] avventura;
    private int i=0;
    public Avventura(int nScene){
        avventura=new Scena [nScene];
    }
    public Scena[] getAvventura(){
        return avventura;
    }
    public int getAvventuraCapacity(){
        return avventura.length;
    }
    public void addScena(Scena scena){
        if(i<=avventura.length)
        {   avventura[i]=scena;
        i++;
                }
        else
            System.out.println("errore limite sforato");
    }
    public Scena getScena(int n){
        return avventura[n];
    }
    public Scelta getScelta(int n){
        if(avventura[n] instanceof Scelta)
        { Scelta s= (Scelta) avventura[n] ;
        return s;
        }
        else
            return null;
    }
    public int getIndice(String id){
        int indice=0;
    for(Scena s:avventura){
        if(id.equals(s.getId()))
        { return indice;
        }
        
    indice++;
    }
    return -1;
    }
    public void modificaScena(int indice,Scena s){
        avventura[indice]=s;
    }
}

