package com.goodjob.bscs.soi;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.CORBA.TCKind;

import com.lhs.ccb.soi.ComponentExceptionI;
import com.lhs.ccb.soi.ErrorInfoI;
import com.lhs.ccb.soi.SecurityExceptionI;
import com.lhs.ccb.soi.ServiceObjectI;
import com.lhs.ccb.soi.UnknownCommandExceptionI;
import com.lhs.ccb.soi.types.DateI;
import com.lhs.ccb.soi.types.DateIHelper;
import com.lhs.ccb.soi.types.DateTimeI;
import com.lhs.ccb.soi.types.DateTimeIHelper;
import com.lhs.ccb.soi.types.NvElementI;
import com.lhs.ccb.soi.types.NvElementListListIHelper;

public class Connection {

	private ServiceObjectI _serviceObject = null;

	protected org.omg.CORBA.ORB _orb = null;

	public Connection(ServiceObjectI serviceObject) throws Exception {
		_serviceObject = serviceObject;
		_orb = ORB.init(new String[] {}, System.getProperties());
	}

	public HashMap<String, Object> executeSoiCommand(String commandName, HashMap input) throws Exception {
		HashMap<String, Object> output = new HashMap<>();
		NvElementI[] result = null;
		NvElementI[] commandInput = null;
		if(input != null)
			commandInput = convertHashMapToNvElementArr(input);
		result = execute(commandName, commandInput);

		return convertnvElementToHashMap(result);
	}

	/**
	 * 
	 * @param pCommand
	 * @param pInput
	 * @return
	 * @throws Exception
	 */
	public NvElementI[] execute(String pCommand, NvElementI[] pInput) throws Exception {

		NvElementI[] result = null;

		System.out.println("Executing " + pCommand + " ...");

		if (pInput == null) {
			pInput = new NvElementI[0];
		}
		// execution of the command
		try {
			result = _serviceObject.executeI(pCommand, pInput);

		} catch (UnknownCommandExceptionI e) { // the command is unknown to the server
			throw new Exception("Command is unknown " + e.commandname);
		} catch (SecurityExceptionI e) {
			throw new Exception("SecurityExceptionI " + e.reason);

		} catch (ComponentExceptionI e) {
			throw new Exception("ComponentExceptionI " + convertErrorInfoToString(e.errorInformation));
		}

		return result;
	}
	
	

	/**
	 * 
	 * @param info
	 * @return
	 */
	private String convertErrorInfoToString(ErrorInfoI[] info) {
		if (info == null)
			return null;

		StringBuffer buf = new StringBuffer(128);

		// run through all error infos
		final int infoCount = info.length;
		for (int i = 0; i < infoCount; i++) {
			ErrorInfoI currentInfo = info[i];

			buf.append(currentInfo.errorCode + ": ");
			buf.append(currentInfo.message);

			// append a comma separated list of the arguments
			String[] errArgs = currentInfo.errorArguments;
			if (errArgs.length > 0) {
				buf.append(": ");
			}
			for (int j = 0; j < errArgs.length;) {
				buf.append(errArgs[j]);
				if (++j < errArgs.length)
					buf.append(",");
			}

			buf.append('\n');
		}
		return buf.toString();
	}

	public void executeSessionChange(String pBuDesc) throws Exception {
		// BU_ID_PUB parameter
		org.omg.CORBA.Any any = _orb.create_any();
		any.insert_wstring("BU_ID_PUB");
		com.lhs.ccb.soi.types.NvElementI keyNamedValue = new com.lhs.ccb.soi.types.NvElementI("KEY", any, 0, (short) 0);

		// VALUE parameter
		any = _orb.create_any();
		any.insert_wstring(pBuDesc);
		com.lhs.ccb.soi.types.NvElementI valueNamedValue = new com.lhs.ccb.soi.types.NvElementI("VALUE", any, 0,
				(short) 0);

		// build the input: values list
		NvElementI[][] listOfLists = new NvElementI[1][];
		listOfLists[0] = new NvElementI[] { keyNamedValue, valueNamedValue };

		any = _orb.create_any();
		NvElementListListIHelper.insert(any, listOfLists);
		com.lhs.ccb.soi.types.NvElementI namedValue = new com.lhs.ccb.soi.types.NvElementI("values", any, 0, (short) 0);
		NvElementI[] input = new com.lhs.ccb.soi.types.NvElementI[1];
		input[0] = namedValue;

		this.execute("SESSION.CHANGE", input);
	}

