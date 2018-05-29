import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.*;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        Properties properties=new Properties();
        properties.load(new FileInputStream("C:/Users/Roman/IdeaProjects/SecondTask/src/main/java/file.properties"));
        FileInputStream fis = new FileInputStream(properties.getProperty("pathRead"));

        XWPFDocument document = new XWPFDocument(fis);

        List<XWPFParagraph> paragraphs = document.getParagraphs();

        for (XWPFParagraph para : paragraphs) {
            String str = para.getText();
            String[] subStr;
            String delimeter = " ";
            subStr = str.split(delimeter);
            for(int i = 0; i < subStr.length; i++) {
                if(subStr[i].equals("personal")){
                    subStr[i]="public";
                }
                System.out.println(subStr[i]);
            }
            Writer writer=new FileWriter(properties.getProperty("pathWrite"),true);
            for(int i = 0; i < subStr.length; i++) {
                writer.append(subStr[i]+" ");
            }
            writer.close();
        }
        fis.close();

    }
}
