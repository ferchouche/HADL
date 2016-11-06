package M1.Interface;

import M2.Composant.ComposantConcret;
import M2.Interface.PortComposantFourni;
import M2.ObjectArchi.ObjetArchitectural;

/**
 * Created by Abdeldjallil on 28/10/2016.
 */
public class SendResponse extends PortComposantFourni {
    private Object message;

    public SendResponse(ObjetArchitectural objetArchi) {
        super(objetArchi, "Send Response");
    }

    public void setMessage(Object message) {
        System.out.println("message is in sendRequest");
        this.message = message;
        ((ComposantConcret)objetArchi).notifierSystem();
    }
}
