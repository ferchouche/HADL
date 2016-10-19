package Configuration;

import Composant.ComposantAbstrait;
import Connecteur.ConnecteurAbstrait;
import Connecteur.ConnecteurExplicite;
import Interface.Role;

import java.util.LinkedList;

/**
 * Created by Abdeldjallil on 17/10/2016.
 */
public abstract class Configuration implements ComposantAbstrait, ConnecteurExplicite {
    LinkedList<ComposantAbstrait> Composants;
    LinkedList<ConnecteurExplicite> Connecteurs;
}
