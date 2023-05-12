package autorpg.battle.service;

import autorpg.character.data.CharacterData;
import autorpg.character.model.Character;
import autorpg.monster.data.MonsterData;
import autorpg.monster.model.Monster;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class BattleService {

    public static void main(String[] args) {
        BattleService bs = new BattleService();
        bs.startBattle(CharacterData.createCharacter(), MonsterData.createMonster());
    }

    public void startBattle(Character character, Monster monster){

        int turnCnt = 0;

        while(checkBattleEnd(character,monster)){
            turnCnt++;
            log.info("==============================================");
            log.info("{} 번째 턴",turnCnt);
            turn(character, monster);
            log.info("==============================================");
        }


    }

    private boolean checkBattleEnd(Character character, Monster monster){

        if(character.getHp()<=0){
            log.info("플레이어 패배");
            log.info("플레이어[{}/{}]",character.getHp(),character.getMaxHp());
            log.info("몬스터[{}/{}]",monster.getHp(),monster.getInfo().getMaxHp());
            return false;
        }
        if(monster.getHp()<=0){
            log.info("플레이어 승리");
            log.info("플레이어[{}/{}]",character.getHp(),character.getMaxHp());
            log.info("몬스터[{}/{}]",monster.getHp(),monster.getInfo().getMaxHp());
            return false;
        }

        return true;
    }

    private void turn(Character character, Monster monster){

        int damage = 0;
        log.info("턴 카운트 플레이어[{}] 몬스터[{}]",character.getTurnCnt(),monster.getTurnCnt());
        // 턴 결정
        if(character.getSpd()*(monster.getTurnCnt()+1) >= monster.getInfo().getSpd()*(character.getTurnCnt()+1)){
            log.info("플레이어 턴 , 플레이어 SPD[{}] 몬스터 SPD[{}]",character.getSpd()*(monster.getTurnCnt()+1),monster.getInfo().getSpd()*(character.getTurnCnt()+1));
            character.setTurnCnt(character.getTurnCnt()+1);
            damage = getDamage(character.getMinAtk(), character.getMaxAtk());
            log.info("플레이어 타격! , 몬스터 HIT DAMAGE[{}]",damage);
            monster.setHp(monster.getHp()-damage);
        }else{
            log.info("몬스터 턴 , 플레이어 SPD[{}] 몬스터 SPD[{}]",character.getSpd()*(monster.getTurnCnt()+1),monster.getInfo().getSpd()*(character.getTurnCnt()+1));
            monster.setTurnCnt(monster.getTurnCnt()+1);
            damage = getDamage(monster.getInfo().getMinAtk(), monster.getInfo().getMaxAtk());
            log.info("몬스터 타격! , 플레이어 HIT DAMAGE[{}]",damage);
            character.setHp(character.getHp()-damage);
        }

    }

    private int getDamage(int minAtk, int maxAtk){
        Random random = new Random();
        int damage = 1 + random.nextInt(minAtk, maxAtk);
        return damage;
    }

}
