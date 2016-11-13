package M1.Serveur;

import M1.Interface.PortComposantFourni;
import M1.Interface.PortComposantRequis;
import M1.Interface.PortConfigurationFourni;
import M1.Interface.PortConfigurationRequis;
import M1.ServerDetail.ConnectionManager;
import M1.ServerDetail.DataBase;
import M1.ServerDetail.SecurityManager;
import M1.Systeme.SystemeCS;
import M2.Configuration.Configuration;
import M2.Connecteur.LienAttachement;
import M2.Connecteur.LienBinding;
import M2.Interface.Interface;
import M2.Interface.PortConfiguration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abdeldjallil on 23/10/2016.
 */
public class ServeurDetail extends Configuration{

    public SystemeCS cs;

    private Map<Interface, LienAttachement> attachementMap;
    private Map<Interface, LienBinding> bindingMap;

    public ServeurDetail(SystemeCS cs) {
        super("Serveur Detail");
        attachementMap = new HashMap<>();
        bindingMap = new HashMap<>();
        this.portsConfigFournis.add(new PortConfigurationFourni(this, "PortServeurDetailFourni"));
        this.portsConfigRequises.add(new PortConfigurationRequis(this, "PortServeurDetailRequis"));
        this.composants.add(new ConnectionManager(this));
        this.composants.add(new SecurityManager(this));
        this.composants.add(new DataBase(this));
        //ajouter les connecteurs
        this.cs = cs;

        bindingMap.put((this).getPremierRequis(),
                new LienBinding(((ConnectionManager)composants.get(0)).getRequis(0),
                        ((this).getPremierRequis())));
        bindingMap.put(((ConnectionManager)composants.get(0)).getFourni(0),
                new LienBinding(((ConnectionManager)composants.get(0)).getFourni(0),
                        ((this).getPremierFourni())));
    }

    public PortConfigurationFourni getPremierFourni(){
        return (PortConfigurationFourni)portsConfigFournis.getFirst(); // without cast, function returning M2 PortComposantFourni
    }

    public PortConfigurationRequis getPremierRequis(){
        return (PortConfigurationRequis)portsConfigRequises.getFirst(); // without cast, function returning M2 PortComposantRequis
    }

    public void notifierBinding(Interface notifieur){
        if (notifieur instanceof PortConfiguration)
            this.bindingMap.get(notifieur).TransmetterVersComposant();
        else
            this.bindingMap.get(notifieur).TransmettreVerConfig();
    }

    public void Notification() {
        cs.notificationBind(this.getPremierFourni());
    }
}
