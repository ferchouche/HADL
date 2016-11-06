package M2.Interface;

import M2.ObjectArchi.ObjetArchitectural;

/**
 * Created by Abdeldjallil on 19/10/2016.
 */
public abstract class Interface {
    protected ObjetArchitectural objetArchi;
    protected Object information;
    protected String name;
    public Interface(ObjetArchitectural objetArchi, String name){
        this.objetArchi = objetArchi;
        this.name = name;
    }

    public ObjetArchitectural getObjetArchi() {
        return objetArchi;
    }

    public void setObjetArchi(ObjetArchitectural objetArchi) {
        this.objetArchi = objetArchi;
    }

    public Object getInformation() {
        return information;
    }

    public void setInformation(Object information) {
        System.out.println("Message reçu sur le port : " + this.getClass().getName() +
                " du composant : " + objetArchi.getClass().getName());
        this.information = information;
    }
}
