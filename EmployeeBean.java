import java.util.*;
import java.io.*;
class EmployeeBean implements Comparable<EmployeeBean>,Serializable
{
private int id;
private String name;
private double salary;
public int compareTo(EmployeeBean emp)
{
	if(this.id>emp.id)
		return 1;
	else if(this.id<emp.id)
		return -1;
	else
		return 0;
}
public int hashCode()
{
	return id;
}
public String toString()
{
	return this.id+" "+this.name+" "+this.salary;
}
public boolean equals(Object o)
{
	return (this.hashCode()==o.hashCode());
}
public int getId()
{
	return this.id;
}
public String getName()
{
	return this.name;
}
public double getSalary()
{
	return this.salary;
}
public void setId(int id)
{
 this.id=id;
}
public void setName(String name)
{
	 this.name=name;
}
public void setSalary(double salary)
{
	 this.salary=salary;
}



}