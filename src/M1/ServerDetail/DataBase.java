package M1.ServerDetail;

import M1.Interface.PortComposantFourni;
import M1.Interface.PortComposantRequis;
import M1.Serveur.ServeurDetail;
import M2.Composant.ComposantConcret;
import M2.Interface.Interface;
import M2.Interface.PortComposant;
import M2.ObjectArchi.ObjetArchitectural;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Abdeldjallil on 11/11/2016.
 */
public class DataBase extends ComposantConcret{

    ServeurDetail sd;
    private HashMap<Integer, String> database; // simple database associating ID to a String
    public DataBase(ServeurDetail sd) {
        super("Data Base");

        this.portsRequis.add(new PortComposantRequis(this, "query_D_Requis"));
        this.portsRequis.add(new PortComposantRequis(this, "check_query_Requis"));

        this.portsFournis.add(new PortComposantFourni(this, "query_D_Fourni"));
        this.portsFournis.add(new PortComposantFourni(this, "check_query_Fourni"));
        this.database = new HashMap<>();
        this.sd = sd;

        initDB();
    }

    private void initDB() {
        database.put(303, "pomme");
        database.put(504, "poire");
        database.put(34, "bannane");
    }

    public PortComposantFourni getFourni(int i) {
        return (PortComposantFourni)portsFournis.get(i); // without cast, function returning M2 PortComposantFourni
    }


    public PortComposantRequis getRequis(int i){
        return (PortComposantRequis)portsRequis.get(i); // without cast, function returning M2 PortComposantRequis
    }

    public void copierMessageEntrePort(PortComposant pc) {
        /*
        avant on doit faire test si utilisateur  n'a pa le droit c pa la peine d'acceder à la bdd
        sinon on accede a la bdd pour verifier par exemple si tous lé champs de la rqt existe
         */
        if (pc.getName() == "check_query_Requis")
            this.portsFournis.get(1).setInformation(pc.getInformation());
        else //query_D_Requis
            this.portsFournis.get(0).setInformation("Voici la reponse du database");
    }

    //TODO corriger les ports en fonction de l'emetteur
    public void traiter(ObjetArchitectural emetteur, String requete){
        String[] parsed = requete.split("|");
        if (emetteur.getClass().equals(SecurityManager.class)){
            if (parsed.length == 2){
                if(parsed[0].equals("GET")){
                    try{
                        Integer.parseInt(parsed[1]);
                        this.getFourni(1).setInformation("valide");
                    } catch (Exception e){
                        this.getFourni(1).setInformation("invalide");
                    }
                }else{
                    this.getFourni(1).setInformation("invalide");
                }
            }else if(parsed.length == 3){
                if(parsed[0].equals("SET")){
                    try{
                        Integer.parseInt(parsed[1]);
                        this.getFourni(1).setInformation("valide");
                    } catch (Exception e){
                        this.getFourni(1).setInformation("invalide");
                    }
                }else{
                    this.getFourni(1).setInformation("invalide");
                }
            }else{
                this.getFourni(1).setInformation("invalide");
            }
        }else if(emetteur.getClass().equals(ConnectionManager.class)){
            if (parsed.length == 2){
                this.getFourni(0).setInformation((database.get(Integer.parseInt(parsed[1]))).toString());//id de clé Integer.parseInt(parsed[1]
            }else {
                database.put(Integer.parseInt(parsed[1]), parsed[2]);
                this.getFourni(0).setInformation("Database mise a jour");
            }
        }
    }

    public void notifierSystem(Interface notifieur){
        sd.notification(notifieur, this);
    }

}
