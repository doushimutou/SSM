package com.ayt.utils;

/**
 * @Auther: ayt
 * @Date: 2018/9/12 00:53
 * @Description: Don't worry ,just try
 */
public class PathUtil {
    //获取文件的分隔符
    private static String separator= System.getProperty("file.separator");
    /**
     * 相对子路径
     * @param shopId
     * @return
     */
    public  static String getShopImagePath(long shopId){
        String imagePath = "\\upload\\shop" + shopId +"\\";
        return  imagePath;

    }
    /**
     * 根据执行环境不同提供根路径，图片存放路径,静态方法，直接调用，不用new实例
     * @return
     */
    public  static  String getImgBasePath(){
        //获取操作系统名称
        String os =System.getProperty("os.name");
        String basePath ="";
        if(os.toLowerCase().startsWith("win")){
            basePath="F:/springboot/img";
        }else {
            basePath="/home/dir/img";
        }
        basePath.replace("/",separator);
        return basePath;
    }
}
