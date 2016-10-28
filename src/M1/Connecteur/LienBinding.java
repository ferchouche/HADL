package M1.Connecteur;

import M2.Interface.PortComposantFourni;
import M2.Interface.PortComposantRequis;
import M2.Interface.PortConfigurationFourni;
import M2.Interface.PortConfigurationRequis;

/**
 * Created by Abdeldjallil on 23/10/2016.
 */
public class LienBinding extends M2.Connecteur.LienBinding{

    public LienBinding(PortComposantFourni portComposantFourni, PortConfigurationFourni portConfigurationFourni) {
        super(portComposantFourni, portConfigurationFourni);
    }

    public LienBinding(PortComposantRequis portComposantRequis, PortConfigurationRequis portConfigurationRequis){
        super(portComposantRequis, portConfigurationRequis);
    }
}
