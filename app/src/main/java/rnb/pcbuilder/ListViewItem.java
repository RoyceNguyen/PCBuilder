package rnb.pcbuilder;


public class ListViewItem {
    private String name;
    private String tip;

    public ListViewItem(String name, String tip){
        this.name = name;
        this.tip = tip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String toString(){
        return getName();
    }
}

