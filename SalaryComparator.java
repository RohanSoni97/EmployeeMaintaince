import java.util.*;
class SalaryComparator implements Comparator<EmployeeBean>
{
public int compare(EmployeeBean e1,EmployeeBean e2)
{
if(e1.getSalary()>e2.getSalary())
return -1;
else if(e1.getSalary()>e2.getSalary())
return 1;
else
return 0;
}
}