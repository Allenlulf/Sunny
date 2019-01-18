package sunny.util.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import sunny.util.datastructure.TreeMapUtil;
import sunny.util.datastructure.VDirTreeMap;

/**
 * VDB 生成快照
 * 
 * @author lulf
 */
public class VDBJob implements Job {
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		//先判断当前时间和上一次改动的时间是否小于900s
		
		
		
		//1）获取对应的目录
		String FileDir="D://VC";
		//2)将当前VC转化为VDirTreeMap对象
		VDirTreeMap tree=new TreeMapUtil().CreateTreeMapByDir(FileDir);
		//3) 将tree对象转化为字节序列
		
		
		
	}
}
