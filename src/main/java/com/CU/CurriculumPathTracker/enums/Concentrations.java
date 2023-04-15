package com.CU.CurriculumPathTracker.enums;

public enum Concentrations {
    DATA_INFO("Data Science and Informatics"),
    FOUND_N_THEO("Foundations and Theory"),
    HCC("Human Centered Computing"),
    NETWORKS("Networking, Systems and Security"),
    SE("Software Engineering"),
    VC("Visual Computing")
    ;

    private final String concentration;

    Concentrations(String concentration) {
        this.concentration = concentration;
    }

    public String getValue() {
        return concentration;
    }

    public static boolean isValidConcentration(String conc){
        for (Concentrations concentrations : values()) {
            if (concentrations.getValue().equalsIgnoreCase(conc)) {
                return true;
            }
        }
        return  false;
    }

}
