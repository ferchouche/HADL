package M2.Connecteur;

import M2.Interface.Role;

import java.util.LinkedList;

/**
 * Created by Abdeldjallil on 19/10/2016.
 */

public class Glue {
    LinkedList<Role> roles;
    ConnecteurConcret connecteurConcret;
    String name;

    public Glue(String name, ConnecteurConcret connecteurConcret) {
        this.name = name;
        this.connecteurConcret = connecteurConcret;
        this.roles = new LinkedList<Role>();
    }
}
