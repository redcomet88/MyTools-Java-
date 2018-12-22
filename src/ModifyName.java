import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @description:修改文件的名字
 *
 * @author: redcomet
 * @param: 
 * @return:         
 * @create: 2018/12/22 
 **/
public class ModifyName {

    public static void main(String[] args) throws IOException {
        String path = "file";
        int folderNum = 0;
        int fileNum = 0;

        Map<String,String> map = new HashMap<>();  //初始化文件名的映射关系

        initialize(map);

        File file = new File(path);
        if (file.exists()) {
            //LinkedList<File> list = new LinkedList<File>();
            File[] files = file.listFiles();
            String temp = "";
            for (File file2 : files) {
                if (file2.isDirectory()) {
                    System.out.println("文件夹:" + file2.getAbsolutePath());
                   // list.add(file2);
                    folderNum++;
                } else {
                    //System.out.println("文件:" + file2.getAbsolutePath());
                    //System.out.println("文件名？:" + file2.getName().replace(".swf","") );
                    temp = file2.getName().replace(".swf","");
                    System.out.println("替换后文件名:" + map.get(temp));
                    file2.renameTo(new File("to/" + map.get(temp) + ".swf"));
                    fileNum++;
                }
            }

            System.out.println("文件夹共有:" + folderNum + ",文件共有:" + fileNum);
        }
    }

    /**
     * @description:数据的预处理
     *
     * @author: redcomet
     * @param: []
     * @return: void        
     * @create: 2018/12/22 
     **/
    public static void initialize(Map map) throws IOException {
        File file = new File("initial/map.txt");//定义一个file对象，用来初始化FileReader
        FileReader reader = new FileReader(file);//定义一个fileReader对象，用来初始化BufferedReader
        BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
        StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
        String s = "";
        while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
            sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
            String row[] = s.split(",");
            //System.out.println(row[0] + "," + row[1]);
            map.put(row[0],row[1]);
        }
        bReader.close();
        String str = sb.toString();
        System.out.println(str );
    }
}
