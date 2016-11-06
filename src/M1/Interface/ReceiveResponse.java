package M1.Interface;

import M2.Interface.PortComposantRequis;
import M2.ObjectArchi.ObjetArchitectural;

/**
 * Created by Abdeldjallil on 28/10/2016.
 */
public class ReceiveResponse extends PortComposantRequis{
    public ReceiveResponse(ObjetArchitectural objetArchi) {
        super(objetArchi, "Receive Response");
    }
}
