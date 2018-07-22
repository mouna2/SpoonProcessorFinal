package Gantt;

public class testt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "net.sourceforge.ganttproject.shape.PaintCellRenderer.getListCellRendererComponent(Ljavax/swing/JList;Ljava/lang/Object;IZZ)\n" +
	               "net.sourceforge.ganttproject.ChartComponentBase$1.-init-(Lnet/sourceforge/ganttproject/ChartComponentBase;)\n" +
	               "net.sourceforge.ganttproject.GanttCalendar.-init-(III)\n" +
	               "net.sourceforge.ganttproject.GanttCalendar.-init-([[Z)\n";

	StringBuilder buf = new StringBuilder();
	int start = 0;
	for (int i = 0; (i = input.indexOf('(', i)) != -1; i++) {
	    buf.append(input.substring(start, ++i));
	    int arrays = 0;
	    ARGLOOP: for (;;) {
	        start = i;
	        switch (input.charAt(i)) {
	            case ')':
	                break ARGLOOP;
	            case '[':
	                arrays++;   i++;
	                continue ARGLOOP;
	            case 'L':
	                if ((i = input.indexOf(';', i)) == -1)
	                    throw new IllegalArgumentException("Unended object type at index " + start);
	                buf.append(input.substring(start + 1, i).replace('/', '.'));
	                break;
	            case 'Z': buf.append("boolean"); break;
	            case 'B': buf.append("byte");    break;
	            case 'C': buf.append("char");    break;
	            case 'S': buf.append("short");   break;
	            case 'I': buf.append("int");     break;
	            case 'J': buf.append("long");    break;
	            case 'F': buf.append("float");   break;
	            case 'D': buf.append("double");  break;
	            case 'V': buf.append("void");    break;
	            default:
	                throw new UnsupportedOperationException("Unknown type character at index " + i + ": " + input.charAt(i));
	        }
	        for (int j = 0; j < arrays; j++)
	            buf.append("[]");
	        buf.append(';');
	        arrays = 0;
	        i++;
	    }
	}
	String output = buf.append(input.substring(start)).toString();
	System.out.println(output);
	}

}
