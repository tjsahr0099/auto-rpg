package autorpg.monster.data;


import autorpg.monster.model.Monster;
import autorpg.monster.model.MonsterInfo;

public class MonsterData {

    public static Monster createMonster(){
        return Monster.builder()
                .hp(50)
                .turnCnt(0)
                .info(MonsterInfo.builder()
                        .def(2)
                        .level(1)
                        .maxAtk(10)
                        .minAtk(1)
                        .spd(4)
                        .maxHp(50)
                        .gainExp(10)
                        .build()
                ).build();
    }

}
