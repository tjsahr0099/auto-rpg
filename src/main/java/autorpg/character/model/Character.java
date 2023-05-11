package autorpg.character.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Character {

    private int minAtk;
    private int maxAtk;
    private int def;
    private int maxHp;
    private int hp;
    private int level;
    private int exp;

}
