package Connecteur;

import Interface.*;

/**
 * Created by Abdeldjallil on 17/10/2016.
 */
public abstract class LienBinding implements ConnecteurAbstrait {

    public abstract void relierRequis(PortConfigurationRequis PConfR, PortComposantRequis PCompR);

    public abstract void relierFourni(PortConfigurationFourni PConfF, PortComposantFourni PCompF);
}
