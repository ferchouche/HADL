package M1.ServerDetail;

import M1.Interface.PortComposantFourni;
import M1.Interface.PortComposantRequis;
import M1.Serveur.ServeurDetail;
import M2.Composant.ComposantConcret;
import M2.Interface.Interface;
import M2.Interface.PortComposant;

/**
 * Created by Abdeldjallil on 11/11/2016.
 */
public class SecurityManager extends ComposantConcret{

    ServeurDetail sd;
    public SecurityManager(ServeurDetail sd) {
        super("Security Manager");

        this.portsRequis.add(new PortComposantRequis(this, "security_auth_Requis"));
        this.portsRequis.add(new PortComposantRequis(this, "check_query_Requis"));

        this.portsFournis.add(new PortComposantFourni(this, "security_auth_Fourni"));
        this.portsFournis.add(new PortComposantFourni(this, "check_query_Fourni"));

        this.sd = sd;
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
}
