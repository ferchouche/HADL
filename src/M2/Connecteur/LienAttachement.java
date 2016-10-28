package M2.Connecteur;

import M2.Interface.PortComposant;
import M2.Interface.Role;

/**
 * Created by Abdeldjallil on 17/10/2016.
 */
public abstract class LienAttachement implements ConnecteurAbstrait {
    private Role roleConnecteur;
    private PortComposant portComposant;

    public LienAttachement(Role roleConnecteur, PortComposant portComposant){
        this.roleConnecteur = roleConnecteur;
        this.portComposant = portComposant;
    }
}