	public Object retrieveValueFromAnyForPrimitive(Any any) throws Exception {
		switch (any.type().kind().value()) {
		case (TCKind._tk_boolean):
			return Boolean.valueOf(any.extract_boolean());
		case (TCKind._tk_long):
			return new Integer(any.extract_long());
		case (TCKind._tk_longlong):
			return new Long(any.extract_longlong());
		case (TCKind._tk_wstring):
			return any.extract_wstring();
		case (TCKind._tk_char):
			return new Character(any.extract_char());
		case (TCKind._tk_wchar):
			return new Character(any.extract_wchar());
		case (TCKind._tk_double):
			return new Double(any.extract_double());

		} // If this point is reached, the value could not be extracted.
		throw new Exception(
				"ErrorExtractingValueFromAny" + "Unknown typecode: " + new Integer(any.type().kind().value()));
	}

	HashMap<String, Object> convertnvElementToHashMap(NvElementI[] input) throws Exception {
		HashMap<String, Object> output = new HashMap<>();

		for (int i = 0; i < input.length; i++) {
			
			NvElementI nvElement = input[i];
		   
			Any value = nvElement.value;
			
			if (value.type().kind().value() == TCKind._tk_struct) {
				if(value.type().equal(DateTimeIHelper.type())) {
					DateTimeI dateTimeI = DateTimeIHelper.extract(value);
					Calendar cal = new GregorianCalendar();
					cal.setTimeInMillis(dateTimeI.time);
					Date date = cal.getTime();
					output.put(nvElement.name, date);
				}
				if(value.type().equal(DateIHelper.type())) {
					DateI dateI = DateIHelper.extract(value);
					Date date = new GregorianCalendar(dateI.year, dateI.month, dateI.year).getTime();
					output.put(nvElement.name, date);
				}
			}

			else if (value.type().kind().value() == TCKind._tk_alias) {
				
				// a list is a CORBA type NvElementListListI
				if (value.type().equal(NvElementListListIHelper.type())) {
					
					NvElementI[][] listListNvElement = NvElementListListIHelper.extract(value);
					HashMap[] list = new HashMap[listListNvElement.length];
					
					if (listListNvElement.length > 0) {
						
						for (int j = 0; j < listListNvElement.length; j++) {
							
							NvElementI[] nvElements = listListNvElement[j];
							list[j] = convertnvElementToHashMap(listListNvElement[j]);
						}
						output.put(nvElement.name, list);
					}
				}
			}

			else {
				output.put(nvElement.name, retrieveValueFromAnyForPrimitive(value));
			}
		}

		return output;
	}
	
	public NvElementI[] convertHashMapToNvElementArr(HashMap<String, Object> input) {
		
		NvElementI[] output = new NvElementI[input.size()];
		
		Iterator<String> iter = input.keySet().iterator();
		int i=0;
		while(iter.hasNext()) {
			String key = (String) iter.next();
			Object value = input.get(key);
			org.omg.CORBA.Any any = _orb.create_any();
			insertValueInAny(value, any);
			NvElementI namedValue = new com.lhs.ccb.soi.types.NvElementI(key, any, 0,  (short)0);
			output[i] = namedValue;
			i++;
		}
		
		return output;
		
	}
	
	
	public void insertValueInAny(Object value, Any any) {

		if (value instanceof String)
			any.insert_wstring((String) value);
		
		if (value instanceof Boolean)
			any.insert_boolean((Boolean) value);

		if (value instanceof Integer)
			any.insert_long((Integer) value);

		if (value instanceof Long)
			any.insert_longlong((Long) value);

		if (value instanceof Character)
			any.insert_wchar((Character) value);
		
		if (value instanceof Double)
			any.insert_double((Double) value);
	}

}
