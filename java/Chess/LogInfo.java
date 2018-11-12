package Chess;

import java.util.ArrayList;
import java.util.List;

public class LogInfo {
	String MethodID; 
	String MethodName; 
	String ClassID; 
	String ClassName; 
	String TraceValue;
	String OwnerClassPrediction; 
	String PrecisionRecall; 
	List<String> IterationValues= new ArrayList<String>();
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
		return "LogInfo [MethodID=" + MethodID + ", MethodName=" + MethodName + ", ClassID=" + ClassID + ", ClassName="
				+ ClassName + ", TraceValue=" + TraceValue + ", OwnerClassPrediction=" + OwnerClassPrediction
				+ ", PrecisionRecall=" + PrecisionRecall + ", IterationValues=" + toString2(IterationValues) + "]";
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
