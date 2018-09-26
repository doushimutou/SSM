package com.ayt.utils;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Auther: ayt
 * @Date: 2018/9/12 00:44
 * @Description: Don't worry ,just try
 */
public class ImageUtil {
//    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");


    private static final Random random = new Random();


    /**
     * 给图片添加水印并压缩
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        Thumbnails.of(new File("图片路径"))
                .size(200, 200).watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("图片名称")), 0.25f)
                .outputQuality(0.8f).toFile("图片路径+图片名称新");
    }

    public static String gererateThumbnail( CommonsMultipartFile commonsMultipartFile, String targetAddr) {
        //随机文件名
        String realFileName = getRandomFileName();
       //扩展名
         String extension = getFileExtension(commonsMultipartFile);
        //String extension = ".jpg";
        makeDirPath(targetAddr);
        //
        String relativeAddr = targetAddr + realFileName + extension;
        //文件名
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);

        try {
            Thumbnails.of(relativeAddr).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File( "F:\\springboot\\img\\shuiyin.jpg")), 0.25f)
                    .outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * storePath 是文件路径还是目录的路径，
     * 目录路径删除该目录下的所有文件
     * 文件路径删除该文件夹
     * @param storePath
     */
    public static  void deleteFileOrPath(String storePath){
        File fileOrPath= new File(PathUtil.getImgBasePath()+storePath);
        if(fileOrPath.exists()){
            if(fileOrPath.isDirectory()){
                File files[] = fileOrPath.listFiles();
                for (int i = 0; i <files.length ; i++) {
                    files[i].delete();
                }
            }
            fileOrPath.delete();
        }
    }

    /**
     * 创建目标路径的目录，即d:xxx/yyy/zzz.jpg
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }

    }

    /**
     * 获取文件的随机名,当前的明月日+随机五位数
     *
     * @return
     */
    private static String getRandomFileName() {
        //获取随机的5位数
        int rannum = random.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());

        return nowTimeStr + rannum;
    }

    /**
     * 获取输入文件流的扩展名
     *
     * @param commonsMultipartFile
     * @return
     */
    private static String getFileExtension(CommonsMultipartFile commonsMultipartFile) {
        String originalFileName = commonsMultipartFile.getOriginalFilename();

        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }
}
