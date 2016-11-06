package M1.Client;

import M1.Interface.ReceiveResponse;
import M1.Interface.SendRequest;
import M1.Systeme.SystemeCS;
import M2.Composant.ComposantConcret;


/**
 * Created by Abdeldjallil on 23/10/2016.
 */
public class Client extends ComposantConcret {

    SystemeCS cs;
    public Client(SystemeCS cs) {
        super("Client");
        this.portsRequis.add(new ReceiveResponse(this));
        this.portsFournis.add(new SendRequest(this));
        this.cs = cs;
    }

    public void EnvoyerRequete() {
        ((SendRequest)portsFournis.getFirst()).setMessage("Envoie Requete");
    }

    @Override public void notifierSystem(){
        System.out.println("Notification du system par le client");
        cs.notification(portsFournis.getFirst(), this);
    }
}
