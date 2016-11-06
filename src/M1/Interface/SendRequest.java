package M1.Interface;

import M1.Client.Client;
import M1.Connecteur.Lienbinding;
import M2.Composant.ComposantConcret;
import M2.Interface.PortComposantFourni;
import M2.Interface.PortConfigurationFourni;
import M2.ObjectArchi.ObjetArchitectural;

/**
 * Created by Abdeldjallil on 28/10/2016.
 */
public class SendRequest extends PortComposantFourni {
    private Object message;
    public SendRequest(ObjetArchitectural objetArchi) {
        super(objetArchi, "Send Request");
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        System.out.println("message is in sendRequest");
        this.message = message;
        ((ComposantConcret)objetArchi).notifierSystem();
    }
}
