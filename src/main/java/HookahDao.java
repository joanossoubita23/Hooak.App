import java.util.List;

public interface HookahDao {
    void addHookah( Hookah hookah);
    void UpdateHookah(Hookah hookah);
    void  deleteHookahByid(int id);
    Hookah getHookahByid(int id);
    List<Hookah> getAllHookahs();
}
