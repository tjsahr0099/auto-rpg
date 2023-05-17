package autorpg.monster.data;


import autorpg.monster.model.Monster;

public class MonsterData {

    public static Monster createMonster(){
        return Monster.builder()
                .hp(50)
                .turnCnt(0)
                .level(1)
                .def(10)
                .maxAtk(10)
                .minAtk(1)
                .spd(4)
                .maxHp(50)
                .gainExp(10)
                .build();

    }

}
