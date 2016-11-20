package M1.ServerDetail;

import M1.Interface.PortComposantFourni;
import M1.Interface.PortComposantRequis;
import M1.Serveur.ServeurDetail;
import M2.Composant.ComposantConcret;
import M2.Interface.Interface;
import M2.Interface.PortComposant;
import M2.ObjectArchi.ObjetArchitectural;

import java.util.HashMap;

/**
 * Created by Abdeldjallil on 11/11/2016.
 */
public class SecurityManager extends ComposantConcret{

    ServeurDetail sd;
    HashMap<Integer, Integer> permissions;
    private String tempRequete;

    public SecurityManager(ServeurDetail sd) {
        super("Security Manager");

        this.portsRequis.add(new PortComposantRequis(this, "security_auth_Requis"));
        this.portsRequis.add(new PortComposantRequis(this, "check_query_Requis"));

        this.portsFournis.add(new PortComposantFourni(this, "security_auth_Fourni"));
        this.portsFournis.add(new PortComposantFourni(this, "check_query_Fourni"));
        this.permissions = new HashMap<>();
        this.sd = sd;

        initPermission();
    }

    private void initPermission() {
        permissions.put(1967, 1);
        permissions.put(987, 0);
        permissions.put(3987, 2);
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
        if (pc.getName() == "security_auth_Requis")
            this.portsFournis.get(1).setInformation(pc.getInformation());
        else //check_query_Requis
            this.portsFournis.get(0).setInformation(pc.getInformation());
    }

    public void notifierSystem(Interface notifieur){
        sd.notification(notifieur, this);
       // System.out.printf(notifieur.getName().toString());
    }

    public void traiter(ObjetArchitectural emetteur, String requete){
        String[] parsed = requete.split("|");
        if (parsed.length == 3 || parsed.length == 4) {
            if (emetteur.getClass().equals(ConnectionManager.class)) {
                // port de la DataBase
                try{
                    if(permissions.get(Integer.parseInt(parsed[0])) != null){
                        StringBuilder requeteOnly = new StringBuilder();
                        for (Integer i = 1; i < parsed.length; i++){
                            requeteOnly.append(parsed[i]);
                            if (i < parsed.length + 1)
                                requeteOnly.append("|");
                        }
                        this.tempRequete = requeteOnly.toString();
                        portsFournis.get(0).setInformation(tempRequete); // prot de la db
                    }
                }catch (Exception e){
                    portsFournis.get(0).setInformation("requete invalide"); // port la db
                }
                this.portsFournis.get(0).setInformation(requete);
            } else if (emetteur.getClass().equals(DataBase.class)) {
                if (requete.equals("valide")) {
                    // port du connection mannager
                    this.portsFournis.get(0).setInformation(tempRequete); // port
                }else{
                    this.portsFournis.get(0).setInformation("Requete mal formee");
                }
            }
        }
    }
}
