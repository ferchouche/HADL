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
        String marequte = "Est-ce que j'existe";

        SendRequest monportfourni = (SendRequest)this.portsFournis.getFirst();
        System.out.printf("J'ai envoyer ma requete à mon port send request\n");
        monportfourni.Transfer(marequte, cs.portsFournis.getFirst(), this);
    }
}
