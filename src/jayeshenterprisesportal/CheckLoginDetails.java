package jayeshenterprisesportal;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class CheckLoginDetails  extends UnicastRemoteObject  implements  LoginInterface
{
    CheckLoginDetails()throws  RemoteException
    {
    }
    @Override
    public boolean checkLoginDetails(String id, String pwd) throws RemoteException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            PreparedStatement st=con.prepareStatement("select * from rmitab where userid=? and password=?");
            st.setString(1 , id);
            st.setString(2 , pwd);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                return true;
            }
            else
                return false;
        }
        catch(Exception ex)
        {
        }
       return true;
    }
    
}
