package autorpg.monster.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Monster {

    private int hp;
    private int turnCnt;
    private MonsterInfo info;
}
