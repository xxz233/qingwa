package net.qinghr.qingwa.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import net.qinghr.qingwa.vo.SystemInfo;

public class SystemIfoUtil {
	public static SystemInfo getSystemInfo(){
		SystemInfo systemInfo = new SystemInfo();
		systemInfo.setOsName(System.getProperty("os.name"));
		systemInfo.setOsArch(System.getProperty("os.arch"));
		systemInfo.setOsVersion(System.getProperty("os.vesion"));
		try {
			systemInfo.setHostIp(getIpAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return systemInfo;
	}
	private static String getIpAddress() throws UnknownHostException {  
        InetAddress address = InetAddress.getLocalHost();  
  
        return address.getHostAddress();  
    }  
}
