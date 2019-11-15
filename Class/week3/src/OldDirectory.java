// package-public
// 改善前のディレクトリクラス

import java.util.ArrayList;
import java.util.List;

class OldDirectory {
    private String name;
    // listの宣言は注意
    private List<OldDirectory> dirList;
    private List<File> fileList;
    private List<SymbolicLink> linkList;

    public OldDirectory(String name){
        this.name = name;
        this.dirList = new ArrayList<OldDirectory>();
        this.fileList = new ArrayList<File>();
        this.linkList = new ArrayList<SymbolicLink>();
    }

    public void add(OldDirectory dir){
        this.dirList.add(dir);
    }

    public void add(File file){
        this.fileList.add(file);
    }

    public void add(SymbolicLink link){
        this.linkList.add(link);
    }

    String getName(){
        return this.name;
    }

    // 指定したオブジェクトによって計算するサイズを変える必要がある
    public int size(OldDirectory dir){
        int sum_size = 0;
        for(int i=0; i<dir.fileList.size(); i++){
            sum_size += dir.fileList.get(i).size();
        }
        return sum_size;
    }

    public int size(File file){
        return file.size();
    }

    // ディレクトリに含まれるファイルを表示
    // これをパスを生成するだけの関数に変更したほうがいい。
    public void printFile(OldDirectory dir){
        for (int i = 0; i < dir.fileList.size(); i++) {
            System.out.println("/" + dir.name + "/" + (dir.fileList.get(i)).getName());
//            System.out.println("  (" + (dir.fileList.get(i)).getNumOfLists() + ")");
        }
    }


    public void print() {
        // このディレクトリそのものの表示
        System.out.println("/" + this.name);

        // このディレクトリに含まれるファイルを表示
        printFile(this);

        // このディレクトリに含まれるディレクトリを表示
        for(int i =0; i < this.dirList.size(); i++){
            System.out.println("/" + this.name + this.dirList.get(i).getName());
            printFile(this.dirList.get(i));
        }

//        for(int i =0; i < this.dirList.getNumOfLists(); i++){
//            System.out.printf("/" + this.name + "/" + (this.dirList.get(i)).getName());
//            System.out.println("  (" + getNumOfLists(this.dirList.get(i))+ ")");
//        }
    }


}
