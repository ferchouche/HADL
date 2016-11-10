package M1.Interface;

import M2.ObjectArchi.ObjetArchitectural;

/**
 * Created by erhode on 11/10/16.
 */
public class PortComposantRequis extends M2.Interface.PortComposantRequis{
    public PortComposantRequis(ObjetArchitectural parent, String name){
        super(parent,name);
    }

    @Override public void setInformation(Object information){
        System.out.println("Le message est arrivé sur : " + parent.getClass().getName());
    }
}