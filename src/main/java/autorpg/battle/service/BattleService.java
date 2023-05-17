package autorpg.battle.service;

import autorpg.battle.model.BattleState;
import autorpg.character.data.CharacterData;
import autorpg.character.model.Character;
import autorpg.monster.data.MonsterData;
import autorpg.monster.model.Monster;
import common.util.Fibonacci;
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
        BattleState battleState = BattleState.builder().isBattleEnd(false).isCharacterWin(false).build();

        while(!battleState.isBattleEnd()){
            turnCnt++;
            log.info("==============================================");
            
            // 레디페이즈
            log.info("{} 번째 턴",turnCnt);
            
            // 배틀페이즈
            turn(character, monster, battleState);
            log.info("종료판별중 ....isEnd={} [{}] ",battleState.isBattleEnd() , battleState.isBattleEnd() ? "전투종료!!" : "계속진행" );

            // 엔드페이즈
            if(battleState.isBattleEnd()){
                if(battleState.isCharacterWin()){
                    log.debug("플레이어 승리!");
                    log.debug("경험치 {} 획득", monster.getGainExp());
                    character.setExp(character.getExp()+monster.getGainExp());
                }else{
                    log.debug("플레이어 패배...");
                }
            }

            log.info("==============================================");
        }


    }

    /**
     * 턴 종료 여부 체크
     * @param character
     * @param monster
     * @return
     */
    private boolean checkBattleEnd(Character character, Monster monster, BattleState battleState){

        if(character.getHp()<=0){
            battleState.setBattleEnd(true);
            battleState.setCharacterWin(false);
            // 전투종료
            return true;
        }
        if(monster.getHp()<=0){
            battleState.setBattleEnd(true);
            battleState.setCharacterWin(true);
            // 전투종료
            return true;
        }
        
        // 종료 아님
        return false;
    }

    /**
     * 턴 진행
     * @param character
     * @param monster
     * @return
     */
    private void turn(Character character, Monster monster, BattleState battleState){

        int damage = 0;
        log.info("턴 카운트 플레이어[{}] 몬스터[{}]",character.getTurnCnt(),monster.getTurnCnt());
        // 이번 턴 스피드 계산
        int thisTurnCharacterSpeed = character.getSpd()*(monster.getTurnCnt()+1);
        int thisTurnMonsterSpeed = monster.getSpd()*(character.getTurnCnt()+1);

        // 턴 결정
        boolean isCharacterTurn = thisTurnCharacterSpeed >= thisTurnMonsterSpeed;

        if(isCharacterTurn){

            // 케릭터 턴
            character.setTurnCnt(character.getTurnCnt()+1);
            damage = getCharacterDamage(character, monster);
            damage = reduceDamage(monster.getDef(),damage);
            monster.setHp(monster.getHp()-damage);

            log.info("플레이어 턴 , 플레이어 SPD[{}] 몬스터 SPD[{}]",thisTurnCharacterSpeed,thisTurnMonsterSpeed);
            log.info("플레이어가 공격합니다! , 몬스터는 {}의 데미지를 입었습니다.",damage);

        }else{

            // 몬스터 턴
            monster.setTurnCnt(monster.getTurnCnt()+1);
            damage = getMonsterDamage(character, monster);
            damage = reduceDamage(character.getDef(),damage);
            character.setHp(character.getHp()-damage);

            log.info("몬스터 턴 , 플레이어 SPD[{}] 몬스터 SPD[{}]",thisTurnCharacterSpeed,thisTurnCharacterSpeed);
            log.info("몬스터가 공격합니다! , 플레이어는 {}의 데미지를 입었습니다.",damage);

        }

        log.info("몬스터\tHP[{}/{}]",monster.getHp(),monster.getMaxHp());
        log.info("플레이어\tHP[{}/{}]",character.getHp(),character.getMaxHp());

        checkBattleEnd(character,monster,battleState);
    }

    /**
     * 케릭터 데미지 계산
     * @param character
     * @return
     */
    private int getCharacterDamage(Character character, Monster monster){
        Random random = new Random();

        // 최소 / 최대 데미지 계산
        int damage = 1 + random.nextInt(character.getMinAtk(), character.getMaxAtk());

        // 크리티컬 데미지 계산
        int criDice = random.nextInt(1, 1000);
        if(criDice < 1000*((float)character.getCriChance()/100)){
            log.info("크리티컬 히트!");
            damage = damage*(character.getCriMultiplier()/100);
        }
//        log.info("크리티컬 히트 안뜸 {} : {} " , criDice, 1000*((float)character.getCriChance()/100));

        return damage;
    }

    /**
     * 몬스터 데미지 계산
     * @param monster
     * @return
     */
    private int getMonsterDamage(Character character, Monster monster){
        Random random = new Random();
        int damage = 1 + random.nextInt(monster.getMinAtk(), monster.getMaxAtk());
        return damage;
    }


    private int reduceDamage(Integer def,Integer damage){

        // 몬스터 방어력 계산
        Integer[] defenceLevelChart = Fibonacci.getFibonacci();
        Integer defenceLevel = 0;
        for(int i=0;i<Fibonacci.maxLength;i++){
            if(def>defenceLevelChart[i]){
                defenceLevel = i-1;
            }
        }
        log.debug("DEF레벨 {} 데미지 {} 데미지 감소 {}", defenceLevel,damage, (double)defenceLevel*0.03*(double)damage);
        
        // 최대 30단계 , 최대 90% 데미지 감소
        double reduceDamage = (double)defenceLevel*0.03*(double)damage;
        damage = damage - (int)reduceDamage;

        return damage;
    }





}
