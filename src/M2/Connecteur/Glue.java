package M2.Connecteur;

import M2.Interface.Role;
import java.util.LinkedList;
/**
 * Created by Abdeldjallil on 28/10/2016.
 */
public class Glue {
    public LinkedList<Role> roles;
    public ConnecteurConcret connecteurConcret;
    public String name;

    public Glue(String name, ConnecteurConcret connecteurConcret) {
        this.name = name;
        this.connecteurConcret = connecteurConcret;
        this.roles = new LinkedList<Role>();
    }
}
