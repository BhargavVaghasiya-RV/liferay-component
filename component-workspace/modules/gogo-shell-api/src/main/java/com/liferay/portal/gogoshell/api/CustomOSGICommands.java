package com.liferay.portal.gogoshell.api;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bhargav Vaghasiya
 * Note : We can register custom gogoshell command using this type of component
 */

@Component(
        property = {"osgi.command.function=check", "osgi.command.scope=custom"},
        service = CustomOSGICommands.class
)
public class CustomOSGICommands {

	public void check(String... companyIds) { /* Hit custom:check command from the gogoshell */
		System.out.println("custom gogoshell command called");
		
	}
	
}