package M1.Interface;

import M1.Connecteur.RPC;
import M2.ObjectArchi.ObjetArchitectural;

/**
 * Created by erhode on 11/10/16.
 */
public class RoleRequis extends M2.Interface.Role{
    public RoleRequis(ObjetArchitectural parent, String name){
        super(parent, name);
    }

    @Override public void setInformation(ObjetArchitectural emetteur, Object information){
        this.information = information;
        if (emetteur.getClass().getName().equals("M1.Client.Client")){ // Si le client est emetteur
            System.out.printf("Le RPC recoi le message du client\n");
            ((RPC)parent).getGlues().get(1).coller(); // on colle vers le serveur
        }else{//System.out.printf("Le RPC revoi le message du Serveur\n");
            ((RPC)parent).getGlues().get(0).coller(); // sinon on colle vers le client
        }
    }
}
