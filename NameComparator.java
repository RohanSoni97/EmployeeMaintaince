import java.util.*;
class NameComparator implements Comparator<EmployeeBean>
{
public int compare(EmployeeBean e1,EmployeeBean e2)
{
	return e1.getName().compareTo(e2.getName());
}
}