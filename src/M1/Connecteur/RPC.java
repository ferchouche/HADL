package M1.Connecteur;

import M1.Interface.Colled;
import M1.Interface.Coller;
import M2.Connecteur.ConnecteurConcret;
import M2.Connecteur.ConnecteurExplicite;

/**
 * Created by Abdeldjallil on 23/10/2016.
 */
public class RPC extends ConnecteurConcret {

    public RPC() {
        super("RPC");
        this.roles.add(new Coller(this));
        this.roles.add(new Colled(this));
    }
}
