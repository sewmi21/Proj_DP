package model;



public class Spacecraft {

    private String name,value,calories,category;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }


    public String getCalories(){
        return calories;
    }

    public void setCalories(String calories){
        this.calories = calories;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return name
                +"   "+
                value
                +"    "+
                calories;
    }
}
