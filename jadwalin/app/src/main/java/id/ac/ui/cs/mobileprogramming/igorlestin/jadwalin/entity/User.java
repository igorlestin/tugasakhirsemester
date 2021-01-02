package id.ac.ui.cs.mobileprogramming.igorlestin.jadwalin.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @ColumnInfo(name = "user_id")
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "user_name")
    private String name;

    @ColumnInfo(name = "user_age")
    private String age;

    @ColumnInfo(name = "user_height")
    private int height;

    @ColumnInfo(name = "user_weight")
    private int weight;

    public User(String name, String age, int height, int weight){
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
