package M2.Configuration;

import M2.Composant.ComposantAbstrait;
import M2.Connecteur.ConnecteurAbstrait;
import M2.Connecteur.ConnecteurExplicite;
import M2.Interface.*;

import java.util.LinkedList;

/**
 * Created by Abdeldjallil on 17/10/2016.
 */
public abstract class Configuration extends ConnecteurExplicite implements ComposantAbstrait  {
    protected LinkedList<ComposantAbstrait> composants;
    protected LinkedList<ConnecteurAbstrait> connecteurs;
    protected LinkedList<PortConfigurationFourni> portsFournis;
    protected LinkedList<PortConfigurationRequis> portsRequis;
    protected String name;

    public Configuration(String name) {
        this.name = name;
        this.portsFournis = new LinkedList<PortConfigurationFourni>();
        this.portsRequis = new LinkedList<PortConfigurationRequis>();
        this.composants = new LinkedList<ComposantAbstrait>();
        this.connecteurs = new LinkedList<ConnecteurAbstrait>();
    }
}
