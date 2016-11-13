package M1.Interface;

import M1.Client.Client;
import M1.ServerDetail.ConnectionManager;
import M1.Serveur.Serveur;
import M2.ObjectArchi.ObjetArchitectural;

/**
 * Created by erhode on 11/10/16.
 */
public class PortComposantFourni extends M2.Interface.PortComposantFourni{

    public PortComposantFourni(ObjetArchitectural parent, String name){
        super(parent,name);
    }

    @Override public void setInformation(Object information){
        this.information = information.toString();//j'ai ajouté cette instruction
        //System.out.println("Le message est arrivé sur le port requis du : " + parent.getClass().getName());
        if (this.parent instanceof Serveur) {System.out.printf("Le message de retour et sur le port du serveur\n");
            ((Serveur)parent).notifierSystem(this);}

    }
}