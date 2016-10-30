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
    public LinkedList<ComposantAbstrait> composants;
    public LinkedList<ConnecteurAbstrait> connecteurs;
    public LinkedList<PortConfigurationFourni> portsFournis;
    public LinkedList<PortConfigurationRequis> portsRequis;
    public String name;

    public Configuration(String name) {
        this.name = name;
        this.portsFournis = new LinkedList<PortConfigurationFourni>();
        this.portsRequis = new LinkedList<PortConfigurationRequis>();
        this.composants = new LinkedList<ComposantAbstrait>();
        this.connecteurs = new LinkedList<ConnecteurAbstrait>();
    }
}
