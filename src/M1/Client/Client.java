package M1.Client;

import M1.Interface.PortComposantFourni;
import M1.Interface.PortComposantRequis;
import M1.Systeme.SystemeCS;
import M2.Composant.ComposantConcret;
import M2.Interface.Interface;


/**
 * Created by Abdeldjallil on 23/10/2016.
 */
public class Client extends ComposantConcret {

    SystemeCS cs;
    public Client(SystemeCS cs) {
        super("Client");
        this.portsRequis.add(new PortComposantRequis(this, "PortClientRequis"));
        this.portsFournis.add(new PortComposantFourni(this, "PortClientFourni"));
        this.cs = cs;
    }

    public void EnvoyerRequete() {

        System.out.printf("Le client envoie une requete\n");
        (portsFournis.getFirst()).setInformation("la Requete du Client");
        cs.notification(portsFournis.getFirst(), this);
        System.out.printf("\n\n\n"+this.portsFournis.getFirst().getInformation().toString()+"\n");
        System.out.printf(this.portsRequis.getFirst().getInformation().toString()+"\n");
    }

    public void notifierSystem(Interface notifieur){
        cs.notification(notifieur);
    }

    public PortComposantFourni getPremierFourni(){
        return (PortComposantFourni)portsFournis.getFirst(); // without cast, function returning M2 PortComposantFourni
    }

    public PortComposantRequis getPremierRequis(){
        return (PortComposantRequis)portsRequis.getFirst(); // without cast, function returning M2 PortComposantRequis
    }
}
