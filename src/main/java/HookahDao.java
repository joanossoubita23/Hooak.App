import java.sql.SQLException;
import java.util.List;

public interface HookahDao {
    void addHookah( Hookah hookah);
    void UpdateHookah(Hookah hookah);
    void  deleteHookahByid(int id);
    Hookah getHookahByid(int id) throws SQLException;
    List<Hookah> getAllHookahs() throws SQLException;
}
