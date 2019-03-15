package jayeshenterprisesportal;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginInterface  extends Remote
{
        public boolean checkLoginDetails(String id,String pwd)  throws RemoteException  ;
}
