package M2.Interface;

import M2.Connecteur.Glue;

/**
 * Created by Abdeldjallil on 17/10/2016.
 */
public class Role extends Interface {
    Glue glue;
    String name;

    public Role (String name, Glue glue) {
        this.name = name;
        this.glue = glue;
    }
}
