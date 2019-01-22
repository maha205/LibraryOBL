package Entity;

import java.io.Serializable;

public class Librarian implements Serializable
{
  public String LibrarianRole;
  public String LibrarianOrganizationalAffiliation;
  public String LibrarianName;
  public String LibrarianID;
  public String LibrarianEmail;
  public String LibrarianPhone;
  public int LibrarianSerialNumber;
  
	public Librarian(String LibrarianID,String LibrarianName,String LibrarianPhone ,String LibrarianEmail,int LibrarianSerialNumber,String LibrarianRole,String LibrarianOrganizationalAffiliation) 
	{
		this.LibrarianRole =LibrarianRole;
		this.LibrarianOrganizationalAffiliation =LibrarianOrganizationalAffiliation ;
		this.LibrarianName =LibrarianName ;
		this.LibrarianID= LibrarianID;
		this.LibrarianEmail=LibrarianEmail;
	    this.LibrarianPhone=LibrarianPhone;
		this.LibrarianSerialNumber=LibrarianSerialNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Librarian [LibrarianRole=" + LibrarianRole + ", LibrarianOrganizationalAffiliation="
				+ LibrarianOrganizationalAffiliation + ", LibrarianName=" + LibrarianName + ", LibrarianID="
				+ LibrarianID + ", LibrarianEmail=" + LibrarianEmail + ", LibrarianPhone=" + LibrarianPhone
				+ ", LibrarianSerialNumber=" + LibrarianSerialNumber + ", getLibrarianRole()=" + getLibrarianRole()
				+ ", getLibrarianOrganizationalAffiliation()=" + getLibrarianOrganizationalAffiliation()
				+ ", getLibrarianName()=" + getLibrarianName() + ", getLibrarianID()=" + getLibrarianID()
				+ ", getLibrarianEmail()=" + getLibrarianEmail() + ", getLibrarianPhone()=" + getLibrarianPhone()
				+ ", getLibrarianSerialNumber()=" + getLibrarianSerialNumber() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public String getLibrarianRole() {
		return LibrarianRole;
	}

	public void setLibrarianRole(String librarianRole) {
		LibrarianRole = librarianRole;
	}

	public String getLibrarianOrganizationalAffiliation() {
		return LibrarianOrganizationalAffiliation;
	}

	public void setLibrarianOrganizationalAffiliation(String librarianOrganizationalAffiliation) {
		LibrarianOrganizationalAffiliation = librarianOrganizationalAffiliation;
	}

	public String getLibrarianName() {
		return LibrarianName;
	}

	public void setLibrarianName(String librarianName) {
		LibrarianName = librarianName;
	}

	public String getLibrarianID() {
		return LibrarianID;
	}

	public void setLibrarianID(String librarianID) {
		LibrarianID = librarianID;
	}

	public String getLibrarianEmail() {
		return LibrarianEmail;
	}

	public void setLibrarianEmail(String librarianEmail) {
		LibrarianEmail = librarianEmail;
	}

	public String getLibrarianPhone() {
		return LibrarianPhone;
	}

	public void setLibrarianPhone(String librarianPhone) {
		LibrarianPhone = librarianPhone;
	}

	public int getLibrarianSerialNumber() {
		return LibrarianSerialNumber;
	}

	public void setLibrarianSerialNumber(int librarianSerialNumber) {
		LibrarianSerialNumber = librarianSerialNumber;
	}

}
