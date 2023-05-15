package autorpg.battle.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class BattleState {
    boolean isBattleEnd;
    boolean isCharacterWin;


}
