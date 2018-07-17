package Chess;

import java.util.List;

public class param {
	String parametername; 
	String parametertype; 
	String parameterclass; 
	String classid; 
	String classname; 
	String methodid; 
	String methodname; 
	String isreturn;
	public String getParametername() {
		return parametername;
	}
	public void setParametername(String parametername) {
		this.parametername = parametername;
	}
	public String getParametertype() {
		return parametertype;
	}
	public void setParametertype(String parametertype) {
		this.parametertype = parametertype;
	}
	public String getParameterclass() {
		return parameterclass;
	}
	public void setParameterclass(String parameterclass) {
		this.parameterclass = parameterclass;
	}
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getMethodid() {
		return methodid;
	}
	public void setMethodid(String methodid) {
		this.methodid = methodid;
	}
	public String getMethodname() {
		return methodname;
	}
	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}
	public String getIsreturn() {
		return isreturn;
	}
	public void setIsreturn(String isreturn) {
		this.isreturn = isreturn;
	}
	public param(String parametername, String parametertype, String parameterclass, String classid, String classname,
			String methodid, String methodname, String isreturn) {
		super();
		this.parametername = parametername;
		this.parametertype = parametertype;
		this.parameterclass = parameterclass;
		this.classid = classid;
		this.classname = classname;
		this.methodid = methodid;
		this.methodname = methodname;
		this.isreturn = isreturn;
	} 
	
	
	
}
