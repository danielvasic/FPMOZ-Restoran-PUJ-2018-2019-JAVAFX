import model.User;

public class application {
    public static void main (String [] args) {
        User u = new User(
                0, "Daniel", "Vasic", "dvasic", "csdigital", "admin"
        );

        User.add(u);
        User.update(u);
        User.remove(u);
        User.select();
    }
}
