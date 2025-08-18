package designPatterns.creational.builder;

public class User {

    //required
    private int id;
    private String name;
    private String password;

    //optional
    private String address;
    private Long phoneNumber;

    public User(UserBuilder userBuilder){
        this.id = userBuilder.id;
        this.name = userBuilder.name;
        this.password = userBuilder.password;
        this.address = userBuilder.address;
        this.phoneNumber = userBuilder.phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    static class UserBuilder{
        //required
        private int id;
        private String name;
        private String password;

        //optional
        private String address;
        private Long phoneNumber;

        public UserBuilder(int id, String name, String password){
            this.id = id;
            this.name = name;
            this.password = password;
        }

        public UserBuilder setAddress(String address){
            this.address = address;
            return this;
        }

        public UserBuilder setPhoneNumber(Long phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
