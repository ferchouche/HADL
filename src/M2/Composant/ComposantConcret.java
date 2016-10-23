package M2.Composant;

import M2.Interface.PortComposantFourni;
import M2.Interface.PortComposantRequis;

import java.util.LinkedList;

/**
 * Created by Abdeldjallil on 17/10/2016.
 */
public abstract class ComposantConcret implements ComposantAbstrait {

    protected LinkedList<Contrainte> listeContraintes;
    protected LinkedList<Propriete> listeProprietes;
    protected LinkedList<PortComposantFourni> portsfourni;
    protected LinkedList<PortComposantRequis> portsrequis;
    protected String name;

    public ComposantConcret(String name){
        this.name = name;
        this.portsrequis = new LinkedList<PortComposantRequis>();
        this.portsfourni = new LinkedList<PortComposantFourni>();
        this.listeContraintes = new LinkedList<Contrainte>();
        this.listeProprietes = new LinkedList<Propriete>();
    }

}
