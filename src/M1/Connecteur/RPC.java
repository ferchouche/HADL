package M1.Connecteur;

import M1.Interface.PortComposantFourni;
import M1.Interface.PortComposantRequis;
import M1.Interface.RoleFourni;
import M1.Interface.RoleRequis;
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
        this.roles.add(new RoleRequis(this, "Caller"));
        this.roles.add(new RoleFourni(this, "CalledClient"));
        this.roles.add(new RoleFourni(this, "CalledServeur"));
        this.cs = cs;


        glues.add(new Glue("versCalledClient", this){
            @Override public void coller(){
                roles.get(1).setInformation(roles.getFirst().getInformation());
                ((RPC)connecteurConcret).notifierSystem(roles.get(1));// c'est 1 et non pas 0

            }
        });

        glues.getFirst().ajouterRole(roles.getFirst());
        glues.getFirst().ajouterRole(roles.get(1));
        //je pense qu'on doit instancier objet glue puis ajouter les roles pour appeler la méthode coller


        glues.add(new Glue("versCalledServeur", this){
            @Override public void coller(){
                roles.get(1).setInformation(roles.getFirst().getInformation());
                System.out.printf("Le RPC notifier la configue pour transmettre le message du client vers le serveur\n");
                ((RPC)connecteurConcret).notifierSystem(roles.get(1));

            }
        });
        glues.get(1).ajouterRole(roles.getFirst());
        glues.get(1).ajouterRole(roles.get(2));
    }

    public void notifierSystem(Interface notifieur){
        System.out.printf("Le RPC notifie la configue\n");

        cs.notification(notifieur);
    }

    public Role getRole(Integer index){
        return roles.get(index);
    }
}