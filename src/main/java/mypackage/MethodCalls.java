package mypackage;

public class MethodCalls {
		Method2Representation Caller; 
		Method2Representation Callee;
		public MethodCalls(Method2Representation caller, Method2Representation callee) {
			super();
			Caller = caller;
			Callee = callee;
		}
		
		public MethodCalls() {
			// TODO Auto-generated constructor stub
		}
		public Method2Representation getCaller() {
			return Caller;
		}
		public void setCaller(Method2Representation caller) {
			Caller = caller;
		}
		public Method2Representation getCallee() {
			return Callee;
		}
		public void setCallee(Method2Representation callee) {
			Callee = callee;
		} 
		
		
		
}
