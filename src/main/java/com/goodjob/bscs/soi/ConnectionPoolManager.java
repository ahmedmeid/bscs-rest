package com.goodjob.bscs.soi;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import com.lhs.ccb.soi.SecurityExceptionI;
import com.lhs.ccb.soi.ServiceFactoryI;
import com.lhs.ccb.soi.ServiceRootI;
import com.lhs.ccb.soi.ServiceRootIHelper;
import com.lhs.ccb.soi.SystemExceptionI;

public class ConnectionPoolManager {
	
	
	List<Connection> availableConnections;
	
	private org.omg.CosNaming.NamingContextExt _namingContext;
	
	protected org.omg.CORBA.ORB _orb = null;
	
	protected ServiceFactoryI _serviceFactory = null;
	
	Properties connectionProperties;
	
	public ConnectionPoolManager() throws Exception {
		connectionProperties = new Properties();
		connectionProperties.load(ClassLoader.getSystemResourceAsStream("soi.properties"));
		System.getProperties().putAll(connectionProperties);
		availableConnections = new ArrayList<>();
		this._orb = org.omg.CORBA.ORB.init(new String[] {}, System.getProperties());
		initalize();
	}
	
	public void initalize() throws Exception {
		
		org.omg.CORBA.Object corbaObj;

		corbaObj = findCORBAObjectInNaming(connectionProperties.getProperty("soi.server"));

		ServiceRootI serviceRoot = ServiceRootIHelper.narrow(corbaObj);

		try {
			_serviceFactory = serviceRoot.loginShortI(connectionProperties.getProperty("soi.username"), connectionProperties.getProperty("soi.password"));

			Integer poolSize = Integer.parseInt(connectionProperties.getProperty("soi.pool.size"));
			for(int i=0;i<poolSize;i++) {
				Connection con = new Connection(_serviceFactory.getServiceObjectI(connectionProperties.getProperty("soi.name"), connectionProperties.getProperty("soi.version")));
				availableConnections.add(con);
			}
			
		} catch (SecurityExceptionI e) {
			throw new Exception("SecurityExceptionI: " + e.reason);
		} catch (SystemExceptionI e) {
			throw new Exception("SystemExceptionI");
		}
		
		
	}
	
	public Connection getConnection() {
		return availableConnections.remove(0);
	}
	
	public void returnConnection(Connection con) {
		availableConnections.add(con);
	}
	
	public org.omg.CORBA.Object findCORBAObjectInNaming(String pServerName)
			throws Exception {
		org.omg.CORBA.Object lResult = null;
		try {
			if (this._namingContext == null) {
				// NameService is not initialized.
				// Initialize it now.
				org.omg.CORBA.Object lObj = this._orb.resolve_initial_references("NameService");
				if (lObj != null) {
					this._namingContext = NamingContextExtHelper.narrow(lObj);
				} else
					throw new Exception("CORBA.NamingServiceNotFound");
			}
			// Search pServerName in the NameService
			try {
				lResult = this._namingContext.resolve_str(pServerName);
			} catch (NotFound e1) {
				lResult = null;
			} catch (org.omg.CosNaming.NamingContextPackage.InvalidName e2) {
				lResult = null;
			}
		} catch (InvalidName e3) {
			throw new Exception("CORBA.InvalidName");
		} catch (CannotProceed e4) {
			throw new Exception("CORBA.CannotProceed");
		}
		return lResult;
	}

}
