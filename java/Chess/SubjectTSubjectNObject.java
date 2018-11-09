package Chess;

public class SubjectTSubjectNObject {
	String MethodName; 
	String RequirementID; 
	String gold2; 
	public String getMethodName() {
		return MethodName;
	}
	public void setMethodName(String methodName) {
		MethodName = methodName;
	}
	public String getRequirementID() {
		return RequirementID;
	}
	public void setRequirementID(String RequirementID) {
		this.RequirementID = RequirementID;
	}
	public String getGoldfinal() {
		return gold2;
	}
	public void setGold2(String gold2) {
		this.goldfinal = gold2;
	}
	public SubjectTSubjectNObject(String methodName, String requirementID, String gold2) {
		super();
		MethodName = methodName;
		RequirementID = requirementID;
		this.goldfinal = gold2;
	}
	public SubjectTSubjectNObject() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SubjectTSubjectNObject [MethodName=" + MethodName + ", RequirementID=" + RequirementID + ", gold2="
				+ gold2 + "]";
	}
	
	
	
	
	
	
}
