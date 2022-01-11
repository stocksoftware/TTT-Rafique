import java.util.Objects;

public class Player {

    private int identifier;
    public Player(int i) {
        this.identifier = i;
    }

    public int getIdentifier(){
        return identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return identifier == player.identifier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }
}
