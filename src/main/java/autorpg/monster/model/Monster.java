package autorpg.monster.model;

import lombok.Data;

@Data
public class Monster {

    private int minAtk;
    private int maxAtk;
    private int def;
    private int maxHp;
    private int hp;
    private int level;
    private MonsterInfo info;
}
