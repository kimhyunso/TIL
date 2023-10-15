package javaStudy;

class User{
    private String id;
    public User(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof User){
            User user = (User) obj;
            if (id.equals(user.getId()))
                return true;
        }
        return false;
    }
}




public class ShallowCopy_DeepCopyTest {
    public static void main(String[] args){
        User member1 = new User("1");
        User member2 = new User("1");

        User member3 = new User("abcd");

        if (member1.equals(member2))
            System.out.println("member1과 member2는 동등하다.");
        else
            System.out.println("member1과 member2는 동등하지 않다.");


        if (member1.equals(member3))
            System.out.println("member1과 member3는 동등하다.");
        else
            System.out.println("member1과 member3는 동등하지 않다.");
    }
    
}
