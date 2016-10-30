package M1.Interface;

import M1.Client.Client;
import M1.Connecteur.Lienbinding;
import M2.Interface.PortComposantFourni;
import M2.Interface.PortConfigurationFourni;
import M2.ObjectArchi.ObjetArchitectural;

/**
 * Created by Abdeldjallil on 28/10/2016.
 */
public class SendRequest extends PortComposantFourni {


    public SendRequest(ObjetArchitectural objetArchi) {

        super(objetArchi, "Send Request");
    }

    //Transformer la demande du client à la configuration CS via lien binding
    public void Transfer(String demandeAenvoyer, PortConfigurationFourni portsysteme, Client client) {

        System.out.printf("J'ai envoyer ma requete du mon composant Client\n");
        System.out.printf("Je crée un lein binding entre moi et le port send information du systeme\n");
        Lienbinding clientsysteme = new Lienbinding(this, portsysteme);
        System.out.printf("J'ai envoyer la requete au port send information du systeme a travers le lien binding crée\n");
        ((SendInformation) clientsysteme.portConfiguration).Transfer(demandeAenvoyer, client);
    }
}
