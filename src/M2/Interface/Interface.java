package M2.Interface;

import M2.ObjectArchi.ObjetArchitectural;

/**
 * Created by Abdeldjallil on 19/10/2016.
 */
public abstract class Interface {
    protected ObjetArchitectural objetArchi;
    protected String name;
    public Interface(ObjetArchitectural objetArchi, String name){
        this.objetArchi = objetArchi;
        this.name = name;
    }
}
