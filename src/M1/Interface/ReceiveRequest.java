package M1.Interface;

import M2.Interface.PortComposantRequis;
import M2.ObjectArchi.ObjetArchitectural;

/**
 * Created by Abdeldjallil on 28/10/2016.
 */
public class ReceiveRequest extends PortComposantRequis{
    public ReceiveRequest(ObjetArchitectural objetArchi) {
        super(objetArchi, "Receive Request");
    }
}
