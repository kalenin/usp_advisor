
package java.data;

/**
 *
 * @author w
 */
public class StudentsDo {
    private int id;
    private String num_usp;
    private int entry_year;
    private String name;
    private String email;
    private String password_hash;
    
    public void setNum_usp(String num_usp){
        this.num_usp=num_usp;
    }
    public String getNum_usp(){
        return num_usp;
    }
    
    public void setEntry_year(int entry_year){
        this.entry_year=entry_year;
    }
    public int getEntry_year(){
        return entry_year;
    }
    
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }
    
    public void setPassword_hash(String password_hash){
        this.password_hash=password_hash;
    }
    public String getPassword_hash(){
        return password_hash;
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
}
