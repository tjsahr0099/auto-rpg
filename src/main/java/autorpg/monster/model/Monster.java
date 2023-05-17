package autorpg.monster.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Monster extends MonsterInfo {

    private String instanseId;
    private int hp;
    private int turnCnt;
}
