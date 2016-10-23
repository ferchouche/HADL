package M2.Connecteur;

import M2.Interface.PortComposant;
import M2.Interface.Role;

/**
 * Created by Abdeldjallil on 17/10/2016.
 */
public abstract class LienAttachement implements ConnecteurAbstrait {
    public abstract void relier (Role roleconnecteur, PortComposant PortComp);

}
