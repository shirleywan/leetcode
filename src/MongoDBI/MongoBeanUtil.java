/**
 * 
 */
package com.huawei.it.ccpc.mongodb.util;



import com.huawei.it.jalor5.core.util.StringUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
public class MongoBeanUtil
{
  public static <T> DBObject bean2DBObject(T bean)
    throws IllegalArgumentException, IllegalAccessException
  {
    if (bean == null) {
      return null;
    }
    DBObject dbObject = new BasicDBObject();

    Field[] fields = bean.getClass().getDeclaredFields();
    if ((null == fields) || (fields.length < 1)) {
      return null;
    }
    for (Field field : fields)
    {
      String varName = field.getName();
      if ("serialVersionUID".equals(varName))
      {
        continue;
      }
      boolean accessFlag = field.isAccessible();
      if (!accessFlag) {
        field.setAccessible(true);
      }
      Object param = field.get(bean);
      if (param == null)
        continue;
      if ((param instanceof Integer)) {
        int value = ((Integer)param).intValue();
        dbObject.put(varName, Integer.valueOf(value));
      } else if ((param instanceof String)) {
        String value = (String)param;
        dbObject.put(varName, value);
      } else if ((param instanceof Double)) {
        double value = ((Double)param).doubleValue();
        dbObject.put(varName, Double.valueOf(value));
      } else if ((param instanceof Float)) {
        float value = ((Float)param).floatValue();
        dbObject.put(varName, Float.valueOf(value));
      } else if ((param instanceof Long)) {
        long value = ((Long)param).longValue();
        dbObject.put(varName, Long.valueOf(value));
      } else if ((param instanceof Boolean)) {
        boolean value = ((Boolean)param).booleanValue();
        dbObject.put(varName, Boolean.valueOf(value));
      } else if ((param instanceof Date)) {
        Date value = (Date)param;
        dbObject.put(varName, value);
      }
      field.setAccessible(accessFlag);
    }
    return dbObject;
  }
  public static <T> DBObject bean2DBObjectSuper(T bean, String state) throws Exception
  {
    if (bean == null) {
      return null;
    }
    DBObject dbObject = new BasicDBObject();
    encapsulatedObject(dbObject, bean, bean.getClass(), state);
    return dbObject;
  }
  @SuppressWarnings("rawtypes")
private static <T> void encapsulatedObject(DBObject dbObject, T bean, Class<?> clazz, String state)
    throws Exception
  {
    if (clazz != Object.class) {
      Field[] fields = clazz.getDeclaredFields();
      for (Field field : fields) {
        String type = field.getGenericType().toString();
        String name = field.getName();
        if ((name.equals("resposeCost")) && ("find".equals(state))) {
          continue;
        }
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        if (type.equals("class java.lang.String"))
        {
          Method m = clazz.getMethod("get" + name, new Class[0]);
          String value = (String)m.invoke(bean, new Object[0]);
          if (!StringUtil.isNullOrEmpty(value))
            dbObject.put(name, value);
        }
        else if (type.equals("class java.lang.Integer")) {
          Method m = clazz.getMethod("get" + name, new Class[0]);
          Integer value = (Integer)m.invoke(bean, new Object[0]);
          if (null != value) {
            dbObject.put(name, value);
          }
        }
        else if (type.equals("class java.lang.Long")) {
          Method m = clazz.getMethod("get" + name, new Class[0]);
          Long value = (Long)m.invoke(bean, new Object[0]);
          if ((!"".equals(value)) || (null != value))
            dbObject.put(name, value);
        }
        else if (type.equals("class java.lang.Boolean")) {
          Method m = clazz.getMethod("get" + name, new Class[0]);
          Boolean value = (Boolean)m.invoke(bean, new Object[0]);
          if ((!"".equals(value)) || (null != value))
            dbObject.put(name, value);
        }
        else if (type.equals("class java.lang.Double")) {
          Method m = clazz.getMethod("get" + name, new Class[0]);
          Double value = (Double)m.invoke(bean, new Object[0]);
          if ((!"".equals(value)) || (null != value))
            dbObject.put(name, value);
        }
        else if (type.equals("class java.lang.Float")) {
          Method m = clazz.getMethod("get" + name, new Class[0]);
          Float value = (Float)m.invoke(bean, new Object[0]);
          if ((!"".equals(value)) || (null != value)) {
            dbObject.put(name, value);
          }
        }
      }
      Class clazzs = clazz.getSuperclass();
      if (!"class com.huawei.it.jalor5.core.base.BaseVO".equals(clazzs.toString()))
        encapsulatedObject(dbObject, bean, clazzs, state);
    }
  }
  public static <T> T dbObject2Bean(DBObject dbObject, T bean)
    throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
  {
    if (bean == null) {
      return null;
    }
    exceClass(dbObject, bean.getClass(), bean);
    return bean;
  }
  @SuppressWarnings("rawtypes")
private static <T> void exceClass(DBObject dbObject, Class<?> clazz, T bean)
    throws IllegalAccessException, InvocationTargetException
  {
    if (clazz != Object.class) {
      Field[] fields = clazz.getDeclaredFields();
      for (Field field : fields) {
        String varName = field.getName();
        String upperCasevarName = varName.substring(0, 1).toUpperCase() + varName.substring(1);
        Object object = dbObject.get(upperCasevarName);
        if (object != null) {
          BeanUtils.setProperty(bean, varName, object);
        }
      }
      Class clazzs = clazz.getSuperclass();
      exceClass(dbObject, clazzs, bean);
    }
  }
}
