package M1.Test;

import M1.Client.Client;
import M1.Serveur.Serveur;
import M1.Systeme.SystemeCS;
import M2.Composant.ComposantAbstrait;


/**
 * Created by Abdeldjallil on 29/10/2016.
 */
public class Principale {
    public static void main(String[] args) {
        SystemeCS monS = new SystemeCS();
        ComposantAbstrait c =  monS.composants.get(0);
        Client cl = (Client) c;
        ((Client) c).EnvoyerRequete();

    }

}
