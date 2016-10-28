package M2.Connecteur;

import M2.Interface.*;

/**
 * Created by Abdeldjallil on 17/10/2016.
 */
public abstract class LienBinding implements ConnecteurAbstrait {
    private PortComposant portComposant;
    private PortConfiguration portConfiguration;

    public LienBinding(PortComposantFourni portComposantFourni, PortConfigurationFourni portConfigurationFourni){
        portComposant = portComposantFourni;
        portConfiguration = portConfigurationFourni;
    }

    public LienBinding(PortComposantRequis portComposantRequis, PortConfigurationRequis portConfigurationRequis){
        portComposant = portComposantRequis;
        portConfiguration = portConfigurationRequis;
    }
}
