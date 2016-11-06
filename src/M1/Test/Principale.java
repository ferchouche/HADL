package M1.Test;

import M1.Client.Client;
import M1.Connecteur.RPC;
import M1.Serveur.Serveur;
import M1.Systeme.SystemeCS;


/**
 * Created by Abdeldjallil on 29/10/2016.
 */
public class Principale {
    public static void main(String[] args) {
        SystemeCS monS = new SystemeCS();
        Client client = new Client(monS);
        Serveur serveur = new Serveur(monS);
        RPC rpc = new RPC(monS);
        monS.ajouterComposant(client);
        monS.ajouterComposant(serveur);
        monS.ajouterConnecteur(rpc);
        monS.Lier(client,rpc); //lier le client en premier obligatoire
        monS.Lier(serveur,rpc);
        client.EnvoyerRequete();
    }

}
