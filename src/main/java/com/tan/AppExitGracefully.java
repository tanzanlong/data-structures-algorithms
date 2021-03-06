package com.tan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 应用优雅退出方法
 * @author peng
 */
@Component
public class AppExitGracefully implements Runnable{

	private static Logger logger = LoggerFactory.getLogger(AppExitGracefully.class);
			
	//当前程序是否停止运行
	private static boolean stop;
	
	public static boolean isStop() {
		return stop;
	}

	public static void setStop(boolean stop) {
		AppExitGracefully.stop = stop;
	}
	
	@Override
	public void run() {
		logger.info("Exit app...");
		AppExitGracefully.setStop(true);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("Exit app success");
	}
}
