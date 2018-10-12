package mypackage;

public class Parameter2 {
	String parameterName; 
	ClassRepresentation2 ParameterType;
	ClassRepresentation2 OwnerClass;
	String isReturn;
	String methodname; 
	public String getParameterName() {
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	
	public String getMethodname() {
		return methodname;
	}
	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}
	public ClassRepresentation2 getParameterType() {
		return ParameterType;
	}
	public void setParameterType(ClassRepresentation2 parameterType) {
		ParameterType = parameterType;
	}
	public ClassRepresentation2 getOwnerClass() {
		return OwnerClass;
	}
	public void setOwnerClass(ClassRepresentation2 ownerClass) {
		OwnerClass = ownerClass;
	}
	public String getIsReturn() {
		return isReturn;
	}
	public void setIsReturn(String isReturn) {
		this.isReturn = isReturn;
	}
	public Parameter2(String parameterName, ClassRepresentation2 parameterType, ClassRepresentation2 ownerClass,
			String isReturn) {
		super();
		this.parameterName = parameterName;
		ParameterType = parameterType;
		OwnerClass = ownerClass;
		this.isReturn = isReturn;
	}
	public Parameter2() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Parameter [parameterName=" + parameterName + ", ParameterType=" + ParameterType.toString() + ", OwnerClass="
				+ OwnerClass.toString() + ", methodname=" + methodname  + ", isReturn=" + isReturn + "]";
	} 
	
	
	
	
}