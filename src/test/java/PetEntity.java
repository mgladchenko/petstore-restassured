import java.util.List;

public class PetEntity {

    int id;
    Object category;
    String name;
    List<String> photoUrls;
    List<Object> tags;
    String status;

    public PetEntity(int id,
                     Object category,
                     String name,
                     List<String> photoUrls,
                     List<Object> tags,
                     String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public PetEntity(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
}
