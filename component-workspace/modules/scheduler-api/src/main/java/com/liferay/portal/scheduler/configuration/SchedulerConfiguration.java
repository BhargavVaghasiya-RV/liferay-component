package com.liferay.portal.scheduler.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "infrastructure")
@Meta.OCD(
	id = "com.liferay.portal.scheduler.configuration.SchedulerConfiguration",
	localization = "content/Language",
	name = "scheduler-configuration"
)
public interface SchedulerConfiguration {
	@Meta.AD(
			deflt = "5", description = "interval-help",
			name = "interval", required = false
		)
		public int interval();

}
