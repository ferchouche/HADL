package M1.ServerDetail;

import M1.Interface.PortComposantFourni;
import M1.Interface.PortComposantRequis;
import M1.Serveur.ServeurDetail;
import M2.Composant.ComposantConcret;

/**
 * Created by Abdeldjallil on 11/11/2016.
 */
public class SecurityManager extends ComposantConcret{

    ServeurDetail sd;
    public SecurityManager(ServeurDetail sd) {
        super("Security Manager");

        this.portsRequis.add(new PortComposantRequis(this, "security_auth_Requis"));
        this.portsRequis.add(new PortComposantRequis(this, "check_query_Requis"));

        this.portsFournis.add(new PortComposantFourni(this, "security_auth_Fourni"));
        this.portsFournis.add(new PortComposantFourni(this, "check_query_Fourni"));

        this.sd = sd;
    }
}
