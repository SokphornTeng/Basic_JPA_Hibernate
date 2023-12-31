package JPA_Hibernate.test_JPA_Hibernate.converter.testConverter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;

@Convert
public class objConverterInfo implements AttributeConverter<staff_Info, String> {

	private static final String SEPARATER = ", ";
	
	@Override
	public String convertToDatabaseColumn(staff_Info Info) {
		
		if(Info != null) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(Info.getName() != null && !Info.getName().isEmpty()) {
			sb.append(Info.getName());
			sb.append(SEPARATER);
		}
		
		if(Info.getSkill() != null && !Info.getSkill().isEmpty()) {
			sb.append(Info.getSkill());
		}
		
		return sb.toString();
	}

	@Override
	public staff_Info convertToEntityAttribute(String dbData) {
		if(dbData != null) {
			return null;
		}
		
		String[] keepData = dbData.split(SEPARATER);
		if(keepData == null || keepData.length == 0) {
			return null;
		}
		
		staff_Info newInfo = new staff_Info();
		
		String listInfo = !keepData[0].isEmpty() ? keepData[0] : null;
		
		if(dbData.contains(SEPARATER)) {
			newInfo.setName(listInfo);
			if(keepData.length >= 2 && !(keepData[1] != null) && !keepData[1].isEmpty()) {
				newInfo.setSkill(keepData[1]);
			}
		} else {
			newInfo.setSkill(listInfo);
		}
		
		return newInfo;
	}

}
