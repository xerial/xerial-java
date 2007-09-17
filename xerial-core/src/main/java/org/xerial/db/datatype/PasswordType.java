//--------------------------------------
// XerialJ Project
//
// PasswordType.java
// Since: 2007/04/13
//
// $Date$
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.datatype;


public class PasswordType extends DataTypeBase
{

	public PasswordType(String name) {
		super(name);
	}


	public String getTypeName() {
		return "password";
	}

}




