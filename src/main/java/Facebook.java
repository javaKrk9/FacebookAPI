import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "birthday",
        "firstname",
        "lastname",
        "occupation",
        "gender",
        "city",
        "work",
        "friends",
        "school",
        "location",
        "relationship",
        "posts"
})
public class Facebook implements Comparable{

    @JsonProperty("id")
    private String id;
    @JsonProperty("birthday")
    private Long birthday;
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("occupation")
    private String occupation;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("city")
    private City city;
    @JsonProperty("work")
    private String work;
    @JsonProperty("friends")
    private List<String> friends = null;
    @JsonProperty("school")
    private String school;
    @JsonProperty("location")
    private String location;
    @JsonProperty("relationship")
    private String relationship;
    @JsonProperty("posts")
    private List<Post> posts = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("birthday")
    public Long getBirthday() {
        return birthday;
    }

    @JsonProperty("birthday")
    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    @JsonProperty("firstname")
    public String getFirstname() {
        return firstname;
    }

    @JsonProperty("firstname")
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @JsonProperty("lastname")
    public String getLastname() {
        return lastname;
    }

    @JsonProperty("lastname")
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @JsonProperty("occupation")
    public String getOccupation() {
        return occupation;
    }

    @JsonProperty("occupation")
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("city")
    public City getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(City city) {
        this.city = city;
    }

    @JsonProperty("work")
    public String getWork() {
        return work;
    }

    @JsonProperty("work")
    public void setWork(String work) {
        this.work = work;
    }

    @JsonProperty("friends")
    public List<String> getFriends() {
        return friends;
    }

    @JsonProperty("friends")
    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    @JsonProperty("school")
    public String getSchool() {
        return school;
    }

    @JsonProperty("school")
    public void setSchool(String school) {
        this.school = school;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("relationship")
    public String getRelationship() {
        return relationship;
    }

    @JsonProperty("relationship")
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    @JsonProperty("posts")
    public List<Post> getPosts() {
        return posts;
    }

    @JsonProperty("posts")
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Facebook{" +
                "id='" + id + '\'' +
                ", birthday=" + birthday +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", occupation='" + occupation + '\'' +
                ", gender='" + gender + '\'' +
                ", city=" + city +
                ", work='" + work + '\'' +
                ", friends=" + friends +
                ", school='" + school + '\'' +
                ", location='" + location + '\'' +
                ", relationship='" + relationship + '\'' +
                ", posts=" + posts +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    @Override
    public int compareTo(Object o)
    {
        if(!(o instanceof Facebook)) return 0;
        Facebook fb = (Facebook)o;
        int compareName = this.getFirstname().compareTo(fb.getFirstname());
        if(compareName!=0) return compareName;
        else return this.getLastname().compareTo(fb.getLastname());
    }
}