package com.liferay.portal.scheduler.api;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.scheduler.SchedulerJobConfiguration;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.TriggerConfiguration;
import com.liferay.portal.scheduler.configuration.SchedulerConfiguration;


@Component(configurationPid = "com.mri.portal.scheduler.ConflictSchedulerJobConfiguration", service = SchedulerJobConfiguration.class)
public class ScheduledWorkJobConfiguration implements SchedulerJobConfiguration {

	@Override
	public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
		return () -> {
			_log.info("Scheduler Process");
		};
	}

	@Override
	public TriggerConfiguration getTriggerConfiguration() {
		return TriggerConfiguration.createTriggerConfiguration(_schedulerConfiguration.interval(), TimeUnit.MINUTE);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_schedulerConfiguration = ConfigurableUtil.createConfigurable(SchedulerConfiguration.class, properties);
	}

	private volatile SchedulerConfiguration _schedulerConfiguration;
	private static final Log _log = LogFactoryUtil.getLog(ScheduledWorkJobConfiguration.class);


}
