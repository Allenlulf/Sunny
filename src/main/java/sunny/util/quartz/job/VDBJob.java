package sunny.util.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * VDB 生成快照
 * 
 * @author lulf
 */
public class VDBJob implements Job {
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("11");
	}
}
