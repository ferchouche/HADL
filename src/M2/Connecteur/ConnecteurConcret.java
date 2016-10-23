package M2.Connecteur;

import java.util.LinkedList;

/**
 * Created by Abdeldjallil on 17/10/2016.
 */

public abstract class ConnecteurConcret implements ConnecteurExplicite {

    LinkedList<Glue> glues;
    String name;

    public ConnecteurConcret(String name) {
        this.name = name;
        glues = new LinkedList<Glue>();
    }

}
