package M2.Connecteur;

import M2.Interface.PortComposantFourni;
import M2.Interface.PortComposantRequis;
import M2.Interface.PortConfigurationFourni;
import M2.Interface.PortConfigurationRequis;

/**
 * Created by Abdeldjallil on 17/10/2016.
 */
public abstract class LienBinding implements ConnecteurAbstrait {

    public abstract void relierRequis(PortConfigurationRequis PConfR, PortComposantRequis PCompR);

    public abstract void relierFourni(PortConfigurationFourni PConfF, PortComposantFourni PCompF);
}
