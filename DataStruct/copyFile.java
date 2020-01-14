package javaIo;

import java.io.*;

/**
 * 文件字节输入流输出流达到文件的复制
 *
 */
public class CopyFile {
    public static void main(String[] args) {
        File src = new File("G:\\GitEver\\src\\javaIo\\ball.png"); //源头
        File dest = new File("G:\\GitEver\\src\\javaIo\\bal.png");
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);
            //操作
            byte[] flush = new byte[1024];
            int len = -1;
            while((len=is.read(flush))!=-1){
                os.write(flush,0,len);
            }
            os.flush();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //释放资源分别关闭先打开的后关闭
            try {
                if(os!=null){
                    os.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

            try {
                if(is!=null){
                    is.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
