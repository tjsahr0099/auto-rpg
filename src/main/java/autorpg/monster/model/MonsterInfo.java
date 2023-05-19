package autorpg.monster.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
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
    private DropItem[] dropTable;

}
