package M1.Systeme;

import M1.Client.Client;
import M1.Connecteur.RPC;
import M1.Interface.ReceiveInformation;
import M1.Interface.SendInformation;
import M1.Serveur.Serveur;
import M2.Configuration.Configuration;

/**
 * Created by Abdeldjallil on 23/10/2016.
 */
public class Systeme extends Configuration{

    public Systeme() {
        super("System C/S");
        this.portsFournis.add(new SendInformation(this));
        this.portsRequis.add(new ReceiveInformation(this));
        this.composants.add(new Client());
        this.composants.add(new Serveur());
        this.connecteurs.add(new RPC());
    }
}
