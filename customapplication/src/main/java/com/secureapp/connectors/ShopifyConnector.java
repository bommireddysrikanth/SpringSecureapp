/**
 * 
 */
package com.secureapp.connectors;

/**
 * @author Chiru
 *
 */
public abstract class ShopifyConnector {
	
	// Authentication
	// API Request and Processing
	// Save Data to Data base
	// Final method to start
	public final void processOrders(String apikey, String password, String hostname, String apiversion, String dataTableName) {
		
		String urlbuilder = "https://"+apikey+":"+password+"@"+hostname+"/admin/api/"+apiversion+"/orders/#1175.json";
		
	}

}
