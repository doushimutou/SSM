package com.ayt.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: ayt
 * @Date: 2018/9/16 13:57
 * @Description: Don't worry ,just try
 */
public class HttpServletRequestUtil {
    //将request中返回的string转换成int
    public  static int getInt (HttpServletRequest request,String key){
        try{
            return Integer.decode(request.getParameter(key));
        } catch (Exception e){
            return -1;
        }
    }
    //将request中返回的string转换成 long
    public  static Long getLong (HttpServletRequest request, String key){
        try{
            return Long.valueOf(request.getParameter(key));
        } catch (Exception e){
            return -1L;
        }
    }
    //将request中返回的string转换成 double
    public  static Double getDouble (HttpServletRequest request, String key){
        try{
            return Double.valueOf(request.getParameter(key));
        } catch (Exception e){
            return -1D;
        }
    }
    //将request中返回的string转换成 BOOLEAN
    public  static Boolean getBoolean (HttpServletRequest request, String key){
        try{
            return Boolean.valueOf(request.getParameter(key));
        } catch (Exception e){
            return false;
        }
    }
    //将request中返回的string转换成 string
    public static  String getString (HttpServletRequest request, String key){
        try{
            String result=request.getParameter(key);
            if(request!=null){
                result=result.trim();
            }
            if("".equals(result)){
                return null;
            }
            return result;
        } catch (Exception e){
            return null ;
        }

    }

}
