import java.util.Iterator;
import java.util.List;
import java.util.Map;

import kr.ac.kaist.mms_client.*;

/* -------------------------------------------------------- */
/** 
File name : IdentityRegistry.java
Author : Jaehee Ha (jaehee.ha@kaist.ac.kr)
Creation Date : 2017-02-01
Version : 0.3.01

Rev. history : 2017-04-20 
Version : 0.5.0
Modifier : Jaehee Ha (jaehee.ha@kaist.ac.kr)

Rev. history : 2017-04-25
Modifier : Jaehee Ha (jaehee.ha@kaist.ac.kr)
*/
/* -------------------------------------------------------- */

public class IdentityRegistry{
	
	public static void main(String args[]) throws Exception{
		String myMRN = "urn:mrn:smart-navi:device:mir1";
		int port = 8904;
		//myMRN = args[0];
		//port = Integer.parseInt(args[1]);
		
		MMSConfiguration.MMS_URL="127.0.0.1:8088";
		
		MMSClientHandler server = new MMSClientHandler(myMRN);
		server.setServerPort(port, new MMSClientHandler.RequestCallback() {
			//Request Callback from the request message
			//it is called when client receives a message
			@Override
			public String respondToClient(Map<String,List<String>> headerField, String message) {
				Iterator<String> iter = headerField.keySet().iterator();
				while (iter.hasNext()){
					String key = iter.next();
					System.out.println(key+":"+headerField.get(key).toString());
				}
				System.out.println(message);
				return "OK";
			}

			@Override
			public int setResponseCode() {
				// TODO Auto-generated method stub
				return 200;
			}
		});
		


	}
	
		
		
}
