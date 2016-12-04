    
package java.data;

/**
 *
 * @author Lucas
 */
public class disciplinesDO {
    private int id;
    private String code;
    private String name;
    private String description;
    
    public void setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return code;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
}