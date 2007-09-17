//--------------------------------------
// XerialJ Project
//
// BeanReader.java
// Since: May 30, 2007
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.sql;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.BeanProcessor;

public class BeanReader<Bean> implements ResultSetHandler<Bean> 
{
	BeanProcessor beanProcessor = new BeanProcessor();
	Class beanClass;
	
	public BeanReader(Bean beanClass)
	{
		this.beanClass = (Class) beanClass;
	}

	@SuppressWarnings("unchecked")
	public Bean handle(ResultSet rs) throws SQLException {
		return (Bean) beanProcessor.toBean(rs, beanClass);
	}

	
}




