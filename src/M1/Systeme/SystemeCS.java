package M1.Systeme;


import M2.Composant.ComposantAbstrait;
import M2.Composant.ComposantConcret;
import M2.Configuration.Configuration;
import M2.Connecteur.ConnecteurAbstrait;
import M2.Connecteur.ConnecteurConcret;
import M2.Connecteur.LienAttachement;
import M2.Interface.Interface;
import M2.ObjectArchi.ObjetArchitectural;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Abdeldjallil on 23/10/2016.
 */
public class SystemeCS extends Configuration{
    private Map<Interface, LienAttachement> attachementMap;
    public SystemeCS() {
        super("System C/S");
        attachementMap = new HashMap<Interface, LienAttachement>();
    }

    public void notification(Interface interfaceCalling, ObjetArchitectural emetteur){
        System.out.println("System notifier par composant");
        attachementMap.get(interfaceCalling).transmettre(emetteur);
    }

    public void notification(Interface interfaceCalling){
        System.out.println("System notifier par connecteur");
        attachementMap.get(interfaceCalling).transmettre();
    }

    public void Lier(ComposantAbstrait composantAbstrait, ConnecteurAbstrait connecteurAbstrait){
        if(composants.contains(composantAbstrait) && connecteurs.contains(connecteurAbstrait)){
            Integer i = 1;
            attachementMap.put(((ComposantConcret)composantAbstrait).getPortsFournis().getFirst(),
                    new LienAttachement(((ComposantConcret)composantAbstrait).getPortsFournis().getFirst(),
                            ((ConnecteurConcret)connecteurAbstrait).getRoles().getFirst()));
            while(attachementMap.containsKey(((ConnecteurConcret)connecteurAbstrait).getRoles().get(i))){++i;}
            attachementMap.put(((ConnecteurConcret)connecteurAbstrait).getRoles().get(i),
                    new LienAttachement(((ComposantConcret)composantAbstrait).getPortsRequis().getFirst(),
                            ((ConnecteurConcret)connecteurAbstrait).getRoles().get(i)));
        }
    }

}
