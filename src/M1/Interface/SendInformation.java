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

    public void Transfer (String message, ObjetArchitectural objArchi) {
        System.out.printf("J'ai réçu la demande et je le fait transmettre à la configuration\n");
        ((SystemeCS)this.objetArchi).notification(objArchi, message);
    }
}
