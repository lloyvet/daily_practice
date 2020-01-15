package javaIo;

import java.io.*;

public class IOtest08 {
    /**
     * 图片读取到字节数组
     * 字节数组写出到文件
     * @param args
     */
    public static void main(String[] args) {
        byte[] datas = fileToByteArray("G:\\GitEver\\src\\javaIo\\ball.png");
        System.out.println(datas.length);
        ByteArrayToFile(datas,"G:\\GitEver\\src\\javaIo\\ba.png");
    }

    /**
     * 图片读取到字节数组
     * 图片到程序
     * 程序到字节数组
     * @param filePath
     * @return
     */
    public static byte[] fileToByteArray(String filePath){
        File src = new File(filePath);

        InputStream is = null;

        ByteArrayOutputStream baos = null;
        int len = -1;

        try {
            is = new FileInputStream(src);
            baos = new ByteArrayOutputStream();
            byte[] flush = new byte[1024];
            while((len = is.read(flush))!=-1){
                baos.write(flush,0,len); //写出到字节数组中
            }
            baos.flush();
            return baos.toByteArray();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(is!=null)
                    is.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 字节数组到图片
     * 字节数组到程序
     * 程序写出到文件
     * @param src
     * @param path
     */
    public static void ByteArrayToFile(byte[] src,String path){
        File dest = new File("G:\\GitEver\\src\\javaIo\\destt.png");
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new ByteArrayInputStream(src);
            os = new FileOutputStream(dest,true);
            byte[] flush = new byte[5];
            int len = -1;
            while((len = is.read(flush))!=-1){
                os.write(flush,0,len);
            }
            os.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(os!=null)
                    os.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
