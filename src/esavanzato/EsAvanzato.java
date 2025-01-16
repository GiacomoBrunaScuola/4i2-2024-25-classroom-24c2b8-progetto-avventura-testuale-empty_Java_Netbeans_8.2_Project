/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package esavanzato;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;

/**
 *
 * @author GIACOMO
 */
public class EsAvanzato {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        //variabili per salvataggio       

        //avventura(array di scelte e descrizioni) a
        //scena corrente e indice i
        Avventura a = null;
        int i = 0;
        System.out.println("Cosa vuoi fare? 1)inizia da file  2)inizia da salvataggio");
        int azione = Integer.parseInt(input.nextLine());
        switch (azione) {
            case 1:// lettura da xml

                int n = 0;
                String[] s = new String[5];
                String id = "";
                String descrizione = "";
                ArrayList<String> ids = new ArrayList<String>();
                ArrayList<String> descrizioni = new ArrayList<String>();

                try {
                    File myObj = new File("myfile.xml");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        System.out.println(data);
                        if (data.contains("<scena")) {
                            n++;//incremento n scene
                        }
                        if (data.contains("<id>")) {
                            s = data.split("<id>");
                            s = s[1].split("</id>");
                            id = s[0];
                            ids.add(id);
                        }
                        if (data.contains("<descrizione>")) {
                            s = data.split("<descrizione>");
                            s = s[1].split("</descrizione>");
                            descrizione = s[0];
                            descrizioni.add(descrizione);
                        }

                    }
                } catch (FileNotFoundException e) {
                    System.out.println("errore");
                    e.printStackTrace();
                }

                a = new Avventura(n);
                Scena scena;
                for (int index = 0; index < n; index++) {
                    scena = new Scena(ids.get(index), descrizioni.get(index));
                    a.addScena(scena);
                }
                //aggiunta scelte e descrizioni
                int indice = 0;
                String introduzione;
                String opzione;
                File myObj = new File("myfile.xml");
                Scanner myReader = new Scanner(myObj);
                for (int index = 0; myReader.hasNextLine(); index++) {
                    ArrayList<String> opzioni = new ArrayList<String>();
                    String data = myReader.nextLine();
                    System.out.println(data);
                    if (data.contains("scelta")) {
                        data = myReader.nextLine();
                        s = data.split("<id>");
                        s = s[1].split("</id>");
                        id = s[0];

                        data = myReader.nextLine();
                        s = data.split("<descrizione>");
                        s = s[1].split("</descrizione>");
                        descrizione = s[0];

                        data = myReader.nextLine();
                        s = data.split("<introduzione>");
                        s = s[1].split("</introduzione>");
                        introduzione = s[0];
                        data = myReader.nextLine();
                        while (!data.contains("</scena>")) {

                            s = data.split("<opzione>");
                            s = s[1].split("</opzione>");
                            opzione = s[0];
                            opzioni.add(opzione);
                            data = myReader.nextLine();
                        }
                        String[] options = opzioni.toArray(new String[0]);
                        Scelta scelta = new Scelta(id, descrizione, introduzione, options);
                        a.modificaScena(indice, scelta);
                        indice++;
                    }
                    if (data.contains("descrizione")) {
                        data = myReader.nextLine();
                        s = data.split("<id>");
                        s = s[1].split("</id>");
                        id = s[0];

                        data = myReader.nextLine();
                        s = data.split("<descrizione>");
                        s = s[1].split("</descrizione>");
                        descrizione = s[0];
                        Descrizione desc = new Descrizione(id, descrizione);
                        a.modificaScena(indice, desc);
                        indice++;
                    }

                }
                break;
            case 2:
                try 
                {File myObj2 = new File("saveFile");
                    Scanner myReader2 = new Scanner(myObj2);
                }catch (FileNotFoundException e) {
                    System.out.println("errore");
                    e.printStackTrace();
                }
                break;
        }

        //ciclo
        int continuo;
        String idSelezionato, avanti;
        for (; i <= a.getAvventuraCapacity();) {
            System.out.println("1)continua avventura  2)fermati e salva tutto su file");
            continuo = Integer.parseInt(input.nextLine());
            if (continuo == 2) {
                //salvataggio su file
                try {

                    FileWriter myWriter = new FileWriter("saveFile");
                    myWriter.write(+'\n');
                    for (int riga = 0; riga < a.getAvventuraCapacity(); riga++) {
                        myWriter.write(a.getScena(riga).getType() + " " + a.getScena(riga) + '\n');

                    }
                    myWriter.write(a.getScena(i).getId());
                    myWriter.close();

                } catch (IOException e) {
                    System.out.println("errore");
                    e.printStackTrace();
                }
                break;
            } else {
                System.out.println(a.getScena(i));
                if (i == a.getAvventuraCapacity() - 1) {
                    System.out.println("avventura finita");
                    break;
                }
                if (a.getScena(i) instanceof Scelta) {
                    System.out.println("opzioni: " + a.getScelta(i).stampaOpzioni());
                    System.out.println("scrivi id della scena che vuoi vedere");
                    idSelezionato = input.nextLine();
                    //controllo id
                    for (Scena scene : a.getAvventura()) {
                        if (scene.getId().equals(idSelezionato) && a.getScelta(i).controlloId(scene)) {
                            {
                                i = a.getIndice(idSelezionato);
                                break;
                            }
                        }
                    }
                } else {
                    System.out.println("premi un tasto per continuare");
                    avanti = input.nextLine();
                    i++;
                }
            }

        }
    }
//fine ciclo
}
