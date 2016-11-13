package M1.ServerDetail;

import M1.Interface.PortComposantFourni;
import M1.Interface.PortComposantRequis;
import M1.Serveur.ServeurDetail;
import M2.Composant.ComposantConcret;

/**
 * Created by Abdeldjallil on 11/11/2016.
 */
public class DataBase extends ComposantConcret{

    ServeurDetail sd;
    public DataBase(ServeurDetail sd) {
        super("Data Base");

        this.portsRequis.add(new PortComposantRequis(this, "query_D_Requis"));
        this.portsRequis.add(new PortComposantRequis(this, "check_query_Requis"));

        this.portsFournis.add(new PortComposantFourni(this, "query_D_Fourni"));
        this.portsFournis.add(new PortComposantFourni(this, "check_query_Fourni"));
        this.sd = sd;
    }
}
