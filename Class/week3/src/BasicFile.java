// package-public
// 各オブジェクト（Directory, File, SymbolicLink）の元になるクラス

class BasicFile {
    private String name;
    private int size;

    BasicFile(String name, int size) {
        this.name = name;
        this.size = size;
    }

    // getter
    // オブジェクトの名前をディレクトリのリストに追加するため
    String getName() {
        return this.name;
    }

    int size(){ // getterの代わり
        return this.size;
    }

    //setter(dirの変更のため)
    void setSize(int size) {
        this.size = this.size + size;
    }

    void print(){
        System.out.println(this.name);
    }
}

