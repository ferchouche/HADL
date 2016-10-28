package M2.Connecteur;

import M2.Interface.Role;

import java.util.LinkedList;

/**
 * Created by erhode on 10/28/16.
 */
public abstract class ConnecteurConcret extends ConnecteurExplicite {
    protected LinkedList<Glue> glues;
    protected LinkedList<Role> roles;
    protected String name;

    public ConnecteurConcret(String name) {
        this.name = name;
        this.glues = new LinkedList<Glue>();
        this.roles = new LinkedList<Role>();
    }
}
