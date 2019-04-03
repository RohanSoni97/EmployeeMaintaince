import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;
class EMS
{
public static void main(String args[])
{
	try(InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr))
{
do
{
	System.out.println("1. Add Employee");
	System.out.println("2. View All");
	System.out.println("3. Search By Id");
	System.out.println("4. Delete By Id");
	System.out.println("5. Update By Id");
	System.out.println("6. View in Asec Order by Id");
	System.out.println("7. EmployeesInAlphaOrder");
	System.out.println("8. EmployeesInDescOrder By Salary");
	System.out.println("9. Exit");
	System.out.print("Enter your choice(1-6)");
	String choice=br.readLine();
	switch(choice)
	{
		case "1":
		{
			EmployeeBean emp=new EmployeeBean();
			System.out.print("Enter Id");
			emp.setId(Integer.parseInt(br.readLine()));
			System.out.print("Enter Name");
			emp.setName(br.readLine());
			System.out.print("Enter Salary");
			emp.setSalary(Double.parseDouble(br.readLine()));
			if(EmployeeServices.addEmployee(emp))
			{
					System.out.println("Record inserted quickly");
			}
			else
			{
					System.out.println("Record not inserted ");
			}
		}
		break;
		case "2":
		{
				Set<EmployeeBean> emp=EmployeeServices.getAllEmployees();
				Iterator<EmployeeBean> itr=emp.iterator();
				while(itr.hasNext()){
				System.out.println(itr.next());}
		}
		break;
		case "3":
		{
						System.out.print("Enter id");
						int id=Integer.parseInt(br.readLine());
						EmployeeBean emp=EmployeeServices.searchById(id);
						if(emp==null)
								System.out.println("Record not found ");
							else
								System.out.println(emp);
		}
		break;
		case "4":
		{
							System.out.print("Enter id");
						int id=Integer.parseInt(br.readLine());
						
						if(EmployeeServices.deleteById(id))
								System.out.println("Record deleted ");
							else
								System.out.println("Record not found ");

		}
		break;
		case "5":
		{
						System.out.print("Enter id");
						int id=Integer.parseInt(br.readLine());
						EmployeeBean emp=EmployeeServices.searchById(id);
						if(emp==null)
								System.out.println("Record not found ");
							else{
								System.out.println(emp);
								System.out.print("Enter Update name");
								emp.setName(br.readLine());
								System.out.print("Enter Update salary");
								emp.setSalary(Double.parseDouble(br.readLine()));
								
							}
		}
		break;
		case "6":
		{
			Set<EmployeeBean> emp=EmployeeServices.getEmployeesInAscOrderById();
				Iterator<EmployeeBean> itr=emp.iterator();
				while(itr.hasNext()){
				System.out.println(itr.next());}
		}
		break;
		case "7":{
		List<EmployeeBean> emp=EmployeeServices.getEmployeesInAlphaOrder();
		Iterator<EmployeeBean> itr=emp.iterator();
				while(itr.hasNext()){
				System.out.println(itr.next());}
		}
		break;
		case "8":
		{
			List<EmployeeBean> emp=EmployeeServices.getEmployeesInDescOrderBySalary();
		Iterator<EmployeeBean> itr=emp.iterator();
				while(itr.hasNext()){
				System.out.println(itr.next());}
		}
		break;
		case "9":{
		if(EmployeeServices.saveData())
			System.out.println("Data Saved Successfully");
		else
			System.out.println("Data not Saved ");
		System.out.println("Thank You");
		System.exit(0);}
		break;
		default:
		System.out.println("Invalid Choice");
	}
}while(true);	
}
catch(Exception e)
{
	System.out.println(e);
}
}
}