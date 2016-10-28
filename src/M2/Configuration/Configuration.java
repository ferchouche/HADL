package M2.Configuration;

import M2.Composant.ComposantAbstrait;
import M2.Connecteur.ConnecteurAbstrait;
import M2.Connecteur.ConnecteurExplicite;

import java.util.LinkedList;

/**
 * Created by Abdeldjallil on 17/10/2016.
 */
public abstract class Configuration extends ConnecteurExplicite implements ComposantAbstrait  {
    LinkedList<ComposantAbstrait> composants;
    LinkedList<ConnecteurAbstrait> connecteurs;

    public Configuration(String name) {
        this.composants = new LinkedList<ComposantAbstrait>();
        this.connecteurs = new LinkedList<ConnecteurAbstrait>();

    }
}
