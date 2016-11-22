package M1.ServerDetail;

import M1.Interface.PortComposantFourni;
import M1.Interface.PortComposantRequis;
import M1.Serveur.ServeurDetail;
import M2.Composant.ComposantConcret;
import M2.Interface.Interface;
import M2.Interface.PortComposant;
import M2.ObjectArchi.ObjetArchitectural;

import java.time.Clock;

/**
 * Created by Abdeldjallil on 11/11/2016.
 */
public class ConnectionManager extends ComposantConcret{

    ServeurDetail sd;
    public ConnectionManager(ServeurDetail sd) {
        super("Connection Manager");
        this.portsRequis.add(new PortComposantRequis(this, "external_socket_Requis"));
        this.portsRequis.add(new PortComposantRequis(this, "security_check_Requis"));
        this.portsRequis.add(new PortComposantRequis(this, "dbQuery_Requis"));

        this.portsFournis.add(new PortComposantFourni(this, "external_socket_Fourni"));
        this.portsFournis.add(new PortComposantFourni(this, "security_check_Fourni"));
        this.portsFournis.add(new PortComposantFourni(this, "dbQuery_Fourni"));

        this.sd = sd;
    }

    public PortComposantFourni getFourni(int i) {
        return (PortComposantFourni)portsFournis.get(i); // without cast, function returning M2 PortComposantFourni
    }


    public PortComposantRequis getRequis(int i){
        return (PortComposantRequis)portsRequis.get(i); // without cast, function returning M2 PortComposantRequis
    }

    @Override public void notifierSystem(Interface notifieur){
        if (notifieur.getName() == "external_socket_Fourni")
            //System.out.printf("C'est bon\n");
           sd.notifierBinding(notifieur);
        else
            sd.notification(notifieur, this);
    }

    public void testretour() {
      //  System.out.printf("Le connection manager envoie la reponse au client\n");
        //this.portsFournis.getFirst().setInformation("La reponse du Connection manager");
        //sd.notifierBinding(this.portsFournis.getFirst());
       // this.portsRequis.getFirst().setInformation("cc");
        this.copierMessageEntrePort(this.portsRequis.getFirst());
       // System.out.printf( this.portsFournis.get(1).getInformation().toString());

    }

    public void copierMessageEntrePort(PortComposant pc) {
        if (pc.getName() == "external_socket_Requis")
            /*dés que un message arrive de la part du serveur detil il sera copier sur le port security_check_Fourni
            du compsant connection manager
            */
            this.portsFournis.get(1).setInformation(pc.getInformation());
        else
            if (pc.getName() == "security_check_Requis")
            /*
            si le security manager il donne l'acce on copie le message vers dbQuery_Founi
            sinon on copie le message vers external_socket_Fourni pour sortir, (dans ce cas je traite le cas ideal)
             */
            this.portsFournis.get(2).setInformation(pc.getInformation());
        else//external_socket_Fourni
            this.portsFournis.get(0).setInformation(pc.getInformation());


    }

    public void traiter(ObjetArchitectural emetteur, String requete){
        if(emetteur.getClass().equals(ServeurDetail.class)){
            // port du security manager
            this.portsFournis.get(1).setInformation(requete);
        } else if(emetteur.getClass().equals(SecurityManager.class)){
            if(requete.contains("|")){
                // port de la database
                this.portsFournis.get(2).setInformation(requete);
            }else{
                // port du serveur details
                this.portsFournis.get(0).setInformation(requete);
            }

        } else if(emetteur.getClass().equals(DataBase.class)){
            //port du serveur detail
            this.portsFournis.get(0).setInformation(requete);
        }
    }
}
