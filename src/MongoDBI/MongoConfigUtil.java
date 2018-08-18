/**
 * 
 */
package com.huawei.it.ccpc.mongodb.util;

import java.util.Map;

import com.huawei.it.ccpc.constant.MongoConfigBean;
import com.huawei.it.ccpc.jalor.util.JalorUtil;
import com.huawei.it.ccpc.security.aes.util.AESUtil;
import com.huawei.it.common.encryption.exception.AppException;
import com.huawei.it.jalor5.core.exception.ApplicationException;
import com.huawei.it.jalor5.core.ioc.Jalor;
import com.huawei.it.jalor5.core.log.ILogger;
import com.huawei.it.jalor5.core.log.JalorLoggerFactory;
import com.huawei.it.jalor5.lookup.dao.ILookupItemDao;

/**
 * @author gWX408562
 *
 */
@SuppressWarnings("unused")
public class MongoConfigUtil
{
  private static final ILogger logger = JalorLoggerFactory.getLogger(MongoConfigUtil.class);

  private static final String AUTHENTICATION = "AUTHENTICATION";
  private static final String USER_NAME = "USER_NAME";
  private static final String PASS_WORD = "PASS_WORD";
  private static final String HOST_PORT = "HOST_PORT";
  private static final String DB_NAME = "DB_NAME";
  private static final String CONNECTIONS_HOST = "CONNECTIONS_HOST";
  private static final String THREAD_ALLOWED_FOR_CONNECTIONS = "THREAD_ALLOWED_FOR_CONNECTIONS";
  private static final String MAX_WAIT_TIME = "MAX_WAIT_TIME";
  private static final String CONNECT_TIME_OUT = "CONNECT_TIME_OUT";
  private static final String SOCKET_TIME_OUT = "SOCKET_TIME_OUT";
  private static final String SOCKET_KEEP_ALIVE = "SOCKET_KEEP_ALIVE";
  private static final String DATA_BASE = "DATA_BASE";
  
  private static AESUtil aesUtil = null;
  
  /**动态加载配置数据 
 * @throws AppException **/
  @SuppressWarnings("rawtypes")
public static MongoConfigBean getMongoConfigBean() throws ApplicationException, AppException
  {
	  ILookupItemDao dao = (ILookupItemDao)Jalor.getContext().getBean("ILookupItemDao", ILookupItemDao.class);
	  MongoConfigBean config = new MongoConfigBean();
	  //动态获取配置信息
	  Map<String, String>  map = null;
	  map = JalorUtil.packageLookupItemMap("mongoDataBase", "zh_CN");
	  for (Map.Entry entry : map.entrySet()) {
	       String key = (String)entry.getKey(); 
	       if ("AUTHENTICATION".equals(key)) {
	         if ("Y".equals((String)entry.getValue()))
	           config.setAuthentication(true);
	       }
	       else if ("USER_NAME".equals(key))
	         config.setUserName((String)entry.getValue());
	       else if ("PASS_WORD".equals(key))
	       {
	    	  /**解密*/
			  config.setPwd(AESUtil.decryptPassword((String)entry.getValue()));
	       } else if ("HOST_PORT".equals(key))
	         config.setHostPort((String)entry.getValue());
	       else if ("DB_NAME".equals(key))
	         config.setDbName((String)entry.getValue());
	       else if ("CONNECTIONS_HOST".equals(key))
	         config.setConnectionsPerHost(Integer.valueOf((String)entry.getValue()).intValue());
	       else if ("THREAD_ALLOWED_FOR_CONNECTIONS".equals(key))
	         config.setThreadsAllowedToBlockForConnectionMultiplier(Integer.valueOf((String)entry.getValue()).intValue());
	       else if ("MAX_WAIT_TIME".equals(key))
	         config.setMaxWaitTime(Integer.valueOf((String)entry.getValue()).intValue());
	       else if ("CONNECT_TIME_OUT".equals(key))
	         config.setConnectTimeout(Integer.valueOf((String)entry.getValue()).intValue());
	       else if ("SOCKET_TIME_OUT".equals(key))
	         config.setSocketTimeout(Integer.valueOf((String)entry.getValue()).intValue());
	       else if ("SOCKET_KEEP_ALIVE".equals(key)) {
	         if ("N".equals((String)entry.getValue()))
	           config.setSocketKeepAlive(false);
	       }
	       else if ("DATA_BASE".equals(key)) {
	         config.setDataBase((String)entry.getValue());
	       }
	    }
		return config;
  	}
}
