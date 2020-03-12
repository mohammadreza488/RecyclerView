package id.ac.polinema.recyclerview.models;

public class TeamLogo {

   private String logo;
   private String name;

    public TeamLogo(String logo, String name) {
        this.logo = logo;
        this.name = name;
    }

    //ini method setter//
    public void setLogo(String logo1){
        this.logo=logo1;
    }
    public void setName(String name1){
        this.name=name1;
    }

    //ini method getter//
    public String getLogo(){
        return this.logo;

    }
    public String getName(){
        return this.name;
    }

}
