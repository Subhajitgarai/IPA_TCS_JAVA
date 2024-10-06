package IPA30;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Document{
    private int id;
    private String title;
    private String folderName;
    private int pages;

    public Document(int id, String title, String folderName, int pages) {
        this.id = id;
        this.title = title;
        this.folderName = folderName;
        this.pages = pages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", folderName='" + folderName + '\'' +
                ", pages=" + pages +
                '}';
    }
}
public class Ipa30 {
    public static Document[] docsWithOddPages(Document[] documents){
        Document[] sortedDocArrByCond = Arrays.stream(documents)
                .filter(document -> document.getPages() % 2 != 0)
                .sorted(Comparator.comparing(Document::getId))
                .toArray(Document[]::new);
        return sortedDocArrByCond;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Document[] docs=new Document[4];
        for (int i=0;i<4;i++){
            int a=sc.nextInt();
            String b=sc.next();
            String c=sc.next();
            int d=sc.nextInt();
            Document document=new Document(a,b,c,d);
            docs[i]=document;
        }
        Document[] sortedDocs=docsWithOddPages(docs);
        Arrays.stream(sortedDocs).forEach(document -> {
            System.out.println(document.getId()+" "+document.getTitle()+" "+document.getFolderName()+" "+document.getPages());
        });
    }
}
