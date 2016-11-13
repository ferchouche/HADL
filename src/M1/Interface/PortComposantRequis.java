package M1.Interface;

import M1.Client.Client;
import M1.ServerDetail.ConnectionManager;
import M1.Serveur.Serveur;
import M2.ObjectArchi.ObjetArchitectural;

/**
 * Created by erhode on 11/10/16.
 */
public class PortComposantRequis extends M2.Interface.PortComposantRequis{

    public PortComposantRequis(ObjetArchitectural parent, String name){
        super(parent,name);
    }

    @Override public void setInformation(Object information){
        this.information = information.toString();//j'ai ajouté cette instruction
        //System.out.println("Le message est arrivé sur le port requis du : " + parent.getClass().getName());
        if (this.parent instanceof Serveur) {System.out.printf("Le message et sur le port du serveur\n");
            ((Serveur)parent).notifierSystem(this);}
        else
            if (this.parent instanceof ConnectionManager){
                System.out.printf("Le message et sur le port du Connection manager\n");
                ((ConnectionManager)parent).notifierSystem(this);}
        if (this.parent instanceof Client) {System.out.printf("Le message de retour et sur le port du Client\n");}
    }
}