// package-public

class Directory extends BasicFile {
    private ObjectLists lists = new ObjectLists();

    /*
    * コンストラクタ
    * 定義の時に自分自身を最初に登録しておく。
    * つまり、
    * nameList.get(0), objectList.get(0) = 自分（ディレクトリ）
    */
    Directory(String name) {
        super(name, 0);
        lists.add(this);
    }

    // 追加
    void add(BasicFile object) {
        this.lists.add(object);
        this.setSize(object.size());
    }

    /*
    * ディレクトリ内のリストを変更するメソッド
    * 引数がディレクトリの場合のみ発動する。
    */
    void add(Directory dir) {
        this.setSize(dir.size());
        this.lists.changeLists(dir.lists);
    }

    // 表示
    void print() {
        for(int i = 0; i<this.lists.getNumOfLists(); i++){
            this.lists.print(i);
        }
    }
}