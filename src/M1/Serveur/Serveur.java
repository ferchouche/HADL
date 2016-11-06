package M1.Serveur;

import M1.Interface.ReceiveRequest;
import M1.Interface.ReceiveResponse;
import M1.Interface.SendRequest;
import M1.Interface.SendResponse;
import M1.Systeme.SystemeCS;
import M2.Composant.ComposantConcret;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by Abdeldjallil on 23/10/2016.
 */
public class Serveur extends ComposantConcret{
    SystemeCS cs;
    public Serveur(SystemeCS cs) {
        super("Server");
        this.portsRequis.add(new ReceiveRequest(this));
        this.portsFournis.add(new SendResponse(this));
        this.cs = cs;
    }

    @Override public void notifierSystem(){
        System.out.println("Notification du system par le serveur");
        cs.notification(portsFournis.getFirst(), this);
    }

    public void traiterInformation(Object information){
        try{
            System.out.println("le message est un entier : " + Integer.toString((Integer)information));
        }catch(Exception eInt){
            try{
                if((Boolean)information){
                    System.out.println("le message est un boolean true");
                }else{
                    System.out.println("le message est un boolean false");
                }
            }catch(Exception eBool){
                try{
                    System.out.println("le message est une String : " + information);
                }catch (Exception eString){
                    System.out.println("Le message n'est pas d'un type générique");
                }
            }
        }

        ((SendResponse)portsFournis.getFirst()).setMessage("reponse");
    }
}
