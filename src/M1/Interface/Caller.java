package M1.Interface;

import M1.Connecteur.RPC;
import M2.Interface.Role;
import M2.ObjectArchi.ObjetArchitectural;

/**
 * Created by Abdeldjallil on 28/10/2016.
 */
public class Caller extends Role{

    public Caller(ObjetArchitectural objetArchi) {

        super(objetArchi, "", "Caller");
    }

    @Override public void setInformation(ObjetArchitectural emetteur, Object information) {
        System.out.println("Message sur le caller");
        this.information = information;
        if (emetteur.getClass().getName().equals("M1.Client.Client"))
            ((RPC)objetArchi).getGlues().get(1).coller(this, emetteur);
        else {
            ((RPC) objetArchi).getGlues().getFirst().coller(this, emetteur);
        }
    }
}
