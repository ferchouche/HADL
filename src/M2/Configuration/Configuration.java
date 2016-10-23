package M2.Configuration;

import M2.Composant.ComposantAbstrait;
import M2.Connecteur.ConnecteurAbstrait;
import M2.Connecteur.ConnecteurExplicite;

import java.util.LinkedList;
import java.util.stream.Stream;

/**
 * Created by Abdeldjallil on 17/10/2016.
 */
public abstract class Configuration implements ComposantAbstrait, ConnecteurExplicite {
    String name;
    LinkedList<ComposantAbstrait> Composants;
    LinkedList<ConnecteurAbstrait> Connecteurs;

    public Configuration(String name) {
        this.name = name;
        this.Composants = new LinkedList<ComposantAbstrait>();
        this.Connecteurs = new LinkedList<ConnecteurAbstrait>();

    }
}
