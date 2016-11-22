package M1.Connecteur;


import M1.Interface.RoleFourni;
import M1.Interface.RoleRequis;
import M1.Systeme.SystemeCS;
import M2.Connecteur.ConnecteurConcret;
import M2.Connecteur.Glue;
import M2.Interface.Interface;


/**
 * Connecteur entre le client et le serveur(composant)
 */
public class RPC extends ConnecteurConcret {

    SystemeCS cs;
    public RPC(SystemeCS cs) {
        super("RPC");
        this.roles.add(new RoleRequis(this, "Caller"));
        this.roles.add(new RoleFourni(this, "CalledClient"));
        this.roles.add(new RoleFourni(this, "CalledServeur"));
        this.cs = cs;


        /**
         * glue serveur vers client
         */
        glues.add(new Glue("versCalledClient", this){
            @Override public void coller(){ // on implémente la fonction coller à l'instanciation
                                            // pour ne pas créer une classe juste pour ça.

                // !! ICI la variable "roles" référence la liste de la glue et non du RPC !!
                roles.get(1).setInformation(roles.getFirst().getInformation());
                ((RPC)connecteurConcret).notifierSystem(roles.get(1));

            }
        });

        // on donne à la glue les roles reliés aux connecteur (ici role requis et roles fourni vers client)
        glues.getFirst().ajouterRole(roles.getFirst());
        glues.getFirst().ajouterRole(roles.get(1));

        /**
         * glue client vers serveur
         */
        glues.add(new Glue("versCalledServeur", this){
            @Override public void coller(){
                roles.get(1).setInformation(roles.getFirst().getInformation());
                ((RPC)connecteurConcret).notifierSystem(roles.get(1));

            }
        });
        // role requis et role fourni vers serveur
        glues.get(1).ajouterRole(roles.getFirst());
        glues.get(1).ajouterRole(roles.get(2));
    }

    public void notifierSystem(Interface notifieur){
        cs.notification(notifieur);
    }


}