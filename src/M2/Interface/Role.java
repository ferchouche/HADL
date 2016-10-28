package M2.Interface;

import M2.ObjectArchi.ObjetArchitectural;

/**
 * Created by Abdeldjallil on 17/10/2016.
 */
public class Role extends Interface {
    protected String name;

    public Role(ObjetArchitectural objetArchi, String nameInterface, String name) {
        super(objetArchi, nameInterface);
        this.name = name;
    }
}
