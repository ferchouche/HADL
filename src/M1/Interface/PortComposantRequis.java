package M1.Interface;

import M1.Client.Client;
import M1.ServerDetail.ConnectionManager;
import M1.ServerDetail.DataBase;
import M1.ServerDetail.SecurityManager;
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
        this.information = information.toString();
        System.out.println("Le message est sur le port : " + this.getName() + " du " + parent.getClass().getName());

        if (this.parent instanceof Serveur) {
            ((Serveur)parent).notifierSystem(this);
        }else if (this.parent instanceof ConnectionManager){
            ((ConnectionManager)parent).copierMessageEntrePort(this);
        }else if (this.parent instanceof SecurityManager) {
            ((SecurityManager)parent).copierMessageEntrePort(this);
        } else if (this.parent instanceof DataBase) {
            ((DataBase)parent).copierMessageEntrePort(this);
        }
    }
}