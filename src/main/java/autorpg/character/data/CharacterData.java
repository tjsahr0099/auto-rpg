package autorpg.character.data;

import autorpg.character.model.Character;

public class CharacterData {

    public static Character createCharacter(){
        return Character.builder()
                .maxHp(100)
                .def(10)
                .maxAtk(5)
                .minAtk(1)
                .spd(5)
                .criChance(10)
                .criMultiplier(200)
                .hp(100)
                .turnCnt(0)
                .level(1).build();
    }

}
