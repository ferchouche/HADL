package M1.Systeme;

import M1.Client.Client;
import M1.Connecteur.RPC;
import M1.Interface.ReceiveInformation;
import M1.Interface.SendInformation;
import M1.Serveur.Serveur;
import M2.Configuration.Configuration;
import M2.ObjectArchi.ObjetArchitectural;

/**
 * Created by Abdeldjallil on 23/10/2016.
 */
public class SystemeCS extends Configuration{

    public SystemeCS() {
        super("System C/S");
        this.portsFournis.add(new SendInformation(this));
        this.portsRequis.add(new ReceiveInformation(this));
        this.composants.add(new Client(this));
        this.composants.add(new Serveur(this));
        this.connecteurs.add(new RPC(this));
    }

    public void notification(ObjetArchitectural objArchi, String info) {
        if (objArchi instanceof Client)
            System.out.printf("Client "+ info);
        else
        if (objArchi instanceof Serveur)
            System.out.printf("Server "+ info);
        else
            System.out.printf("RPC "+ info);
    }
}
