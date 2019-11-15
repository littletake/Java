// package-public

import java.util.ArrayList;
import java.util.List;

class ObjectLists implements LookUp {

    private List<String> nameList = new ArrayList<>();
    private List<BasicFile> objectList = new ArrayList<>();

    void add(BasicFile object) {
        if (this.nameList.size() == 0 && object instanceof Directory) {
            this.nameList.add("/" + object.getName());
            this.objectList.add(object);
        } else{
            this.nameList.add(this.nameList.get(0) + "/" + object.getName());
            this.objectList.add(object);
        }
    }

    void changeLists(ObjectLists childLists) {
        for (int i = 0; i < childLists.getNumOfLists(); i++) {
            this.nameList.add(this.nameList.get(0) + childLists.nameList.get(i));
            this.objectList.add(childLists.objectList.get(i));
        }
    }

    int getNumOfLists(){
        return this.nameList.size();
    }

    void print(int i) {
        System.out.print(this.nameList.get(i));

        // File + Directory
        if ((this.objectList.get(i) instanceof File) || (this.objectList.get(i) instanceof Directory)) {
            System.out.println(" " + "(" + this.objectList.get(i).size() + ")");
        // SymbolicLink
        } else {
            this.objectList.get(i).print();
        }

    }

    // interfaceを試すために作成したメソッド（使用していない）
    public BasicFile find(String name){
        for(int i = 0; i<this.nameList.size(); i++){
            if(nameList.get(i).equals(name)) {
                return objectList.get(i);
            }
        }
        return null;
    }

}
