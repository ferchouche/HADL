package M2.Connecteur;

import M2.Interface.Interface;
import M2.Interface.PortComposant;
import M2.Interface.Role;
import M2.ObjectArchi.ObjetArchitectural;

import java.util.Optional;

/**
 * Created by Abdeldjallil on 17/10/2016.
 */
public class LienAttachement implements ConnecteurAbstrait {
    public Role roleConnecteur;
    public PortComposant portComposant;

    public LienAttachement(PortComposant portComposant, Role roleConnecteur){
        this.roleConnecteur = roleConnecteur;
        this.portComposant = portComposant;
    }

    public void transmettre(){
        portComposant.setInformation(roleConnecteur.getInformation());
    }

    public void transmettre(ObjetArchitectural emetteur){
        roleConnecteur.setInformation(emetteur, portComposant.getInformation());
    }
}
