package backend.pet.model;

public class Pet {
    public Integer id;
    public String name;
    public String owner;
    public String age;
    public String type;
    public String gender;
    public Pet() {
    }
    public Pet(Integer id, String name, String owner, String age, String type, String gender) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.age = age;
        this.type = type;
        this.gender = gender;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    
}
