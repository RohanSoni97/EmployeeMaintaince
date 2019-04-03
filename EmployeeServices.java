import java.util.*;
import java.io.*;
class EmployeeServices
{
private static LinkedHashSet<EmployeeBean> empSet;
static File f=new File("employeedetails.txt");
static
{
	
	
	if(f.exists())
	{
		try(FileInputStream fis=new FileInputStream(f))
		{
			try(ObjectInputStream ois=new ObjectInputStream(fis))
			{
			empSet=(LinkedHashSet<EmployeeBean>)ois.readObject();
			
			}
			catch(Exception e)
			{
				
			}
		}
		catch(Exception e)
			{
				
			}
	}
	else
	{
	empSet=new LinkedHashSet<EmployeeBean>();	
	}
	
}

public static boolean addEmployee(EmployeeBean emp)
{
	return empSet.add(emp);
}
public static Set<EmployeeBean> getAllEmployees()
{
	return Collections.unmodifiableSet(empSet); //read only
}
public static Set<EmployeeBean> getEmployeesInAscOrderById()
{
	return new TreeSet<EmployeeBean>(empSet); //read only
}
public static List<EmployeeBean> getEmployeesInAlphaOrder()
{
	List<EmployeeBean> emplist=new ArrayList<EmployeeBean>(empSet);
	Collections.sort(emplist,new NameComparator());
	return emplist; 
}
public static List<EmployeeBean> getEmployeesInDescOrderBySalary()
{
	List<EmployeeBean> emplist=new ArrayList<EmployeeBean>(empSet);
	Collections.sort(emplist,new SalaryComparator());
	return emplist; 
}

public static EmployeeBean searchById(int id)
{
	for(EmployeeBean emp:empSet)
	{
		if(emp.getId()==id)
		{
			return emp;
		}
	}
	return null;
}
public static boolean deleteById(int id)
{
	return empSet.remove(searchById(id));
}
public static boolean saveData()
{
	try(FileOutputStream fos=new FileOutputStream(f))
	{
			try(ObjectOutputStream oos=new ObjectOutputStream(fos))
			{
				oos.writeObject(empSet);
				return true;
			}
			catch(Exception e)
			{
				
			}
	}
	catch(Exception e)
	{
				
	}
	return false;
}
}