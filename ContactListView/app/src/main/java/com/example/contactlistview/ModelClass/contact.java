package com.example.contactlistview.ModelClass;

public class contact {

    String name, phoneno;

    int image;

    public contact( int image, String name, String phoneno) {
        this.name = name;
        this.phoneno = phoneno;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
