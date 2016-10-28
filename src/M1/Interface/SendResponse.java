package M1.Interface;

import M2.Interface.PortComposantFourni;
import M2.ObjectArchi.ObjetArchitectural;

/**
 * Created by Abdeldjallil on 28/10/2016.
 */
public class SendResponse extends PortComposantFourni {
    public SendResponse(ObjetArchitectural objetArchi) {
        super(objetArchi, "Send Response");
    }
}
