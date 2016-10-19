package Configuration;

import Composant.ComposantAbstrait;
import Connecteur.ConnecteurAbstrait;
import Connecteur.ConnecteurExplicite;
import Role.Role;

import java.util.LinkedList;

/**
 * Created by Abdeldjallil on 17/10/2016.
 */
public class Configuration implements ComposantAbstrait, ConnecteurExplicite {
    LinkedList<ComposantAbstrait> Config;

    @Override
    public void Glue(LinkedList<Role> ListePar) {

    }
}
