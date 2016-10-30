package M1.Connecteur;

import M1.Interface.Colled;
import M1.Interface.Coller;
import M1.Systeme.SystemeCS;
import M2.Connecteur.ConnecteurConcret;


/**
 * Created by Abdeldjallil on 23/10/2016.
 */
public class RPC extends ConnecteurConcret {

    SystemeCS cs;
    public RPC(SystemeCS cs) {
        super("RPC");
        this.roles.add(new Coller(this));
        this.roles.add(new Colled(this));
        this.cs = cs;
    }
}
