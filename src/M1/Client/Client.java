package M1.Client;

import M1.Interface.PortComposantFourni;
import M1.Interface.PortComposantRequis;
import M1.Systeme.SystemeCS;
import M2.Composant.ComposantConcret;
import M2.Interface.Interface;


/**
 * Classe cliente, envoie des requête vers le serveur et attend la réponse
 */
public class Client extends ComposantConcret {

    private Integer ID; //identifiant unique à chaque client, référencé chez le serveur pour les permissions
    SystemeCS cs;

    public Client(SystemeCS cs, Integer ID) {
        super("Client");
        this.portsRequis.add(new PortComposantRequis(this, "PortClientRequis"));
        this.portsFournis.add(new PortComposantFourni(this, "PortClientFourni"));
        this.cs = cs;
        this.ID = ID;
    }

    /**
     * Test l'envoie d'une requête vers le serveur
     * Une requête commence par l'ID du client suivis de GET ou SET, de l'ID du produit à modifier
     * dans la base de donnée et de la potentielle nouvelle valeur de produit (le tout séparé par des "-")
     */
    public void EnvoyerRequete() {

        System.out.printf("Le client envoie une requete\n");
        (portsFournis.getFirst()).setInformation(ID.toString() + "|GET|78");
        cs.notification(portsFournis.getFirst(), this);
        System.out.printf("\n\n\n"+this.portsFournis.getFirst().getInformation().toString()+"\n");
        System.out.printf(this.portsRequis.getFirst().getInformation().toString()+"\n");
    }

    @Override public void notifierSystem(Interface notifieur){
        cs.notification(notifieur);
    }

    public PortComposantFourni getPremierFourni(){
        return (PortComposantFourni)portsFournis.getFirst(); // sans le cast, la classe du port fourni retourné par getFirst
                                                             // provien du M2 et non du M1
    }

    public PortComposantRequis getPremierRequis(){
        return (PortComposantRequis)portsRequis.getFirst(); // sans le cast, la classe du port fourni retourné par getFirst
                                                            // provien du M2 et non du M1
    }
}
