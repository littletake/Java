// package-public

class SymbolicLink extends BasicFile{
    private String path;

    SymbolicLink(String name, String path){
        super(name, 0);
        this.path = path;
    }

    void print() {
        System.out.println(" -> " + this.path);
    }
}
