package M1.Serveur;

import M1.Interface.ReceiveRequest;
import M1.Interface.ReceiveResponse;
import M1.Interface.SendRequest;
import M1.Interface.SendResponse;
import M1.Systeme.SystemeCS;
import M2.Composant.ComposantConcret;

/**
 * Created by Abdeldjallil on 23/10/2016.
 */
public class Serveur extends ComposantConcret{
    SystemeCS cs;
    public Serveur(SystemeCS cs) {
        super("Server");
        this.portsRequis.add(new ReceiveRequest(this));
        this.portsFournis.add(new SendResponse(this));
        this.cs = cs;
    }

    public void recever() {
        cs.notification(this, "MoiServer");
    }
}
