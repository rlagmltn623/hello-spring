package hellospring.hellospring.도메인;

public class Member {
    private Long id; //id 식별자 DB값
    private String name; //

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
