package M1.Connecteur;

import M2.Connecteur.LienBinding;
import M2.Interface.PortComposantFourni;
import M2.Interface.PortConfigurationFourni;


/**
 * Created by Abdeldjallil on 30/10/2016.
 */
public class Lienbinding extends LienBinding{

    public Lienbinding(PortComposantFourni portComposantFourni, PortConfigurationFourni portConfigurationFourni) {
        super(portComposantFourni, portConfigurationFourni);
    }
}
