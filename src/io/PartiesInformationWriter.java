package io;

import java.util.List;
import entity.Party;
import enums.ActionLevel;

/**
 * Запись информации о количестве партий в консоль.
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

        System.out.println(new StringBuilder().append("Обработано ")
                .append(fedPartiesCounter).append(" партий федерального уровня и ")
                .append(regPartiesCounter).append(" партий регионального уровня"));
    }
}
