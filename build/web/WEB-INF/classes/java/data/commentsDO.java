
package java.data;

/**
 *
 * @author Lucas
 */
public class commentsDO {
    private int id;
    private int offering_id;
    private int student_id;
    private String comment;
    
    public void setComment(String comment){
        this.comment=comment;
    }
    public String getComment(){
        return comment;
    }
    
    public void setOffering_id(int offering_id){
        this.offering_id=offering_id;
    }
    public int getOffering_id(){
        return offering_id;
    }
    
    public void setStudent_id(int student_id){
        this.student_id=student_id;
    }
    public int getStudent_id(){
        return student_id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
}
