package M1.Test;

import M1.Client.Client;
import M1.Connecteur.RPC;
import M1.Serveur.Serveur;
import M1.Serveur.ServeurDetail;
import M1.Systeme.SystemeCS;


/**
 * Created by Abdeldjallil on 29/10/2016.
 */
public class Principale {
    public static void main(String[] args) {
        SystemeCS monS = new SystemeCS();
        monS.test();
        /*ServeurDetail sd = new ServeurDetail(null);
        sd.testerrrr();*/
    }

}
