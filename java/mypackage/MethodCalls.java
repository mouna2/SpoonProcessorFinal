package mypackage;

public class MethodCalls {
		public Method2Representation Caller; 
		public Method2Representation Callee;
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
