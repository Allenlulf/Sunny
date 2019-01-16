package sunny.util.vcontrol;

import sunny.util.quartz.QuartzUtil;
import sunny.util.quartz.job.VDBJob;

/**
 * VControl初始类
 * 
 * @author lulf
 */
public class VControlUtil {

	// 默认的快照策略 即900s存在更改操作的话,会触发一次快照生成
	private static int DEFALUTTIME = 3;

	// 默认持久化策略是VDB
	// 三种持久化侧率 VDB,VOF及ALL
	// VDB 是快照模式
	// VOF 是记录指令
	// ALL 是快照结合指令
	private static String PERSISTENCETYPE = "VDB";

	public VControlUtil() {
		this(PERSISTENCETYPE);
	}

	public VControlUtil(String pERSISTENCETYPE) {
		this(pERSISTENCETYPE, DEFALUTTIME);
	}

	public VControlUtil(String pERSISTENCETYPE, int dEFALUTTIME) {
		this.PERSISTENCETYPE = pERSISTENCETYPE;
		this.DEFALUTTIME = dEFALUTTIME;
	}

	public void startVC() {
		// 如果是VDB或者是ALL模式的,起一个Quartz来定时生成快照
		if (PERSISTENCETYPE.equals("VDB") || PERSISTENCETYPE.equals("ALL")) {
			// 1)初始化工具类Joe
			QuartzUtil q = new QuartzUtil();
			// 2)新增俩个job,并且启动【建议采取第一种写法，命名job名称，名字冲突会报错，后者的写法只能使用一次】
			q.addJob("JOE", VDBJob.class, DEFALUTTIME);
		}
	}
}
