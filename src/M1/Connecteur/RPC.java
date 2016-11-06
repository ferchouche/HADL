package M1.Connecteur;

import M1.Interface.Called;
import M1.Interface.Caller;
import M1.Systeme.SystemeCS;
import M2.Connecteur.ConnecteurConcret;
import M2.Connecteur.Glue;
import M2.Interface.Interface;
import M2.Interface.Role;
import M2.ObjectArchi.ObjetArchitectural;


/**
 * Created by Abdeldjallil on 23/10/2016.
 */
public class RPC extends ConnecteurConcret {

    SystemeCS cs;
    public RPC(SystemeCS cs) {
        super("RPC");
        this.roles.add(new Caller(this));
        this.roles.add(new Called(this)); // role du client si linké en premier
        this.roles.add(new Called(this)); // role du serveur si linké en second
        this.cs = cs;

        glues.add(new Glue("versCalledClient", this));
        glues.getFirst().ajouterRole(roles.getFirst());
        glues.getFirst().ajouterRole(roles.get(1));
        glues.add(new Glue("versCalledServeur", this));
        glues.get(1).ajouterRole(roles.getFirst());
        glues.get(1).ajouterRole(roles.get(2));
    }

    public void notifierSystem(Interface notifier){
        System.out.println("notif du system par le RPC");
        cs.notification(notifier);
    }
}
