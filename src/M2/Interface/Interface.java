package M2.Interface;

import M2.ObjectArchi.ObjetArchitectural;

/**
 * Created by Abdeldjallil on 19/10/2016.
 */
public abstract class Interface {
    protected ObjetArchitectural parent;
    protected Object information;
    protected String name;

    public Interface(ObjetArchitectural objetArchi, String name){
        this.parent = objetArchi;
        this.name = name;
    }

    public Object getInformation() {
        return information;
    }

    public void setInformation(Object information) {
        this.information = information;
    }
}
