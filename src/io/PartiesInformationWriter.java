package io;

import java.util.List;
import domain.Party;
import enums.ActionLevel;

/**
 * todo vpodogov
 *
 * @author Vadim Podogov
 * @since 2024.01.26
 */
public class PartiesInformationWriter {

    public static void writeInformationToConsole(List<Party> parties) {
        int fedPartiesCounter = 0;
        int regPartiesCounter = 0;
        for (Party party : parties) {
            if (party.getActionLevel() == ActionLevel.FEDERAL) {
                fedPartiesCounter++;
            } else if (party.getActionLevel() == ActionLevel.REGIONAL) {
                regPartiesCounter++;
            }
        }
        var sb = new StringBuilder();
        sb.append("Обработано ").append(fedPartiesCounter).append(" партий федерального уровня и ")
            .append(regPartiesCounter).append(" партий регионального уровня");
        System.out.println(sb);
    }
}
