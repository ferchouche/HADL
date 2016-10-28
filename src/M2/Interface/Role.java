package M2.Interface;

import M2.Connecteur.Glue;
import M2.ObjectArchi.ObjetArchitectural;

/**
 * Created by Abdeldjallil on 17/10/2016.
 */
public class Role extends Interface {
    Glue glue;

    public Role(ObjetArchitectural objetArchi, String name, Glue glue) {
        super(objetArchi, name);
        this.glue = glue;
    }
}
