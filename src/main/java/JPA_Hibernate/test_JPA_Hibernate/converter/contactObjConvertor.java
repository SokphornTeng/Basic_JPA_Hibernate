package JPA_Hibernate.test_JPA_Hibernate.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class contactObjConvertor implements AttributeConverter<contact_object, String> {

	private static final String SEPARATOR = ", ";
	
	@Override
	public String convertToDatabaseColumn(contact_object attribute) {
	    if(attribute == null ) return null;
	
		StringBuilder sb = new 	StringBuilder();
		
		if(attribute.getPhone() != null && !attribute.getPhone().isEmpty()) {
			sb.append(attribute.getPhone());
			sb.append(SEPARATOR);
		}
		
		if(attribute.getAddress() != null && !attribute.getAddress().isEmpty()) 
			sb.append(attribute.getAddress());
		return  attribute.toString();
	}

	@Override
	public contact_object convertToEntityAttribute(String dbData) {
		
	    if(dbData == null )
		return null;
	    
	    String[] pieces = dbData.split(SEPARATOR);
	    if(pieces == null || pieces.length == 0) return null;
	    
	    contact_object contactObj  = new contact_object();
	    String firstPieces = !pieces[0].isEmpty() ? pieces[0] : null;
	    
	    if(dbData.contains(SEPARATOR)) {
	    	contactObj.setPhone(firstPieces);
	    	
	    	if(pieces.length >= 2 && pieces[1] != null && !pieces[1].isEmpty())
	    		contactObj.setAddress(pieces[1]);
	    } else {
	    	contactObj.setAddress(firstPieces);
	    }
	    return contactObj;
	}

}
