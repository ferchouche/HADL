package M1.Serveur;

import M1.Interface.PortComposantFourni;
import M1.Interface.PortComposantRequis;
import M1.Systeme.SystemeCS;
import M2.Composant.ComposantConcret;
import M2.Interface.Interface;

/**
 * Created by Abdeldjallil on 23/10/2016.
 */
public class Serveur extends ComposantConcret{
    SystemeCS cs;
    public Serveur(SystemeCS cs) {
        super("Server");
        this.portsRequis.add(new PortComposantRequis(this, "PortServeurRequis"));
        this.portsFournis.add(new PortComposantFourni(this, "PortServeurFourni"));
        this.cs = cs;
    }

    public PortComposantFourni getPremierFourni(){
        return (PortComposantFourni)portsFournis.getFirst(); // without cast, function returning M2 PortComposantFourni
    }

    public PortComposantRequis getPremierRequis(){
        return (PortComposantRequis)portsRequis.getFirst(); // without cast, function returning M2 PortComposantRequis
    }

    public void notifierSystem(Interface notifieur){
        cs.notification(notifieur);
    }

    public void traiterInformation(Object information){

    }
}
