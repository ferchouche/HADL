package M1.Interface;

import M1.Connecteur.RPC;
import M2.Interface.Role;
import M2.ObjectArchi.ObjetArchitectural;

/**
 * Created by Abdeldjallil on 28/10/2016.
 */
public class Called extends Role{
    public Called(ObjetArchitectural objetArchi) {
        super(objetArchi, "", "Called");
    }

    @Override public void setInformation(Object information) {
        System.out.println("Message collé sur le port called");
        this.information = information;
        ((RPC)objetArchi).notifierSystem(this);
    }
}
