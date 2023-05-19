package autorpg.character.model;

import autorpg.item.model.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Character {

    private CharacterInfo info;
    private int minAtk;
    private int maxAtk;
    private int def;
    private int maxHp;
    private int level;
    private int exp;
    private int spd;
    private int criChance;
    private int criMultiplier;

    // battle info
    private int turnCnt;
    private int hp;

    private List<Item> inventory = new ArrayList<>();

}
