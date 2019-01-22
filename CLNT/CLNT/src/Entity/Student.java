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
	/**
 * @return the studentId
 */
public String getStudentId() {
	return StudentId;
}

/**
 * @param studentId the studentId to set
 */
public void setStudentId(String studentId) {
	StudentId = studentId;
}

/**
 * @return the studentName
 */
public String getStudentName() {
	return StudentName;
}

/**
 * @param studentName the studentName to set
 */
public void setStudentName(String studentName) {
	StudentName = studentName;
}

/**
 * @return the statusMembership
 */
public String getStatusMembership() {
	return StatusMembership;
}

/**
 * @param statusMembership the statusMembership to set
 */
public void setStatusMembership(String statusMembership) {
	StatusMembership = statusMembership;
}

/**
 * @return the phone
 */
public String getPhone() {
	return phone;
}

/**
 * @param phone the phone to set
 */
public void setPhone(String phone) {
	this.phone = phone;
}

/**
 * @return the email
 */
public String getEmail() {
	return Email;
}

/**
 * @param email the email to set
 */
public void setEmail(String email) {
	Email = email;
}

/**
 * @return the subscriptionNumber
 */
public int getSubscriptionNumber() {
	return subscriptionNumber;
}

/**
 * @param subscriptionNumber the subscriptionNumber to set
 */
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
