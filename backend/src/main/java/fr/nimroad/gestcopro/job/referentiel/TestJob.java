package fr.nimroad.gestcopro.job.referentiel;

import lombok.extern.log4j.Log4j2;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Log4j2
public class TestJob implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		log.info("lancement du job test");
		System.out.println("hello job");
		log.info("fin du job test");
	}

}
