package autorpg.monster.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MonsterInfo {
    private String id;
    private String name;
    private int minAtk;
    private int maxAtk;
    private int def;
    private int maxHp;
    private int level;
    private int spd;
    private int gainExp;
}
