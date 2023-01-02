package plmtechie;

import java.util.HashMap;

import com.agile.api.APIException;
import com.agile.api.AgileSessionFactory;
import com.agile.api.IAgileSession;
import com.agile.api.IItem;
import com.agile.api.ItemConstants;

public class HelloAgile {

	public static void main(String[] args) {
		String sURL="http://agile936.localdomain:7001/Agile/";
		String sUsername="testuser";
		String sPassword="testpwd";

		HashMap<Integer, String> params = new HashMap<>();
		params.put(AgileSessionFactory.URL, sURL);
		params.put(AgileSessionFactory.USERNAME, sUsername);
		params.put(AgileSessionFactory.PASSWORD, sPassword);
		
		try {
			System.out.println("Connecting to Agile");
			IAgileSession aglSession = AgileSessionFactory.createSessionEx(params);
			System.out.println("Successfully Connected to Agile : "+aglSession);
			
			IItem item = (IItem)aglSession.getObject("Part", "P00001");
			System.out.println("Item Description :  "+item.getValue(ItemConstants.ATT_TITLE_BLOCK_DESCRIPTION));
			
			
			
		} catch (APIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
