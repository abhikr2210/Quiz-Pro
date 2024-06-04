package com.example.quizpro;

public class PhysicsQuestion {
        public static String[] question ={
                "What is the formula to calculate gravitational potential energy?",
                "What is the SI unit of electric charge?",
                "What is the formula to calculate electrical power?",
                "What is the SI unit of electric potential difference?",
                "What is the formula to calculate momentum?",
                "What is the SI unit of momentum?",
                "What is the formula to calculate pressure?",
                "What is the SI unit of pressure?",
                "What is the formula to calculate frequency?",
                "What is the SI unit of frequency?"
        };

        public static String[][] choices ={
                {"mgh", "0.5 * mv²", "F * d", "Q * V"},
                {"Coulomb", "Ampere", "Volt", "Ohm"},
                {"P = V² / R", "P = V / I", "P = I²R", "P = VI"},
                {"Volt", "Coulomb", "Watt", "Joule"},
                {"p = mv", "p = F * t", "p = F / t", "p = m / v"},
                {"kg*m/s", "kg*m²/s²", "N*m", "Joule"},
                {"P = F / A", "P = F * A", "P = F * d", "P = F / d"},
                {"Newton", "Pascal", "Joule", "Watt"},
                {"f = 1 / T", "f = T / λ", "f = T * λ", "f = λ / T"},
                {"Hz", "Newton", "Watt", "Joule"}
        };

        public static String[] correctAnswers ={
                "mgh",
                "Coulomb",
                "P = VI",
                "Volt",
                "p = mv",
                "kg*m/s",
                "P = F / A",
                "Pascal",
                "f = 1 / T",
                "Hz"
        };
}
