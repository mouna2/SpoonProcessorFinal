import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtMethod;

public interface Visitor{
  public void visit(CtMethod<?> book);
  public void visit(CtConstructor<?> book);

  
}