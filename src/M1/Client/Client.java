package M1.Client;

import M2.Composant.ComposantConcret;
import M2.Composant.Contrainte;
import M2.Composant.Propriete;
import M2.Interface.PortComposantFourni;
import M2.Interface.PortComposantRequis;

import java.util.LinkedList;

/**
 * Created by Abdeldjallil on 23/10/2016.
 */
public class Client extends ComposantConcret {

    public Client() {
        super("Client");
        this.portsrequis.add(new PortComposantRequis("ReceiveResponse"));
        this.portsfourni.add(new PortComposantFourni("SendRequest"));
    }
}