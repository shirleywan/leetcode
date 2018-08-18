
package com.huawei.it.ccpc.mongodb.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.huawei.it.ccpc.constant.MongoConfigBean;
import com.huawei.it.jalor5.core.util.StringUtil;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;


/*
MongoDBManager mongodb = null;
mongodb = MongoDBManager.getInstance(true);
DBObject object = MongoBeanUtil.bean2DBObjectSuper(appOperLogVO, "save");
DBCollection collection = mongodb.getDBCollection(appOperLogVO.getClass().getSimpleName());
collection.save(object);
**/
public class MongoDBManager{
	private static Log log = LogFactory.getLog(MongoDBManager.class);
    private static MongoClient mongoClient;
    private static String defaultDBName;
    private static MongoDBManager instance = null;
    private static boolean flag = false;
    public static MongoDBManager getInstance(boolean flag) throws Exception{
    	log.info("ccpc  getInstance strat:" + flag);
    	if ((flag) && (instance == null)) {
    		instance = new MongoDBManager(flag);
    	}
    	log.info("ccpc  getInstance end:" + flag);
    	return instance;
    }
    public static boolean mongodbPoolNull(){
    	boolean flags = false;
    	if (instance != null) {
    		instance = null;
    		mongoClient.close();
    		flags = true;
    	}
    	log.info("ccpc  mongodbPoolNull :" + flag);
    	return flags;
    }
    private MongoDBManager() {
    }
    @SuppressWarnings({ "rawtypes", "unused", "unchecked", "deprecation" })
	private MongoDBManager(boolean flag)throws Exception{
	      MongoConfigBean mongo =MongoConfigUtil.getMongoConfigBean();
	      defaultDBName = mongo.getDbName();
	      log.info("ccpc  get config defaultDBName is :" + defaultDBName);
	      Map<String,String> hostMap = new HashMap<String,String>();
	      List addrs = new ArrayList();
	      MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
	      builder.connectionsPerHost(mongo.getConnectionsPerHost());
	      builder.threadsAllowedToBlockForConnectionMultiplier(mongo.getThreadsAllowedToBlockForConnectionMultiplier());
	      builder.maxWaitTime(mongo.getMaxWaitTime());
	      builder.connectTimeout(mongo.getConnectTimeout());
	      builder.socketTimeout(mongo.getSocketTimeout());
	      builder.socketKeepAlive(mongo.isSocketKeepAlive());
	      MongoClientOptions mco = builder.build();
	      String hostPorts = mongo.getHostPort();
	      if (StringUtil.isNullOrEmpty(hostPorts)) {
	    	  log.info("ccpc get config host posts is null");
	    	  throw new Exception("hostPort  is null!");
	      }
	      if (hostPorts.endsWith(",")) {
	    	  hostPorts = hostPorts.substring(0, hostPorts.length() - 1);
	      }
	      log.info("ccpc  get config host posts is :" + hostPorts);
	      String[] hostPortArray = hostPorts.split(",");
	      int i;
	      if (ArrayUtils.isNotEmpty(hostPortArray)) {
	    	  for (i = 0; i < hostPortArray.length; i++) {
	    		  if (StringUtil.isNullOrEmpty(hostPortArray[i])) {
	    			  log.info("ccpc  host posrt " + i + " is null");
	    		  }
	    		  else
	    		  {
	    			  String[] array = hostPortArray[i].split(":");
	    			  if ((!ArrayUtils.isNotEmpty(array)) || (array.length <= 1) || 
		              (StringUtil.isNullOrEmpty(array[0])) || (StringUtil.isNullOrEmpty(array[1]))) continue;
		              log.info("ccpc  host ip:" + array[0] + "  host port:" + array[1]);
		              hostMap.put(array[0], array[1]);
	    		  }
	    	  }
	      }
	      if ((null != hostMap) && (CollectionUtils.isNotEmpty(hostMap.keySet()))) {
	          for (Entry<String, String> entry : hostMap.entrySet()) {
		         log.info("ccpc  serverAddress ip:" + (String)entry.getKey() + "  serverAddress port:" + (String)entry.getValue());
		          Mongo mongoDB = new Mongo((String)entry.getKey(), Integer.parseInt((String)entry.getValue()));
		          ServerAddress serverAddress = new ServerAddress((String)entry.getKey(), Integer.valueOf((String)entry.getValue()).intValue());
		          addrs.add(serverAddress);
          }
      }
      if (CollectionUtils.isEmpty(addrs)) {
       log.info("ccpc  host or port  is :" + addrs);
        throw new Exception("host or port  is error!");
      }
     log.info("ccpc  mongo authentication :" + mongo.isAuthentication());
      if (mongo.isAuthentication()) {
        if (StringUtil.isNullOrEmpty(mongo.getUserName())) {
         log.info("ccpc  mongo userName is null");
          throw new Exception("userName is null");
        }
        if (StringUtil.isNullOrEmpty(mongo.getPwd())) {
         log.info("ccpc  mongo password is null");
          throw new Exception("pwd is null");
        }
        if (StringUtil.isNullOrEmpty(mongo.getDbName())) {
         log.info("ccpc  mongo dbName is null");
          throw new Exception("dbName is null");
        }
        if (StringUtil.isNullOrEmpty(mongo.getDataBase())) {
          mongo.setDataBase("admin");
        }
        List credentials = new ArrayList();
        credentials.add(MongoCredential.createCredential(mongo.getUserName(), mongo.getDataBase(), mongo.getPwd().toCharArray()));
        mongoClient = new MongoClient(addrs, credentials);//, mco
       log.info("ccpc  get mongoClient is :" + mongoClient);
      }
      else {
        mongoClient = new MongoClient(addrs);//, mco
       log.info("ccpc  get mongoClient is :" + mongoClient);
      }
  }
  /**切换数据库链接**/  
  @SuppressWarnings("deprecation")
public DB getDB(String dbname)
    throws Exception
  {
    if (!StringUtil.isNullOrEmpty(dbname)) {
      DB database = mongoClient.getDB(dbname);
      return database;
    }
    return null;
  }

  @SuppressWarnings("deprecation")
public DB getCurrentDB()
    throws Exception
  {
    if (StringUtil.isNullOrEmpty(defaultDBName)) {
      throw new Exception("defaultDBName is null!");
    }
    return mongoClient.getDB(defaultDBName);
  }

  public DBCollection getDBCollection(String collectionName)
    throws Exception
  {
    DB db = getCurrentDB();
    if (db == null) {
      throw new Exception("getCurrentDB is null!");
    }
    return db.getCollection(collectionName);
  }

  public DBCollection getDBCollection(String dbName, String collName)
    throws Exception
  {
    DB db = getDB(dbName);
    if (db == null) {
      throw new Exception("dbName is null!");
    }
    return db.getCollection(collName);
  }
}
