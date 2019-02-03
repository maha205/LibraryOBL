package Entity;

import java.io.Serializable;


/**
 * 
 * Librarian
 *
 */
public class Librarian implements Serializable
{
  public String LibrarianRole;
  public String LibrarianOrganizationalAffiliation;
  public String LibrarianName;
  public String LibrarianID;
  public String LibrarianEmail;
  public String LibrarianPhone;
  public int LibrarianSerialNumber;
  
  /**
   * 
   * @param LibrarianID
   * @param LibrarianName
   * @param LibrarianPhone
   * @param LibrarianEmail
   * @param LibrarianSerialNumber
   * @param LibrarianRole
   * @param LibrarianOrganizationalAffiliation
   */
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
	/**
	 * Convert to string
	 */
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

	
	/**
	 * Getting LibrarianRole
	 * @return LibrarianRole
	 */
	public String getLibrarianRole() {
		return LibrarianRole;
	}

	/**
	 * Setting LibrarianRole
	 * @param librarianRole
	 */
	public void setLibrarianRole(String librarianRole) {
		LibrarianRole = librarianRole;
	}

	/**
	 * Getting LibrarianOrganizationalAffiliation
	 * @return LibrarianOrganizationalAffiliation
	 */
	public String getLibrarianOrganizationalAffiliation() {
		return LibrarianOrganizationalAffiliation;
	}

	/**
	 * Setting LibrarianOrganizationalAffiliation
	 * @param librarianOrganizationalAffiliation
	 */
	public void setLibrarianOrganizationalAffiliation(String librarianOrganizationalAffiliation) {
		LibrarianOrganizationalAffiliation = librarianOrganizationalAffiliation;
	}

	/**
	 * Getting LibrarianName
	 * @return LibrarianName
	 */
	public String getLibrarianName() {
		return LibrarianName;
	}

	/**
	 * Setting LibrarianName
	 * @param librarianName
	 */
	public void setLibrarianName(String librarianName) {
		LibrarianName = librarianName;
	}

	/**
	 * Getting LibrarianID
	 * @return LibrarianID
	 */
	public String getLibrarianID() {
		return LibrarianID;
	}

	/**
	 * Setting LibrarianID
	 * @param librarianID
	 */
	public void setLibrarianID(String librarianID) {
		LibrarianID = librarianID;
	}

	/**
	 * Getting LibrarianEmail
	 * @return LibrarianEmail
	 */
	public String getLibrarianEmail() {
		return LibrarianEmail;
	}

	/**
	 * Setting LibrarianEmail
	 * @param librarianEmail
	 */
	public void setLibrarianEmail(String librarianEmail) {
		LibrarianEmail = librarianEmail;
	}

	/**
	 * Getting LibrarianPhone
	 * @return LibrarianPhone
	 */
	public String getLibrarianPhone() {
		return LibrarianPhone;
	}

	/**
	 * Setting LibrarianPhone
	 * @param librarianPhone
	 */
	public void setLibrarianPhone(String librarianPhone) {
		LibrarianPhone = librarianPhone;
	}

	/**
	 *  Getting LibrarianSerialNumber
	 * @return LibrarianSerialNumber
	 */
	public int getLibrarianSerialNumber() {
		return LibrarianSerialNumber;
	}

	/**
	 * Setting LibrarianSerialNumber
	 * @param librarianSerialNumber
	 */
	public void setLibrarianSerialNumber(int librarianSerialNumber) {
		LibrarianSerialNumber = librarianSerialNumber;
	}

}
