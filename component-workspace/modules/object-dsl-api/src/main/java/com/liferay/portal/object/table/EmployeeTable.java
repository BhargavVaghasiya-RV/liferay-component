package com.liferay.portal.object.table;

import java.sql.Types;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

public class EmployeeTable extends BaseTable<EmployeeTable> {
	
	public static final EmployeeTable INSTANCE = new EmployeeTable();

	
	public final Column<EmployeeTable, Long> objectEntryId = createColumn(
		"C_EmployeeId_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY); //You can get it from object review screen
	
	public final Column<EmployeeTable, String> name = createColumn(
			"name_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);//You can get it from object review screen

	private EmployeeTable() {
		super("O_20116_Employee", EmployeeTable::new); //You can get it from object review screen
	}
	
}
