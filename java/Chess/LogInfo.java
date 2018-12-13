package Chess;

import java.util.ArrayList;
import java.util.List;

public class LogInfo {
	String MethodID; 
	String MethodName; 
	String RequirementID; 
	String RequirementName; 
	String ClassID; 
	String ClassName; 
	String TraceValue;
	String TraceClassOldValue; 
	String TraceClassNewValue; 
	String OwnerClassPrediction; 
	String Prediction; 
	public String PrecisionRecall; 
	String GoldFinal; 
	String SubjectGold; 
	List<String> IterationValues= new ArrayList<String>();
	boolean myFlag; 
	
	
	public boolean isMyFlag() {
		return myFlag;
	}
	public void setMyFlag(boolean myFlag) {
		this.myFlag = myFlag;
	}
	public String getGoldFinal() {
		return GoldFinal;
	}
	public void setGoldFinal(String goldFinal) {
		GoldFinal = goldFinal;
	}
	public String getSubjectGold() {
		return SubjectGold;
	}
	public void setSubjectGold(String subjectGold) {
		SubjectGold = subjectGold;
	}
	public String getPrediction() {
		return Prediction;
	}
	public void setPrediction(String prediction) {
		Prediction = prediction;
	}
	public String getTraceClassOldValue() {
		return TraceClassOldValue;
	}
	public void setTraceClassOldValue(String traceClassOldValue) {
		TraceClassOldValue = traceClassOldValue;
	}
	public String getTraceClassNewValue() {
		return TraceClassNewValue;
	}
	public void setTraceClassNewValue(String traceClassNewValue) {
		TraceClassNewValue = traceClassNewValue;
	}
	public String getMethodID() {
		return MethodID;
	}
	public void setMethodID(String methodID) {
		MethodID = methodID;
	}
	public String getMethodName() {
		return MethodName;
	}
	public void setMethodName(String methodName) {
		MethodName = methodName;
	}
	public String getClassID() {
		return ClassID;
	}
	public void setClassID(String classID) {
		ClassID = classID;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public String getTraceValue() {
		return TraceValue;
	}
	public void setTraceValue(String traceValue) {
		TraceValue = traceValue;
	}
	public List<String> getIterationValues() {
		return IterationValues;
	}
	public void setIterationValues(List<String> iterationValues) {
		IterationValues = iterationValues;
	}
	
	
	public String getOwnerClassPrediction() {
		return OwnerClassPrediction;
	}
	public void setOwnerClassPrediction(String ownerClassPrediction) {
		OwnerClassPrediction = ownerClassPrediction;
	}
	
	public String getPrecisionRecall() {
		return PrecisionRecall;
	}
	public void setPrecisionRecall(String precisionRecall) {
		PrecisionRecall = precisionRecall;
	}
	public LogInfo() {
		super();
	}
	
	
	
	
	@Override
	public String toString() {
		System.out.println(MethodName);
		MethodName=MethodName.replaceAll(",", "/"); 
		return MethodID+","+MethodName+","+RequirementID+","+RequirementName+","+ClassID+","+ClassName+","+TraceValue+","+TraceClassOldValue+","+TraceClassNewValue+","+OwnerClassPrediction
				+","+PrecisionRecall	+","+toString2(IterationValues); 
		
	}
	
	public String getRequirementID() {
		return RequirementID;
	}
	public void setRequirementID(String requirementID) {
		RequirementID = requirementID;
	}
	public String getRequirementName() {
		return RequirementName;
	}
	public void setRequirementName(String requirementName) {
		RequirementName = requirementName;
	}
	public String toString2(List<String> IterationValues) {
		 String FinalString=""; 
		 int it=0; 
		for(String s: IterationValues) {
			if(it+1<IterationValues.size()) {
				FinalString=FinalString+s+","; 
				it++; 	
			}
			
			else if(it+1==IterationValues.size()) {
				FinalString=FinalString+s; 
			}
			
		}
		return FinalString;
		
	}
	
	
	
	
}
