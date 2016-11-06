package M1.Interface;

import M1.Systeme.SystemeCS;
import M2.Interface.PortConfigurationFourni;
import M2.ObjectArchi.ObjetArchitectural;

/**
 * Created by Abdeldjallil on 28/10/2016.
 */
public class SendInformation extends PortConfigurationFourni{
    public SendInformation(ObjetArchitectural objetArchi) {

        super(objetArchi, "Send Information");
    }
}
