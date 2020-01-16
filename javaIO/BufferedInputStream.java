package JavaIO_2;

import java.io.*;

public class BufferedTest01 {
    public static void main(String[] args) {
        //创建源
        File src = new File("G:\\GitEver\\src\\javaIo\\abc.txt");
        //选择流
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(src));
            //读取
            byte[] flush = new byte[1024*10];
            int len = -1;
            while((len=is.read(flush))!=-1){
                String str = new String(flush,0,len);
                System.out.println(str);
            }
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
    }
    public void test01(){
        //创建源
        File src = new File("G:\\GitEver\\src\\javaIo\\abc.txt");
        //选择流
        InputStream is = null;
        BufferedInputStream bis = null;

        try {
            is = new FileInputStream(src);
            bis = new BufferedInputStream(is);
            //读取
            byte[] flush = new byte[1024*10];
            int len = -1;
            while((len=is.read(flush))!=-1){
                String str = new String(flush,0,len);
                System.out.println(str);
            }

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
            try {
                if(bis!=null)
                    bis.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
