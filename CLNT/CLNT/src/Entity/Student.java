package Entity;

import java.io.Serializable;

public class Student implements Serializable
{
  public String StudentId;
  public String StudentName;
  public String StatusMembership;
  public String phone;
  public String Email;
  public int subscriptionNumber;
   
	public Student(String StudentId,String StudentName,String StatusMembership,String phone,String Email,int subscriptionNumber) 
	{
		this.StudentId=StudentId;
		this.StudentName=StudentName ;
		this.StatusMembership =StatusMembership;
		this.phone=phone;
		this.Email=Email;
		this.subscriptionNumber=subscriptionNumber ;
	}
	
public String getStudentId() {
	return StudentId;
}


public void setStudentId(String studentId) {
	StudentId = studentId;
}

public String getStudentName() {
	return StudentName;
}

public void setStudentName(String studentName) {
	StudentName = studentName;
}

public String getStatusMembership() {
	return StatusMembership;
}

public void setStatusMembership(String statusMembership) {
	StatusMembership = statusMembership;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}

public int getSubscriptionNumber() {
	return subscriptionNumber;
}

public void setSubscriptionNumber(int subscriptionNumber) {
	this.subscriptionNumber = subscriptionNumber;
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Student [StudentId=" + StudentId + ", StudentName=" + StudentName + ", StatusMembership=" + StatusMembership
			+ ", phone=" + phone + ", Email=" + Email + ", subscriptionNumber=" + subscriptionNumber + ", getClass()="
			+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}

}
