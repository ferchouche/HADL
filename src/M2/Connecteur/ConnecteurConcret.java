package M2.Connecteur;

import java.util.LinkedList;

/**
 * Created by erhode on 10/28/16.
 */
public abstract class ConnecteurConcret extends ConnecteurExplicite {
    private LinkedList<Glue> glues;
    private String name;

    public ConnecteurConcret(String name) {
        this.name = name;
        glues = new LinkedList<Glue>();
    }
}
