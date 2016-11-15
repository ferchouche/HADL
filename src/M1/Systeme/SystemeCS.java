package M1.Systeme;


import M1.Client.Client;
import M1.Connecteur.RPC;
import M1.Interface.PortConfigurationFourni;
import M1.Serveur.Serveur;
import M1.Serveur.ServeurDetail;
import M2.Configuration.Configuration;
import M2.Connecteur.ConnecteurConcret;
import M2.Connecteur.LienAttachement;
import M2.Connecteur.LienBinding;
import M2.Interface.Interface;
import M2.Interface.PortConfiguration;
import M2.ObjectArchi.ObjetArchitectural;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abdeldjallil on 23/10/2016.
 */
public class SystemeCS extends Configuration{
    private Map<Interface, LienAttachement> attachementMap;
    public SystemeCS() {
        super("System C/S");
        attachementMap = new HashMap<>();
        composants.add(new Client(this));
        composants.add(new Serveur(this));
        connecteurs.add(new RPC(this));

        attachementMap.put(((Client)composants.getFirst()).getPremierFourni(), // port fourni client
                new LienAttachement(((Client)composants.getFirst()).getPremierFourni(), // port fourni client
                        ((RPC)connecteurs.getFirst()).getRole(0))); // role requis RPC

        attachementMap.put(((RPC)connecteurs.getFirst()).getRole(1), // role fourni RPC  (vers Client)
                new LienAttachement(((Client)composants.getFirst()).getPremierRequis(), // port requis client
                        ((RPC)connecteurs.getFirst()).getRole(1))); // role fourni RPC (vers Client)

        attachementMap.put(((Serveur)composants.get(1)).getPremierFourni(), // port fourni serveur
                new LienAttachement(((Serveur)composants.get(1)).getPremierFourni(), // port fourni serveur
                        ((RPC)connecteurs.getFirst()).getRole(0))); // role requis RPC

        attachementMap.put((((RPC)connecteurs.getFirst()).getRole(2)), // role fourni RPC (vers Serveur)
                new LienAttachement(((Serveur)composants.get(1)).getPremierRequis(), // port requis client
                        ((RPC)connecteurs.getFirst()).getRole(2))); // role fourni RPC (vers Serveur)
    }

    public void notification(Interface interfaceCalling, ObjetArchitectural emetteur){
        /*if (emetteur instanceof Client)
            System.out.printf("La configue appelle le lien d'attachement entre le client et le  RPC \n");
        else
            System.out.printf("La configue appelle le lien d'attachement entre le serveur et le RPC \n");*/
        attachementMap.get(interfaceCalling).transmettre(emetteur);
    }

    public void notification(Interface interfaceCalling) {
        attachementMap.get(interfaceCalling).transmettre();
    }

    public void test(){
        ((Client)composants.getFirst()).EnvoyerRequete();
    }
}
