package com.liferay.portal.object.dsl.api;

import com.liferay.object.service.ObjectEntryLocalServiceUtil;
import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.object.table.EmployeeTable;

public class ObjectsUtil {
	
	/*Developer Note: The purpose of this class is to instruct developers on how to call DSL queries for custom objects.

	For any service call, use @reference instead of direct util methods.*/
	
	public static long getEmployeeCount(){
		
		/*
		 * Prepare the fully qualified DSL query as per the requirements. We can add
		 * various filters, joins to this query and execute it.
		 */
		DSLQuery query = DSLQueryFactoryUtil
			    .count()
			    .from(EmployeeTable.INSTANCE);
		return ObjectEntryLocalServiceUtil
				.dslQueryCount(query); 
	}
}
